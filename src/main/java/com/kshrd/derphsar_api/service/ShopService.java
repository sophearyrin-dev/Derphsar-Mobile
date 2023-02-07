package com.kshrd.derphsar_api.service;

import com.kshrd.derphsar_api.page.Pagination;
import com.kshrd.derphsar_api.repository.dto.ShopDto;
import com.kshrd.derphsar_api.repository.dto.UserDto;
import com.kshrd.derphsar_api.rest.shop.request.ApplyShopPromotionRequestModel2;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShopService {

    //    create shop
    ShopDto createShop(ShopDto shop);

    //    get all shop
    List<ShopDto> getShops(Pagination pagination);


    //    update shop
    ShopDto updateShop(String shop_id, ShopDto shop);

    //    update shop
    ShopDto updateShopPromoId(String shop_id, ShopDto shop);

    //    find by id
    ShopDto findById(String shopId);

    //pheary get shop by id integer
    ShopDto getShopByShopIdInt(int shopId);


    List<ShopDto> getAllShopsByUserId (int userId);

    UserDto getUserByUserId(String userId);

    //
    int countId();

    //    delete shop
    void deleteShop(String shop_id);

    int getShopId(String id);


    //get all shops by shop name
    List<ShopDto> getAllShopByName(String shopName);

    //get promotion by shopId
    ShopDto getPromotionByShopId(int shopId);


    // delete shop promotion by shop id vesal
    String deleteShopPromotionByShopId(String shopId);

    //update - apply shop promotion
    List<ShopDto> updateShopPromotion(@Param("userId") int userId, @Param("applyShopPromotionRequestModel2") ApplyShopPromotionRequestModel2 applyShopPromotionRequestModel2);
}
