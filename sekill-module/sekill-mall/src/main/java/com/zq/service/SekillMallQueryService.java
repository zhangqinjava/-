package com.zq.service;

import com.zq.dto.SeckillSessionEntity;

import java.util.List;

public interface SekillMallQueryService {
    List<SeckillSessionEntity> getLates3DaysSession();
}
