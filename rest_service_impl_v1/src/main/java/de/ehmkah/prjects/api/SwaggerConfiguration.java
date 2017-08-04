package de.ehmkah.prjects.api;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author Michael Krausse (ehmkah)
 */
//@Configuration
//@EnableSwagger2
public class SwaggerConfiguration {

  public class SwaggerConfig {
  //  @Bean
    public Docket api() {
      return new Docket(DocumentationType.SWAGGER_2)
              .select()
              .apis(RequestHandlerSelectors.any())
              .paths(PathSelectors.any())
              .build();
    }
  }
}
