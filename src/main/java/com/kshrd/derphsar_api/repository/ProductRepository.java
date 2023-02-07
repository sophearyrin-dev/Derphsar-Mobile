package com.kshrd.derphsar_api.repository;

import com.kshrd.derphsar_api.mybatis.JSONTypeHandlerPg;
import com.kshrd.derphsar_api.page.Pagination;
import com.kshrd.derphsar_api.repository.dto.*;
import com.kshrd.derphsar_api.repository.provider.OrderDetailProvider;
import com.kshrd.derphsar_api.repository.provider.ProductProvider;
import com.kshrd.derphsar_api.repository.provider.WishListProvider;
import com.kshrd.derphsar_api.rest.promotion.request.ApplyProductPromotionRequest;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.data.annotation.QueryAnnotation;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository {

    //get all products
    // @SelectProvider(value = ProductProvider.class, method = "getProducts")
    @Select("SELECT * FROM dp_products WHERE status = 'true' LIMIT #{pagination.limit}  OFFSET #{pagination.offset}")
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
    List<ProductDto> getProducts(@Param("pagination") Pagination pagination);


    @Select("SELECT * FROM dp_products WHERE promo_id = #{promo_id} and status = 'true' LIMIT #{pagination.limit}  OFFSET #{pagination.offset}")
    @ResultMap("mapProduct")
    List<ProductDto> getProductsByPromotionId(@Param("promo_id") int promo_id, @Param("pagination") Pagination pagination);



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
            //@Result(column = "promo_id", property = "promotion", many = @Many(select = "getPromotion"))
    })
    ShopDto getShop(int shop_id);


    @Select("SELECT * FROM dp_users WHERE id = #{user_id}  AND status = 'true'")
    @Results({
            @Result(column = "user_id", property = "userId")
    })
    UserDto getUser(int user_id);


    @Select("SELECT * FROM dp_category WHERE id= #{cate_id}")
    @Results({
            @Result(column = "cat_id", property = "catId")
    })
    CategoryDto getCategory(int cate_id);


//    @Select("SELECT * FROM dp_promotion WHERE id= #{promo_id}  AND status = 'true'")
//    @Results({
//            @Result(column = "promo_id", property = "promoId"),
//            @Result(column = "is_apply", property = "isApply"),
//            @Result(column = "end_date", property = "endDate"),
//            @Result(column = "start_date", property = "startDate"),
//            @Result(column = "start_rank", property = "startRank"),
//            @Result(column = "end_rank", property = "endRank"),
//    })
//    PromotionDto getPromotion(int promo_id);


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


    @Select("SELECT * FROM dp_promotion WHERE promo_id= #{promoId}  AND status = 'true'")
    @Results({
            @Result(column = "promo_id", property = "promoId"),
            @Result(column = "is_apply", property = "isApply"),
            @Result(column = "end_date", property = "endDate"),
            @Result(column = "start_date", property = "startDate"),
            @Result(column = "start_rank", property = "startRank"),
            @Result(column = "end_rank", property = "endRank"),
    })
    PromotionDto getPromotionByPromoString(String promoId);


    //create product
    @Insert("INSERT INTO dp_products (pro_id, name, price, description, status, is_sold, view_count, images , details, shop_id, post_date, discount)" +
            "VALUES ( #{proId}, #{name, jdbcType=VARCHAR}, #{price}, #{description}, #{status}, #{soldStatus}, #{viewCount},#{images, jdbcType=OTHER, typeHandler=com.kshrd.derphsar_api.mybatis.JSONTypeHandlerPg},#{details, jdbcType=OTHER, typeHandler=com.kshrd.derphsar_api.mybatis.JSONTypeHandlerPg}, #{shop_id}, #{postDate}, #{discount})")
    boolean insert(ProductDto productDto);



    //delete product
    @Delete("UPDATE dp_products SET status = FALSE WHERE pro_id =#{id}")
    void deleteProduct(String id);


    //update a product
    @Update("UPDATE dp_products set name = #{product.name}, price = #{product.price}, description= #{product.description} ,status = #{product.status}, is_sold = #{product.soldStatus}, view_count= #{product.viewCount}, images=#{product.images, jdbcType=OTHER, typeHandler=com.kshrd.derphsar_api.mybatis.JSONTypeHandlerPg}, details=#{product.details, jdbcType=OTHER, typeHandler=com.kshrd.derphsar_api.mybatis.JSONTypeHandlerPg}, promo_id = #{product.promotion.id}, discount = #{product.discount} WHERE pro_id = #{id}")
    boolean updateProduct(String id, ProductDto product);

    @Update("UPDATE dp_products set promo_id = NULL, discount = 0 WHERE pro_id = #{id}")
    boolean updateProductPromotionAndDiscount(String id, ProductDto product);


    //Search product by shop
    @Select("SELECT * FROM dp_products WHERE shop_id=#{shopId} AND status = 'true' LIMIT #{pagination.limit}  OFFSET #{pagination.offset}")
    @Results(id = "productMap", value = {
            @Result(column = "pro_id" ,property = "proId"),
            @Result(column = "is_sold" ,property = "soldStatus"),
            @Result(column = "view_count" ,property = "viewCount"),
            @Result(column = "post_date", property = "postDate"),
            @Result(column = "discount", property = "discount"),
            @Result(column = "details" ,property = "details", jdbcType = JdbcType.OTHER, typeHandler = JSONTypeHandlerPg.class),
            @Result(column = "images" ,property = "images", jdbcType = JdbcType.OTHER, typeHandler = JSONTypeHandlerPg.class),
            @Result(column = "shop_id" ,property = "shop",many = @Many(select = "selectOneShop")),
    })
    List<ProductDto> findProductByShopId(@Param("shopId") int shopId, @Param("pagination") Pagination pagination);


    @Select("SELECT * FROM dp_products WHERE shop_id=#{shopId} AND status = 'true'")
    @ResultMap("productMap")
    List<ProductDto> findProductByShopIdWithoutPagination(@Param("shopId") int shopId);




    //select on shop
    @Select("SELECT * FROM dp_shops WHERE id = #{shop_id}")
       @ResultMap("shopMap")
    ShopDto selectOneShop(int shop_id);



    //find product by id
    @Select("SELECT * FROM dp_products WHERE pro_id = #{proId} AND status = 'true'")
    @Results({
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


    @SelectProvider(type = ProductProvider.class, method = "countId")
    int countId();


    @SelectProvider(type = ProductProvider.class,method = "getViewCount")
    int getViewCount(String proId);


    @UpdateProvider(type = ProductProvider.class,method = "updateViewCount")
    void updateViewCount(String proId, int viewCount);


    @Select("SELECT * FROM dp_products AS pro\n" +
            "WHERE status = 'true' AND is_sold = FALSE\n" +
            "ORDER BY pro.post_date DESC\n" +
            "LIMIT 12 ")
        @ResultMap("mapProduct")
    List<ProductDto> getNewProducts();


    @Select("SELECT * \n" +
            "FROM dp_products AS pro\n" +
            "INNER JOIN dp_shops AS sh ON sh.id = pro.shop_id\n" +
            "WHERE pro.status = 'true' AND pro.is_sold = FALSE AND pro.shop_id = #{shopId}\n" +
            "ORDER BY pro.post_date DESC\n" +
            "LIMIT 8 ")
    @ResultMap("mapProduct")
    List<ProductDto> getNewProductsByShopId(int shopId);

    @Select("select p.id, p.pro_id,p.name, p.price, p.status, p.description, p.is_sold, p.view_count, p.post_date, p.discount, p.images, p.shop_id, p.promo_id, p.details from dp_shops s INNER JOIN dp_products p \n" +
            "ON s.id = p.shop_id\n" +
            "where s.cat_id = #{cat_id} and s.status = 'true' and p.status = 'true'")
    @ResultMap("mapProduct")
    List<ProductDto> getAllProductsByCategoryId(int cat_id);

    //get popular products
    @Select("SELECT * FROM dp_products AS pro\n" +
            "WHERE status = 'true'\n" +
            "ORDER BY pro.view_count DESC\n" +
            "LIMIT 12")
        @ResultMap("mapProduct")
    List<ProductDto> getPopularProducts();


    @SelectProvider(type = ProductProvider.class, method = "getAllProductsByUserId")
    @Results({
            @Result(property = "proId", column = "pro_id"),
            @Result(property = "name", column = "proName"),
            @Result(property = "price", column = "price"),
            @Result(property = "images", column = "images"),
            @Result(property = "viewCount", column = "view_count"),
            @Result(property = "shop.name", column = "shopName"),
            @Result(property = "shop.status", column = "status"),

    })
    List<ProductDto> getAllProductsByUserId(int uId, @Param("pagination") Pagination pagination);


    @Select("SELECT * FROM dp_products AS pro\n" +
            "INNER JOIN dp_shops AS sh ON pro.shop_id = sh.id\n" +
            "INNER JOIN dp_category AS c ON sh.cat_id = c.id\n" +
            "WHERE pro.status = 'TRUE' AND c.id = #{c.id}\n" +
            "ORDER BY pro.post_date DESC\n" +
            "LIMIT 12")
    @ResultMap("mapProduct")
    List<ProductDto> getRelatedProducts(int categoryId);

    @Select("SELECT * FROM dp_category WHERE cat_id = #{catId}")
    CategoryDto getCategoryByCatId(String catId);


    @Select("SELECT * FROM dp_shops WHERE shop_id = #{shopId}")
    ShopDto getShopByShopId(String shopId);

    //get all products by product name

//    @SelectProvider(type = ProductProvider.class,method = "getAllProductByProductName")
//    @Select("select id, pro_id,name, price, status, description, is_sold, view_count, post_date, discount, images, details, promo_id, shop_id from dp_products where name ILIKE CONCAT('%', #{name}, '%')")
//    @Select("select * from dp_products where name LIKE CONCAT('%', #{name}, '%')")
    @Select("SELECT * FROM dp_products WHERE status = 'true' and name ILIKE CONCAT('%', #{name}, '%')")
    @ResultMap("mapProduct")
    List<ProductDto> getAllProductByProductName(@Param("name") String name);


//    @UpdateProvider(type = ProductProvider.class, method = "updateProductPromotion")
//    boolean updateProductPromotion(int  shop_id);

    @Update("UPDATE dp_products set promo_id = #{product.promo_id}, discount = #{product.discount} WHERE id = #{proId}")
    boolean updateProductPromotion(int proId, ApplyProductPromotionRequest product);
}
