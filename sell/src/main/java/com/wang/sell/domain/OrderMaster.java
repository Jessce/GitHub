package com.wang.sell.domain;

import com.wang.sell.enums.PayStatusEnum;
import com.wang.sell.enums.OrderStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @ Author     ：泽非
 * @ Date       ：Created in 16:27 2018/5/25
 * @ Description：
 * @ Modified By：
 */
@Entity
@Data
@DynamicUpdate
public class OrderMaster {
    @Id
    private String orderId;

    private String buyerName;

    private String buyerPhone;

    private String buyerAddress;

    private String buyerOpenid;

    private BigDecimal orderAmount;

    /*订单状态，0是新单，默认0*/
    private Integer orderStatus= OrderStatusEnum.NEW.getCode();

    /*支付状态，0是未支付，默认0*/
    private Integer payStatus= PayStatusEnum.WAITING.getCode();

    private Date createTime;

    private Date updateTime;

}
