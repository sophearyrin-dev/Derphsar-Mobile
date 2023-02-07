package com.kshrd.derphsar_api.repository.provider;

import com.kshrd.derphsar_api.rest.shopreport.request.ShopReportRequestModel;
import org.apache.ibatis.jdbc.SQL;

public class ShopReportProvider {

    // addition shop report

    public String insertShopReport(ShopReportRequestModel shopReportRequestModel){
        return new SQL(){{
            INSERT_INTO("dp_shop_report");
            VALUES("shop_report_id, reasons, shop_id", "#{shop_report_id}, #{reasons, jdbcType=OTHER, typeHandler=com.kshrd.derphsar_api.mybatis.JSONTypeHandlerPg}, #{shop_id}");
        }}.toString();
    }

    // get shop report by shop id

    public String getShopReportByShopId(){
        return new SQL(){{
            SELECT("*");
            FROM("dp_shop_report");
            WHERE("shop_id = #{shop_id}");
        }}.toString();
    }
}
