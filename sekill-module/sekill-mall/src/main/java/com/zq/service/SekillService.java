package com.zq.service;

import com.zq.dto.SeckillSkuRedisDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface SekillService {
    void uploadSeckillSku3Days();

    List<SeckillSkuRedisDto> getCurrentSeckillSkus() throws Exception;

    SeckillSkuRedisDto getSeckillSessionBySkuId(Long skuId);

    String kill(String killId, String code, Integer num);

}
