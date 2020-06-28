package com.ahut.domain;

/**
 * @author hanzijian
 * @create 2020-06-27 10:28
 */
public class Role {
    private int id;
    private String roleName;
    private String roleDesc;

    public int getId() {
        return id;
    }

    public void setId(int pId) {
        id = pId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String pRoleName) {
        roleName = pRoleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String pRoleDesc) {
        roleDesc = pRoleDesc;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", roleDesc='" + roleDesc + '\'' +
                '}';
    }
}
