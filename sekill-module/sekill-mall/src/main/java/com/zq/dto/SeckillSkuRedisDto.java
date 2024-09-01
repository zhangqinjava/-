package com.zq.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class SeckillSkuRedisDto {


    private Long promotionSessionId;

    private Long skuId;

    private BigDecimal seckillPrice;

    private BigDecimal seckillCount;

    private BigDecimal seckillLimit;

    private Integer seckillSort;



    private Long startTime;
    private Long endTime;
    // 随机码
    private String randCode;

    private SkuInfoEntity skuInfoVo;

}
