package com.constant;

public enum DeletedFlagEnum {

    ENABLE(0, "enable", "未删除，可用"),
    DELETED(1, "deleted", "不可用");
    private Integer code;
    private String text;
    private String desc;

    DeletedFlagEnum() {}

    DeletedFlagEnum(Integer code, String text, String desc) {
        this.code = code;
        this.text = text;
        this.desc = desc;
    }
}
