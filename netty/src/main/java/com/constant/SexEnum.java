package com.constant;

/**
 * @author ZhangZhenhua
 * @date 2021/1/18 17:44
 */
public enum  SexEnum {
    UNKNOWN(0,"unknown","未知的性别"),
    MAN(1,"man","男性"),
    WOMAN(2,"woman","女性");

    private Integer code;
    private String text;
    private String codeDesc;

    SexEnum() {}

     SexEnum(Integer code, String text, String desc) {
        this.code = code;
        this.text = text;
        this.codeDesc = desc;
    }
}
