package de.ehmkah.projects.service_versioning_example.rest_service_media_type_versioning;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Michael Krausse (ehmkah)
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(apiInfo())
            .select()
              .apis(RequestHandlerSelectors.any())
              .paths(PathSelectors.any())
              .build()
            .pathMapping("/");
    
  }

  private ApiInfo apiInfo() {
    return new ApiInfoBuilder()
            .title("Awesome API - build #")
            .description("Enter the IDs in order to look for the content")
            .version("0.1")
            .build();

  }
}
