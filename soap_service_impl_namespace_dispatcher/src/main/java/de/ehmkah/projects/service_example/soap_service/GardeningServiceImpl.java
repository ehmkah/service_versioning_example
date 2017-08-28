package de.ehmkah.projects.service_example.soap_service;


import com.ehmkah.services.gardening.v2.*;
import org.springframework.stereotype.Component;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;


@Component
@WebService(name = "Wsgardening", targetNamespace = "http://ehmkah.com/services/gardening/v2", serviceName = "Wsgardening")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
        ObjectFactory.class
})
public class GardeningServiceImpl implements Wsgardening {

  @Override
  public ResponseType checkNeighbours(RequestType request) {
    return null;
  }

  @Override
  public GetPriceResponseType getPrice(GetPriceRequestType request) {
    return null;
  }

//  @Autowired
//  private NeigbhbourCheckService neigbhbourCheckService;
//
//  private static final String NAMESPACE_URI = "http://ehmkah.com/services/gardening";
//
//  @PayloadRoot(namespace = NAMESPACE_URI, localPart = "checkNeighbours")
//  @ResponsePayload
//  public ResponseType checkNeighbours(@RequestPayload RequestType parameters) {
//    ResponseType result = new ResponseType();
//
//    String checkResult = neigbhbourCheckService.areGood(parameters.getSpeciesOne(), parameters.getSpeciesTwo());
//    result.setAreGoodNeighbours(checkResult);
//
//    return result;
//  }
//
//  @Override
//  public GetPriceResponseType getPrice(GetPriceRequestType request) {
//    return null;
//  }
}
