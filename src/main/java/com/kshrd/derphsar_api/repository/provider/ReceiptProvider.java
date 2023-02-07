package com.kshrd.derphsar_api.repository.provider;

import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.jdbc.SQL;

public class ReceiptProvider {
    public String insertReceipt(){
        return new SQL(){{
            INSERT_INTO("dp_receipt");
            VALUES("receipt_id, receipt_url, u_id",
                    "#{receipt_id}, #{url}, #{u_id}");
        }}.toString();
    }


    public String deleteReceipt(int id){
        return new SQL(){{
            UPDATE("dp_receipt");
            SET("status = false");
            WHERE("id = " + id);
        }}.toString();
    }

    public String findCode(int id){
//        System.out.println(" Provider: "  +id);
        return new SQL(){{
            SELECT("*");
            FROM("dp_receipt");
            WHERE("id = #{id}");
        }}.toString();
    }

    public String getAllReceiptByUserId(){
        return new SQL(){{
            SELECT("*");
            FROM("dp_receipt");
            WHERE("u_id = #{u_id} and status=true");
        }}.toString();
    }
}
