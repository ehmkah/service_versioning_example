package de.ehmkah.prjects.api;

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
public class ApplicationRestImplV1 {

  public static void main(String[] args) throws Exception {
    SpringApplication.run(ApplicationRestImplV1.class, args);
  }
}
