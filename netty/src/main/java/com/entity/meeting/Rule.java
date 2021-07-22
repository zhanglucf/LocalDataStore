package com.entity.meeting;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author ZhangZhenhua
 * @date 2021/1/19 9:26
 */
@Data
public class Rule {

    private Long id;

    private Integer seq;
    /**
     * 号文名称
     */
    private String ruleName;
    /**
     * 号文描述
     */
    private String desc;
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
