package com.hand.domain.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.NotBlank;
import io.choerodon.mybatis.domain.AuditDomain;
import java.math.BigDecimal;
import java.util.Date;

import io.choerodon.mybatis.annotation.ModifyAudit;
import io.choerodon.mybatis.annotation.VersionAudit;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 *
 * @author menghui.liu@hand-china.com 2019-09-25 18:13:55
 */
@ApiModel("")
@VersionAudit
@ModifyAudit
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Table(name = "goods")
public class Goods {

    public static final String FIELD_ID = "id";
    public static final String FIELD_GOODS_NAME = "goodsName";
    public static final String FIELD_GOODS_TITLE = "goodsTitle";
    public static final String FIELD_GOODS_IMG = "goodsImg";
    public static final String FIELD_GOODS_DETAIL = "goodsDetail";
    public static final String FIELD_GOODS_PRICE = "goodsPrice";
    public static final String FIELD_GOODS_STOCK = "goodsStock";
    public static final String FIELD_CREATE_DATE = "createDate";
    public static final String FIELD_UPDATE_DATE = "updateDate";

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
   @ApiModelProperty(value = "商品名称")    
    private String goodsName;
   @ApiModelProperty(value = "商品标题")    
    private String goodsTitle;
   @ApiModelProperty(value = "商品图片")    
    private String goodsImg;
   @ApiModelProperty(value = "商品介绍详情")    
    private String goodsDetail;
   @ApiModelProperty(value = "商品单价")    
    private BigDecimal goodsPrice;
   @ApiModelProperty(value = "商品库存，-1表示没有限制")    
    private Long goodsStock;
   @ApiModelProperty(value = "")    
    private Date createDate;
   @ApiModelProperty(value = "")    
    private Date updateDate;

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
     * @return 商品名称
     */
	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
    /**
     * @return 商品标题
     */
	public String getGoodsTitle() {
		return goodsTitle;
	}

	public void setGoodsTitle(String goodsTitle) {
		this.goodsTitle = goodsTitle;
	}
    /**
     * @return 商品图片
     */
	public String getGoodsImg() {
		return goodsImg;
	}

	public void setGoodsImg(String goodsImg) {
		this.goodsImg = goodsImg;
	}
    /**
     * @return 商品介绍详情
     */
	public String getGoodsDetail() {
		return goodsDetail;
	}

	public void setGoodsDetail(String goodsDetail) {
		this.goodsDetail = goodsDetail;
	}
    /**
     * @return 商品单价
     */
	public BigDecimal getGoodsPrice() {
		return goodsPrice;
	}

	public void setGoodsPrice(BigDecimal goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
    /**
     * @return 商品库存，-1表示没有限制
     */
	public Long getGoodsStock() {
		return goodsStock;
	}

	public void setGoodsStock(Long goodsStock) {
		this.goodsStock = goodsStock;
	}
    /**
     * @return 
     */
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
    /**
     * @return 
     */
	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

}
