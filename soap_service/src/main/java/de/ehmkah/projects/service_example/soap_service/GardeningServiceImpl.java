package de.ehmkah.projects.service_example.soap_service;


import com.ehmkah.services.gardening.Add;
import com.ehmkah.services.gardening.Answer;
import org.springframework.stereotype.Component;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


@Endpoint
@Component
public class GardeningServiceImpl {//implements WsMath {


  private static final String NAMESPACE_URI = "http://ehmkah.com/services/gardening";

  @PayloadRoot(namespace = NAMESPACE_URI, localPart = "add")
  @ResponsePayload
  public Answer sum(@RequestPayload  Add parameters) {
    Answer result = new Answer();
    result.setResult(100);

    return result;
  }
}
