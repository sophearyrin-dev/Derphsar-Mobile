package com.kshrd.derphsar_api.rest.restcontroller;

import com.kshrd.derphsar_api.repository.dto.ShopReportDto;
import com.kshrd.derphsar_api.rest.message.MessageProperties;
import com.kshrd.derphsar_api.rest.shopreport.request.ShopReportRequestModel;
import com.kshrd.derphsar_api.rest.shopreport.response.ShopReportResponseModel;
import com.kshrd.derphsar_api.service.implement.ShopReportServiceImp;
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
public class ShopReportRestController {
    private ShopReportServiceImp shopReportServiceImp;
    private MessageProperties messageProperties;

    @Autowired
    public void setShopReportServiceImp(ShopReportServiceImp shopReportServiceImp) {
        this.shopReportServiceImp = shopReportServiceImp;
    }

    @Autowired
    public void setMessageProperties(MessageProperties messageProperties) {
        this.messageProperties = messageProperties;
    }

    /**
     * Addition Shop Report
     *
     * @param shopReportRequestModel - shop report request model
     * @return - Return response message
     */


    @PostMapping("/ShopReport")
    @ApiOperation(value = "User report shop", response = ShopReportResponseModel.class)
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, Object> insertShopReport(@RequestBody ShopReportRequestModel shopReportRequestModel) {
        Map<String, Object> result = new HashMap<>();
        UUID uuid = UUID.randomUUID();
        shopReportRequestModel.setShop_report_id("DP" + uuid.toString().substring(0,10));
        shopReportServiceImp.insertShopReport(shopReportRequestModel);
        result.put("Message", "Insert Shop Report successful");
        result.put("DATA", shopReportRequestModel);
        return result;
    }


    /**
     * get shop report by shop id
     *
     * @param shop_id
     * @return - Return response message
     */


    @GetMapping("/ShopReport/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public Map<String, Object> getShopReportByShopId(@RequestParam int shop_id){
        Map<String, Object> res = new HashMap<>();
        List<ShopReportDto> shopReportDtos = shopReportServiceImp.getShopReportByShopId(shop_id);
        try {
            if(shopReportDtos.isEmpty()){
                res.put("Message", "No Shop Report in Database");
            }else {
                res.put("Message", "Get Shop Report Successful");
            }
            res.put("Data", shopReportDtos);

        }catch (Exception e){
            e.printStackTrace();
        }
        return res;
    }
}
