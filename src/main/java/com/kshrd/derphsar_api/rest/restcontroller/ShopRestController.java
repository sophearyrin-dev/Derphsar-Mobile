package com.kshrd.derphsar_api.rest.restcontroller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kshrd.derphsar_api.page.Pagination;
import com.kshrd.derphsar_api.repository.ShopRepository;
import com.kshrd.derphsar_api.repository.dto.ProductDto;
import com.kshrd.derphsar_api.repository.dto.PromotionDto;
import com.kshrd.derphsar_api.repository.dto.ShopDto;
import com.kshrd.derphsar_api.repository.dto.UserDto;
import com.kshrd.derphsar_api.rest.BaseApiResponse;
import com.kshrd.derphsar_api.rest.message.MessageProperties;
import com.kshrd.derphsar_api.rest.product.request.ProductRequestModel;
import com.kshrd.derphsar_api.rest.product.response.ProductResponseModel;
import com.kshrd.derphsar_api.rest.promotion.response.PromotionResponseModel;
import com.kshrd.derphsar_api.rest.promotion.response.PromotionResponseShopId;
import com.kshrd.derphsar_api.rest.shop.request.ApplyShopPromotionRequestModel2;
import com.kshrd.derphsar_api.rest.shop.request.DeleteShopPromotionChangePromoIdToNull;
import com.kshrd.derphsar_api.rest.shop.request.ShopRequestModel;
import com.kshrd.derphsar_api.rest.shop.request.UpdateShopPromoIdRequestModel;
import com.kshrd.derphsar_api.rest.shop.response.ShopCreateFirstResponse;
import com.kshrd.derphsar_api.rest.shop.response.ShopResponseModel;
import com.kshrd.derphsar_api.rest.shop.response.UpdateShopPromoIdResponse;
import com.kshrd.derphsar_api.rest.user.response.UserResponseModel;
import com.kshrd.derphsar_api.rest.utils.BaseApiNoPaginationResponse;
import com.kshrd.derphsar_api.service.implement.ShopServiceImp;
import com.kshrd.derphsar_api.service.implement.UserServiceImp;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


//@CrossOrigin(origins = "*", maxAge = 3600)
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/v1")
public class ShopRestController {


    private ShopServiceImp shopServiceImp;
    private UserServiceImp userServiceImp;
    private MessageProperties message;

    @Autowired
    public void setMessage(MessageProperties message) {
        this.message = message;
    }

    @Autowired
    public void setShopServiceImp(ShopServiceImp shopServiceImp) {
        this.shopServiceImp = shopServiceImp;
    }


    @Autowired
    public void setUserServiceImp(UserServiceImp userServiceImp) {
        this.userServiceImp = userServiceImp;
    }


    /**
     * Post a shop
     *
     * @param shopRequestModel - Shop request model
     * @return - Return response message
     */
    @PostMapping("/shops")
    @ApiOperation(value = "create a shop", response = ShopCreateFirstResponse.class)
    public ResponseEntity<BaseApiNoPaginationResponse<ShopCreateFirstResponse>> createShop(@RequestBody ShopRequestModel shopRequestModel) {

        ModelMapper mapper = new ModelMapper();
        UUID uuid = UUID.randomUUID();
        BaseApiNoPaginationResponse<ShopCreateFirstResponse> response = new BaseApiNoPaginationResponse<>();

        ShopDto shopDto = mapper.map(shopRequestModel, ShopDto.class);

        if (!shopRequestModel.getName().isEmpty() && shopRequestModel.getU_id() != 0 && shopRequestModel.getCat_id() != 0) {

            if (shopRequestModel.getOpenTime().after(shopRequestModel.getCloseTime())) {
                response.setMessage(message.insertError("Shop"));
                response.setStatus(HttpStatus.BAD_REQUEST);
            } else {
                shopDto.setShopId("DP" + uuid.toString().substring(0, 10));
                shopDto.setStatus(true);
                ShopDto shop = shopServiceImp.createShop(shopDto);

                ShopCreateFirstResponse shopCreateFirstResponse = mapper.map(shop, ShopCreateFirstResponse.class);
                response.setMessage(message.inserted("Shop"));
                response.setData(shopCreateFirstResponse);
                response.setStatus(HttpStatus.CREATED);
            }

        } else {
            response.setMessage(message.insertError("Shop"));
            response.setStatus(HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.ok(response);
    }


    /**
     * Get shops
     *
     * @param page        - Page of pagination
     * @param limit       - Limit data of a pagination
     * @param totalPages  - Total pages of data limited in a page
     * @param pagesToShow - Pages to show
     * @return - Return response message
     */
    @GetMapping("shops")
    @ApiOperation(value = "show all shops", response = ShopResponseModel.class)
    public ResponseEntity<BaseApiResponse<List<ShopResponseModel>>> getShops(@RequestParam(value = "page", required = false, defaultValue = "1") int page,
                                                                             @RequestParam(value = "limit", required = false, defaultValue = "3") int limit,
                                                                             @RequestParam(value = "totalPages", required = false, defaultValue = "3") int totalPages,
                                                                             @RequestParam(value = "pagesToShow", required = false, defaultValue = "3") int pagesToShow) {

        Pagination pagination = new Pagination(page, limit, totalPages, pagesToShow);
        pagination.setPage(page);
        pagination.setLimit(limit);
        pagination.nextPage();
        pagination.previousPage();
        pagination.setTotalCount(shopServiceImp.countId());
        pagination.setTotalPages(pagination.getTotalPages());

        ModelMapper mapper = new ModelMapper();
        BaseApiResponse<List<ShopResponseModel>> response = new BaseApiResponse<>();
        List<ShopResponseModel> shops = new ArrayList<>();

        try {
            List<ShopDto> shop = shopServiceImp.getShops(pagination);
            System.out.println("shop_111 : " + shop);
            for (ShopDto shopDto : shop) {
                shops.add(mapper.map(shopDto, ShopResponseModel.class));
            }
            if (!shop.isEmpty()) {
                response.setMessage(message.selected("Shops"));
                response.setData(shops);
                response.setStatus(HttpStatus.FOUND);
            } else {
                response.setMessage(message.hasNoRecords("Shops"));
                response.setStatus(HttpStatus.NOT_FOUND);
            }
            response.setPagination(pagination);
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.setTime(new Timestamp(System.currentTimeMillis()));
        return ResponseEntity.ok(response);
    }




    /**
     * Delete a shop
     *
     * @param shopId - Id of a shop
     * @return - Return response message
     */
    @DeleteMapping("/shops/{shopId}")
    @ApiOperation(value = "delete a shop", response = Void.class)
    public ResponseEntity<BaseApiNoPaginationResponse<Void>> deleteShop(@PathVariable("shopId") String shopId) {

        BaseApiNoPaginationResponse<Void> response = new BaseApiNoPaginationResponse<>();
        ShopDto shopDto = shopServiceImp.findById(shopId);
        if (shopDto != null) {
            shopServiceImp.deleteShop(shopId);
            response.setMessage(message.deleted("Shop"));
            response.setStatus(HttpStatus.OK);
        } else {
            response.setMessage(message.deleteError("Shop"));
            response.setStatus(HttpStatus.BAD_REQUEST);
        }
        response.setTime(new Timestamp(System.currentTimeMillis()));
        return ResponseEntity.ok(response);
    }


    /**
     * Put a shop
     *
     * @param shopId           - Id of a shop
     * @param shopRequestModel - Shop request model
     * @return - Return response message
     */
    @PutMapping("/update-shops/{shopId}")
    @ApiOperation(value = "update a shop", response = ShopResponseModel.class)
    public ResponseEntity<BaseApiNoPaginationResponse<ShopResponseModel>> updateShop(@PathVariable("shopId") String shopId,
                                                                                     @RequestBody ShopRequestModel shopRequestModel) {

        ModelMapper modelMapper = new ModelMapper();
        BaseApiNoPaginationResponse<ShopResponseModel> response = new BaseApiNoPaginationResponse<>();
        ShopDto shopDto = shopServiceImp.findById(shopId);

        if (shopDto != null) {
            if(shopDto.getPromo_id()==0){
                shopDto.setPromo_id(0);
            }
            ShopDto dto = modelMapper.map(shopRequestModel, ShopDto.class);
            ShopResponseModel responseModel = modelMapper.map(shopServiceImp.updateShop(shopId, dto), ShopResponseModel.class);

            response.setMessage(message.updated("Shop"));
            response.setData(responseModel);
            response.setStatus(HttpStatus.OK);

        } else {
            response.setMessage(message.updateError("Shop"));
            response.setStatus(HttpStatus.BAD_REQUEST);
        }

        response.setTime(new Timestamp(System.currentTimeMillis()));
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/update-shops-promoId/{shopId}")
    @ApiOperation(value = "update a shop", response = UpdateShopPromoIdResponse.class)
    public ResponseEntity<BaseApiNoPaginationResponse<UpdateShopPromoIdResponse>> updateShopPromoId(@PathVariable("shopId") String shopId,
                                                                                     @RequestBody UpdateShopPromoIdRequestModel shopRequestModel) {

        ModelMapper modelMapper = new ModelMapper();
        BaseApiNoPaginationResponse<UpdateShopPromoIdResponse> response = new BaseApiNoPaginationResponse<>();
        ShopDto shopDto = shopServiceImp.findById(shopId);

        if (shopDto != null) {
            ShopDto dto = modelMapper.map(shopRequestModel, ShopDto.class);
            UpdateShopPromoIdResponse responseModel = modelMapper.map(shopServiceImp.updateShopPromoId(shopId, dto), UpdateShopPromoIdResponse.class);

            response.setMessage(message.updated("Shop"));
            response.setData(responseModel);
            response.setStatus(HttpStatus.OK);

        } else {
            response.setMessage(message.updateError("Shop"));
            response.setStatus(HttpStatus.BAD_REQUEST);
        }

        response.setTime(new Timestamp(System.currentTimeMillis()));
        return ResponseEntity.ok(response);
    }


//    @PutMapping("/shops/{shopId}")
//    @ApiOperation(value = "update a shop", response = ShopResponseModel.class)
//    public ResponseEntity<BaseApiNoPaginationResponse<ShopResponseModel>> updateShop(
//            @PathVariable("shopId") String shopId,
//            @RequestBody ShopRequestModel shopRequestModel){
//
//
//        ModelMapper modelMapper=new ModelMapper();
//        ShopDto dto=modelMapper.map(shopRequestModel,ShopDto.class);
//        ShopResponseModel responeModel= modelMapper.map(shopServiceImp.updateShop(shopId,dto),ShopResponseModel.class);
////                BaseApiNoPaginationResponse<ShopResponseModel> response = new BaseApiNoPaginationResponse <>();
//
//        BaseApiResponse<ProductRequestModel> respone=new BaseApiResponse <>();
//        respone.setMessage(message.updated("Update"));
//        respone.setStatus(HttpStatus.OK);
//        respone.setData(responeModel);
//        respone.setTime(new Timestamp(System.currentTimeMillis()));
//        return ResponseEntity.ok(respone);
//    }


    /**
     * Get a shop
     *
     * @param shopId - Id of a shop
     * @return - Return response message
     */
    @GetMapping("/shop/{shopId}")
    @ApiOperation(value = "search a shop by shop id", response = ShopResponseModel.class)
    public ResponseEntity<BaseApiNoPaginationResponse<ShopResponseModel>> findById(@PathVariable("shopId") String shopId) {

        ModelMapper mapper = new ModelMapper();
        BaseApiNoPaginationResponse<ShopResponseModel> response = new BaseApiNoPaginationResponse<>();

        try {
            ShopDto shopDto = shopServiceImp.findById(shopId);
            ModelMapper modelMapper = new ModelMapper();
            ShopResponseModel shopResponseModel = modelMapper.map(shopDto, ShopResponseModel.class);

            response.setMessage(message.selectedOne("Shop"));
            response.setData(shopResponseModel);
            response.setStatus(HttpStatus.FOUND);
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.setTime(new Timestamp(System.currentTimeMillis()));
        return ResponseEntity.ok(response);
    }


    @GetMapping("/shop-idInt/{shopId}")
    @ApiOperation(value = "search a shop by shop id", response = ShopResponseModel.class)
    public ResponseEntity<BaseApiNoPaginationResponse<ShopResponseModel>> getShopByShopIdInt(@PathVariable("shopId") int shopId) {

        ModelMapper mapper = new ModelMapper();
        BaseApiNoPaginationResponse<ShopResponseModel> response = new BaseApiNoPaginationResponse<>();

        try {
            ShopDto shopDto = shopServiceImp.getShopByShopIdInt(shopId);
            ModelMapper modelMapper = new ModelMapper();
            ShopResponseModel shopResponseModel = modelMapper.map(shopDto, ShopResponseModel.class);

            response.setMessage(message.selectedOne("Shop"));
            response.setData(shopResponseModel);
            response.setStatus(HttpStatus.FOUND);
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.setTime(new Timestamp(System.currentTimeMillis()));
        return ResponseEntity.ok(response);
    }


    /**
     * Get a shop
     *
     * @param userId - Id of a user
     * @return - Return response message
     */
    @GetMapping("shops/{userId}")
    @ApiOperation(value = "show all shops by user id", response = ShopResponseModel.class)
    public ResponseEntity<BaseApiResponse<List<ShopResponseModel>>> getAllShopsByUserId(@PathVariable("userId") String userId) {

        ModelMapper mapper = new ModelMapper();
        BaseApiResponse<List<ShopResponseModel>> response = new BaseApiResponse<>();
        List<ShopResponseModel> shops = new ArrayList<>();

        try {
            UserDto userDto = shopServiceImp.getUserByUserId(userId);
            List<ShopDto> shop = shopServiceImp.getAllShopsByUserId(userDto.getId());
            for (ShopDto shopDto : shop) {
                shops.add(mapper.map(shopDto, ShopResponseModel.class));
            }

            if (!shop.isEmpty()) {
                response.setMessage(message.selected("Shops"));
                response.setData(shops);
                response.setStatus(HttpStatus.FOUND);
            } else {
                response.setMessage(message.hasNoRecords("Shops"));
                response.setStatus(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.setTime(new Timestamp(System.currentTimeMillis()));
        return ResponseEntity.ok(response);
    }


    /**
     * Get all shops by shop name (pheary)
     *
     * @param name
     * @return
     */
    @GetMapping("/all-shops/")
    @ApiOperation(value = "show all shops by shop name", response = ShopResponseModel.class)
    public ResponseEntity<BaseApiResponse<List<ShopResponseModel>>> getAllShopByShopName(@RequestParam("name") String name) {

        BaseApiResponse<List<ShopResponseModel>> response = new BaseApiResponse<>();
        ObjectMapper mapper = new ObjectMapper();

        List<ShopDto> productDtos1 = shopServiceImp.getAllShopByName(name);
        List<ShopResponseModel> productResponseModels = new ArrayList<>();

        for (ShopDto shopDto : productDtos1) {
            try {

                ModelMapper modelMapper = new ModelMapper();
                ShopResponseModel productResponseModel = modelMapper.map(shopDto, ShopResponseModel.class);
                productResponseModels.add(productResponseModel);


                if (!productDtos1.isEmpty()) {
                    response.setData(productResponseModels);
                    response.setMessage(message.selected("Shops"));
                    response.setStatus(HttpStatus.OK);
                } else {
                    response.setMessage(message.hasNoRecord("Shops"));
                    response.setStatus(HttpStatus.BAD_REQUEST);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        response.setTime(new Timestamp(System.currentTimeMillis()));
        return ResponseEntity.ok(response);

    }

    @GetMapping("get-promotion/{shopId}")
    @ApiOperation(value = "show all shop by shop shopId", response = ShopResponseModel.class)
    public ResponseEntity<BaseApiResponse<ShopResponseModel>> getPromotionByShopId(@PathVariable("shopId") String shopId) {


        ModelMapper mapper = new ModelMapper();
        BaseApiResponse<ShopResponseModel> response = new BaseApiResponse<>();
        List<ShopResponseModel> shops = new ArrayList<>();

        try {
            ShopDto userDto = shopServiceImp.findById(shopId);
           ShopDto shop = shopServiceImp.getPromotionByShopId(userDto.getId());
//            for (ShopDto shopDto : shop) {
//                shops.add(mapper.map(shopDto, ShopResponseModel.class));
//                shops.add(mapper.map(shopDto, ShopResponseModel.class));
//            }

            ShopResponseModel shopResponseModel = mapper.map(shop, ShopResponseModel.class);
//            mapper.map(shop, ShopResponseModel.class);

//            if (!shop.isEmpty()) {
                response.setMessage(message.selected("Shops"));
                response.setData(shopResponseModel);
                response.setStatus(HttpStatus.FOUND);
//            } else {
//                response.setMessage(message.hasNoRecords("Shops"));
//                response.setStatus(HttpStatus.NOT_FOUND);
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.setTime(new Timestamp(System.currentTimeMillis()));
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/apply-shop-promotion/{userId}")
    @ApiOperation(value = "apply shop promotion by user id", response = ShopResponseModel.class)
    public ResponseEntity<BaseApiNoPaginationResponse<List<ShopResponseModel>>> applyShopPromotion(@PathVariable("userId") String userId,
                                                                                                   @RequestBody ApplyShopPromotionRequestModel2 orderDetailUpdateIsCheckoutModel) {

        ModelMapper modelMapper = new ModelMapper();
        BaseApiNoPaginationResponse<List<ShopResponseModel>> response = new BaseApiNoPaginationResponse<>();

        List<ShopResponseModel> shopResponseModels = new ArrayList<>();

        try {
            if(orderDetailUpdateIsCheckoutModel.getId().length > 0){
                UserResponseModel userDto = userServiceImp.getOneUserById(userId);
                System.out.println(userDto);

                List<ShopDto> result = shopServiceImp.updateShopPromotion(userDto.getId(), orderDetailUpdateIsCheckoutModel);

                for(ShopDto orderDetailDto1 : result){

                    shopResponseModels.add(modelMapper.map(orderDetailDto1, ShopResponseModel.class));

                }

                response.setMessage(message.updated("Shop Promotion"));
                response.setStatus(HttpStatus.OK);
                response.setData(shopResponseModels);
            }
            else {
                response.setMessage(message.updateError("Shop Promotion"));
                response.setStatus(HttpStatus.BAD_REQUEST);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        response.setTime(new Timestamp(System.currentTimeMillis()));
        return ResponseEntity.ok(response);
    }



    @PutMapping("/shops/{delete promotion shopId}")
    @ApiOperation(value = "delete shop promotion by shop id", response = ShopResponseModel.class)
    public ResponseEntity<BaseApiNoPaginationResponse<ShopResponseModel>> deleteShopPromotionByShopId(@RequestParam("shopId") String shopId) {

        ModelMapper modelMapper = new ModelMapper();
        BaseApiNoPaginationResponse<ShopResponseModel> response = new BaseApiNoPaginationResponse<>();
        ShopDto shopDto = shopServiceImp.findById(shopId);

        shopServiceImp.deleteShopPromotionByShopId(shopId);
        response.setMessage(message.updated("Shop"));
        response.setStatus(HttpStatus.OK);


//        if (shopDto != null) {
//            ShopDto dto = modelMapper.map(deleteShopPromotionChangePromoIdToNull, ShopDto.class);
//            ShopResponseModel responseModel = modelMapper.map(shopServiceImp.deletgeShopPromotionByShopId(shopId, dto), ShopResponseModel.class);
//
//            response.setMessage(message.updated("Shop"));
//            response.setData(responseModel);
//            response.setStatus(HttpStatus.OK);
//
//        } else {
//            response.setMessage(message.updateError("Shop"));
//            response.setStatus(HttpStatus.BAD_REQUEST);
//        }

        response.setTime(new Timestamp(System.currentTimeMillis()));
        return ResponseEntity.ok(response);
    }
}
