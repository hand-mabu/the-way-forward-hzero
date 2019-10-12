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

import java.util.Date;

/**
 * 
 *
 * @author mengtao.yan@hand-chian.com 2019-10-12 16:54:08
 */
@ApiModel("")
@VersionAudit
@ModifyAudit
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Table(name = "flashkill_goods")
public class Flashkillgoods extends AuditDomain {

    public static final String FIELD_ID = "id";
    public static final String FIELD_GOODSNAME = "goodsName";
    public static final String FIELD_INVENTORY = "inventory";
    public static final String FIELD_STARTTIME = "startTime";
    public static final String FIELD_COUNTDOWNTIME = "countdownTime";
    public static final String FIELD_IMGADRESS = "imgAdress";
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
    @ApiModelProperty(value = "商品名",required = true)
    @NotBlank
    private String goodsName;
    @ApiModelProperty(value = "库存",required = true)
    @NotNull
    private Long inventory;
   @ApiModelProperty(value = "开始秒杀时间")    
    private Date startTime;
   @ApiModelProperty(value = "倒计时时间(ms)")    
    private Long countdownTime;
    @ApiModelProperty(value = "图片地址",required = true)
    @NotBlank
    private String imgAdress;
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
     * @return 商品名
     */
	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
    /**
     * @return 库存
     */
	public Long getInventory() {
		return inventory;
	}

	public void setInventory(Long inventory) {
		this.inventory = inventory;
	}
    /**
     * @return 开始秒杀时间
     */
	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
    /**
     * @return 倒计时时间(ms)
     */
	public Long getCountdownTime() {
		return countdownTime;
	}

	public void setCountdownTime(Long countdownTime) {
		this.countdownTime = countdownTime;
	}
    /**
     * @return 图片地址
     */
	public String getImgAdress() {
		return imgAdress;
	}

	public void setImgAdress(String imgAdress) {
		this.imgAdress = imgAdress;
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
