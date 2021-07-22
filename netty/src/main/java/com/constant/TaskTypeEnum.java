package com.constant;

/**
 * @author ZhangZhenhua
 * @date 2021/1/19 9:33
 */
public enum TaskTypeEnum {
    UNCOMMITTED(0, "uncommitted", "未提交"),
    SCRATCH(1, "scratch", "暂存"),
    COMMITTED(2, "committed", "已提交"),
    RETREAT(3, "retreat", "回退"),
    CONFIRM(4, "confirm", "已提交");

    private Integer code;
    private String text;
    private String desc;

    TaskTypeEnum() {}

    TaskTypeEnum(Integer code, String codeName, String desc) {
        this.code = code;
        this.text = codeName;
        this.desc = desc;
    }
}
