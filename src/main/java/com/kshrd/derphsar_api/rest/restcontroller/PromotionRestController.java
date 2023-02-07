package com.kshrd.derphsar_api.rest.restcontroller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.kshrd.derphsar_api.page.Pagination;
import com.kshrd.derphsar_api.repository.dto.*;
import com.kshrd.derphsar_api.rest.ApplyProductPromotion.request.ApplyProductPromotionRequestModel;
import com.kshrd.derphsar_api.rest.BaseApiResponse;
import com.kshrd.derphsar_api.rest.applyshoppromotion.request.ApplyShopPromotionRequestModel;
import com.kshrd.derphsar_api.rest.applyshoppromotion.response.ApplyShopPromotionResponseModel;
import com.kshrd.derphsar_api.rest.message.MessageProperties;
import com.kshrd.derphsar_api.rest.orderdetail.request.OrderDetailUpdateIsCheckoutModel;
import com.kshrd.derphsar_api.rest.orderdetail.response.OrderDetailResponse;
import com.kshrd.derphsar_api.rest.product.request.ProductUpdateDiscountModel;
import com.kshrd.derphsar_api.rest.product.response.ProductResponseModel;
import com.kshrd.derphsar_api.rest.promotion.request.ApplyProductPromotionRequest;
import com.kshrd.derphsar_api.rest.promotion.request.PromotionRequestModel;
import com.kshrd.derphsar_api.rest.promotion.request.PromotionUpdateIsApplyModel;
import com.kshrd.derphsar_api.rest.promotion.response.PromotionCreateFirstResponse;
import com.kshrd.derphsar_api.rest.promotion.response.PromotionResponseModel;
import com.kshrd.derphsar_api.rest.promotion.response.PromotionResponseShop;
import com.kshrd.derphsar_api.rest.receipt.response.ReceiptResponseModel;
import com.kshrd.derphsar_api.rest.shop.request.ShopPromotionRequestModel;
import com.kshrd.derphsar_api.rest.shop.request.ShopRequestModel;
import com.kshrd.derphsar_api.rest.shop.request.ShopUpdatePromotionRequestModel;
import com.kshrd.derphsar_api.rest.shop.response.ShopCreateFirstResponse;
import com.kshrd.derphsar_api.rest.shop.response.ShopPromotionResponse;
import com.kshrd.derphsar_api.rest.shop.response.ShopResponseModel;
import com.kshrd.derphsar_api.rest.user.response.UserResponseModel;
import com.kshrd.derphsar_api.rest.utils.BaseApiNoPaginationResponse;
import com.kshrd.derphsar_api.service.implement.*;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static net.bytebuddy.matcher.ElementMatchers.is;


//@CrossOrigin(origins = "*", maxAge = 3600)
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/v1")
public class PromotionRestController {

    private UserServiceImp userServiceImp;
    private PromotionServiceImp promotionServiceImp;
    private ProductServiceImp productServiceImp;
    private MessageProperties message;
    private ShopServiceImp shopServiceImp;
    private ApplyShopPromotionServiceImp applyShopPromotionServiceImp;
    private ApplyProductPromotionServiceImp applyProductPromotionServiceImp;


    @Autowired
    public void setApplyProductPromotionServiceImp(ApplyProductPromotionServiceImp applyProductPromotionServiceImp) {
        this.applyProductPromotionServiceImp = applyProductPromotionServiceImp;
    }

    @Autowired
    public void setProductServiceImp(ProductServiceImp productServiceImp) {
        this.productServiceImp = productServiceImp;
    }
    @Autowired
    public void setApplyShopPromotionServiceImp(ApplyShopPromotionServiceImp applyShopPromotionServiceImp) {
        this.applyShopPromotionServiceImp = applyShopPromotionServiceImp;
    }
    @Autowired
    public void setShopServiceImp(ShopServiceImp shopServiceImp) {
        this.shopServiceImp = shopServiceImp;
    }

    @Autowired
    public void setMessage(MessageProperties message) {
        this.message = message;
    }

    @Autowired
    public void setPromotionServiceImp(PromotionServiceImp promotionServiceImp) {
        this.promotionServiceImp = promotionServiceImp;
    }

    @Autowired
    public void setUserServiceImp(UserServiceImp userServiceImp) {
        this.userServiceImp = userServiceImp;
    }


    /**
     * Get all promotions
     *
     * @return - Return response message
     */
    @GetMapping("/promotions")
    @ApiOperation(value = "show all promotions", response = PromotionResponseModel.class)
    public ResponseEntity<BaseApiResponse<List<PromotionResponseModel>>> getPromotions(@RequestParam(value = "page" , required = false , defaultValue = "1") int page,
                                                                                                   @RequestParam(value = "limit" , required = false , defaultValue = "3") int limit,
                                                                                                   @RequestParam(value = "totalPages" , required = false , defaultValue = "3") int totalPages,
                                                                                                   @RequestParam(value = "pagesToShow" , required = false , defaultValue = "3") int pagesToShow) {

        Pagination pagination = new Pagination(page, limit,totalPages,pagesToShow);
        pagination.setPage(page);
        pagination.setLimit(limit);
        pagination.nextPage();
        pagination.previousPage();
        pagination.setTotalCount(productServiceImp.countId());
        pagination.setTotalPages(pagination.getTotalPages());

        ModelMapper mapper = new ModelMapper();
        BaseApiResponse<List<PromotionResponseModel>> response = new BaseApiResponse<>();
        List<PromotionResponseModel> promotions = new ArrayList<>();

        try {
            List<PromotionDto> promotion = promotionServiceImp.getPromotions(pagination);
            for (PromotionDto promotionDto : promotion) {
                promotions.add(mapper.map(promotionDto, PromotionResponseModel.class));
            }


            if (!promotion.isEmpty()) {
                response.setMessage(message.selected("Promotions"));
                response.setData(promotions);
                response.setStatus(HttpStatus.FOUND);
            }else {
                response.setMessage(message.hasNoRecords("Promotions"));
                response.setStatus(HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        response.setPagination(pagination);
        response.setTime(new Timestamp(System.currentTimeMillis()));
        return ResponseEntity.ok(response);
    }



    /**
     * Get promotions
     *
     * @param u_id - Id of a shop
     * @return - Return response message
     */
    @GetMapping("/promotions-in-shop")
    @ApiOperation(value = "show all promotions by user id", response = PromotionResponseModel.class)
    public ResponseEntity<BaseApiNoPaginationResponse<List<PromotionResponseModel>>> getPromotionByUserId(
            @RequestParam(value="userId",required = false,defaultValue = "") int u_id) {

        ModelMapper mapper = new ModelMapper();
        BaseApiNoPaginationResponse<List<PromotionResponseModel>> response = new BaseApiNoPaginationResponse<>();
        List<PromotionResponseModel> promotions = new ArrayList<>();

        try {
//            ShopDto shopDto = shopServiceImp.findById(u_id);
            List<PromotionDto> promotion = promotionServiceImp.getPromotionsByUserId(u_id);
            for (PromotionDto promotionDto : promotion) {
                promotions.add(mapper.map(promotionDto, PromotionResponseModel.class));
            }


            if (!promotion.isEmpty()) {
                response.setMessage(message.selected("Promotions"));
                response.setData(promotions);
                response.setStatus(HttpStatus.FOUND);
            }else {
                response.setMessage(message.hasNoRecords("Promotions"));
                response.setStatus(HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        response.setTime(new Timestamp(System.currentTimeMillis()));
        return ResponseEntity.ok(response);
    }

    @GetMapping("/prmotion-in-shop")
    @ApiOperation(value = "get all promotions by shop id", response = PromotionResponseModel.class)
    public ResponseEntity<BaseApiNoPaginationResponse<List<PromotionResponseModel>>> getPromotionByShopId(
            @RequestParam(value="shopId",required = false,defaultValue = "") int shop_id) {

        ModelMapper mapper = new ModelMapper();
        BaseApiNoPaginationResponse<List<PromotionResponseModel>> response = new BaseApiNoPaginationResponse<>();
        List<PromotionResponseModel> promotions = new ArrayList<>();

        try {
//            PromotionDto promotionDto = productServiceImp.findById(shop_id)
            List<PromotionDto> promotion = promotionServiceImp.getPromotionByShopId(shop_id);
            for (PromotionDto promotionDto : promotion) {
                promotions.add(mapper.map(promotionDto, PromotionResponseModel.class));
            }

            System.out.println("kokookooko"+promotion);


            if (!promotion.isEmpty()) {
                response.setMessage(message.selected("Promotions"));
                response.setData(promotions);
                response.setStatus(HttpStatus.FOUND);
            }else {
                response.setMessage(message.hasNoRecords("Promotions"));
                response.setStatus(HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        response.setTime(new Timestamp(System.currentTimeMillis()));
        return ResponseEntity.ok(response);
    }



    /**
     * Delete a promotion
     *
     * @param promoId - Id of a promotion
     * @return - Return response message
     */
    @DeleteMapping("/promotions/{promoId}")
    @ApiOperation(value = "delete a promotion by promotion id", response = Void.class)
    public ResponseEntity<BaseApiNoPaginationResponse<Void>> deletePromotion(@RequestParam int promoId) {

        BaseApiNoPaginationResponse<Void> response = new BaseApiNoPaginationResponse<>();
//        PromotionDto promotionDto = promotionServiceImp.findById(promoId);
//        PromotionDto promotionDto = new PromotionDto();
        promotionServiceImp.deletePromotion(promoId);
        response.setMessage(message.deleted("Promotion"));
        response.setStatus(HttpStatus.OK);
//        if(promotionDto.getId() == promoId){
//            promotionServiceImp.deletePromotion(promoId);
//            response.setMessage(message.deleted("Promotion"));
//            response.setStatus(HttpStatus.OK);
//        }
//        else {
//            response.setMessage(message.deleteError("Promotion"));
//            response.setStatus(HttpStatus.BAD_REQUEST);
//        }

        response.setTime(new Timestamp(System.currentTimeMillis()));
        return ResponseEntity.ok(response);
    }


    /**
     * Put a promotion
     *
     * @param promoId - Id of a promotion
     * @param promotionRequestModel - Promotion request model
     * @return - Return response message
     */
    @PutMapping("/promotions/{promoId}")
    @ApiOperation(value = "update a promotion by a promotion id", response = PromotionResponseModel.class)
    public ResponseEntity<BaseApiResponse<PromotionResponseModel>> updatePromotion(@PathVariable("promoId") String promoId,
                                                                                  @RequestBody PromotionRequestModel promotionRequestModel) {

        ModelMapper modelMapper = new ModelMapper();
        BaseApiResponse<PromotionResponseModel> response = new BaseApiResponse<>();

        try {
            PromotionDto promotionDto = modelMapper.map(promotionRequestModel, PromotionDto.class);
            PromotionResponseModel responseModel = modelMapper.map(promotionServiceImp.updatePromotion(promoId, promotionDto), PromotionResponseModel.class);

            response.setMessage(message.updated("Promotion"));
            response.setStatus(HttpStatus.OK);
            response.setData(responseModel);
        }catch (Exception e){
            e.printStackTrace();
        }

        response.setTime(new Timestamp(System.currentTimeMillis()));
        return ResponseEntity.ok(response);
    }

    /**
     * Put a promotion
     *
     * @param promoId - Id of a promotion
     * @param promotionUpdateIsApplyModel - Promotion request model
     * @return - Return response message
     */
    @PatchMapping("/promotions/{promoId}")
    @ApiOperation(value = "update isApply", response = PromotionUpdateIsApplyModel.class)
    public ResponseEntity<BaseApiNoPaginationResponse<PromotionUpdateIsApplyModel>> updateIsApply(@PathVariable("promoId") String promoId,
                                                                                   @RequestBody PromotionUpdateIsApplyModel promotionUpdateIsApplyModel) {
        ModelMapper modelMapper = new ModelMapper();
        BaseApiNoPaginationResponse<PromotionUpdateIsApplyModel> response = new BaseApiNoPaginationResponse<>();

        try {
            PromotionDto promotionDto = modelMapper.map(promotionUpdateIsApplyModel, PromotionDto.class);

            PromotionUpdateIsApplyModel responseModel = modelMapper.map(promotionServiceImp.updateIsApply(promoId, promotionDto), PromotionUpdateIsApplyModel.class);

            response.setMessage(message.updated("Promotion"));
            response.setStatus(HttpStatus.OK);
            response.setData(responseModel);
        }catch (Exception e){
            e.printStackTrace();
        }

        response.setTime(new Timestamp(System.currentTimeMillis()));
        return ResponseEntity.ok(response);
    }



    //pheary apply products promotion
    @PatchMapping("/apply-product-promotion/{shopId}")
    @ApiOperation(value = "apply products promotion", response = ProductResponseModel.class)
    public ResponseEntity<BaseApiNoPaginationResponse<List<ProductResponseModel>>> updateIsCheckout(@PathVariable("shopId") String shopId,
                                                                                                   @RequestBody ApplyProductPromotionRequest orderDetailUpdateIsCheckoutModel) {

//        System.out.println("orderDetailUpdateIsCheckoutModel");
        ModelMapper modelMapper = new ModelMapper();
        ObjectMapper mapper = new ObjectMapper();
        BaseApiNoPaginationResponse<List<ProductResponseModel>> response = new BaseApiNoPaginationResponse<>();

        List<ProductResponseModel> orderDetailUpdateIsCheckoutModelArrayList = new ArrayList<>();

        System.out.println(response);

//        List<OrderDetailDto> orderDetailDtos = new ArrayList<>();
        try {
            if(orderDetailUpdateIsCheckoutModel.getId().length > 0){
//                OrderDetailDto orderDetailDto = new OrderDetailDto();
                ShopDto findOrderByOrderId = shopServiceImp.findById(shopId);
                System.out.println(findOrderByOrderId);

                List<ProductDto> result = productServiceImp.updateProductPromotion(findOrderByOrderId.getId(), orderDetailUpdateIsCheckoutModel);

                ObjectMapper objectMapper = new ObjectMapper();
                for(ProductDto orderDetailDto1 : result){

//                    Object delivery = objectMapper.readValue(orderDetailDto1.getDeliveryTracking().toString(), Object.class);
//                    orderDetailDto1.setDeliveryTracking(delivery);
                    Object details = mapper.readValue(orderDetailDto1.getDetails().toString(), Object.class);
                    Object images = mapper.readValue(orderDetailDto1.getImages().toString(), Object.class);

                    orderDetailDto1.setDetails(details);
                    orderDetailDto1.setImages(images);
                    orderDetailUpdateIsCheckoutModelArrayList.add(modelMapper.map(orderDetailDto1, ProductResponseModel.class));

                }

                response.setMessage(message.updated("Product Promotion"));
                response.setStatus(HttpStatus.OK);
                response.setData(orderDetailUpdateIsCheckoutModelArrayList);
            }
            else {
                response.setMessage(message.updateError("Product Promotion"));
                response.setStatus(HttpStatus.BAD_REQUEST);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        response.setTime(new Timestamp(System.currentTimeMillis()));
        return ResponseEntity.ok(response);
    }




    /**
     * Post a promotion
     *
     * @param promotionRequestModel - Promotion request model
     * @return - Return response message
     */
    @PostMapping("/promotions")
    @ApiOperation(value = "create a promotion", response = PromotionCreateFirstResponse.class)
    public ResponseEntity<BaseApiNoPaginationResponse<PromotionCreateFirstResponse>> createPromotion(@RequestBody PromotionRequestModel promotionRequestModel) throws ParseException {

        ModelMapper mapper = new ModelMapper();
        UUID uuid = UUID.randomUUID();
        BaseApiNoPaginationResponse<PromotionCreateFirstResponse> response = new BaseApiNoPaginationResponse<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        PromotionDto promotionDto = mapper.map(promotionRequestModel,PromotionDto.class);


        if(!promotionRequestModel.getTitle().isEmpty() && promotionRequestModel.getStartRank() !=0 && promotionRequestModel.getEndRank() !=0 && promotionRequestModel.getStartDate() != null && promotionRequestModel.getEndDate() !=null && promotionRequestModel.getU_id() !=0){
            if(promotionRequestModel.getStartRank() > promotionRequestModel.getEndRank() || promotionRequestModel.getStartDate().after(promotionRequestModel.getEndDate())){
                response.setMessage(message.insertError("Promotion"));
                response.setStatus(HttpStatus.BAD_REQUEST);
            }else {
                promotionDto.setId(promotionDto.getId());
                promotionDto.setPromoId("DP"+uuid.toString().substring(0,10));
                promotionDto.setStatus(true);
                PromotionDto promotionDto1 = promotionServiceImp.createPromotion(promotionDto);

                PromotionCreateFirstResponse promotionCreateFirstResponse = mapper.map(promotionDto1, PromotionCreateFirstResponse.class);
                response.setMessage(message.inserted("Promotion"));
                response.setData(promotionCreateFirstResponse);
                response.setStatus(HttpStatus.CREATED);
                response.setStatus(HttpStatus.CREATED);
            }

        }else {
            response.setMessage(message.insertError("Promotion"));
            response.setStatus(HttpStatus.BAD_REQUEST);
        }
        response.setTime(new Timestamp(System.currentTimeMillis()));
        return ResponseEntity.ok(response);
    }


    /**
     * Get a promotion
     *
     * @param promoId - Id of a promotion
     * @return - Return response message
     */
    @GetMapping("/promotions/{promoId}")
    @ApiOperation(value = "get a promotion by a promotion id", response = PromotionResponseModel.class)
    public ResponseEntity<BaseApiNoPaginationResponse<List<PromotionResponseModel>>> findById(@PathVariable("promoId") String promoId){

        ModelMapper mapper = new ModelMapper();
        BaseApiNoPaginationResponse<List<PromotionResponseModel>> response =
                new BaseApiNoPaginationResponse<>();
        List<PromotionResponseModel> promotionRequestModels = new ArrayList<>();

        PromotionDto promotionDto = promotionServiceImp.findById(promoId);
        if(promotionDto != null){
            promotionRequestModels.add(mapper.map(promotionDto, PromotionResponseModel.class));

            response.setMessage(message.selectedOne("Promotion"));
            response.setData(promotionRequestModels);
            response.setStatus(HttpStatus.FOUND);
        }else {
            response.setMessage(message.hasNoRecord("Promotion"));
            response.setStatus(HttpStatus.NOT_FOUND);
        }

        response.setTime(new Timestamp(System.currentTimeMillis()));
        return ResponseEntity.ok(response);
    }


    /**
     * Post apply shop promotion
     *
     * @param applyShopPromotionRequestModel - Id of a promotion
     * @return - Return response message
     */


    @PostMapping("/apply-shop-promotion")
    @ApiOperation(value = "apply shop promotion", response = ApplyShopPromotionResponseModel.class)
    public Map<String, Object> applyShopPromotion(@RequestBody ApplyShopPromotionRequestModel applyShopPromotionRequestModel) {
        Map<String, Object> result = new HashMap<>();
        BaseApiResponse baseApiResponse = new BaseApiResponse();
        applyShopPromotionServiceImp.applyShopPromotion(applyShopPromotionRequestModel);
        result.put("Message", "Apply Shop Promotion successful");
        result.put("DATA", applyShopPromotionRequestModel);
        return result;
    }


    /**
     * Get product by promotion id
     *
     * @param promo_id - Id of a shop
     * @return - Return response message
     */

    @GetMapping("/getProduct/{PromotionId}")
    public Map<String, Object> getProductByPromotionId(@RequestParam int promo_id){
        Map<String, Object> res = new HashMap<>();
        List<ProductDto> productDtos = promotionServiceImp.getProductByPromotionId(promo_id);

        ObjectMapper mapper = new ObjectMapper();


//        Object images = mapper.readValue(productDtos.getImages().toString(), Object.class);
//        productDtos.setImages(images);


        try {
            if(productDtos.isEmpty()){
                res.put("Message", "No Product Promotion in Database");
            }else {
                res.put("Message", "Get Product Promotion Successful");
            }
            res.put("Data", productDtos);

        }catch (Exception e){
            e.printStackTrace();
        }
        return res;
    }


    /**
     * Get Shop by promotion id
     *
     * @param promotion - Id of a shop
     * @return - Return response message
     */

    @GetMapping("/getShop/{promotionId}")
    public Map<String, Object> getShopByPromotionId(@RequestParam int promotion){
        Map<String, Object> res = new HashMap<>();
        List<ShopDto> shopDtos = promotionServiceImp.getShopByPromotionId(promotion);
        try {
            if(shopDtos.isEmpty()){
                res.put("Message", "No Shop Promotion in Database");
            }else {
                res.put("Message", "Get Shop Promotion Successful");
            }
            res.put("Data", shopDtos);

        }catch (Exception e){
            e.printStackTrace();
        }
        return res;
    }

    /**
     * Post apply product promotion
     *
//     * @param applyProductPromotionRequestModel - Id of a promotion
     * @return - Return response message
     */


//    @PostMapping("/apply-product-promotion")
//    @ApiOperation(value = "apply product promotion", response = ApplyProductPromotionRequestModel.class)
//    public Map<String, Object> applyProductPromotion(@RequestBody ApplyProductPromotionRequestModel applyProductPromotionRequestModel) {
//        Map<String, Object> result = new HashMap<>();
//        BaseApiResponse baseApiResponse = new BaseApiResponse();
//        applyProductPromotionServiceImp.applyProductPromotion(applyProductPromotionRequestModel);
//        result.put("Message", "Apply Product Promotion successful");
//        result.put("DATA", applyProductPromotionRequestModel);
//        return result;
//    }


//    /**
//     * Put a shop promotion vesal
//     *
//     * @param shop_id - Id of a promotion
//     * @param shopRequestModel - Promotion request model
//     * @return - Return response message
//     */
//    @PutMapping("/update-shop-promotion/{shop-id}")
//    @ApiOperation(value = "update shop promotion by shop id", response = ShopResponseModel.class)
//    public ResponseEntity<BaseApiResponse<ShopResponseModel>> updateShopPromotionByShopId(@RequestParam int shop_id,
//                                                                                   @RequestBody ShopRequestModel shopRequestModel) {
//
//        ModelMapper modelMapper = new ModelMapper();
//        BaseApiResponse<ShopResponseModel> response = new BaseApiResponse<>();
//
//        try {
////            ShopDto shopDto = modelMapper.map(shopRequestModel, ShopDto.class);
//            ShopResponseModel responseModel = modelMapper.map(promotionServiceImp.updateShopPromotionByShopId(shop_id));
//            response.setMessage(message.updated("Shop Promotion"));
//            response.setStatus(HttpStatus.OK);
//            response.setData(responseModel);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//        response.setTime(new Timestamp(System.currentTimeMillis()));
//        return ResponseEntity.ok(response);
//    }
//

//    /**
//     * Delete a promotion
//     *
//     * @param shop_id - Id of a promotion
//     * @return - Return response message
//     */
//    @DeleteMapping("/promotions/{ShopId}")
//    @ApiOperation(value = "delete a shop promotion by shop id", response = Void.class)
//    public ResponseEntity<BaseApiNoPaginationResponse<Void>> deleteShopPromotionByShopId(@RequestParam int shop_id) {
//
//        BaseApiNoPaginationResponse<Void> response = new BaseApiNoPaginationResponse<>();
//        PromotionDto promotionDto = promotionServiceImp.findByShopId(shop_id);
//
//        if(promotionDto != null){
//            promotionServiceImp.deleteShopPromotionByShopId(shop_id);
//            response.setMessage(message.deleted("Promotion"));
//            response.setStatus(HttpStatus.OK);
//        }else {
//            response.setMessage(message.deleteError("Promotion"));
//            response.setStatus(HttpStatus.BAD_REQUEST);
//        }
//        response.setTime(new Timestamp(System.currentTimeMillis()));
//        return ResponseEntity.ok(response);
//    }

    @GetMapping("get-promotion-by-user/{userId}")
    @ApiOperation(value = "show a promotion by user id", response = PromotionResponseModel.class)
    public ResponseEntity<BaseApiResponse<List<PromotionResponseModel>>> getPromotionByUserId(@PathVariable("userId") String userId) {


        ModelMapper mapper = new ModelMapper();
        BaseApiResponse<List<PromotionResponseModel>> response = new BaseApiResponse<>();
        List<PromotionResponseModel> shops = new ArrayList<>();

        try {
            UserResponseModel userDto = userServiceImp.getOneUserById(userId);
            List<PromotionDto> shop = promotionServiceImp.getPromotionByUserId(userDto.getId());
            for (PromotionDto shopDto : shop) {
                shops.add(mapper.map(shopDto, PromotionResponseModel.class));
            }

//            PromotionResponseModel shopResponseModel = mapper.map(shop, PromotionResponseModel.class);
//            mapper.map(shop, ShopResponseModel.class);

            if (!shop.isEmpty()) {
            response.setMessage(message.selected("Promotion"));
            response.setData(shops);
            response.setStatus(HttpStatus.FOUND);
            } else {
                response.setMessage(message.hasNoRecords("Promotion"));
                response.setStatus(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.setTime(new Timestamp(System.currentTimeMillis()));
        return ResponseEntity.ok(response);
    }
}