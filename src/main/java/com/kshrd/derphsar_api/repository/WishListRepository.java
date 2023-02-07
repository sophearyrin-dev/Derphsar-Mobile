package com.kshrd.derphsar_api.repository;

import com.kshrd.derphsar_api.mybatis.JSONTypeHandlerPg;
import com.kshrd.derphsar_api.page.Pagination;
import com.kshrd.derphsar_api.repository.dto.ProductDto;
import com.kshrd.derphsar_api.repository.dto.ShopDto;
import com.kshrd.derphsar_api.repository.dto.UserDto;
import com.kshrd.derphsar_api.repository.dto.WishListDto;
import com.kshrd.derphsar_api.repository.provider.WishListProvider;
import com.kshrd.derphsar_api.rest.wishlist.response.WishListResponse;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WishListRepository {

    //Insert wishlist
    @InsertProvider(type = WishListProvider.class, method = "insertWishList")
    boolean insert(WishListDto wishListDto);


    //Get all wishlist
    @SelectProvider(value = WishListProvider.class, method = "getWishList")
    @Results({
            @Result(column = "wishlist_id" ,property = "wishlistId"),
            @Result(column = "fav_date" ,property = "favDate"),
//            @Result(column = "pro_id", property = "productId"),
//            @Result(column = "u_id", property = "userId")
    })
    List<WishListDto> select();

    @Select("SELECT * FROM dp_wishlist WHERE status = 'true'")
    @Results(id = "mapWishList", value = {

            @Result(column = "wishlist_id", property = "wishlistId"),
            @Result(column = "fav_date", property = "favDate"),
            @Result(column = "u_id", property = "user", many = @Many(select = "getUser")),
            @Result(column = "pro_id", property = "product", many = @Many(select = "getProduct"))
    })
    List<WishListDto> getAllWishList();

    //Delete a wishlist
    @Delete("UPDATE dp_wishlist SET status = FALSE WHERE wishlist_id = #{wishlist_id}")
    void delete(String wishlist_id);

    @Select("SELECT id ,wishlist_id,fav_date, u_id, pro_id, status  FROM dp_wishlist  WHERE u_id = #{uId} AND status = TRUE")
            @Results({
                    @Result(column = "id", property = "id"),
                    @Result(column = "wishlist_id", property = "wishlistId"),
                    @Result(column = "fav_date", property = "favDate"),
                    @Result(column = "u_id", property = "u_id"),
                    //@Result(column = "pro_id", property = "pro_id"),
                    @Result(column = "pro_id", property = "product", many = @Many(select = "getProduct")),
            })
    List<WishListDto> getAllShopsByUserId(int uId);

    @Select("SELECT * FROM dp_products WHERE id = #{pro_id}")
    @Results({
            @Result(column = "pro_id" ,property = "proId"),
    })
    ProductDto getProduct(int pro_id);



    @SelectProvider(type = WishListProvider.class, method = "getUserByUserId")
    UserDto getUserByUserId(String userId);


    //get all wishlists by userid
    @SelectProvider(type = WishListProvider.class, method = "getAllWishListByUserId")
    @ResultMap("mapWishList")
    List<WishListDto> getAllWishListByUserId(int uId, @Param("pagination") Pagination pagination);



    @Select("SELECT * FROM dp_users WHERE id = #{user_id}  AND status = 'true'")
    @Results({
            @Result(column = "user_id", property = "userId")
    })
    UserDto getUser(int user_id);


    //count all orders
    @Select("SELECT COUNT(id) FROM dp_wishlist WHERE status = 'true'")
    int countId();

}
