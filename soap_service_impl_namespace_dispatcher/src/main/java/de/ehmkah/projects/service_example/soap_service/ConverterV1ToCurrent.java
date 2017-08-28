package de.ehmkah.projects.service_example.soap_service;

import com.ehmkah.services.gardening.v2.ResponseType;
import de.ehmkah.projects.service_versioning_example.soap.v1.RequestType;
import org.springframework.stereotype.Component;

/**
 * @author Michael Krausse (ehmkah)
 */
@Component
public class ConverterV1ToCurrent {

  public com.ehmkah.services.gardening.v2.RequestType map(RequestType requestV1) {
    com.ehmkah.services.gardening.v2.RequestType result = new com.ehmkah.services.gardening.v2.RequestType();
    result.setSpeciesOne(requestV1.getSpeciesOne());
    result.setSpeciesTwo(requestV1.getSpeciesTwo());

    return result;
  }

  public de.ehmkah.projects.service_versioning_example.soap.v1.ResponseType map(ResponseType responseTypeCurrent) {
    de.ehmkah.projects.service_versioning_example.soap.v1.ResponseType result = new de.ehmkah.projects.service_versioning_example.soap.v1.ResponseType();
    result.setAreGoodNeighbours(responseTypeCurrent.getAreGoodNeighbours());

    return result;
  }
}
