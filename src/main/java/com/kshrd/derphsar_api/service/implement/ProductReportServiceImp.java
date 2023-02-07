package com.kshrd.derphsar_api.service.implement;

import com.kshrd.derphsar_api.repository.ProductReportRepository;
import com.kshrd.derphsar_api.repository.dto.ProductReportDto;
import com.kshrd.derphsar_api.rest.message.MessageProperties;
import com.kshrd.derphsar_api.rest.productreport.request.ProductReportRequestModel;
import com.kshrd.derphsar_api.service.ProductReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductReportServiceImp implements ProductReportService {

    private ProductReportRepository productReportRepository;
    private MessageProperties messageProperties;

    @Autowired
    public void setProductReportRepository(ProductReportRepository productReportRepository) {
        this.productReportRepository = productReportRepository;
    }
    @Autowired
    public void setMessageProperties(MessageProperties messageProperties) {
        this.messageProperties = messageProperties;
    }

    @Override
    public ProductReportRequestModel insertProductReport(ProductReportRequestModel productReportRequestModel) {
        boolean isInserted = productReportRepository.insertProductReport(productReportRequestModel);
        if (isInserted)
            return productReportRequestModel;
        else
            return null;
    }

    @Override
    public List<ProductReportDto> getProductReportByProductId(int pro_id) {
        return productReportRepository.getProductReportByProductId(pro_id);
    }
}
