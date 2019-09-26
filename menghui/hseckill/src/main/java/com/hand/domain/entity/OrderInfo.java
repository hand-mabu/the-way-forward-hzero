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
@Table(name = "order_info")
public class OrderInfo {

    public static final String FIELD_ID = "id";
    public static final String FIELD_USER_ID = "userId";
    public static final String FIELD_GOODS_ID = "goodsId";
    public static final String FIELD_ADDR_ID = "addrId";
    public static final String FIELD_GOODS_NAME = "goodsName";
    public static final String FIELD_GOODS_COUNT = "goodsCount";
    public static final String FIELD_GOODS_PRICE = "goodsPrice";
    public static final String FIELD_ORDER_CHANNEL = "orderChannel";
    public static final String FIELD_STATUS = "status";
    public static final String FIELD_CREATE_DATE = "createDate";
    public static final String FIELD_PAY_DATE = "payDate";

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
   @ApiModelProperty(value = "用户id")    
    private Long userId;
   @ApiModelProperty(value = "商品id")    
    private Long goodsId;
   @ApiModelProperty(value = "收货地址id")    
    private Long addrId;
   @ApiModelProperty(value = "冗余过来的商品名称")    
    private String goodsName;
   @ApiModelProperty(value = "商品数量")    
    private Long goodsCount;
   @ApiModelProperty(value = "商品价格")    
    private BigDecimal goodsPrice;
   @ApiModelProperty(value = "支付通道：1 PC、2 Android、3 ios")    
    private Long orderChannel;
   @ApiModelProperty(value = "订单状态：0 未支付，1已支付，2 已发货，3 已收货，4 已退款，‘5 已完成")    
    private Long status;
   @ApiModelProperty(value = "")    
    private Date createDate;
   @ApiModelProperty(value = "支付时间")    
    private Date payDate;

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
     * @return 收货地址id
     */
	public Long getAddrId() {
		return addrId;
	}

	public void setAddrId(Long addrId) {
		this.addrId = addrId;
	}
    /**
     * @return 冗余过来的商品名称
     */
	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
    /**
     * @return 商品数量
     */
	public Long getGoodsCount() {
		return goodsCount;
	}

	public void setGoodsCount(Long goodsCount) {
		this.goodsCount = goodsCount;
	}
    /**
     * @return 商品价格
     */
	public BigDecimal getGoodsPrice() {
		return goodsPrice;
	}

	public void setGoodsPrice(BigDecimal goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
    /**
     * @return 支付通道：1 PC、2 Android、3 ios
     */
	public Long getOrderChannel() {
		return orderChannel;
	}

	public void setOrderChannel(Long orderChannel) {
		this.orderChannel = orderChannel;
	}
    /**
     * @return 订单状态：0 未支付，1已支付，2 已发货，3 已收货，4 已退款，‘5 已完成
     */
	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
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
     * @return 支付时间
     */
	public Date getPayDate() {
		return payDate;
	}

	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}

}
