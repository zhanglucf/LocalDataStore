package com.constant;

public enum UserStateEnum {
    ENABLE(0, "enable", "可用"),
    DISENABLE(1, "disEnable", "可用");

    private Integer code;
    private String text;
    private String desc;

    UserStateEnum(Integer code) {}

    UserStateEnum(Integer code, String text, String desc) {
        this.code = code;
        this.text = text;
        this.desc = desc;
    }
}

