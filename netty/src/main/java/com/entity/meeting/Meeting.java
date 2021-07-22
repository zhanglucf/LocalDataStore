package com.entity.meeting;

import com.constant.MeetingStateEnum;
import com.constant.ProjectTypeEnum;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author ZhangZhenhua
 * @date 2021/1/19 8:41
 */
@Data
public class Meeting {

    private Long id;
    /**
     * 会议编号
     */
    private String meetingNum;
    /**
     * 会议名称
     */
    private String meetingName;
    /**
     * 会议开始时间
     */
    private LocalDateTime meetingDateStart;
    /**
     * 会议结束时间
     */
    private LocalDateTime meetingDatEnd;
    /**
     * 会议概括
     */
    private String meetingSummarize;
    /**
     * 会议状态
     */
    private MeetingStateEnum state;
    /**
     * 项目类型
     */
    private ProjectTypeEnum projectType;
    /**
     * 项目细目
     */
    private String projectJson;
    /**
     * 送审时间
     */
    private LocalDateTime auditTime;
    /**
     * 送审地点
     */
    private String auditLocation;
    /**
     * 审核单位
     */
    private String auditUnit;
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
