package com.kshrd.derphsar_api.service.implement;

import com.kshrd.derphsar_api.page.Pagination;
import com.kshrd.derphsar_api.repository.PromotionRepository;
import com.kshrd.derphsar_api.repository.dto.ProductDto;
import com.kshrd.derphsar_api.repository.dto.PromotionDto;
import com.kshrd.derphsar_api.repository.dto.ShopDto;
import com.kshrd.derphsar_api.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PromotionServiceImp implements PromotionService {
    private PromotionRepository promotionRepository;

    @Autowired
    public void setPromotionRepository(PromotionRepository promotionRepository) {
        this.promotionRepository = promotionRepository;
    }

    //select all promotions
    @Override
    public List<PromotionDto> getPromotions(Pagination pagination) {
//        if (shopId == 0)
            return promotionRepository.getPromotions(pagination);
//        else
//            return promotionRepository.findPromotionByShopId(shopId);
    }

    @Override
    public List<PromotionDto> getPromotionsByUserId(int u_id) {
        return promotionRepository.findPromotionByShopId(u_id);
    }

    @Override
    public List<PromotionDto> getPromotionByShopId(int shop_id) {
        return promotionRepository.getPromotionByShopId(shop_id);
    }


    //delete a promotion
    @Override
    public void deletePromotion(int promoId) {
        promotionRepository.deletePromotion(promoId);
    }

    @Override
    public void deleteShopPromotionByShopId(int shop_id) {
        promotionRepository.deleteShopPromotionByShopId(shop_id);
    }

    //update a promotion
    @Override
    public PromotionDto updatePromotion(String id, PromotionDto promotionDto) {
        boolean isUpdated = promotionRepository.updatePromotion(id,promotionDto);
        if(isUpdated){
            return promotionDto;
        }
        return null;
    }

    @Override
    public PromotionDto updateIsApply(String id, PromotionDto promotionDto) {
        boolean isUpdated = promotionRepository.updateIsApply(id,promotionDto);
        if(isUpdated){
            return promotionDto;
        }
        return null;
    }

    @Override
    public ProductDto applyShopMyPromotion(String id, ProductDto productDto) {
        boolean isUpdated = promotionRepository.applyShopMyPromotion(id,productDto);
        if(isUpdated){
            return productDto;
        }
        return null;
    }

//    @Override
//    public ProductDto applyPromotion(String id, ProductDto productDto) {
//        boolean isUpdated = promotionRepository.applyPromotion(id,productDto);
//        if(isUpdated){
//            return productDto;
//        }
//        return null;
//    }

    //create a promotion
    @Override
    public PromotionDto createPromotion(PromotionDto promotionDto) {
        //System.out.println("promotion"+promotionDto);
        boolean isInserted = promotionRepository.createPromotion(promotionDto);
        if(isInserted)
            return promotionDto;
        else
            return null;
    }

    //find a promotion by id
    @Override
    public PromotionDto findById(String promoId) {
        return  promotionRepository.findById(promoId);
    }

    @Override
    public PromotionDto findByShopId(int shop_id) {
        return promotionRepository.findByShopId(shop_id);
    }


    @Override
    public List<ProductDto> getProductByPromotionId(int promo_id) {
        return promotionRepository.getProductByPromotionId(promo_id);
    }

    @Override
    public List<ShopDto> getShopByPromotionId(int promotion) {
        return promotionRepository.getShopByPromotionId(promotion);
    }

    @Override
    public ShopDto updateShopPromotion(int promotion_id, ShopDto shopDto) {
        boolean isUpdated = promotionRepository.updateShopPromotion(promotion_id,shopDto);
        if(isUpdated){
            return shopDto;
        }
        return null;
    }

    @Override
    public List<PromotionDto> getPromotionByUserId(int u_id) {
        return promotionRepository.getPromotionByUserId(u_id);
    }

    @Override
    public ShopDto updateShopPromotionByShopId(int shop_id, ShopDto shopDto) {
        boolean isUpdated = promotionRepository.updateShopPromotionByShopId(shop_id, shopDto);
        if (isUpdated){
            return shopDto;
        }
        return null;
    }
}
