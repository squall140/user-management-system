package org.ums.api.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import lombok.Data;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @desc:
 * @author: Leif
 * @date: 23/06/2022 14:57
 */
//@Configuration
@EnableSwagger2
@Data
//@ConfigurationProperties("swagger2")
@EnableKnife4j
public class Swagger2Config {

    /**
     * Contact Config
     */
    private String name;
    private String url;
    private String email;
    private boolean enable;

    /**
     * ApiInfo Config
     */
    private String termsOfServiceUrl;
    private String description;
    private String title;
    private String version;

    /**
     * @Description: http://127.0.0.1:11111/swagger-ui.html
     * @param:
     * @return: Docket
     */
    @Bean
    public Docket createRestApi(@Qualifier("swagger2Contact") Contact contact) {
        ApiInfo apiInfo = new ApiInfoBuilder().title(title) // 大标题
                .description(description) // 详细描述
                .termsOfServiceUrl(termsOfServiceUrl).contact(contact) // 作者
                .version(version).build();

        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .enable(enable)
                .apiInfo(apiInfo).select() // 选择那些路径和api会生成document
                .apis(RequestHandlerSelectors.basePackage("org.ums.api.restful.v1")) // 对所有指定包进行监控
                .paths(PathSelectors.any()) // 对所有路径进行监控
                .build();
        docket.groupName(name);
        return docket;
    }

    @Bean
    public Docket testRestApi(@Qualifier("swagger2Contact") Contact contact) {
        ApiInfo apiInfo = new ApiInfoBuilder().title(title) // 大标题
                .description(description) // 详细描述
                .termsOfServiceUrl(termsOfServiceUrl).contact(contact) // 作者
                .version(version).build();

        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .enable(enable)
                .apiInfo(apiInfo).select() // 选择那些路径和api会生成document
                .apis(RequestHandlerSelectors.basePackage("org.ums.api.example")) // 对所有指定包进行监控
                .paths(PathSelectors.any()) // 对所有路径进行监控
                .build();
        docket.groupName("biesae-api-test");
        return docket;
    }

    @Bean
    public Docket RestApi(@Qualifier("swagger2Contact") Contact contact) {
        ApiInfo apiInfo = new ApiInfoBuilder().title(title) // 大标题
                .description(description) // 详细描述
                .termsOfServiceUrl(termsOfServiceUrl).contact(contact) // 作者
                .version(version).build();

        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .enable(enable)
                .apiInfo(apiInfo).select() // 选择那些路径和api会生成document
                .apis(RequestHandlerSelectors.basePackage("org.ums.api")) // 对所有指定包进行监控
                .paths(PathSelectors.any()) // 对所有路径进行监控
                .build();
        docket.groupName("biesae-bff");
        return docket;
    }
    @Bean(name = "swagger2Contact")
    public Contact initContact() {
        return new Contact(name, url, email);
    }

}
