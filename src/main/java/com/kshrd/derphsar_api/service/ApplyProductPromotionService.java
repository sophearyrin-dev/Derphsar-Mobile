package com.kshrd.derphsar_api.service;

import com.kshrd.derphsar_api.rest.ApplyProductPromotion.request.ApplyProductPromotionRequestModel;
import com.kshrd.derphsar_api.rest.applyshoppromotion.request.ApplyShopPromotionRequestModel;

public interface ApplyProductPromotionService {

    ApplyProductPromotionRequestModel applyProductPromotion(ApplyProductPromotionRequestModel applyProductPromotionRequestModel);

}
