package com.kshrd.derphsar_api.service.implement;

import com.kshrd.derphsar_api.repository.ReceiptRepository;
import com.kshrd.derphsar_api.repository.dto.ReceiptDto;
import com.kshrd.derphsar_api.rest.message.MessageProperties;
import com.kshrd.derphsar_api.service.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ReceiptServiceImp implements ReceiptService {
    private ReceiptRepository receiptRepository;
    private MessageProperties messageProperties;

    @Autowired
    public void setReceiptRepository(ReceiptRepository receiptRepository) {
        this.receiptRepository = receiptRepository;
    }
    @Autowired
    public void setMessageProperties(MessageProperties messageProperties) {
        this.messageProperties = messageProperties;
    }

    @Override
    public ReceiptDto insertReceipt(ReceiptDto receiptDto) {
        UUID uuid = UUID.randomUUID();
        receiptRepository.insertReceipt(receiptDto);
        return receiptDto;
    }

    @Override
    public boolean deleteReceipt(int id) {
        return receiptRepository.deleteReceipt(id);
    }

    @Override
    public List<ReceiptDto> getAllReceiptByUserId(int u_id) {
        return receiptRepository.getAllReceiptByUserId(u_id);
    }

    @Override
    public ReceiptDto findCode(int id) {
        return receiptRepository.findCode(id);
    }
}
