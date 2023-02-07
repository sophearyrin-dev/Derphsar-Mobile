package com.kshrd.derphsar_api.rest.restcontroller;
import com.kshrd.derphsar_api.repository.dto.ReceiptDto;
import com.kshrd.derphsar_api.rest.BaseApiResponse;
import com.kshrd.derphsar_api.rest.message.MessageProperties;
import com.kshrd.derphsar_api.rest.orderdetail.response.OrderDetailFilterResponse;
import com.kshrd.derphsar_api.rest.receipt.response.ReceiptResponseModel;
import com.kshrd.derphsar_api.service.implement.ReceiptServiceImp;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("api/v1")
public class ReceiptController {
    private MessageProperties messageProperties;
    private ReceiptServiceImp receiptServiceImp;

    @Autowired
    public void setMessageProperties(MessageProperties messageProperties) {
        this.messageProperties = messageProperties;
    }

    @Autowired
    public void setReceiptServiceImp(ReceiptServiceImp receiptServiceImp) {
        this.receiptServiceImp = receiptServiceImp;
    }

    @PostMapping("/receipt")
    @ApiOperation(value = "insert receipt", response = ReceiptResponseModel.class)
    public Map<String, Object> insertReceipt(@RequestBody ReceiptDto receiptDto) {
        Map<String, Object> result = new HashMap<>();
        UUID uuid = UUID.randomUUID();
        receiptDto.setReceipt_id("DP" + uuid.toString().substring(0,10));
        BaseApiResponse baseApiResponse = new BaseApiResponse();
        receiptServiceImp.insertReceipt(receiptDto);
        result.put("Message", "Insert Receipt successful");
        result.put("DATA", receiptDto);
        return result;
    }
    @RequestMapping(value = "{/receipt/id}",method=RequestMethod.DELETE)
    public ResponseEntity<ReceiptDto> deleteReceipt(@RequestParam int id){
        Map<String, Object> res = new HashMap<>();
        ReceiptDto receiptDto=receiptServiceImp.findCode(id);
        System.out.println(receiptDto.toString());
        try {
            if(receiptDto == null){
                res.put("Message","ID Not Found Delete Unsuccessful");
                res.put("Response Code",404);
            }else{
                receiptServiceImp.deleteReceipt(id);
                res.put("Message","Delete Receipt Successful");
                res.put("Response Code",200);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity(res, HttpStatus.OK);

    }
    @GetMapping("/receipt/{id}")
    public Map<String, Object> getAllReceiptByUserId(@RequestParam int u_id){
        Map<String, Object> res = new HashMap<>();
        List<ReceiptDto> receiptDtos = receiptServiceImp.getAllReceiptByUserId(u_id);
        try {
            if(receiptDtos.isEmpty()){
                res.put("Message", "No receipt in Database");
            }else {
                res.put("Message", "Get Receipt Successful");
            }
            res.put("Data", receiptDtos);

        }catch (Exception e){
            e.printStackTrace();
        }
        return res;
    }

}
