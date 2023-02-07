package com.kshrd.derphsar_api.repository;

import com.kshrd.derphsar_api.mybatis.JSONTypeHandlerPg;
import com.kshrd.derphsar_api.page.Pagination;
import com.kshrd.derphsar_api.repository.dto.*;
import com.kshrd.derphsar_api.repository.provider.FollowerProvider;
import com.kshrd.derphsar_api.repository.provider.ReceiptProvider;
import com.kshrd.derphsar_api.rest.follower.request.FollowerRequestModel;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FollowerRepository {



    // Insert follower

    @InsertProvider(value = FollowerProvider.class, method = "insertFollower")
    boolean insertFollower(FollowerRequestModel followerRequestModel);

    // Get follower by user id

    @SelectProvider(value = FollowerProvider.class, method = "getFollowerByUserId")
    @Results(id = "mapFollower", value = {
            @Result(column = "shop_id", property = "shop", many = @Many(select = "getShop")),

    })
    List<FollowerDto> getFollowerByUserId(int u_id);



    // get user follow by shop id //vesal//
    @SelectProvider(value = FollowerProvider.class, method = "getUserFollowerByShopId")
    @Results(id = "mapFollowers", value = {
            @Result(column = "user_id", property = "userId", many = @Many(select = "getUser")),

    })
    List<FollowerDto> getUserFollowerByShopId(int shop_id);


    // Update follower by user id

    @UpdateProvider(value = FollowerProvider.class, method = "unFollowerByUserId")
    @Results({
            @Result(property = "u_id", column = "u_id"),
            @Result(property = "shop_id", column = "shop_id"),
            @Result(property = "status", column = "status")
    })
    boolean updateFollowerByUserId(int u_id, int shop_id);


    // find code to update follower

    @SelectProvider(value= FollowerProvider.class, method = "findCode")
    FollowerDto findCode(int u_id,int shop_id);


    //Pheary find follower by user id
    @Select("SELECT * FROM dp_follower WHERE u_id = #{u_id}")
    @Results({
            @Result(column = "shop_id", property = "shop", many = @Many(select = "getShop")),
    })
    List<FollowerDto> findFollowShopByUserId(@Param("u_id") int u_id);



//    // find all user follow by shop id
//    @Select("SELECT * FROM dp_follower WHERE shop_id = #{shop_id}")
//    @Results({
//            @Result(column = "user_id", property = "userId", many = @Many(select = "getUser")),
//    })
//    List<FollowerDto> findUserFollowerByShopId(@Param("shop_id") int shop_id);


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


    //get all followers by shop id
    @Select("SELECT * FROM dp_follower WHERE shop_id = #{shop_id} and status = 'true'")
    @Results({
            @Result(column = "u_id", property = "user", many = @Many(select = "getUser")),
    })
    List<FollowerDto> getAllFollowerByShopId(@Param("shop_id") int shop_id);






}
