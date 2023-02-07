package com.kshrd.derphsar_api.service;

import com.kshrd.derphsar_api.page.Pagination;
import com.kshrd.derphsar_api.repository.dto.FollowerDto;
import com.kshrd.derphsar_api.repository.dto.ProductDto;
import com.kshrd.derphsar_api.rest.follower.request.FollowerRequestModel;

import java.util.List;

public interface FollowerService {

    FollowerRequestModel insertFollower(FollowerRequestModel followerRequestModel);

    boolean unFollowerByUserId(int u_id, int shop_id);

    FollowerDto findCode(int u_id,int shop_id);

    //get products by user id
    List<FollowerDto> getFollowByUserId(int u_id);

    //get all followers by shopId
    List<FollowerDto> getAllFollowerByShopId(int shop_id);
}
