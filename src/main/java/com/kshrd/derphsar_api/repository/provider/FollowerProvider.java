package com.kshrd.derphsar_api.repository.provider;
import com.kshrd.derphsar_api.rest.follower.request.FollowerRequestModel;
import org.apache.ibatis.jdbc.SQL;

public class FollowerProvider {


    // insert follower
    public String insertFollower(FollowerRequestModel followerRequestModel){
        return new SQL(){{
            INSERT_INTO("dp_follower");
            VALUES("follower_id, u_id, shop_id, status", "#{follower_id}, #{u_id}, #{shop_id}, TRUE");
        }}.toString();
    }

    // get follower by user id


    public String getFollowerByUserId(){
        return new SQL(){{
            SELECT("*");
            FROM("dp_follower");
            WHERE("u_id = #{u_id} and status=true");
        }}.toString();
    }


    public String getUserFollowerByShopId(){
        return new SQL(){{
            SELECT("*");
            FROM("dp_follower");
            WHERE("shop_id = #{shop_id} and status=true");
        }}.toString();
    }

    // find user by id

    public String findCode(int u_id, int shop_id){
        return new SQL(){{
            SELECT("*");
            FROM("dp_follower");
            WHERE("u_id = #{u_id} AND shop_id = #{shop_id}");
        }}.toString();
    }

    // unFollower by user id

    public String unFollowerByUserId(int u_id){
        return new SQL(){{
            UPDATE("dp_follower");
            SET("status = false");
            WHERE("u_id = #{u_id} AND shop_id = #{shop_id}");
        }}.toString();
    }
}
