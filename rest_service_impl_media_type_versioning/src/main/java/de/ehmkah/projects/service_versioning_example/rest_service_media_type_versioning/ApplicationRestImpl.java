package de.ehmkah.projects.service_versioning_example.rest_service_media_type_versioning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;


@Controller
@EnableAutoConfiguration
@ComponentScan
public class ApplicationRestImpl {

  public static void main(String[] args) throws Exception {
    SpringApplication.run(ApplicationRestImpl.class, args);
  }
}
