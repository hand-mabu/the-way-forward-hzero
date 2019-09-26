package com.hand.domain.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.NotBlank;
import io.choerodon.mybatis.domain.AuditDomain;
import io.choerodon.mybatis.annotation.ModifyAudit;
import io.choerodon.mybatis.annotation.VersionAudit;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * 
 *
 * @author menghui.liu@hand-china.com 2019-09-25 18:13:55
 */
@ApiModel("")
@VersionAudit
@ModifyAudit
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Table(name = "user")
public class User {

    public static final String FIELD_ID = "id";
    public static final String FIELD_USER_NAME = "userName";
    public static final String FIELD_PHONE = "phone";
    public static final String FIELD_PASSWORD = "password";
    public static final String FIELD_SALT = "salt";
    public static final String FIELD_HEAD = "head";
    public static final String FIELD_LOGIN_COUNT = "loginCount";
    public static final String FIELD_REGISTER_DATE = "registerDate";
    public static final String FIELD_LAST_LOGIN_DATE = "lastLoginDate";

    //
    // 业务方法(按public protected private顺序排列)
    // ------------------------------------------------------------------------------

    //
    // 数据库字段
    // ------------------------------------------------------------------------------


    @ApiModelProperty("")
    @Id
    @GeneratedValue
    private Long id;
   @ApiModelProperty(value = "")    
    private String userName;
   @ApiModelProperty(value = "")    
    private String phone;
   @ApiModelProperty(value = "")    
    private String password;
   @ApiModelProperty(value = "")    
    private String salt;
   @ApiModelProperty(value = "")    
    private String head;
   @ApiModelProperty(value = "")    
    private Long loginCount;
   @ApiModelProperty(value = "")    
    private Date registerDate;
   @ApiModelProperty(value = "")    
    private Date lastLoginDate;

	//
    // 非数据库字段
    // ------------------------------------------------------------------------------

    //
    // getter/setter
    // ------------------------------------------------------------------------------

    /**
     * @return 
     */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
    /**
     * @return 
     */
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
    /**
     * @return 
     */
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
    /**
     * @return 
     */
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    /**
     * @return 
     */
	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}
    /**
     * @return 
     */
	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}
    /**
     * @return 
     */
	public Long getLoginCount() {
		return loginCount;
	}

	public void setLoginCount(Long loginCount) {
		this.loginCount = loginCount;
	}
    /**
     * @return 
     */
	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
    /**
     * @return 
     */
	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

}
