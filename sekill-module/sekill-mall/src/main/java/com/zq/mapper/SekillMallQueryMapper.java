package com.zq.mapper;
import com.zq.dto.SeckillSessionEntity;
import com.zq.dto.SeckillSkuRelationEntity;
import com.zq.dto.SkuInfoEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SekillMallQueryMapper {
     List<SeckillSessionEntity> querySkuInfo(String startTime,String endTime);
     List<SeckillSkuRelationEntity> querySessionId(String id);
     SkuInfoEntity querySkuIdInfo(String skuId);
}
