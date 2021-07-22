package com.entity.meeting;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author ZhangZhenhua
 * @date 2021/1/19 9:45
 */
@Data
public class RuleAttr {

    private Long id;
    private Long ruleId;
    /**
     * 号文属性唯一CODE代码
     */
    private String code;
    private Long meetingId;
    private String name;

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
