package com.javaTests.configs;


import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Component
@EnableSwagger2
public class SpringFoxConfig {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.javaTests.controllers"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(vovasData());

    }

    private ApiInfo vovasData(){

        ApiInfo apiInfo = new ApiInfo("My REST API to learn ho to make test with mockito <3","A small REST API to learn how to make tests","1.0","2019","snowtoslow@gmail.com","GNU Lesser General Public License","https://www.gnu.org/licenses/lgpl-3.0.html");
        /*title, description, version, termsOfServiceUrl, new Contact(contactName, "", ""), license, licenseUrl, new ArrayList())*/
        return apiInfo;
    }





}
