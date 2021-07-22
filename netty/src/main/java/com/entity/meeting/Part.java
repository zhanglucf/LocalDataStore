package com.entity.meeting;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author ZhangZhenhua
 * @date 2021/1/19 8:55
 */
@Data
public class Part {

    private Long id;
    /**
     * 排序字段
     */
    private Long seq;
    /**
     * atk名称
     */
    private String atkName;
    /**
     * 会议ID
     */
    private Long meetingId;
    /**
     * ATK原始字段
     */
    private String text;
    /**
     * ATK原始字段
     */
    private String did;
    /**
     * ATK原始字段
     */
    private String pid;
    /**
     * ATK原始字段
     */
    private String index;
    /**
     * ATK原始字段
     */
    private String tableName;
    /**
     * ATK原始字段
     */
    private Integer ntype;
    /**
     * 号文ID
     */
    private String ruleId;
    /**
     * 创建时间
     */
    private LocalDateTime insertTime;
    /**
     * 创建人
     */
    private Long insertBy;
    /**
     * 修改时间
     */
    private LocalDateTime updateTime;
    /**
     * 修改人
     */
    private Long updateBy;
}
