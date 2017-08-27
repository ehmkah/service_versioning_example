package de.ehmkah.projects.service_example.soap_service;


import com.ehmkah.services.gardening.*;
import de.ehmkah.projects.service_example.soap_service.domain.NeigbhbourCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


@Endpoint
@Component
public class GardeningServiceImpl implements Wsgardening {

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

  @Override
  public GetPriceResponseType getPrice(GetPriceRequestType request) {
    return null;
  }
}
