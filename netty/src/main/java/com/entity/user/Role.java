package com.entity.user;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author ZhangZhenhua
 * @date 2021/1/19 8:30
 */
@Data
public class Role {

    private Long id;
    /**
     * 角色唯一CODE代码
     */
    private String code;
    /**
     * 角色名称
     */
    private String name;
    /**
     * 角色介绍
     */
    private String desc;
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
