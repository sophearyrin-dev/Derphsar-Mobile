package com.kshrd.derphsar_api.repository;


import com.kshrd.derphsar_api.page.Pagination;
import com.kshrd.derphsar_api.repository.dto.*;
import com.kshrd.derphsar_api.repository.provider.PromotionProvider;
import com.kshrd.derphsar_api.rest.ApplyProductPromotion.request.ApplyProductPromotionRequestModel;
import com.kshrd.derphsar_api.rest.applyshoppromotion.request.ApplyShopPromotionRequestModel;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PromotionRepository {

    //get all promotions
//    @SelectProvider(value = PromotionProvider.class, method = "getPromotions")
    @Select("SELECT * FROM dp_promotion WHERE status = 'TRUE' LIMIT #{pagination.limit}  OFFSET #{pagination.offset}")
    @Results(id = "mapPromotion", value = {
            @Result(column = "id", property = "id"),
            @Result(column = "promo_id" ,property = "promoId"),
            @Result(column = "is_apply" ,property = "isApply"),
            @Result(column = "start_date" ,property = "startDate"),
            @Result(column = "end_date" ,property = "endDate"),
            @Result(column = "start_rank" ,property = "startRank"),
            @Result(column = "end_rank" ,property = "endRank"),
            @Result(column = "id", property = "shop", many = @Many(select = "getShop"))
//           @Result(column = "pro_id", property = "product", many = @Many(select = "getProduct"))
    })
    List<PromotionDto> getPromotions(@Param("pagination") Pagination pagination);


    @Select("SELECT * FROM dp_shops WHERE id = #{shop_id} AND status = 'true'")
    @Results(id = "mapShop", value = {
            @Result(column = "shop_id", property = "shopId"),
            @Result(column = "is_open", property = "openStatus"),
            @Result(column = "open_time", property = "openTime"),
            @Result(column = "close_time", property = "closeTime"),
            @Result(column = "u_id", property = "user", many = @Many(select = "getUser")),
            @Result(column = "cat_id", property = "category", many = @Many(select = "getCategory")),
            @Result(column = "u_id", property = "u_id"),
            @Result(column = "cat_id", property = "cat_id")

    })
    ShopDto getShop(int shop_id);


    @Select("SELECT * FROM dp_users WHERE id = #{user_id}  AND status = 'true'")
    @Results({
            //my comment code here
            @Result(column = "user_id", property = "userId")
    })
    UserDto getUser(int user_id);



    @Select("SELECT * FROM dp_category WHERE id = #{cate_id}")
    @Results({
            @Result(column = "cat_id", property = "catId")
    })
    CategoryDto getCategory(int cate_id);


    //select all product
    @Select("SELECT * FROM dp_products WHERE id=#{pro_id} AND status = 'TRUE'")
    @Results({
            @Result(column = "id" ,property = "id"),
            @Result(column = "pro_id" ,property = "proId"),
            @Result(column = "pro_name" ,property = "name"),
            @Result(column = "pro_price" ,property = "price")
    })
    ProductDto getProduct(int pro_id);


    //delete promotions
    @Delete("UPDATE dp_promotion SET status = FALSE WHERE id =#{promoId}; UPDATE dp_shops set promo_id = NULL where promo_id =#{promoId} ")
    void deletePromotion(int promoId);


    // delete shop promotion
    @Delete("UPDATE dp_shop_promotion SET status = FALSE WHERE shop_id = #{shop_id};")
    boolean deleteShopPromotionByShopId(int shop_id);


    //update a promotion
    @Update("UPDATE dp_promotion SET title = #{promotion.title}, is_apply = #{promotion.isApply}, start_date= #{promotion.startDate} ,end_date = #{promotion.endDate},start_rank = #{promotion.startRank}, end_rank= #{promotion.endRank},cover = #{promotion.cover}, status = #{promotion.status}  WHERE promo_id = #{id}")
    boolean updatePromotion(String id, PromotionDto promotion);


    //update is apply
    @Update("UPDATE dp_promotion SET is_apply = #{promotion.isApply} WHERE promo_id = #{id}")
    boolean updateIsApply(String id, PromotionDto promotion);

//    //update is apply
//    @Update("UPDATE dp_products SET discount = #{productDto.discount} WHERE pro_id = #{id}")
//    boolean applyPromotion(String id, ProductDto productDto);


    //create a promotion
    @Insert("INSERT INTO dp_promotion (promo_id, title, is_apply, start_rank, start_date, end_date, status , end_rank, u_id, cover)" +
            "VALUES (#{promoId, jdbcType=VARCHAR}, #{title}, #{isApply}, #{startRank}, #{startDate}, #{endDate}, TRUE, #{endRank}, #{u_id}, #{cover})")
    boolean createPromotion(PromotionDto promotionDto);



    //Search promotion by user id
    @Select("SELECT * FROM dp_promotion WHERE u_id=#{u_id} AND status = 'TRUE'")
        @ResultMap("mapPromotion")
    List<PromotionDto> findPromotionByShopId(@Param("u_id") int u_d);



    //select on shop
    @Select("SELECT * FROM dp_shops WHERE id = #{shop_id}")
        @ResultMap("mapShop")
    ShopDto selectOneShop(int shop_id);


    //find product by id
    @Select("SELECT * FROM dp_promotion WHERE promo_id = #{promoId} AND status = 'TRUE'")
        @ResultMap("mapPromotion")
    PromotionDto findById(String promoId);

    //find shop promotion by shop id
    @Select("SELECT * FROM dp_shop_promotion WHERE shop_id = #{shop_id} AND status = 'TRUE'")
    PromotionDto findByShopId(int shop_id);


    //apply shop promotion
    @Insert("INSERT INTO dp_shop_promotion (promotion_id, shop_id)" +
            "VALUES (#{promo_id}, #{shop_id})")
    boolean applyShopPromotion(ApplyShopPromotionRequestModel applyShopPromotionRequestModel);


    // get promotion in shop
    @Select("SELECT * FROM dp_shop_promotion WHERE shop_id = #{shop_id} AND status = 'TRUE'")
    @Results({

            @Result(column = "promotion_id", property = "promotion", many = @Many(select = "getPromotionByPromotionId")),

    })
    List<PromotionDto> getPromotionByShopId(int shop_id);


    //apply product promotion
    @Insert("INSERT INTO dp_product_promotion (promotion_id, product_id)"+
            "VALUES (#{promotion_id}, #{product_id})")
    boolean applyProductPromotion(ApplyProductPromotionRequestModel applyProductPromotionRequestModel);


    //get product by promotion id
    @SelectProvider(value = PromotionProvider.class, method = "getProductByPromotionId")
    @Results({
            @Result(column = "promo_id" ,property = "promo_id"),
            @Result(column = "pro_id", property = "proId"),
    })
    List<ProductDto> getProductByPromotionId(int promo_id);


    //get shop by promotion id
    @SelectProvider(value = PromotionProvider.class, method = "getShopByPromotionId")
    @Results({
            @Result(column = "promotion_id" ,property = "promo_id"),
    })
    List<ShopDto> getShopByPromotionId(int promotion);


    //update shop promotion by promo_id
    @Update("UPDATE dp_shop_promotion SET shop_id = #{shopDto.shop_id} WHERE promotion_id = #{promotion_id}")
    boolean updateShopPromotion(int promotion_id, ShopDto shopDto);

    @Select("select * from dp_promotion where id = #{promo_id}")
    @ResultMap("mapPromotion")
    PromotionDto getPromotionByPromotionId(int promo_id);


    /// apply shop promotion
    @Update("UPDATE dp_products SET discount = #{productDto.discount} WHERE pro_id = #{id}")
    boolean applyShopMyPromotion(String id, ProductDto productDto);


    @Select("select * from dp_promotion where u_id = #{userId} and status = 'true'")
    @Results({
            @Result(column = "promo_id" ,property = "promoId"),
            @Result(column = "is_apply" ,property = "isApply"),
            @Result(column = "start_date" ,property = "startDate"),
            @Result(column = "end_date" ,property = "endDate"),
            @Result(column = "start_rank" ,property = "startRank"),
            @Result(column = "end_rank" ,property = "endRank"),
            @Result(column = "u_id", property = "user", many = @Many(select = "getUser")),
    })
    List<PromotionDto> getPromotionByUserId(int userId);

    // update shop promotion by shop id Vesal
    @Update("UPDATE dp_shops SET promo_id = NULL WHERE shop_id = #{shopDto.shopId}")
    boolean updateShopPromotionByShopId(int shop_id, ShopDto shopDto);


    @Select("SELECT * FROM dp_promotion WHERE promo_id = #{promoId} and status = 'true'")
    @Results({
            @Result(column = "promo_id" ,property = "promoId"),
            @Result(column = "is_apply" ,property = "isApply"),
            @Result(column = "start_date" ,property = "startDate"),
            @Result(column = "end_date" ,property = "endDate"),
            @Result(column = "start_rank" ,property = "startRank"),
            @Result(column = "end_rank" ,property = "endRank"),
            @Result(column = "u_id", property = "user", many = @Many(select = "getUser")),
    })
    PromotionDto getPromotionByPromoIdString(@Param("promo_id") String  promoId);

}
