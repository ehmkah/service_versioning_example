package de.ehmkah.projects.service_example.soap_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;

@Controller
@EnableAutoConfiguration
@ComponentScan
public class ApplicationImplV2 {

  public static void main(String[] args) throws Exception {
    SpringApplication.run(ApplicationImplV2.class, args);
  }
}

