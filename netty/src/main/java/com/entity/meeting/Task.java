package com.entity.meeting;

import com.constant.TaskTypeEnum;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author ZhangZhenhua
 * @date 2021/1/19 9:31
 */
@Data
public class Task {

    private Long id;
    private Long partId;
    private Long userId;
    private Long meetingId;
    private String ruleCode;
    private TaskTypeEnum state;

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
