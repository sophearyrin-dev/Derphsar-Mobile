package com.kshrd.derphsar_api.service.implement;

import com.kshrd.derphsar_api.page.Pagination;
import com.kshrd.derphsar_api.repository.OrderDetailRepository;
import com.kshrd.derphsar_api.repository.dto.OrderDetailDto;
import com.kshrd.derphsar_api.rest.orderdetail.request.OrderDetailUpdateIsCheckoutModel;
import com.kshrd.derphsar_api.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderDetailServiceImp implements OrderDetailService {

    private OrderDetailRepository orderDetailRepository;

    private OrderDetailServiceImp orderDetailServiceImp;

    @Autowired
    public void setOrderDetailServiceImp(OrderDetailServiceImp orderDetailServiceImp) {
        this.orderDetailServiceImp = orderDetailServiceImp;
    }

    @Autowired
    public void setOrderDetailRepository(OrderDetailRepository orderDetailRepository) {
        this.orderDetailRepository = orderDetailRepository;
    }

    @Override
    public List<OrderDetailDto> getOrderDetails(){
        List<OrderDetailDto> data = orderDetailRepository.getOrderDetails();
        try{
            if(!data.isEmpty())
                return data;
        }catch (Exception e){
            e.printStackTrace();
        }
        return data;
    }

    @Override
    public List<OrderDetailDto> getOrderDetailsIgnoreStatus() {
        List<OrderDetailDto> data = orderDetailRepository.getAllOrderIgnoreStatus();
        try{
            if(!data.isEmpty())
                return data;
        }catch (Exception e){
            e.printStackTrace();
        }
        return data;
    }

    @Override
    public List<OrderDetailDto> findAllWithFilter(int orderId) {
        List<OrderDetailDto> data = orderDetailRepository.findAllWithFilter(orderId);
        try {
            if(!data.isEmpty())
                return data;
        }catch (Exception e){
            e.printStackTrace();
        }
        return data;
    }

    @Override
    public List<OrderDetailDto> findOrderDetailByOrderId(int orderId) {
        System.out.println("order_id" + orderId);
        List<OrderDetailDto> data = orderDetailRepository.findOrderDetailByOrderId(orderId);
        System.out.println("data"+ data);
        try {
            if(!data.isEmpty())
                return data;
        }catch (Exception e){
            e.printStackTrace();
        }
        return data;
    }

    @Override
    public List<OrderDetailDto> findAllTracking(int itemId, Pagination pagination) {
        System.out.println("item_id" + itemId);
        List<OrderDetailDto> data = orderDetailRepository.findAllTracking(itemId,pagination);
        System.out.println("data"+ data.toString());
        try {
            if(!data.isEmpty())
                return data;
        }catch (Exception e){
            e.printStackTrace();
        }
        return data;
    }

    @Override
    public List<OrderDetailDto> findAllProductCheckout(int shopId) {
        List<OrderDetailDto> data = orderDetailRepository.getAllProductCheckout(shopId);
        System.out.println("data"+ data.toString());
        try {
            if(!data.isEmpty())
                return data;
        }catch (Exception e){
            e.printStackTrace();
        }
        return data;
    }

    @Override
    public boolean deleteOrderdetail(String order_detail_id) {
        boolean isDeleted = orderDetailRepository.deleteOrderDetail(order_detail_id);
        if(isDeleted){
            return true;
        }else
            return false;
    }

    //count all id
    @Override
    public int countId() {
        return orderDetailRepository.countId();
    }

    @Override
    public OrderDetailDto addProductToCart(OrderDetailDto orderDetailDto) {

        boolean isInsertOrderDetail = orderDetailRepository.insertOrderDetail(orderDetailDto);
        if(isInsertOrderDetail)
            return orderDetailDto;
        else
            return null;
    }

    @Override
    public OrderDetailDto getOrderDetailByItemId(String itemId) {
        return orderDetailRepository.getOrderDetailByItemId(itemId);
    }

    @Override
    public List<OrderDetailDto> updateIsCheckout(int orderId, OrderDetailUpdateIsCheckoutModel orderDetailUpdateIsCheckoutModel) {

        List<OrderDetailDto> orderDetailDtoList1 = new ArrayList<>();
        List<OrderDetailDto> orderDetailDtoList = findOrderDetailByOrderId(orderId);
        boolean orderDetailDtos;

        System.out.println("size1"+ orderDetailUpdateIsCheckoutModel.getOrderItemId().length);
        for (int i=0; i<orderDetailUpdateIsCheckoutModel.getOrderItemId().length ; i++) {
            for (OrderDetailDto orderDetailDto1 : orderDetailDtoList) {
                if (orderDetailDto1.getItemId().compareTo(orderDetailUpdateIsCheckoutModel.getOrderItemId()[i])==0){
                    orderDetailRepository.updateIsCheckout(orderDetailDto1.getId());
                    orderDetailDtoList1.add(orderDetailDto1);
                    System.out.println("dto1"+ orderDetailDto1);
                    System.out.println("list dto: "+ orderDetailDtoList1);
                }
            }
        }
        return orderDetailDtoList1;
    }

    @Override
    public List<OrderDetailDto> updateDeliveryTracking(int itemId, OrderDetailDto orderDetailDto) {
        return null;
    }

//    @Override
//    public List<OrderDetailDto> updateDeliveryTracking(int itemId, OrderDetailDto orderDetailDto) {
//        Pagination pagination = new Pagination();
//        List<OrderDetailDto> orderDetailDtoList = findAllTracking(itemId,pagination);
//        System.out.println("order"+ orderDetailDtoList);
//        boolean orderDetailDtos = false;
//
//        for(OrderDetailDto orderDetailDto1 : orderDetailDtoList){
//            orderDetailDtos = orderDetailRepository.updateDeliveryTracking(orderDetailDto1.getOrder_id(),orderDetailDto);
//            System.out.println("hi"+orderDetailDtos);
//        }
//        return orderDetailDtoList;
//    }

    @Override
    public OrderDetailDto updateTracking(String id, OrderDetailDto orderDetailDto) {
        boolean isUpdated = orderDetailRepository.updateDeliveryTracking(id, orderDetailDto);
        System.out.println("service : " + orderDetailDto);
        if(isUpdated){
            return orderDetailDto;
        }
        return null;
    }

//    //update a product
//    @Override
//    public ProductDto updateProduct(String id, ProductDto productDto) {
//        boolean isUpdated = productRepository.updateProduct(id,productDto);
//        if(isUpdated){
//            return productDto;
//        }
//        return null;
//    }
}
