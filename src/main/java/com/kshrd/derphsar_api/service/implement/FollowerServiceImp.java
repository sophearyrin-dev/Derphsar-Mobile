package com.kshrd.derphsar_api.service.implement;

import com.kshrd.derphsar_api.repository.FollowerRepository;
import com.kshrd.derphsar_api.repository.dto.FollowerDto;
import com.kshrd.derphsar_api.rest.follower.request.FollowerRequestModel;
import com.kshrd.derphsar_api.rest.message.MessageProperties;
import com.kshrd.derphsar_api.service.FollowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FollowerServiceImp implements FollowerService {

    private FollowerRepository followerRepository;
    private MessageProperties messageProperties;

    @Autowired
    public void setFollowerRepository(FollowerRepository followerRepository) {
        this.followerRepository = followerRepository;
    }

    @Autowired
    public void setMessageProperties(MessageProperties messageProperties) {
        this.messageProperties = messageProperties;
    }

    // insert follower

    @Override
    public FollowerRequestModel insertFollower(FollowerRequestModel followerRequestModel) {
        boolean isInserted = followerRepository.insertFollower(followerRequestModel);
        if (isInserted)
            return followerRequestModel;
        else
            return null;
    }


    @Override
    public boolean unFollowerByUserId(int u_id, int shop_id) {
        return followerRepository.updateFollowerByUserId(u_id, shop_id);
    }

    @Override
    public FollowerDto findCode(int u_id, int shop_id) {
        return followerRepository.findCode(u_id, shop_id);
    }

    @Override
    public List<FollowerDto> getFollowByUserId(int u_id) {
        return followerRepository.getFollowerByUserId(u_id);
    }

    @Override
    public List<FollowerDto> getAllFollowerByShopId(int shop_id) {
        return followerRepository.getAllFollowerByShopId(shop_id);
    }

}
