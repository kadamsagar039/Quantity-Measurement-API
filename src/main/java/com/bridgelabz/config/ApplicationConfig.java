package com.bridgelabz.config;

import com.bridgelabz.qm.enumeration.LengthUnit;
import com.bridgelabz.qm.enumeration.TemperatureUnit;
import com.bridgelabz.qm.enumeration.VolumeUnit;
import com.bridgelabz.qm.enumeration.WeightUnit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
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
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
