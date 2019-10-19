package org.hzero.todo.domain.entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import io.choerodon.mybatis.annotation.ModifyAudit;
import io.choerodon.mybatis.annotation.VersionAudit;
import io.choerodon.mybatis.domain.AuditDomain;

import org.hzero.core.util.Regexs;
@ApiModel("商品信息") // Swagger 实体描述
@ModifyAudit //在类上使用，启用审计字段支持，实体类加上该注解后，插入和更新会启动对 lastUpdateDate、lastUpdatedBy 自维护字段支持
@VersionAudit //在类上使用，启用objectVersionNumber自维护支持，插入一条数据objectVersionNumber默认为1，每次update后objectVersionNumber自增1
@Table(name = "todo_goods") // 表映射
@JsonInclude(JsonInclude.Include.NON_NULL) // 数据返回前端时，排除为空的字段
public class Goods extends AuditDomain {
    @Id // 主键主键，注意是 javax.persistence.Id
    @GeneratedValue //对于自增张、序列（SEQUENCE）类型的主键，需要添加该注解
    private Long goodsId;
    @Length(max = 30) // 长度控制
    @NotBlank // 非空控制
    @ApiModelProperty("商品名称") // Swagger 字段描述
    private String goodsName;
    @Length(max = 30)
    @NotBlank
    @Pattern(regexp = Regexs.CODE, message = "htdo.warn.goods.numberFormatIncorrect") // 格式控制
    @ApiModelProperty("商品编号")
    private String goodsNumber;
    @Length(max = 1000)
    @ApiModelProperty("商品介绍")
    private String goodsDes;
    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }
    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsNumber() {
        return goodsNumber;
    }

    public void setGoodsNumber(String goodsNumber) {
        this.goodsNumber = goodsNumber;
    }

    public String getGoodsDes() {
        return goodsDes;
    }

    public void setGoodsDes(String goodsDes) {
        this.goodsDes = goodsDes;
    }

}
