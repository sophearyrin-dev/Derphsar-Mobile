package com.kshrd.derphsar_api.rest.restcontroller;

import com.kshrd.derphsar_api.repository.dto.ProductReportDto;
import com.kshrd.derphsar_api.repository.dto.ShopReportDto;
import com.kshrd.derphsar_api.rest.message.MessageProperties;
import com.kshrd.derphsar_api.rest.productreport.request.ProductReportRequestModel;
import com.kshrd.derphsar_api.rest.productreport.response.ProductReportResponseModel;
import com.kshrd.derphsar_api.service.implement.ProductReportServiceImp;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/v1")
public class ProductReportRestController {

    private ProductReportServiceImp productReportServiceImp;
    private MessageProperties messageProperties;

    @Autowired
    public void setProductReportServiceImp(ProductReportServiceImp productReportServiceImp) {
        this.productReportServiceImp = productReportServiceImp;
    }

    @Autowired
    public void setMessageProperties(MessageProperties messageProperties) {
        this.messageProperties = messageProperties;
    }

    /**
     * Addition Product Report
     *
     * @param productReportRequestModel - product report request model
     * @return - Return response message
     */


    @PostMapping("/ProductReport")
    @ApiOperation(value = "User report product", response = ProductReportResponseModel.class)
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, Object> insertProductReport(@RequestBody ProductReportRequestModel productReportRequestModel) {
        Map<String, Object> result = new HashMap<>();
        UUID uuid = UUID.randomUUID();
        productReportRequestModel.setReport_id("DP" + uuid.toString().substring(0,10));
        productReportServiceImp.insertProductReport(productReportRequestModel);
        result.put("Message", "Insert Product Report successful");
        result.put("DATA", productReportRequestModel);
        return result;
    }


    /**
     * get product report by pro_id
     *
     * @param pro_id
     * @return - Return response message
     */


    @GetMapping("/ProductReport/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public Map<String, Object> getProductReportByProductId(@RequestParam int pro_id){
        Map<String, Object> res = new HashMap<>();
        List<ProductReportDto> productReportDtos = productReportServiceImp.getProductReportByProductId(pro_id);
        try {
            if(productReportDtos.isEmpty()){
                res.put("Message", "No Product Report in Database");
            }else {
                res.put("Message", "Get Product Report Successful");
            }
            res.put("Data", productReportDtos);

        }catch (Exception e){
            e.printStackTrace();
        }
        return res;
    }


}
