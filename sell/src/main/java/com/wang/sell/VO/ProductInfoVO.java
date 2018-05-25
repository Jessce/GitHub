package com.wang.sell.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @ Author     ：泽非
 * @ Date       ：Created in 17:01 2018/5/24
 * @ Description：
 * @ Modified By：
 */
@Data
public class ProductInfoVO {
    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    private List<ProductVO> productVOList;
}
