package com.entity.user;

import com.constant.DeletedFlagEnum;
import com.constant.SexEnum;
import com.constant.UserStateEnum;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author ZhangZhenhua
 * @date 2021/1/18 17:16
 */
@Data
public class User {
    /**
     * 主键
     */
    private Long id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 登录密码
     */
    private String password;
    /**
     * 手机号码
     */
    private String mobile;
    /**
     * 身份证号
     */
    private String idCard;
    /**
     * 头像图片地址
     */
    private String icon;
    /**
     * 出生年月
     */
    private String dateOfBirth;
    /**
     * 省
     */
    private Long provinceId;
    /**
     * 市
     */
    private Long cityId;
    /**
     * 县
     */
    private String districtId;
    /**
     * 性别
     */
    private SexEnum sex;
    /**
     * 专家类型
     */
    private Integer expertType;
    /**
     * 单位
     */
    private String unit;
    /**
     * 职务
     */
    private String duty;
    /**
     * 职称
     */
    private String technicalTitle;
    /**
     * 学历
     */
    private String technicalLevel;
    /**
     * 地方
     */
    private String address;
    /**
     * 银行卡
     */
    private String bankCard;
    /**
     * 开户行
     */
    private String bankName;
    /**
     * 汇入省
     */
    private String bankProvince;
    /**
     * 汇入市
     */
    private String bankCity;
    /**
     * 用户状态
     */
    private UserStateEnum state;
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
    /**
     * 逻辑删除标识符
     */
    private DeletedFlagEnum deleted;

}
