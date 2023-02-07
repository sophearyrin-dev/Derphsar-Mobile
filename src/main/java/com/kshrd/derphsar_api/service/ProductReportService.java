package com.kshrd.derphsar_api.service;

import com.kshrd.derphsar_api.repository.dto.ProductReportDto;
import com.kshrd.derphsar_api.rest.productreport.request.ProductReportRequestModel;

import java.util.List;

public interface ProductReportService {

    ProductReportRequestModel insertProductReport(ProductReportRequestModel productReportRequestModel);

    List<ProductReportDto> getProductReportByProductId(int pro_id);
}
