package com.kshrd.derphsar_api.repository;

import com.kshrd.derphsar_api.repository.dto.ProductReportDto;
import com.kshrd.derphsar_api.repository.provider.ProductReportProvider;
import com.kshrd.derphsar_api.rest.productreport.request.ProductReportRequestModel;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductReportRepository {

    // Addition Product report

    @InsertProvider(value = ProductReportProvider.class, method = "insertProductReport")
    boolean insertProductReport(ProductReportRequestModel productReportRequestModel);


    // Get product report by shop id

    @SelectProvider(value = ProductReportProvider.class, method = "getProductReportByProductId")
    List<ProductReportDto> getProductReportByProductId(int pro_id);
}
