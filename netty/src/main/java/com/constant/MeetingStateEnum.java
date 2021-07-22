package com.constant;

/**
 * @author ZhangZhenhua
 * @date 2021/1/19 8:48
 */
public enum  MeetingStateEnum {
    NOT_START(0, "notStart", "未开始"),
    UNDERWAY(1, "underway", "进行中"),
    COMPLETE(2, "complete", "完成");

    private Integer code;
    private String text;
    private String desc;

    MeetingStateEnum() {}

    MeetingStateEnum(Integer code, String codeName, String desc) {
        this.code = code;
        this.text = codeName;
        this.desc = desc;
    }
}
