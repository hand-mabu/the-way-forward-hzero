package org.hand.flashkill.domain.entity;

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

import java.sql.Date;

/**
 * 
 *
 * @author mengtao.yan@hand-chian.com 2019-10-14 17:12:38
 */
@ApiModel("")
@VersionAudit
@ModifyAudit
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Table(name = "flashkill_order")
public class Flashkillorder extends AuditDomain {

    public static final String FIELD_ID = "id";
    public static final String FIELD_USERID = "userId";
    public static final String FIELD_GOODSID = "goodsId";
    public static final String FIELD_PAY = "pay";
    public static final String FIELD_CREATEDBY = "createdBy";
    public static final String FIELD_CREATIONDATE = "creationDate";
    public static final String FIELD_LASTUPDATEDBY = "lastUpdatedBy";
    public static final String FIELD_LASTUPDATEDATE = "lastUpdateDate";
    public static final String FIELD_OBJECTVERSIONNUMBER = "objectVersionNumber";

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
    @ApiModelProperty(value = "用户id",required = true)
    @NotNull
    private Long userId;
    @ApiModelProperty(value = "商品id",required = true)
    @NotNull
    private Long goodsId;
   @ApiModelProperty(value = "是否付款 Y:是 N:否")    
    private String pay;
   @ApiModelProperty(value = "")    
    private Long createdBy;
   @ApiModelProperty(value = "")    
    private Date creationDate;
   @ApiModelProperty(value = "")    
    private Long lastUpdatedBy;
   @ApiModelProperty(value = "")    
    private Date lastUpdateDate;
   @ApiModelProperty(value = "")    
    private Long objectVersionNumber;

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
     * @return 用户id
     */
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
    /**
     * @return 商品id
     */
	public Long getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}
    /**
     * @return 是否付款 Y:是 N:否
     */
	public String getPay() {
		return pay;
	}

	public void setPay(String pay) {
		this.pay = pay;
	}
    /**
     * @return 
     */
	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}
    /**
     * @return 
     */
	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
    /**
     * @return 
     */
	public Long getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(Long lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}
    /**
     * @return 
     */
	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}
    /**
     * @return 
     */
	public Long getObjectVersionNumber() {
		return objectVersionNumber;
	}

	public void setObjectVersionNumber(Long objectVersionNumber) {
		this.objectVersionNumber = objectVersionNumber;
	}

}
