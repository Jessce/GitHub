package com.wang.sell.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @ Author     ：泽非
 * @ Date       ：Created in 9:49 2018/5/24
 * @ Description：商品表，商品ID name icon等具体信息数据库映射
 * @ Modified By：
 */
@Entity
@Data
public class ProductInfo {
    @Id
    private String productId;

    private String productName;

    private BigDecimal productPrice;

    private Integer productStock;

    private String productDescription;

    private String productIcon;

    private Integer categoryType;

    private Integer productStatus;
}
