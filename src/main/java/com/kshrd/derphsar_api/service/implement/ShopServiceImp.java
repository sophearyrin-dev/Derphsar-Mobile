package com.kshrd.derphsar_api.service.implement;

import com.kshrd.derphsar_api.page.Pagination;
import com.kshrd.derphsar_api.repository.ShopRepository;
import com.kshrd.derphsar_api.repository.dto.ShopDto;
import com.kshrd.derphsar_api.repository.dto.UserDto;
import com.kshrd.derphsar_api.repository.dto.UserRoleDto;
import com.kshrd.derphsar_api.rest.shop.request.ApplyShopPromotionRequestModel2;
import com.kshrd.derphsar_api.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShopServiceImp implements ShopService {

    private ShopRepository shopRepository;
    private UserServiceImp userServiceImp;
    private UserRoleServiceImp userRoleServiceImp;


    @Autowired
    public void setUserRoleServiceImp(UserRoleServiceImp userRoleServiceImp) {
        this.userRoleServiceImp = userRoleServiceImp;
    }

    @Autowired
    public void setUserServiceImp(UserServiceImp userServiceImp) {
        this.userServiceImp = userServiceImp;
    }

    @Autowired
    public void setShopRepository(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }



    //create a shop
    @Override
    public ShopDto createShop(ShopDto shop) {
        boolean isInserted = shopRepository.insert(shop);
        if (isInserted){
//            System.out.println(shop.getAddress());
            UserRoleDto userRoleDto = userRoleServiceImp.findUserRoleById(shop.getU_id());
            userRoleDto.setRoleId(2);
            System.out.println("user dto" + userRoleDto);
            if(userRoleDto.getRoleId() == 1){
                userRoleServiceImp.updateRoleToShopkeeper(shop.getU_id(), userRoleDto);
            }
            return shop;
        }
        else
            return null;
    }

//    //get all shops
//    @Override
//    public List<ShopDto> getShops(){
//        return shopRepository.select();
//    }


    //get shops
    @Override
    public List<ShopDto> getShops(Pagination pagination){
        return shopRepository.select(pagination);
    }


    //delete a shop
    @Override
    public void deleteShop(String shop_id) {
        shopRepository.delete(shopRepository.getShopID(shop_id));
    }

    //update a shop
    @Override
    public ShopDto updateShop(String shop_id, ShopDto shop) {
        boolean isUpdated = shopRepository.update(shop_id,shop);
        if(isUpdated){
            return shop;
        }
        return null;
    }

    @Override
    public ShopDto updateShopPromoId(String shop_id, ShopDto shop) {
        boolean isUpdated = shopRepository.updateShopPromoId(shop_id,shop);
        if(isUpdated){
            return shop;
        }
        return null;
    }


    //    find a shop by id
    @Override
    public ShopDto findById(String shopId) {
        return  shopRepository.findById(shopId);
    }

    @Override
    public ShopDto getShopByShopIdInt(int shopId) {
        return  shopRepository.getShopByShopIdInt(shopId);
    }

    @Override
    public List<ShopDto> getAllShopsByUserId(int userId) {
        return shopRepository.getAllShopsByUserId(userId);
    }

    @Override
    public UserDto getUserByUserId(String userId) {
        return shopRepository.getUserByUserId(userId);
    }


    //count all id
    @Override
    public int countId() {
        return shopRepository.countId();
    }

    @Override
    public int getShopId(String id) {
        return shopRepository.getShopID(id);
    }

    @Override
    public List<ShopDto> getAllShopByName(String shopName) {
        return shopRepository.getAllShopsByShopName(shopName);
    }

    @Override
    public ShopDto getPromotionByShopId(int shopId) {
        return shopRepository.getPromotionByShopId2(shopId);
    }



    @Override
    public String deleteShopPromotionByShopId(String shopId) {
        boolean isUpdated = shopRepository.deleteShopPromotionByShopId(shopId);
        if(isUpdated){
            return shopId;
        }
        return null;
    }


    @Override
    public List<ShopDto> updateShopPromotion(int userId, ApplyShopPromotionRequestModel2 applyShopPromotionRequestModel2) {
        List<ShopDto> productDtos = new ArrayList<>();
        List<ShopDto> productDtos1 = getAllShopsByUserId(userId);

        for (int i=0 ; i<applyShopPromotionRequestModel2.getId().length; i++){
            for(ShopDto productDto : productDtos1){
                if(productDto.getId() == applyShopPromotionRequestModel2.getId()[i]){
                    shopRepository.updateShopPromotion(productDto.getId(), applyShopPromotionRequestModel2);
                    productDtos.add(productDto);
                }
            }
        }
        return productDtos;
    }
}
