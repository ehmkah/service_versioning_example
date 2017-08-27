package de.ehmkah.projects.service_example.soap_service;


import com.ehmkah.services.gardening.ObjectFactory;
import com.ehmkah.services.gardening.RequestType;
import com.ehmkah.services.gardening.ResponseType;
import com.ehmkah.services.gardening.Wsgardening;
import de.ehmkah.projects.service_example.soap_service.domain.NeigbhbourCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;


@Component
@WebService(name = "Wsgardening", targetNamespace = "http://ehmkah.com/services/gardening", serviceName = "Wsgardening")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
        ObjectFactory.class
})
public class GardeningServiceImpl implements Wsgardening{

  @Autowired
  private NeigbhbourCheckService neigbhbourCheckService;

  private static final String NAMESPACE_URI = "http://ehmkah.com/services/gardening";

  @PayloadRoot(namespace = NAMESPACE_URI, localPart = "checkNeighbours")
  @ResponsePayload
  public ResponseType checkNeighbours(@RequestPayload RequestType parameters) {
    ResponseType result = new ResponseType();

    String checkResult = neigbhbourCheckService.areGood(parameters.getSpeciesOne(), parameters.getSpeciesTwo());
    result.setAreGoodNeighbours(checkResult);

    return result;
  }
}
