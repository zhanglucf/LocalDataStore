package com.entity.user;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author ZhangZhenhua
 * @date 2021/1/19 8:39
 */
@Data
public class RolePermissionRelation {

    private Long id;
    /**
     * 角色ID
     */
    private Long roleId;
    /**
     * 权限ID
     */
    private Long permissionId;

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
