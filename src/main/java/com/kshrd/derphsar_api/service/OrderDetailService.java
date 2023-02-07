package com.kshrd.derphsar_api.service;

import com.kshrd.derphsar_api.page.Pagination;
import com.kshrd.derphsar_api.repository.dto.*;
import com.kshrd.derphsar_api.repository.filter.OrderDetailFilter;
import com.kshrd.derphsar_api.rest.orderdetail.request.OrderDetailUpdateDeliveryTrackingModel;
import com.kshrd.derphsar_api.rest.orderdetail.request.OrderDetailUpdateIsCheckoutModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderDetailService {

    //get all orderDetail
    List<OrderDetailDto> getOrderDetails();

    //get all orderdetail ignore status
    List<OrderDetailDto> getOrderDetailsIgnoreStatus();

    List<OrderDetailDto> findAllWithFilter(int userId);

    List<OrderDetailDto> findOrderDetailByOrderId(int orderId);

    List<OrderDetailDto> findAllTracking(int orderId,Pagination pagination);

    List<OrderDetailDto> findAllProductCheckout(int shopId);


    boolean deleteOrderdetail(String order_detail_id);

    //count all id
    int countId();

    OrderDetailDto addProductToCart(OrderDetailDto orderDetailDto);

    OrderDetailDto getOrderDetailByItemId(String itemId);

    List<OrderDetailDto> updateIsCheckout(@Param("orderId") int orderId,@Param("orderDetailUpdateIsCheckoutModel") OrderDetailUpdateIsCheckoutModel orderDetailUpdateIsCheckoutModel);

    List<OrderDetailDto> updateDeliveryTracking(@Param("itemId") int itemId, @Param("orderDetailDto") OrderDetailDto orderDetailDto);

    //update a product
//    OrderDetailUpdateDeliveryTrackingModel updateTracking(int itemId, OrderDetailUpdateDeliveryTrackingModel orderDetailDto);

    OrderDetailDto updateTracking(String itemId, OrderDetailDto orderDetailDto);
}
