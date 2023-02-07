package com.kshrd.derphsar_api.repository;


import com.kshrd.derphsar_api.page.Pagination;
import com.kshrd.derphsar_api.repository.dto.OrderDto;
import com.kshrd.derphsar_api.repository.dto.ShopDto;
import com.kshrd.derphsar_api.repository.dto.UserDto;
import com.kshrd.derphsar_api.repository.dto.UserRoleDto;
import com.kshrd.derphsar_api.repository.provider.UserProvider;
import com.kshrd.derphsar_api.rest.order.response.OrderUserResponse;
import com.kshrd.derphsar_api.rest.role.response.RoleResponse;
import com.kshrd.derphsar_api.rest.user.request.UserRequestModel;
import com.kshrd.derphsar_api.rest.user.response.UserResponseModel;
import org.apache.ibatis.annotations.*;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface UserRepository {

    @SelectProvider(type = UserProvider.class, method = "findByEmail")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "userId",column = "user_id"),
            @Result(property = "role.name", column = "role_name"),
            @Result(property = "role.id", column = "id"),
            @Result(property = "role.roleId", column = "role_id"),
    })
    UserDto findByEmail(String email);


    @InsertProvider(type = UserProvider.class, method = "insertUser")
    @Results({
            @Result(property = "userId", column = "user_id")
    })
    boolean insertUser(UserDto user);


    @InsertProvider(type = UserProvider.class, method = "insertUserRole")
    boolean insertUserRole(UserDto user);


    @InsertProvider(type = UserProvider.class, method = "insertOrder")
    boolean insertOrder(String orderId,@Param("user") UserDto user);



    @Select("SELECT * FROM dp_order WHERE user_id = #{userId}")
        @Results({
                @Result(column = "order_id", property = "orderId"),
                @Result(column = "user_id", property = "userId")
        })
    List<OrderUserResponse> getOrderByUserId(int userId);



    @SelectProvider(type = UserProvider.class, method = "getAllUsers")
    @Results({
            @Result(property = "userId", column = "user_id"),
            //@Result(column = "id", property = "order", many = @Many(select = "getOrderByUserId")),
    })
    List<UserResponseModel> getAllUsers();



    @Select("SELECT r.id, r.name, r.role_id FROM dp_role r INNER JOIN dp_user_role ur ON r.id = ur.role_id" +
            " INNER JOIN dp_users u ON u.id = ur.user_id\n" +
            "WHERE u.id = #{id}")
    @Results({
            @Result(column = "id",property = "id"),
            @Result(column = "role_id", property = "roleId")
    }
    )
    List<RoleResponse> role(int id);



    //get user by userId
    @SelectProvider(type = UserProvider.class, method = "getOneUserById")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "user_id", property = "userId"),
            @Result(column ="firebase_id", property = "firebaseId")
    }
    )
    UserResponseModel getOneUserById(String userId);


    @SelectProvider(type = UserProvider.class, method = "getUserByUserIdInt")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "user_id", property = "userId"),
            @Result(column ="firebase_id", property = "firebaseId")
    }
    )
    UserResponseModel getUserByUserIdInt(int userId);

    //get user by firebaseId
    @SelectProvider(type = UserProvider.class, method = "getOneUserByFirebaseId")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "user_id", property = "userId"),
            @Result(column ="firebase_id", property = "firebaseId")
    }
    )
    UserResponseModel getOneUserByFirebaseId(String firebaseId);



//    @UpdateProvider(type = UserProvider.class, method = "deleteUserById")
//    void deleteOneUserById(String userId);


    //@UpdateProvider(type = UserProvider.class, method = "updateUserById")
    @Update("UPDATE dp_users SET name = #{user.name} , gender = #{user.gender}, phone = #{user.phone}, email = #{user.email}, profile = #{user.profile}, firebase_id = #{user.firebaseIds} WHERE user_id = #{userId}")
    boolean updateUserById(String userId, UserDto user);

    @Update("UPDATE dp_users SET address=#{user.address} WHERE user_id = #{userId}")
    boolean updateUserAddressById(String userId, UserDto user);




    @Select("SELECT u.user_id, u.name, u.phone, u.email, u.status\n" +
            "FROM dp_order\tAS o\n" +
            "INNER JOIN dp_users AS u ON u.id = o.user_id\n" +
            "WHERE o.shop_id = #{shopId} AND u.status = 'TRUE'")
        @Results({
                @Result(property = "userId", column = "user_id"),
        })
    List<UserDto> getAllCustomersByShopId(@Param("shopId") int shopId);




    @Select("SELECT u.user_id, u.name AS userName, u.phone, u.email, r.name AS roleName, u.status\n" +
            "FROM dp_users AS u\n" +
            "INNER JOIN dp_user_role AS ur ON ur.user_id = u.id\n" +
            "INNER JOIN dp_role AS r ON r.id = ur.role_id\n" +
            "WHERE r.name = #{roleName} AND u.status = 'TRUE' LIMIT #{pagination.limit}  OFFSET #{pagination.offset}")

        @Results({
                @Result(property = "userId", column = "user_id"),
                @Result(property = "name", column = "userName"),
                @Result(property = "name", column = "userName"),
        })

    List<UserDto> getAllCustomersByRoleName(@Param("roleName") String roleName,@Param("pagination") Pagination pagination);


    //count all users
    @Select("SELECT COUNT(u.id)\n" +
            "FROM dp_users AS u\n" +
            "INNER JOIN dp_user_role AS ur ON ur.user_id = u.id\n" +
            "INNER JOIN dp_role AS r ON r.id = ur.role_id\n" +
            "WHERE status = 'TRUE' AND r.name = 'ROLE_BUYER'")
    int countId();

    //delete user by userId and also delete shop
    @Delete("UPDATE dp_users SET status = FALSE WHERE id = #{user_id}; UPDATE dp_shops SET status = false WHERE u_id = #{userId}")
    void deleteUserById(int userId);

    @Select("SELECT id from dp_users where user_id = #{userId}")
    int getUserId(String userId);


}
