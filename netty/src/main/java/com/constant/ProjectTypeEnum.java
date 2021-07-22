package com.constant;

public enum ProjectTypeEnum {
    TYPE_1(1, "type_1", "类型1"),
    TYPE_2(2, "type_2", "类型2"),
    TYPE_3(3, "type_3", "类型3");

    private Integer code;
    private String text;
    private String codeDesc;

    ProjectTypeEnum() {}

    ProjectTypeEnum(Integer code, String text, String desc) {
        this.code = code;
        this.text = text;
        this.codeDesc = desc;
    }
}
