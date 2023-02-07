package com.kshrd.derphsar_api.repository;

import com.kshrd.derphsar_api.mybatis.JSONTypeHandlerPg;
import com.kshrd.derphsar_api.page.Pagination;
import com.kshrd.derphsar_api.repository.dto.*;
import com.kshrd.derphsar_api.repository.provider.OrderDetailProvider;
import com.kshrd.derphsar_api.repository.provider.OrderProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository {

    @Select("SELECT DISTINCT(o.order_id) , o.id AS oId,u.user_id, u.name AS userName, u.phone, sh.shop_id, sh.name AS shopName,ord.status,ord.is_checkout, ord.order_date,sum(quatity) qty\n" +
            "            FROM dp_order AS o\n" +
            "INNER JOIN dp_users AS u ON u.id = o.user_id\n" +
            "INNER JOIN dp_shops AS sh ON sh.id = o.shop_id\n" +
            "INNER JOIN dp_order_detail AS ord ON ord.order_id = o.id\n" +
            "WHERE o.shop_id = #{shopId} AND ord.is_checkout = 'TRUE' AND ord.status = 'TRUE'\n" +
            "GROUP BY o.order_id,o.id,u.user_id, u.name, u.phone, sh.shop_id, sh.name,ord.status,ord.is_checkout, ord.order_date\n" +
            "ORDER BY u.name DESC")
        @Results( id ="OrderMap", value = {
                @Result(property = "id", column = "oId"),
                @Result(property = "orderId", column = "order_id"),

                @Result(property = "user.name", column = "userName"),
                @Result(property = "user.userId", column = "user_id"),
                @Result(property = "user.phone", column = "phone"),

                @Result(property = "shop.shopId", column = "shop_id"),
                @Result(property = "shop.name", column = "shopName"),

                @Result(property = "orderDetail.checkoutStatus", column = "is_checkout"),
                @Result(property = "orderDetail.status", column = "status"),
                @Result(property = "orderDetail.orderDate", column = "order_date"),
                @Result(property = "orderDetail.quatity", column = "qty"),

        })
    List<OrderDto> getAllOrderByShopId(int shopId);


    @SelectProvider(type = OrderProvider.class, method = "orderDetailByOrderId")
    @Results({
            @Result(property = "itemId", column = "item_id"),
            @Result(property = "quatity", column = "quatity"),
            @Result(property = "orderDate", column = "order_date"),
    })
    List<OrderDetailDto> getAllOrderDetailByOrderId(int orderId);


    @Select("SELECT sum(quatity) AS QTY FROM dp_order_detail WHERE order_id = #{orderId}")
    int getSumQty(int orderId);



//    @Select("\tSELECT DISTINCT( o.order_id), u.name AS userName, u.phone, ord.order_date\n" +
//            "            FROM dp_order AS o\n" +
//            "            INNER JOIN dp_users AS u ON u.id = o.user_id\n" +
//            "            INNER JOIN dp_shops AS sh ON sh.id = o.shop_id\n" +
//            "            INNER JOIN dp_order_detail AS ord ON ord.order_id = o.id\n" +
//            "\t\t\t\t\t\tWHERE ord.status = 'TRUE' AND ord.is_checkout = 'TRUE'\n" +
//            "\t\t\t\t\t\tORDER BY ord.order_date DESC\n" +
//            "\t\t\t\t\t\tLIMIT 5")

    @Select("SELECT DISTINCT(o.order_id),o.id AS oId, u.user_id, u.name AS userName, u.phone, sh.shop_id, sh.name AS shopName,ord.status,ord.is_checkout, ord.order_date,sum(quatity) qty\n" +
            "            FROM dp_order AS o\n" +
            "INNER JOIN dp_users AS u ON u.id = o.user_id\n" +
            "INNER JOIN dp_shops AS sh ON sh.id = o.shop_id\n" +
            "INNER JOIN dp_order_detail AS ord ON ord.order_id = o.id\n" +
            "WHERE ord.is_checkout = 'TRUE' AND ord.status = 'TRUE'\n" +
            "GROUP BY o.order_id,o.id, u.user_id, u.name, u.phone, sh.shop_id, sh.name,ord.status,ord.is_checkout, ord.order_date\n" +
            "ORDER BY ord.order_date DESC\n" +
            "LIMIT 5")
            @ResultMap("OrderMap")
            //@Select("SELECT * FROM dp_order")
            //@Results(id = "OrderMap", value = {
            //        @Result(column = "id" ,property = "id"),
            //        @Result(column = "order_id" ,property = "orderId"),
            //        @Result(column = "shop_id", property = "shop_id", many = @Many(select = "getShop")),
            //        @Result(column = "user_id", property = "user_id", many = @Many(select = "getUser"))
            //
            //})
    List<OrderDto> getOrdersLatestFiveRecords();


    @SelectProvider(type = OrderProvider.class, method = "getAllOrdersHistoryByUserId")
    @Results({
            @Result(property = "orderDetail.product.proId", column = "pro_id"),
            @Result(property = "orderDetail.product.name", column = "pro_name"),
            @Result(property = "orderDetail.product.price", column = "price"),
            @Result(property = "orderDetail.product.images", column = "images"),
            @Result(property = "orderDetail.product.description", column = "description"),
            @Result(property = "orderDetail.product.status", column = "status"),
            @Result(property = "orderDetail.product.soldStatus", column = "is_sold"),
            @Result(property = "orderDetail.product.viewCount", column = "view_count"),
            @Result(property = "orderDetail.product.details", column = "details"),
            @Result(property = "orderDetail.product.shop_id", column = "shop_id"),
            @Result(property = "orderDetail.product.postDate", column = "post_date"),
            @Result(property = "orderDetail.product.promo_id", column = "promo_id"),
            @Result(property = "orderDetail.product.discount", column = "discount"),


            @Result(property = "orderDetail.quatity", column = "quatity"),
            @Result(property = "orderDetail.itemId", column = "item_id"),
            @Result(property = "orderDetail.orderDate", column = "order_date"),
            @Result(property = "shop.status", column = "status"),
            @Result(property = "orderDetail.checkoutStatus", column = "is_checkout"),

            @Result(property = "orderDetail.detail", column = "detail"),
            @Result(property = "orderDetail.image", column = "image"),
            @Result(property = "orderDetail.status", column = "status"),
//            @Result(property = "orderDetail.order_id", column = "order_id"),
            @Result(property = "orderDetail.pro_id", column = "pro_id"),
//            @Result(property = "orderDetail.order", column = "order_price"),
            @Result(property = "orderDetail.deliveryTracking", column = "delivery_tracking"),
            @Result(property = "orderDetail.destination", column = "destination"),

    })
    List<OrderDto> getAllOrdersHistoryByUserId(int uId, @Param("pagination") Pagination pagination);

    @SelectProvider(type = OrderProvider.class, method = "countId")
    int countId();


    @SelectProvider(type = OrderProvider.class, method = "getOrderByOrderId")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "order_id", property = "orderId")
    }
    )
    OrderDto getOrderByOrderId(@Param("orderId") String orderId);


    //get product by product id
    //find product by id
    @Select("SELECT * FROM dp_products WHERE pro_id = #{proId} AND status = 'true'")
    @Results(id = "mapProduct", value = {
            @Result(column = "pro_id" ,property = "proId"),
            @Result(column = "is_sold" ,property = "soldStatus"),
            @Result(column = "view_count" ,property = "viewCount"),
            @Result(column = "post_date", property = "postDate"),
            @Result(column = "discount", property = "discount"),
            @Result(column = "details" ,property = "details", jdbcType = JdbcType.OTHER, typeHandler = JSONTypeHandlerPg.class),
            @Result(column = "images" ,property = "images", jdbcType = JdbcType.OTHER, typeHandler = JSONTypeHandlerPg.class),
            @Result(column = "shop_id", property = "shop", many = @Many(select = "getShop")),
            @Result(column = "promo_id", property = "promotion", many = @Many(select = "getPromotion"))

    })
    ProductDto findById(String proId);

    //select all shops
    @Select("SELECT * FROM dp_shops WHERE id=#{shop_id} AND status = 'true'")
    @Results(id="shopMap", value = {
            @Result(column = "id" ,property = "id"),
            @Result(column = "shop_id" ,property = "shopId"),
            @Result(column = "name" ,property = "name"),
            @Result(column = "address" ,property = "address"),
            @Result(column = "open_time", property = "openTime"),
            @Result(column = "close_time", property = "closeTime"),
            @Result(column = "u_id", property = "user", many = @Many(select = "getUser")),
            @Result(column = "cat_id", property = "category", many = @Many(select = "getCategory")),
            @Result(column = "promo_id", property = "promotion", many = @Many(select = "getPromotion"))
    })
    ShopDto getShop(int shop_id);

    //get promotion
    @Select("SELECT * FROM dp_promotion WHERE id= #{promo_id}  AND status = 'true'")
    @Results({
            @Result(column = "promo_id", property = "promoId"),
            @Result(column = "is_apply", property = "isApply"),
            @Result(column = "end_date", property = "endDate"),
            @Result(column = "start_date", property = "startDate"),
            @Result(column = "start_rank", property = "startRank"),
            @Result(column = "end_rank", property = "endRank"),
    })
    PromotionDto getPromotion(int promo_id);

}
