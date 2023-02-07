package com.kshrd.derphsar_api.service.implement;

import com.kshrd.derphsar_api.repository.ShopReportRepository;
import com.kshrd.derphsar_api.repository.dto.ShopReportDto;
import com.kshrd.derphsar_api.rest.message.MessageProperties;
import com.kshrd.derphsar_api.rest.shopreport.request.ShopReportRequestModel;
import com.kshrd.derphsar_api.service.ShopReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopReportServiceImp implements ShopReportService {

    private ShopReportRepository shopReportRepository;
    private MessageProperties messageProperties;

    @Autowired
    public void setShopReportRepository(ShopReportRepository shopReportRepository) {
        this.shopReportRepository = shopReportRepository;
    }

    @Autowired
    public void setMessageProperties(MessageProperties messageProperties) {
        this.messageProperties = messageProperties;
    }


    // Addition Shop Report


    @Override
    public ShopReportRequestModel insertShopReport(ShopReportRequestModel shopReportRequestModel) {
        boolean isInserted = shopReportRepository.insertShopReport(shopReportRequestModel);
        if (isInserted)
            return shopReportRequestModel;
        else
            return null;
    }

    @Override
    public List<ShopReportDto> getShopReportByShopId(int shop_id) {
        return shopReportRepository.getShopReportByShopId(shop_id);
    }

}
