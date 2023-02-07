package com.kshrd.derphsar_api.service;


import com.kshrd.derphsar_api.page.Pagination;
import com.kshrd.derphsar_api.repository.dto.*;
import com.kshrd.derphsar_api.rest.orderdetail.request.OrderDetailUpdateIsCheckoutModel;
import com.kshrd.derphsar_api.rest.promotion.request.ApplyProductPromotionRequest;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductService {

    //getProducts
    List<ProductDto> getProducts(Pagination pagination);


    List<ProductDto> findProductByShopId(int shopId, Pagination pagination);

    List<ProductDto> findProductByShopIdWithoutPagination(int shopId);

    //create product
    ProductDto insert(ProductDto productDto);


    //delete a product
    void deleteProduct(String id);

    //update a product
    ProductDto updateProduct(String id, ProductDto productDto);

    //update a product
    ProductDto updateProductPromotionAndDiscount(String id, ProductDto productDto);

    //find by id
    ProductDto findById(String proId);

    //get product by promotionId
    //find by id
    List<ProductDto> getProductByPromotionId(int promoId, Pagination pagination);

    //count id
    int countId();

    //get new products
    List<ProductDto> getNewProducts();


    //get new products
    List<ProductDto> getNewProductsByShopId(int shopId);

    //get all products by categoryId
    List<ProductDto> getAllProductByCategoryId(int categoryId);

    //get popular
    List<ProductDto> getPopularProducts();

    //get products by user id
    List<ProductDto> getAllProductsByUserId(int userId, Pagination pagination);

    //get related products
    List<ProductDto> getRelatedProducts(int categoryId);

    ShopDto getShopByShopId(String shopId);

    CategoryDto getCategoryByCatId(String catId);

    //getAllProductByProductName
    List<ProductDto> getAllProductByProductName(String productName);

    //update product promotion
    List<ProductDto> updateProductPromotion(@Param("shopId") int shopId, @Param("applyProductPromotionRequest") ApplyProductPromotionRequest applyProductPromotionRequest);

}
