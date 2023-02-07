package com.kshrd.derphsar_api.repository.provider;

import com.kshrd.derphsar_api.rest.productreport.request.ProductReportRequestModel;
import org.apache.ibatis.jdbc.SQL;

public class ProductReportProvider {

    // addition product report
    public String insertProductReport(ProductReportRequestModel productReportRequestModel){
        return new SQL(){{
            INSERT_INTO("dp_product_report");
            VALUES("report_id, reasons, pro_id", "#{report_id}, #{reasons, jdbcType=OTHER, typeHandler=com.kshrd.derphsar_api.mybatis.JSONTypeHandlerPg}, #{pro_id}");
        }}.toString();
    }

    // get product report by pro_id

    public String getProductReportByProductId(){
        return new SQL(){{
            SELECT("*");
            FROM("dp_product_report");
            WHERE("pro_id = #{pro_id}");
        }}.toString();
    }
}
