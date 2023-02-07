package com.kshrd.derphsar_api.repository;

import com.kshrd.derphsar_api.repository.dto.OrderDetailDto;
import com.kshrd.derphsar_api.repository.dto.ReceiptDto;
import com.kshrd.derphsar_api.repository.provider.ReceiptProvider;
import com.kshrd.derphsar_api.rest.receipt.response.ReceiptResponseModel;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReceiptRepository {


    @InsertProvider(type = ReceiptProvider.class, method = "insertReceipt")
    boolean insertReceipt(ReceiptDto receiptDto);

    @UpdateProvider(value = ReceiptProvider.class, method = "deleteReceipt")
    boolean deleteReceipt(int id);

    @SelectProvider(value= ReceiptProvider.class, method = "findCode")
    ReceiptDto findCode(int id);

    @SelectProvider(value = ReceiptProvider.class, method = "getAllReceiptByUserId")
    @Results({
            @Result(property = "url", column = "receipt_url")

    })
    List<ReceiptDto> getAllReceiptByUserId(int u_id);

}
