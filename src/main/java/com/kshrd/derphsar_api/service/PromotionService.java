package com.kshrd.derphsar_api.service;

import com.kshrd.derphsar_api.page.Pagination;
import com.kshrd.derphsar_api.repository.dto.ProductDto;
import com.kshrd.derphsar_api.repository.dto.PromotionDto;
import com.kshrd.derphsar_api.repository.dto.ShopDto;

import java.util.List;

public interface PromotionService {

    //get all promotion
    List<PromotionDto> getPromotions(Pagination pagination);


    //get all promotion by user Id
    List<PromotionDto> getPromotionsByUserId(int u_id);

    // get all promotion by shop id
    List<PromotionDto> getPromotionByShopId(int shop_id);

    //delete a promotion
    void deletePromotion(int promoId);

    // delete promotion by shop id
    void deleteShopPromotionByShopId(int shop_id);

    //update a promotion
    PromotionDto updatePromotion(String id, PromotionDto promotionDto);

    PromotionDto updateIsApply(String id, PromotionDto promotionDto);

    ProductDto applyShopMyPromotion(String id, ProductDto productDto);

    //create a promotion
    PromotionDto createPromotion(PromotionDto promotionDto);

    //find by id
    PromotionDto findById(String promoId);

    // find shop id
    PromotionDto findByShopId(int shop_id);

    // get product by promotion id
    List<ProductDto> getProductByPromotionId(int promo_id);

    // get shop by promotion id
    List<ShopDto> getShopByPromotionId(int promotion);


    // update shop promotion
    ShopDto updateShopPromotion(int promotion_id, ShopDto shopDto);

    //get promotoin by userId
    List<PromotionDto> getPromotionByUserId(int u_id);


    // update shop promotion by shop id vesal
    ShopDto updateShopPromotionByShopId(int shop_id, ShopDto shopDto);
}
