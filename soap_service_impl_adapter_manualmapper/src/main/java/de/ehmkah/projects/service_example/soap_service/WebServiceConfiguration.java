package de.ehmkah.projects.service_example.soap_service;

import de.ehmkah.projects.service_versioning_example.soap.v1.Wsgardening;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
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

import javax.xml.ws.Endpoint;

/**
 * @author Michael Krausse (ehmkah)
 */
@EnableWs
@Configuration
public class WebServiceConfiguration {

  @Autowired
  private Wsgardening gardeningServiceV1;

  @Autowired
  private com.ehmkah.services.gardening.Wsgardening wsgardeningCurrent;

  @Bean(name="cxf")
  public SpringBus springBus() {
    return new SpringBus();
  }

  @Bean("endpointServiceV1")
  public Endpoint endpointServiceV1(SpringBus springBus) {
    EndpointImpl result = new EndpointImpl(springBus, gardeningServiceV1);
    result.setWsdlLocation("classpath:/wsdl/serviceDefinitionV1.wsdl");
    result.publish("/v1/service");

    return result;
  }

  @Bean("endpointServiceV2")
  public Endpoint endpointServiceV2(SpringBus springBus) {
    EndpointImpl result = new EndpointImpl(springBus, gardeningServiceV1);
    result.setWsdlLocation("classpath:/wsdl/serviceDefinitionV2.wsdl");
    result.publish("/v2/service");

    return result;
  }

  @Bean
  public ServletRegistrationBean servletRegistrationBean() {
    String url = "/overview/*";
    ServletRegistrationBean result = new ServletRegistrationBean(new CXFServlet(), url);
    result.setLoadOnStartup(1);
    return result;
  }

}
