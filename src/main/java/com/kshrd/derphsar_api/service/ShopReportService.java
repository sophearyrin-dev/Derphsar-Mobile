package com.kshrd.derphsar_api.service;

import com.kshrd.derphsar_api.repository.dto.FollowerDto;
import com.kshrd.derphsar_api.repository.dto.ShopReportDto;
import com.kshrd.derphsar_api.rest.shopreport.request.ShopReportRequestModel;

import java.util.List;

public interface ShopReportService {

    ShopReportRequestModel insertShopReport(ShopReportRequestModel shopReportRequestModel);

    List<ShopReportDto> getShopReportByShopId(int shop_id);
}
