package org.hzero.todo.domain.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.choerodon.mybatis.annotation.ModifyAudit;
import io.choerodon.mybatis.annotation.VersionAudit;
import io.choerodon.mybatis.domain.AuditDomain;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@ApiModel("用户信息") // Swagger 实体描述
@ModifyAudit //在类上使用，启用审计字段支持，实体类加上该注解后，插入和更新会启动对 lastUpdateDate、lastUpdatedBy 自维护字段支持
@VersionAudit //在类上使用，启用objectVersionNumber自维护支持，插入一条数据objectVersionNumber默认为1，每次update后objectVersionNumber自增1
@Table(name = "todo_user") // 表映射
@JsonInclude(JsonInclude.Include.NON_NULL) // 数据返回前端时，排除为空的字段
public class User extends AuditDomain {
    @Id // 主键主键，注意是 javax.persistence.Id
    @GeneratedValue //对于自增张、序列（SEQUENCE）类型的主键，需要添加该注解
    private Long userId;


    @ApiModelProperty("用户姓名") // Swagger 字段描述
    private String userName;

    @ApiModelProperty("用户性别") // Swagger 字段描述
    private String userSex;

    @ApiModelProperty("用户年龄") // Swagger 字段描述
    private int userAge;

    @ApiModelProperty("用户标志") // Swagger 字段描述
    private String userFlag;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public int getUserAge() { return userAge; }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public String getUserFlag() {
        return userFlag;
    }

    public void setUserFlag(String userFlag) {
        this.userFlag = userFlag;
    }
}
