package de.ehmkah.projects.service_versioning_example.contract_test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;


@Controller
@EnableAutoConfiguration
@ComponentScan
public class ApplicationRestContractTestImpl {

  public static void main(String[] args) throws Exception {
    SpringApplication.run(ApplicationRestContractTestImpl.class, args);
  }
}
