package com.kshrd.derphsar_api.service;

import com.kshrd.derphsar_api.repository.dto.ReceiptDto;

import java.util.List;

public interface ReceiptService{

    ReceiptDto insertReceipt(ReceiptDto receiptDto);

    boolean deleteReceipt(int id);

    List<ReceiptDto> getAllReceiptByUserId(int u_id);

    ReceiptDto findCode(int id);

}
