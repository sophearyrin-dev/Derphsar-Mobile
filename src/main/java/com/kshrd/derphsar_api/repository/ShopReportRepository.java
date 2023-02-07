package com.kshrd.derphsar_api.repository;

import com.kshrd.derphsar_api.repository.dto.FollowerDto;
import com.kshrd.derphsar_api.repository.dto.ShopReportDto;
import com.kshrd.derphsar_api.repository.provider.FollowerProvider;
import com.kshrd.derphsar_api.repository.provider.ShopReportProvider;
import com.kshrd.derphsar_api.rest.shopreport.request.ShopReportRequestModel;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShopReportRepository {

    // Addition shop report

    @InsertProvider(value = ShopReportProvider.class, method = "insertShopReport")
    boolean insertShopReport(ShopReportRequestModel shopReportRequestModel);


    // Get shop report by shop id

    @SelectProvider(value = ShopReportProvider.class, method = "getShopReportByShopId")
    List<ShopReportDto> getShopReportByShopId(int shop_id);
}
