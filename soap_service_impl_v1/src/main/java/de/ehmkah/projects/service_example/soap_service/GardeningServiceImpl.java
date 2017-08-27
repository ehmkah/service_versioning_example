package de.ehmkah.projects.service_example.soap_service;


import de.ehmkah.projects.service_example.soap_service.domain.NeigbhbourCheckService;
import de.ehmkah.projects.service_versioning_example.soap.v1.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.math.BigInteger;


@Component
@WebService(name = "Wsgardening", targetNamespace = "http://ehmkah.com/services/gardening", serviceName = "Wsgardening")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
        ObjectFactory.class
})
public class GardeningServiceImpl implements Wsgardening {

  @Autowired
  private NeigbhbourCheckService internalService;

  private static final String NAMESPACE_URI = "http://ehmkah.com/services/gardening";

  @Override
  @WebMethod(action = "http://ehmkah.com/services/gardening/#checkNeighbours")
  @WebResult(name = "responseType", targetNamespace = "http://ehmkah.com/services/gardening", partName = "response")
  public ResponseType checkNeighbours(
          @WebParam(name = "requestType", targetNamespace = "http://ehmkah.com/services/gardening", partName = "request")
                  RequestType parameters) {

    String areGoodNeigbours = internalService.areGood(parameters.getSpeciesOne(), parameters.getSpeciesTwo());
    ResponseType result = new ResponseType();
    result.setAreGoodNeighbours(areGoodNeigbours);
    return result;
  }

  @Override
  public GetPriceResponseType getPrice(GetPriceRequestType request) {
    GetPriceResponseType result = new GetPriceResponseType();
    result.setPriceInChf(new BigInteger("1000"));
    return result;
  }
}
