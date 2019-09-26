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
@Table(name = "seckill_goods")
public class SeckillGoods {

    public static final String FIELD_ID = "id";
    public static final String FIELD_GOODS_ID = "goodsId";
    public static final String FIELD_SECKIL_PRICE = "seckilPrice";
    public static final String FIELD_STOCK_COUNT = "stockCount";
    public static final String FIELD_START_DATE = "startDate";
    public static final String FIELD_END_DATE = "endDate";

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
   @ApiModelProperty(value = "商品id")    
    private Long goodsId;
   @ApiModelProperty(value = "秒杀价")    
    private BigDecimal seckilPrice;
   @ApiModelProperty(value = "秒杀数量")    
    private Long stockCount;
   @ApiModelProperty(value = "")    
    private Date startDate;
   @ApiModelProperty(value = "")    
    private Date endDate;

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
     * @return 商品id
     */
	public Long getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}
    /**
     * @return 秒杀价
     */
	public BigDecimal getSeckilPrice() {
		return seckilPrice;
	}

	public void setSeckilPrice(BigDecimal seckilPrice) {
		this.seckilPrice = seckilPrice;
	}
    /**
     * @return 秒杀数量
     */
	public Long getStockCount() {
		return stockCount;
	}

	public void setStockCount(Long stockCount) {
		this.stockCount = stockCount;
	}
    /**
     * @return 
     */
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
    /**
     * @return 
     */
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

}
