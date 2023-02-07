package com.kshrd.derphsar_api.repository.provider;

import com.kshrd.derphsar_api.page.Pagination;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

public class OrderProvider {

    public String getAllOrderByShopId(int shopId){
        return new SQL(){{
            SELECT("DISTINCT(o.order_id) , u.name AS userName, u.user_id, u.phone, sh.shop_id, sh.name AS shopName, ord.item_id, ord.quatity, ord.order_date");
            FROM("dp_order AS o");
            INNER_JOIN("dp_users AS u ON u.id = o.user_id");
            INNER_JOIN("dp_shops AS sh ON sh.id = o.shop_id");
            INNER_JOIN("dp_order_detail AS ord ON ord.order_id = o.id");
            WHERE("o.shop_id = #{shopId}");

        }}.toString();
    }

    //get all products
    public String getOrder(@Param("pagination") Pagination pagination) {
        return new SQL(){{
            SELECT("*");
            FROM("dp_order");
            LIMIT("#{pagination.limit}  OFFSET #{pagination.offset}");
        }}.toString();
    }


    public String countId(){
        return new SQL(){{
            SELECT("COUNT(id)");
            FROM("dp_order");
        }}.toString();
    }

    public String orderDetailByOrderId(int orderId) {
        return new SQL(){{
            SELECT("item_id, quatity, order_date");
            FROM("dp_order_detail");
            WHERE("order_id = #{orderId}");
        }}.toString();
    }

    public String getAllOrdersHistoryByUserId(int uId, @Param("pagination") Pagination pagination){
        return new SQL(){{
            SELECT("pro.name as pro_name, u.name as u_name, *");
            FROM ("dp_order AS o");
            INNER_JOIN ("dp_users AS u ON o.user_id = u.id");
            INNER_JOIN ("dp_order_detail AS od ON od.order_id = o.id");
            INNER_JOIN ("dp_products AS pro ON od.pro_id = pro.id");
            WHERE ("u.id =  #{uId} AND od.is_checkout = TRUE");
            ORDER_BY("od.order_date DESC");
            LIMIT(pagination.getLimit());
            OFFSET(pagination.getOffset());
        }}.toString();
    }


    //get one order by order id
    public String getOrderByOrderId(@Param("orderId") String orderId){
        return new SQL(){{
            SELECT("*");
            FROM("dp_order");
            WHERE("order_id = #{orderId}");
        }}.toString();
    }




}
