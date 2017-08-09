package de.ehmkah.projects.service_example.soap_service;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.SimpleWsdl11Definition;
import org.springframework.ws.wsdl.wsdl11.Wsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;

/**
 * @author Michael Krausse (ehmkah)
 */
@EnableWs
@Configuration
public class WebServiceConfiguration {

  @Bean
  public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
    MessageDispatcherServlet servlet = new MessageDispatcherServlet();
    servlet.setApplicationContext(applicationContext);
    servlet.setTransformWsdlLocations(true);
    return new ServletRegistrationBean(servlet, "/ws/*");
  }

  @Bean(name = "service")
  public Wsdl11Definition defaultWsdl11Definition() {
    SimpleWsdl11Definition wsdl11Definition = new SimpleWsdl11Definition();
    wsdl11Definition.setWsdl(new ClassPathResource("/wsdl/serviceDefinitionV2.wsdl"));

    return wsdl11Definition;
  }

  @Bean(name = "types")
  public SimpleXsdSchema xsdTypes() {
    SimpleXsdSchema result = new SimpleXsdSchema(new ClassPathResource("/wsdl/types.xsd"));

    return result;
  }

  @Bean(name = "serviceV1")
  public Wsdl11Definition defaultWsdl11DefinitionV1() {
    SimpleWsdl11Definition wsdl11Definition = new SimpleWsdl11Definition();
    wsdl11Definition.setWsdl(new ClassPathResource("/wsdl/serviceDefinitionV1.wsdl"));

    return wsdl11Definition;
  }




}
