package com.kshrd.derphsar_api.service.implement;

import com.kshrd.derphsar_api.repository.PromotionRepository;
import com.kshrd.derphsar_api.rest.applyshoppromotion.request.ApplyShopPromotionRequestModel;
import com.kshrd.derphsar_api.service.ApplyShopPromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplyShopPromotionServiceImp implements ApplyShopPromotionService {

    private PromotionRepository promotionRepository;

    @Autowired
    public void setPromotionRepository(PromotionRepository promotionRepository) {
        this.promotionRepository = promotionRepository;
    }

    @Override
    public ApplyShopPromotionRequestModel applyShopPromotion(ApplyShopPromotionRequestModel applyShopPromotionRequestModel) {
        boolean isInserted = promotionRepository.applyShopPromotion(applyShopPromotionRequestModel);
        if(isInserted)
            return applyShopPromotionRequestModel;
        else
            return null;
    }
}
