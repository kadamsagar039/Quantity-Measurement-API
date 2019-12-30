package com.bridgelabz.qm.config;

import com.bridgelabz.qm.enumeration.LengthUnit;
import com.bridgelabz.qm.enumeration.TemperatureUnit;
import com.bridgelabz.qm.enumeration.VolumeUnit;
import com.bridgelabz.qm.enumeration.WeightUnit;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableAutoConfiguration
public class ApplicationConfig implements WebMvcConfigurer {

    public enum QUANTITY_TYPE{LENGTH, VOLUME, WEIGHT, TEMPERATURE};
    public static final Class[] quantityTypeClasses = {LengthUnit.class, VolumeUnit.class, WeightUnit.class,
            TemperatureUnit.class};

    @Bean
    public Docket apiDocket() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(getApiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("com.bridgelabz.qm")).paths(PathSelectors.any()).build();
    }

    private ApiInfo getApiInfo() {
        Contact contact = new Contact("Quantity Measurement Service API", "https://bridgelabz.com", "aniket.chile@bridgelabz.com");
        return new ApiInfoBuilder().title("Quantity Measurement Swagger API")
                .description("Swagger API for Quantity Measurement").version("1.0.0-SNAPSHOT")
                .license("Apache 2.0").licenseUrl("http://www.apache.org/licenses/LICENSE-2.0").contact(contact)
                .build();
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addRedirectViewController("/api/v2/api-docs", "/v2/api-docs");
        registry.addRedirectViewController("/api/swagger-resources/configuration/ui", "/swagger-resources/configuration/ui");
        registry.addRedirectViewController("/api/swagger-resources/configuration/security", "/swagger-resources/configuration/security");
        registry.addRedirectViewController("/api/swagger-resources", "/swagger-resources");
    }


    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedHeaders("*").allowedOrigins("*").allowedMethods("*");
    }
}
