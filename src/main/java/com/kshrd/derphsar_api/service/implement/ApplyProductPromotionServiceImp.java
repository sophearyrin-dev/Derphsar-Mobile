package com.kshrd.derphsar_api.service.implement;

import com.kshrd.derphsar_api.repository.PromotionRepository;
import com.kshrd.derphsar_api.rest.ApplyProductPromotion.request.ApplyProductPromotionRequestModel;
import com.kshrd.derphsar_api.rest.applyshoppromotion.request.ApplyShopPromotionRequestModel;
import com.kshrd.derphsar_api.service.ApplyProductPromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplyProductPromotionServiceImp implements ApplyProductPromotionService {

    private PromotionRepository promotionRepository;

    @Autowired
    public void setPromotionRepository(PromotionRepository promotionRepository) {
        this.promotionRepository = promotionRepository;
    }

    @Override
    public ApplyProductPromotionRequestModel applyProductPromotion(ApplyProductPromotionRequestModel applyProductPromotionRequestModel) {
        boolean isInserted = promotionRepository.applyProductPromotion(applyProductPromotionRequestModel);
        if(isInserted)
            return applyProductPromotionRequestModel;
        else
            return null;
    }
}
