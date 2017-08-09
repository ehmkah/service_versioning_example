package de.ehmkah.projects.service_example.soap_service;

import de.ehmkah.projects.service_versioning_example.soap.v1.RequestType;
import de.ehmkah.projects.service_versioning_example.soap.v1.ResponseType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

public class GardeningServiceV1Impl {

  @Autowired
  private ConverterV1ToCurrent converterV1ToCurrent;

  @Autowired
  private GardeningServiceImpl gardeningService;

  private static final String NAMESPACE_URI = "http://ehmkah.com/services/gardening";

  @PayloadRoot(namespace = NAMESPACE_URI, localPart = "checkNeighbours")
  @ResponsePayload
  public ResponseType checkNeighbours(@RequestPayload RequestType parameters) {
    com.ehmkah.services.gardening.RequestType requestCurrent = converterV1ToCurrent.map(parameters);
    com.ehmkah.services.gardening.ResponseType responseTypeCurrent = gardeningService.checkNeighbours(requestCurrent);
    ResponseType result = converterV1ToCurrent.map(responseTypeCurrent);

    return result;
  }
}
