package com.zq.service.impl;

import com.zq.dto.SeckillSessionEntity;
import com.zq.dto.SeckillSkuRelationEntity;
import com.zq.mapper.SekillMallQueryMapper;
import com.zq.service.SekillMallQueryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class SekillMallQueryServiceImpl implements SekillMallQueryService {
    @Autowired
    private SekillMallQueryMapper sekillMallQueryMapper;
    public List<SeckillSessionEntity> getLates3DaysSession() {
        String start = startTime();
        String end = endTime();
        List<SeckillSessionEntity> seckillSessionEntities = sekillMallQueryMapper.querySkuInfo(start, end);
        seckillSessionEntities.forEach(item->{
            List<SeckillSkuRelationEntity> seckillSkuRelationEntities = sekillMallQueryMapper.querySessionId(String.valueOf(item.getId()));
            item.setRelationEntities(seckillSkuRelationEntities);
        });
        return seckillSessionEntities;
    }
    public  String startTime(){
        LocalDate now = LocalDate.now();
        LocalDate startDay = now.plusDays(0);
        LocalTime min = LocalTime.MIN;
        LocalDateTime start = LocalDateTime.of(startDay, min);
        return start.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    public  String endTime(){
        LocalDate now = LocalDate.now();
        LocalDate endDay = now.plusDays(2);
        LocalTime max = LocalTime.MAX;
        LocalDateTime end = LocalDateTime.of(endDay, max);
        return end.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}
