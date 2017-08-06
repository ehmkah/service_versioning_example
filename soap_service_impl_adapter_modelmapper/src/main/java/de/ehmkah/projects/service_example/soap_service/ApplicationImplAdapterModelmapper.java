package de.ehmkah.projects.service_example.soap_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;

/**
 * @author Michael Krausse (ehmkah)
 */

@Controller
@EnableAutoConfiguration
@ComponentScan
public class ApplicationImplAdapterModelmapper {

  public static void main(String[] args) throws Exception {
    SpringApplication.run(ApplicationImplAdapterModelmapper.class, args);
  }
}

