package com.lfx.business.passport.swagger;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.models.dto.ApiInfo;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by liufeixiang on 2019/3/18.
 */
@Configuration
@EnableSwagger
@EnableWebMvc
public class SwaggerConfig{

    private SpringSwaggerConfig springSwaggerConfig;

    /**
     * Required to autowire SpringSwaggerConfig
     */
    @Autowired
    public void setSpringSwaggerConfig(SpringSwaggerConfig springSwaggerConfig)
    {
        this.springSwaggerConfig = springSwaggerConfig;
    }

    /**
     * Every SwaggerSpringMvcPlugin bean is picked up by the swagger-mvc
     * framework - allowing for multiple swagger groups i.e. same code base
     * multiple swagger resource listings.
     */
    @Bean
    public SwaggerSpringMvcPlugin customImplementation()
    {
        return new SwaggerSpringMvcPlugin(this.springSwaggerConfig)
                .apiInfo(apiInfo())
                .includePatterns(".*?");
    }

    /*
     * "标题 title",
     * "描述 description",
     * "termsOfServiceUrl",
     * "联系邮箱 contact email",
     * "许可证的类型 license type",
     * "许可证的链接 license url"
     */
    private ApiInfo apiInfo()
    {
        ApiInfo apiInfo = new ApiInfo(
                "API文档首页",
                "后台RESTful API",
                "web app",//
                "liufeixiang@qq.com",
                "web app",
                "web app");
        return apiInfo;
    }
}