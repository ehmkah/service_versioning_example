package de.ehmkah.projects.service_example.soap_service;

import de.ehmkah.projects.service_versioning_example.soap.v1.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;


@Component
@WebService(name = "Wsgardening", targetNamespace = "http://ehmkah.com/services/gardening", serviceName = "Wsgardening")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
        ObjectFactory.class
})
public class GardeningServiceV1Impl implements Wsgardening {

  @Autowired
  private ConverterV1ToCurrent converterV1ToCurrent;

  @Autowired
  private GardeningServiceImpl gardeningService;

  private static final String NAMESPACE_URI = "http://ehmkah.com/services/gardening";

  @Override
  @WebMethod(action = "http://ehmkah.com/services/gardening/#checkNeighbours")
  @WebResult(name = "responseType", targetNamespace = "http://ehmkah.com/services/gardening", partName = "response")
  public ResponseType checkNeighbours(
          @WebParam(name = "requestType", targetNamespace = "http://ehmkah.com/services/gardening", partName = "request")
                  RequestType parameters) {
    com.ehmkah.services.gardening.RequestType requestCurrent = converterV1ToCurrent.map(parameters);
    com.ehmkah.services.gardening.ResponseType responseTypeCurrent = gardeningService.checkNeighbours(requestCurrent);
    ResponseType result = converterV1ToCurrent.map(responseTypeCurrent);

    return result;
  }

  @Override
  public GetPriceResponseType getPrice(GetPriceRequestType request) {
    return null;
  }
}
