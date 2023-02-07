package com.kshrd.derphsar_api.repository.provider;

import org.apache.ibatis.jdbc.SQL;

public class PromotionProvider {

    //get all promotions
    public String getPromotions(){
        return new SQL(){{
            SELECT("*");
            FROM("dp_promotion");
        }}.toString();
    }
    // get product by promotion id
    public String getProductByPromotionId(){
        return new SQL(){{
            SELECT("*");
            FROM("dp_products");
            WHERE("promo_id = #{promo_id}");
        }}.toString();
    }
    // get shop by promotion id
    public String getShopByPromotionId(){
        return new SQL(){{
            SELECT("*");
            FROM("dp_shops");
            WHERE("promotion_id = #{promo_id}");
        }}.toString();
    }
}
