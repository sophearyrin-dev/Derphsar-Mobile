package com.kshrd.derphsar_api.repository.provider;

import com.kshrd.derphsar_api.page.Pagination;
import com.kshrd.derphsar_api.repository.dto.UserDto;
import com.kshrd.derphsar_api.repository.dto.WishListDto;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

public class WishListProvider {

    //get all wishlists
    public String getWishList() {
        return new SQL(){{
            SELECT("*");
            FROM("dp_wishlist");
        }}.toString();
    }

    //insert new wishlist
    public String insertWishList(WishListDto wishListDto){
        return new SQL(){{
            INSERT_INTO("dp_wishlist");
            VALUES("wishlist_id, fav_date, u_id, pro_id, status", "#{wishlistId}, #{favDate}, #{u_id}, #{pro_id}, TRUE");
        }}.toString();
    }



    public String getUserByUserId(){
        return new SQL(){{
            SELECT("*");
            FROM("dp_users");
            WHERE("user_id = #{userId}");
        }}.toString();
    }

    public String getAllWishListByUserId(int uId, @Param("pagination") Pagination pagination){
        return new SQL(){{
            SELECT("*");
            FROM("dp_wishlist as w");
            WHERE("w.u_id = #{uId} AND w.status = TRUE");
            LIMIT(pagination.getLimit());
            OFFSET(pagination.getOffset());
        }}.toString();
    }


}
