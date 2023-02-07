//package com.kshrd.derphsar_api.repository;
//
//import com.kshrd.derphsar_api.page.Pagination;
//import com.kshrd.derphsar_api.repository.dto.*;
//import com.kshrd.derphsar_api.repository.provider.SubResourceProvider;
//import com.kshrd.derphsar_api.rest.shop.request.ApplyShopPromotionRequestModel2;
//import org.apache.ibatis.annotations.*;
//import org.springframework.stereotype.Repository;
//import java.util.List;
//
//@Repository
//public interface ShopRepository {
//
//    //Insert a shop
//    @Insert("INSERT INTO dp_shops(shop_id, name, address, description, profile, cover, contact, is_open, status, open_time, close_time, u_id, cat_id) "+
//            "VALUES (#{shopId}, #{name}, #{address}, #{description}, #{profile}, #{cover}, #{contact}, #{openStatus}, #{status}, #{openTime}, #{closeTime}, #{u_id}, #{cat_id})")
//
//    boolean insert(ShopDto shop);
//
////    @Select("SELECT sh.*, sh.name AS shopName, sh.profile AS shopProfile, sh.status AS shopStatus, cat.*, cat.name AS catName, u.*,u.name AS userName, u.profile AS userProfile, u.status AS userStatus\n" +
////            "\t\t\t\t\t\tFROM dp_shops AS sh\n" +
////            "\t\t\t\t\t\tINNER JOIN dp_category AS cat ON sh.cat_id = cat.id\n" +
////            "\t\t\t\t\t\tINNER JOIN dp_users AS u ON sh.u_id = u.id\n" +
////            "\t\t\t\t\t\tWHERE sh.status = 'TRUE' LIMIT #{pagination.limit}  OFFSET #{pagination.offset}")
////    @Results(id = "mapShop", value = {
////            @Result(column = "shopId", property = "id"),
////            @Result(column = "shop_id" ,property = "shopId"),
////            @Result(column = "is_open" ,property = "openStatus"),
////            @Result(column = "shopName" ,property = "name"),
////            @Result(column = "open_time" ,property = "openTime"),
////            @Result(column = "close_time" ,property = "closeTime"),
////            @Result(column = "shopProfile" ,property = "profile"),
////            @Result(column = "shopStatus" ,property = "status"),
////            @Result(column = "is_open" ,property = "openStatus"),
////
////            @Result(column = "id", property = "user.id"),
////            @Result(column = "userId", property = "user.id"),
////            @Result(column = "user_id" ,property = "user.userId"),
////            @Result(column = "userName" ,property = "user.name"),
////            @Result(column = "gender" ,property = "user.gender"),
////            @Result(column = "age" ,property = "user.age"),
////            @Result(column = "phone" ,property = "user.phone"),
////            @Result(column = "email" ,property = "user.email"),
////            @Result(column = "password" ,property = "user.password"),
////            @Result(column = "status" ,property = "user.status"),
////            @Result(column = "userProfile" ,property = "user.profile"),
////            @Result(column = "userStatus" ,property = "user.status"),
////
////            @Result(column = "categoryId", property = "category.id"),
////            @Result(column = "cat_id" ,property = "category.catId"),
////            @Result(column = "catName" ,property = "category.name"),
////
////            //@Result(column = "id" ,property = "promotion.shop_id",many = @Many(select = "findPromotionByShopId")),
////    })
//
//<<<<<<< HEAD
//    @Select("SELECT * FROM dp_shops where status = 'true' LIMIT #{pagination.limit}  OFFSET #{pagination.offset}")
//    @ResultMap("shopMap3")
//=======
//            @Result(column = "id" ,property = "promotion1",many = @Many(select = "getPromotion")),
//    })
//>>>>>>> 13017992279b8c33466fdfd8c4497bcc64511059
//    List<ShopDto> select(@Param("pagination") Pagination pagination);
//
//
//    @Select("SELECT promo.* \n" +
//            "\t\t\t\t\t\tFROM dp_promotion AS promo\n" +
//            "\t\t\t\t\t\tINNER JOIN  dp_shops AS sh ON sh.id = promo.shop_id\n" +
//            "\t\t\t\t\t\tWHERE sh.id = #{shopId} AND promo.status = 'TRUE'")
//    List<PromotionDto> getAllpromotionsByShopId(int shopId);
//
//
//    //Delete a shop
//    @Delete("UPDATE dp_shops SET status = FALSE WHERE id = #{shop_id}; UPDATE dp_products SET status = false WHERE shop_id = #{shop_id}")
//    // @Delete("UPDATE dp_products SET status = FALSE WHERE shop_id = #{shop_id}")
//    void delete(int shop_id);
//
//
//    @Select("SELECT id from dp_shops where shop_id = #{shop_id}")
//    int getShopID(String shop_id);
//
//
//    //Update a shop
//    @Update("UPDATE dp_shops SET name = #{shop.name}, address = #{shop.address}, description= #{shop.description} , profile= #{shop.profile} , cover= #{shop.cover} , status = #{shop.status}, is_open = #{shop.openStatus}, contact= #{shop.contact}, open_time= #{shop.openTime}, close_time = #{shop.closeTime} WHERE shop_id = #{shop_id}")
//    @Results(id = "mapShop2", value = {
////                @Result(column = "id", property = "id"),
//            @Result(column = "shop_id" ,property = "shopId"),
//            @Result(column = "is_open" ,property = "openStatus"),
//            @Result(column = "shopName" ,property = "name"),
//            @Result(column = "open_time" ,property = "openTime"),
//            @Result(column = "close_time" ,property = "closeTime"),
//            @Result(column = "shopProfile" ,property = "profile"),
//            @Result(column = "status" ,property = "status"),
//            @Result(column = "is_open" ,property = "openStatus"),
//            @Result(column = "contact", property = "contact"),
////            @Result(column = "phone")
//
////                @Result(column = "u_id", property = "user.id"),
//            @Result(column = "user_id" ,property = "user.userId"),
//            @Result(column = "userName" ,property = "user.name"),
//            @Result(column = "gender" ,property = "user.gender"),
//            @Result(column = "age" ,property = "user.age"),
//            @Result(column = "phone" ,property = "user.phone"),
//            @Result(column = "email" ,property = "user.email"),
//            @Result(column = "password" ,property = "user.password"),
//            @Result(column = "status" ,property = "user.status"),
//            @Result(column = "userProfile" ,property = "user.profile"),
//            @Result(column = "userStatus" ,property = "user.status"),
//
////                @Result(column = "cat_id", property = "category.id"),
//            @Result(column = "cat_id" ,property = "category.catId"),
//            @Result(column = "catName" ,property = "category.name"),
//
//            //@Result(column = "id" ,property = "promotion.shop_id",many = @Many(select = "findPromotionByShopId")),
//    })
//
//    boolean update(String shop_id, ShopDto shop);
//
//
////    //get all shop
////    @Select("SELECT * FROM dp_shops WHERE id=#{shop_id} AND status = 'true'")
////    @Results(id="shopMap", value = {
////            @Result(column = "id" ,property = "id"),
////            @Result(column = "shop_id" ,property = "shopId"),
////            @Result(column = "name" ,property = "name"),
////            @Result(column = "address" ,property = "address"),
////            @Result(column = "open_time", property = "openTime"),
////            @Result(column = "close_time", property = "closeTime"),
////            @Result(column = "u_id", property = "user", many = @Many(select = "getUser")),
////            @Result(column = "cat_id", property = "category", many = @Many(select = "getCategory")),
////            //@Result(column = "promo_id", property = "promotion", many = @Many(select = "getPromotion"))
////    })
////    ShopDto getShop(String shop_id);
////
////
////    //get user
////    @Select("SELECT * FROM dp_users WHERE id = #{user_id}  AND status = 'true'")
////    @Results({
////            @Result(column = "user_id", property = "userId")
////    })
////    UserDto getUser(int user_id);
////
////
////    @Select("SELECT * FROM dp_category WHERE id= #{cate_id}")
////    @Results({
////            @Result(column = "cat_id", property = "catId")
////    })
////    CategoryDto getCategory(int cate_id);
//
//
//    //find by id
//    @Select("SELECT sh.*, sh.name AS shopName, sh.profile AS shopProfile, sh.status AS shopStatus, cat.*, cat.name AS catName, u.*,u.name AS userName, u.profile AS userProfile, u.status AS userStatus\n" +
//            "\t\t\t\t\t\tFROM dp_shops AS sh\n" +
//            "\t\t\t\t\t\tINNER JOIN dp_category AS cat ON sh.cat_id = cat.id\n" +
//            "\t\t\t\t\t\tINNER JOIN dp_users AS u ON sh.u_id = u.id\n" +
//            "\t\t\t\t\t\tWHERE sh.status = 'TRUE' AND  sh.shop_id = #{shopId}")
//
//    @Results(id = "find", value = {
//            @Result(column = "id", property = "id"),
//            @Result(column = "shop_id" ,property = "shopId"),
//            @Result(column = "is_open" ,property = "openStatus"),
//            @Result(column = "shopName" ,property = "name"),
//            @Result(column = "open_time" ,property = "openTime"),
//            @Result(column = "close_time" ,property = "closeTime"),
//            @Result(column = "shopProfile" ,property = "profile"),
//            @Result(column = "shopStatus" ,property = "status"),
//            @Result(column = "is_open" ,property = "openStatus"),
//
//            @Result(column = "u_id", property = "user.id"),
//            @Result(column = "user_id" ,property = "user.userId"),
//            @Result(column = "userName" ,property = "user.name"),
//            @Result(column = "gender" ,property = "user.gender"),
//            @Result(column = "age" ,property = "user.age"),
//            @Result(column = "phone" ,property = "user.phone"),
//            @Result(column = "email" ,property = "user.email"),
//            @Result(column = "password" ,property = "user.password"),
//            @Result(column = "status" ,property = "user.status"),
//            @Result(column = "userProfile" ,property = "user.profile"),
//            @Result(column = "userStatus" ,property = "user.status"),
//
//            @Result(column = "cat_id", property = "category.id"),
//            @Result(column = "cat_id" ,property = "category.catId"),
//            @Result(column = "catName" ,property = "category.name"),
//    })
//    ShopDto findById(String shopId);
//
//
//    ShopDto findProductByCategory(String categoryId);
//
//
//    //Search shop by user
////    @Select("SELECT sh.*, sh.name AS shopName, sh.profile AS shopProfile, sh.status AS shopStatus, cat.*, cat.name AS catName, u.*,u.name AS userName, u.profile AS userProfile, u.status AS userStatus\n" +
////            "\t\t\t\t\t\tFROM dp_shops AS sh\n" +
////            "\t\t\t\t\t\tINNER JOIN dp_category AS cat ON sh.cat_id = cat.id\n" +
////            "\t\t\t\t\t\tINNER JOIN dp_users AS u ON sh.u_id = u.id\n" +
////            "\t\t\t\t\t\tWHERE sh.u_id = #{id} AND sh.status = 'TRUE'")
//
////    @ResultMap("find")
//
//@Select("SELECT * FROM dp_shops WHERE u_id=#{id} AND status = 'true'")
//    @ResultMap("shopMap3")
//    List<ShopDto> getAllShopsByUserId(int id);
//
//
//    @SelectProvider(type = SubResourceProvider.class, method = "getUserByUserId")
//    UserDto getUserByUserId(String userId);
//
//
//    //count all shops
//    @Select("SELECT COUNT(id) FROM dp_shops WHERE status = 'true'")
//    int countId();
//
//
//    //select all shops
//    @Select("SELECT * FROM dp_shops WHERE id=#{shop_id} AND status = 'true'")
//    @Results(id="shopMap", value = {
//            @Result(column = "id" ,property = "id"),
//            @Result(column = "shop_id" ,property = "shopId"),
//            @Result(column = "name" ,property = "name"),
//            @Result(column = "address" ,property = "address"),
//            @Result(column = "open_time", property = "openTime"),
//            @Result(column = "close_time", property = "closeTime"),
//            @Result(column = "u_id", property = "user", many = @Many(select = "getUser")),
//            @Result(column = "cat_id", property = "category", many = @Many(select = "getCategory")),
//            @Result(column = "promo_id", property = "promotion1", many = @Many(select = "getPromotion"))
//    })
//    ShopDto getShop(int shop_id);
//
//
//    @Select("SELECT * FROM dp_users WHERE id = #{user_id}  AND status = 'true'")
//    @Results({
//            @Result(column = "user_id", property = "userId")
//    })
//    UserDto getUser(int user_id);
//
//
//    @Select("SELECT * FROM dp_category WHERE id= #{cate_id}")
//    @Results({
//            @Result(column = "cat_id", property = "catId")
//    })
//    CategoryDto getCategory(int cate_id);
//
//    //get all shops by shop name
//    @Select("SELECT * FROM dp_shops WHERE status = 'true' and name ILIKE CONCAT('%', #{name}, '%')")
//    @ResultMap("shopMap")
//    List<ShopDto> getAllShopsByShopName(@Param("name") String name);
//
//
//    @Select("SELECT * FROM dp_shops WHERE id=#{shopId} AND status = 'true'")
//    @Results(id="shopMap3", value = {
//            @Result(column = "id" ,property = "id"),
//            @Result(column = "shop_id" ,property = "shopId"),
//            @Result(column = "name" ,property = "name"),
//            @Result(column = "address" ,property = "address"),
//            @Result(column = "open_time", property = "openTime"),
//            @Result(column = "close_time", property = "closeTime"),
//            @Result(column = "u_id", property = "user", many = @Many(select = "getUser")),
//            @Result(column = "cat_id", property = "category", many = @Many(select = "getCategory")),
//            @Result(column = "promo_id", property = "promotion1", many = @Many(select = "getPromotion"))
//    })
//    ShopDto getPromotionByShopId2(@Param("shopId") int shopId);
//
//
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
//
//
//    @Update("UPDATE dp_shops set promo_id = #{product.promo_id} WHERE id = #{shopId}")
//    boolean updateShopPromotion(int shopId, ApplyShopPromotionRequestModel2 product);
//
//
//    // delete promotion by shop id
//    @Update("UPDATE dp_shops set promo_id = NULL WHERE shop_id = #{shopId}")
//    boolean deleteShopPromotionByShopId(String shopId);
//
//
//
//
//}
//







package com.kshrd.derphsar_api.repository;

import com.kshrd.derphsar_api.page.Pagination;
import com.kshrd.derphsar_api.repository.dto.*;
import com.kshrd.derphsar_api.repository.provider.SubResourceProvider;
import com.kshrd.derphsar_api.rest.shop.request.ApplyShopPromotionRequestModel2;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ShopRepository {

    //Insert a shop
    @Insert("INSERT INTO dp_shops(shop_id, name, address, description, profile, cover, contact, is_open, status, open_time, close_time, u_id, cat_id) "+
            "VALUES (#{shopId}, #{name}, #{address}, #{description}, #{profile}, #{cover}, #{contact}, #{openStatus}, #{status}, #{openTime}, #{closeTime}, #{u_id}, #{cat_id})")

    boolean insert(ShopDto shop);

    @Select("SELECT sh.*, sh.name AS shopName, sh.profile AS shopProfile, sh.status AS shopStatus, cat.*, cat.name AS catName, u.*,u.name AS userName, u.profile AS userProfile, u.status AS userStatus\n" +
            "\t\t\t\t\t\tFROM dp_shops AS sh\n" +
            "\t\t\t\t\t\tINNER JOIN dp_category AS cat ON sh.cat_id = cat.id\n" +
            "\t\t\t\t\t\tINNER JOIN dp_users AS u ON sh.u_id = u.id\n" +
            "\t\t\t\t\t\tWHERE sh.status = 'TRUE' LIMIT #{pagination.limit}  OFFSET #{pagination.offset}")
    @Results(id = "mapShop", value = {
            @Result(column = "id", property = "id"),
            @Result(column = "shopId", property = "id"),
            @Result(column = "shop_id" ,property = "shopId"),
            @Result(column = "is_open" ,property = "openStatus"),
            @Result(column = "shopName" ,property = "name"),
            @Result(column = "open_time" ,property = "openTime"),
            @Result(column = "close_time" ,property = "closeTime"),
            @Result(column = "shopProfile" ,property = "profile"),
            @Result(column = "shopStatus" ,property = "status"),
            @Result(column = "is_open" ,property = "openStatus"),

            @Result(column = "id", property = "user.id"),
            @Result(column = "userId", property = "user.id"),
            @Result(column = "user_id" ,property = "user.userId"),
            @Result(column = "userName" ,property = "user.name"),
            @Result(column = "gender" ,property = "user.gender"),
            @Result(column = "age" ,property = "user.age"),
            @Result(column = "phone" ,property = "user.phone"),
            @Result(column = "email" ,property = "user.email"),
            @Result(column = "password" ,property = "user.password"),
            @Result(column = "status" ,property = "user.status"),
            @Result(column = "userProfile" ,property = "user.profile"),
            @Result(column = "userStatus" ,property = "user.status"),

            @Result(column = "categoryId", property = "category.id"),
            @Result(column = "cat_id" ,property = "category.catId"),
            @Result(column = "catName" ,property = "category.name"),

            @Result(column = "id" ,property = "promotion1",many = @Many(select = "getPromotion")),
    })
    List<ShopDto> select(@Param("pagination") Pagination pagination);


    @Select("SELECT promo.* \n" +
            "\t\t\t\t\t\tFROM dp_promotion AS promo\n" +
            "\t\t\t\t\t\tINNER JOIN  dp_shops AS sh ON sh.id = promo.shop_id\n" +
            "\t\t\t\t\t\tWHERE sh.id = #{shopId} AND promo.status = 'TRUE'")
    List<PromotionDto> getAllpromotionsByShopId(int shopId);


    //Delete a shop
    @Delete("UPDATE dp_shops SET status = FALSE WHERE id = #{shop_id}; UPDATE dp_products SET status = false WHERE shop_id = #{shop_id}")
    // @Delete("UPDATE dp_products SET status = FALSE WHERE shop_id = #{shop_id}")
    void delete(int shop_id);


    @Select("SELECT id from dp_shops where shop_id = #{shop_id}")
    int getShopID(String shop_id);


    //Update a shop
    @Update("UPDATE dp_shops SET name = #{shop.name}, address = #{shop.address}, description= #{shop.description} , profile= #{shop.profile} , cover= #{shop.cover} , status = #{shop.status}, is_open = #{shop.openStatus}, open_time= #{shop.openTime}, close_time = #{shop.closeTime}, contact= #{shop.contact} WHERE shop_id = #{shop_id}")
    @ResultMap("shopMap3")
    boolean update(String shop_id, ShopDto shop);

    @Update("UPDATE dp_shops SET promo_id= #{shop.promo_id} WHERE shop_id = #{shop_id}")
    @ResultMap("shopMap3")
    boolean updateShopPromoId(String shop_id, ShopDto shop);


//    //get all shop
//    @Select("SELECT * FROM dp_shops WHERE id=#{shop_id} AND status = 'true'")
//    @Results(id="shopMap", value = {
//            @Result(column = "id" ,property = "id"),
//            @Result(column = "shop_id" ,property = "shopId"),
//            @Result(column = "name" ,property = "name"),
//            @Result(column = "address" ,property = "address"),
//            @Result(column = "open_time", property = "openTime"),
//            @Result(column = "close_time", property = "closeTime"),
//            @Result(column = "u_id", property = "user", many = @Many(select = "getUser")),
//            @Result(column = "cat_id", property = "category", many = @Many(select = "getCategory")),
//            //@Result(column = "promo_id", property = "promotion", many = @Many(select = "getPromotion"))
//    })
//    ShopDto getShop(String shop_id);
//
//
//    //get user
//    @Select("SELECT * FROM dp_users WHERE id = #{user_id}  AND status = 'true'")
//    @Results({
//            @Result(column = "user_id", property = "userId")
//    })
//    UserDto getUser(int user_id);
//
//
//    @Select("SELECT * FROM dp_category WHERE id= #{cate_id}")
//    @Results({
//            @Result(column = "cat_id", property = "catId")
//    })
//    CategoryDto getCategory(int cate_id);


    //find by id
    @Select("SELECT sh.*, sh.name AS shopName, sh.profile AS shopProfile, sh.status AS shopStatus, cat.*, cat.name AS catName, u.*,u.name AS userName, u.profile AS userProfile, u.status AS userStatus\n" +
            "\t\t\t\t\t\tFROM dp_shops AS sh\n" +
            "\t\t\t\t\t\tINNER JOIN dp_category AS cat ON sh.cat_id = cat.id\n" +
            "\t\t\t\t\t\tINNER JOIN dp_users AS u ON sh.u_id = u.id\n" +
            "\t\t\t\t\t\tWHERE sh.status = 'TRUE' AND  sh.shop_id = #{shopId}")

    @Results(id = "find", value = {
            @Result(column = "id", property = "id"),
            @Result(column = "shop_id" ,property = "shopId"),
            @Result(column = "is_open" ,property = "openStatus"),
            @Result(column = "shopName" ,property = "name"),
            @Result(column = "open_time" ,property = "openTime"),
            @Result(column = "close_time" ,property = "closeTime"),
            @Result(column = "shopProfile" ,property = "profile"),
            @Result(column = "shopStatus" ,property = "status"),
            @Result(column = "is_open" ,property = "openStatus"),

            @Result(column = "u_id", property = "user.id"),
            @Result(column = "user_id" ,property = "user.userId"),
            @Result(column = "userName" ,property = "user.name"),
            @Result(column = "gender" ,property = "user.gender"),
            @Result(column = "age" ,property = "user.age"),
            @Result(column = "phone" ,property = "user.phone"),
            @Result(column = "email" ,property = "user.email"),
            @Result(column = "password" ,property = "user.password"),
            @Result(column = "status" ,property = "user.status"),
            @Result(column = "userProfile" ,property = "user.profile"),
            @Result(column = "userStatus" ,property = "user.status"),

            @Result(column = "cat_id", property = "category.id"),
            @Result(column = "cat_id" ,property = "category.catId"),
            @Result(column = "catName" ,property = "category.name"),

            @Result(column = "id" ,property = "promotion1",many = @Many(select = "getPromotion")),

    })
    ShopDto findById(String shopId);

    @Select("SELECT sh.*, sh.name AS shopName, sh.profile AS shopProfile, sh.status AS shopStatus, cat.*, cat.name AS catName, u.*,u.name AS userName, u.profile AS userProfile, u.status AS userStatus\n" +
            "\t\t\t\t\t\tFROM dp_shops AS sh\n" +
            "\t\t\t\t\t\tINNER JOIN dp_category AS cat ON sh.cat_id = cat.id\n" +
            "\t\t\t\t\t\tINNER JOIN dp_users AS u ON sh.u_id = u.id\n" +
            "\t\t\t\t\t\tWHERE sh.status = 'TRUE' AND  sh.id = #{shopId}")

    @ResultMap("find")
    ShopDto getShopByShopIdInt(int shopId);

//    @Select("SELECT * FROM dp_shops WHERE id=#{shopId} AND status = 'true'")
//    @Results(id="shopMap4", value = {
//            @Result(column = "id" ,property = "id"),
//            @Result(column = "shop_id" ,property = "shopId"),
//            @Result(column = "name" ,property = "name"),
//            @Result(column = "address" ,property = "address"),
//            @Result(column = "open_time", property = "openTime"),
//            @Result(column = "close_time", property = "closeTime"),
//            @Result(column = "u_id", property = "user", many = @Many(select = "getUser")),
//            @Result(column = "cat_id", property = "category", many = @Many(select = "getCategory")),
//            @Result(column = "promo_id", property = "promotion1", many = @Many(select = "getPromotion"))
//    })
//    ShopDto findById(String shopId);


    ShopDto findProductByCategory(String categoryId);



    //Search shop by user
//    @Select("SELECT sh.*, sh.name AS shopName, sh.profile AS shopProfile, sh.status AS shopStatus, cat.*, cat.name AS catName, u.*,u.name AS userName, u.profile AS userProfile, u.status AS userStatus\n" +
//            "\t\t\t\t\t\tFROM dp_shops AS sh\n" +
//            "\t\t\t\t\t\tINNER JOIN dp_category AS cat ON sh.cat_id = cat.id\n" +
//            "\t\t\t\t\t\tINNER JOIN dp_users AS u ON sh.u_id = u.id\n" +
//            "\t\t\t\t\t\tWHERE sh.u_id = #{id} AND sh.status = 'TRUE'")

    //    @ResultMap("find")
    @Select("SELECT * FROM dp_shops WHERE u_id=#{id} AND status = 'true'")
    @ResultMap("shopMap3")
    List<ShopDto> getAllShopsByUserId(int id);


    @SelectProvider(type = SubResourceProvider.class, method = "getUserByUserId")
    UserDto getUserByUserId(String userId);


    //count all shops
    @Select("SELECT COUNT(id) FROM dp_shops WHERE status = 'true'")
    int countId();


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
            @Result(column = "promo_id", property = "promotion1", many = @Many(select = "getPromotion"))
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

    //get all shops by shop name
    @Select("SELECT * FROM dp_shops WHERE status = 'true' and name ILIKE CONCAT('%', #{name}, '%')")
    @ResultMap("shopMap")
    List<ShopDto> getAllShopsByShopName(@Param("name") String name);


    @Select("SELECT * FROM dp_shops WHERE id=#{shopId} AND status = 'true'")
    @Results(id="shopMap3", value = {
            @Result(column = "id" ,property = "id"),
            @Result(column = "shop_id" ,property = "shopId"),
            @Result(column = "name" ,property = "name"),
            @Result(column = "address" ,property = "address"),
            @Result(column = "open_time", property = "openTime"),
            @Result(column = "close_time", property = "closeTime"),
            @Result(column = "u_id", property = "user", many = @Many(select = "getUser")),
            @Result(column = "cat_id", property = "category", many = @Many(select = "getCategory")),
            @Result(column = "promo_id", property = "promotion1", many = @Many(select = "getPromotion"))
    })
    ShopDto getPromotionByShopId2(@Param("shopId") int shopId);


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


    @Update("UPDATE dp_shops set promo_id = #{product.promo_id} WHERE id = #{shopId}")
    boolean updateShopPromotion(int shopId, ApplyShopPromotionRequestModel2 product);


    // delete promotion by shop id
    @Update("UPDATE dp_shops set promo_id = NULL WHERE shop_id = #{shopId}")
    boolean deleteShopPromotionByShopId(String shopId);

}


