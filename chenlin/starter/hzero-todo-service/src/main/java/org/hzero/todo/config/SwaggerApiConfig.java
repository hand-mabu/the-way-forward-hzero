package org.hzero.todo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.Tag;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Swagger Api 描述配置
 */
@Configuration
public class SwaggerApiConfig {
    public static final String Goods = "Goods";
    public static final String Order = "Order";


    @Autowired
    public SwaggerApiConfig(Docket docket) {
        docket.tags(
                new Tag(Goods, "商品信息"),
                new Tag(Order, "订单信息"));
    }
}
