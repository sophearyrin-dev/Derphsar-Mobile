package com.kshrd.derphsar_api.rest.restcontroller;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kshrd.derphsar_api.page.Pagination;
import com.kshrd.derphsar_api.repository.dto.FollowerDto;
import com.kshrd.derphsar_api.repository.dto.ProductDto;
import com.kshrd.derphsar_api.repository.dto.ShopDto;
import com.kshrd.derphsar_api.rest.BaseApiResponse;
import com.kshrd.derphsar_api.rest.follower.request.FollowerRequestModel;
import com.kshrd.derphsar_api.rest.follower.response.FollowerResponseModel;
import com.kshrd.derphsar_api.rest.follower.response.FollowerResponseModel2;
import com.kshrd.derphsar_api.rest.message.MessageProperties;
import com.kshrd.derphsar_api.rest.product.response.ProductResponseModel;
import com.kshrd.derphsar_api.rest.user.response.UserResponseModel;
import com.kshrd.derphsar_api.service.implement.FollowerServiceImp;
import com.kshrd.derphsar_api.service.implement.ShopServiceImp;
import com.kshrd.derphsar_api.service.implement.UserServiceImp;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.*;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/v1")
public class FollowerRestController {

    private FollowerServiceImp followerServiceImp;
    private UserServiceImp userServiceImp;
    private MessageProperties message;
    private ShopServiceImp shopServiceImp;


    @Autowired
    public void setFollowerServiceImp(FollowerServiceImp followerServiceImp) {
        this.followerServiceImp = followerServiceImp;
    }


    @Autowired
    public void setShopServiceImp(ShopServiceImp shopServiceImp) {
        this.shopServiceImp = shopServiceImp;
    }

    @Autowired
    public void setUserServiceImp(UserServiceImp userServiceImp) {
        this.userServiceImp = userServiceImp;
    }

    @Autowired
    public void setMessage(MessageProperties message) {
        this.message = message;
    }


     /**
    /**
     * Post a Follower
     *
     * @param followerRequestModel - Follower request model
     * @return - Return response message
     */


    @PostMapping("/follower")
    @ApiOperation(value = "User follow shop", response = FollowerResponseModel.class)
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, Object> insertFollower(@RequestBody FollowerRequestModel followerRequestModel) {
        Map<String, Object> result = new HashMap<>();
        UUID uuid = UUID.randomUUID();
        followerRequestModel.setFollower_id("DP" + uuid.toString().substring(0,10));
        followerServiceImp.insertFollower(followerRequestModel);
        result.put("Message", "Insert follower successful");
        result.put("DATA", followerRequestModel);
        return result;
    }



    /**
     * get follower by user id
     *
     * @param u_id
     * @return - Return response message
     */


//    @GetMapping("/follower/{id}")
//    @ApiOperation(value = "get foollow by userId", response = FollowerResponseModel.class)
//    public Map<String, Object> getFollowerByUserId(@RequestParam int u_id){
//        Map<String, Object> res = new HashMap<>();
//        List<FollowerDto> followerDtos = followerServiceImp.getFollowerByUserId(u_id);
//        try {
//            if(followerDtos.isEmpty()){
//                res.put("Message", "No Follower in Database");
//            }else {
//                res.put("Message", "Get Follower Successful");
//            }
//            res.put("Data", followerDtos);
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return res;
//    }



    /**
     * Unfollower
     *
     * @param u_id
     * @return - Return response message
     */


    @RequestMapping(value = "{id}",method=RequestMethod.PUT)
    public Map<String,Object> unFollower(@RequestParam int u_id, int shop_id){
        Map<String,Object> result=new HashMap<>();
        FollowerDto followerDto1=followerServiceImp.findCode(u_id, shop_id);
        if(followerDto1==null){
            result.put("Message","ID Not Found Update Follower Unsuccessfully");
            result.put("Response Code",404);
        }else{
            followerServiceImp.unFollowerByUserId(u_id, shop_id);
            result.put("Message","You have UnFollower Successfully");
            result.put("Response Code",200);
        }
        return result;
    }



    /**
     * Get all shops that has been follow by user id (pheary)
     * @param u_id
     * @return
     */

    @GetMapping("followers/{userId}")
    @ApiOperation(value = "get all follows shop by user id", response = FollowerResponseModel2.class)
    public ResponseEntity<BaseApiResponse<List<FollowerResponseModel2>>> getAllFollowByUserId(@PathVariable("userId") String u_id) {


        BaseApiResponse<List<FollowerResponseModel2>> response = new BaseApiResponse<>();
        ModelMapper mapper = new ModelMapper();
        List<FollowerResponseModel2> productResponseModels = new ArrayList<>();

        try {
            UserResponseModel userDto = userServiceImp.getOneUserById(u_id);
            List<FollowerDto> products = followerServiceImp.getFollowByUserId(userDto.getId());
            for (FollowerDto productDto : products) {
                FollowerResponseModel2 productResponseModel = mapper.map(productDto, FollowerResponseModel2.class);
                productResponseModels.add(productResponseModel);
            }

            if (!products.isEmpty()) {
                response.setData(productResponseModels);
                response.setStatus(HttpStatus.FOUND);
                response.setMessage(message.selected("Follow shops"));
            }else {
                response.setStatus(HttpStatus.NOT_FOUND);
                response.setMessage(message.hasNoRecords("Follow shops"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        response.setTime(new Timestamp(System.currentTimeMillis()));
        return ResponseEntity.ok(response);
    }


    @GetMapping("follower-in-shop/{shopId}")
    @ApiOperation(value = "get all follows shop by shop id", response = FollowerResponseModel2.class)
    public ResponseEntity<BaseApiResponse<List<FollowerResponseModel2>>> getAllFollowerByShopId(@PathVariable("shopId") String shop_id) {


        BaseApiResponse<List<FollowerResponseModel2>> response = new BaseApiResponse<>();
        ModelMapper mapper = new ModelMapper();
        List<FollowerResponseModel2> productResponseModels = new ArrayList<>();

        try {
            ShopDto shopDto = shopServiceImp.findById(shop_id);
            List<FollowerDto> products = followerServiceImp.getAllFollowerByShopId(shopDto.getId());
            for (FollowerDto productDto : products) {
                FollowerResponseModel2 productResponseModel = mapper.map(productDto, FollowerResponseModel2.class);
                productResponseModels.add(productResponseModel);
            }

            if (!products.isEmpty()) {
                response.setData(productResponseModels);
                response.setStatus(HttpStatus.FOUND);
                response.setMessage(message.selected("Follow shops"));
            }else {
                response.setStatus(HttpStatus.NOT_FOUND);
                response.setMessage(message.hasNoRecords("Follow shops"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        response.setTime(new Timestamp(System.currentTimeMillis()));
        return ResponseEntity.ok(response);
    }

}

