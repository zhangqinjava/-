package com.zq.dto;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class SeckillOrderDto {
    private String orderSN; // 订单编号

    private Long skuId; // SkuId

    private Long promotionSessionId; // 秒杀活动编号

    private BigDecimal seckillPrice; // 秒杀价格

    private Integer num; // 秒杀的商品数量

    private Long memberId; // 会员编号
}
