package com.zq.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;
@Data
public class SeckillSessionEntity {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;
    /**
     * 场次名称
     */
    private String name;
    /**
     * 每日开始时间
     */
    private Date startTime;
    /**
     * 每日结束时间
     */
    private Date endTime;
    /**
     * 启用状态
     */
    private Integer status;
    /**
     * 创建时间
     */
    private Date createTime;

    // 每日秒杀活动对应的SKU信息  @TableField(exist = false) 修改该字段不是表结构中的
    private List<SeckillSkuRelationEntity> relationEntities;
}
