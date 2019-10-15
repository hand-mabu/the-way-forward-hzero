package org.hand.flashkill.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.Tag;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Swagger Api 描述配置
 */
@Configuration
public class SwaggerTags {

    public static final String EXAMPLE = "Example";
    public static final String FLASHKILL = "FLASHKILL";
    public static final String FLASHKILL_ORDER = "FLASHKILL_ORDER";


    @Autowired
    public SwaggerTags(Docket docket) {
        docket.tags(
                new Tag(EXAMPLE, "EXAMPLE 案例"),
                new Tag(FLASHKILL, "秒杀系统"),
                new Tag(FLASHKILL_ORDER, "秒杀系统-订单")
        );
    }
}
