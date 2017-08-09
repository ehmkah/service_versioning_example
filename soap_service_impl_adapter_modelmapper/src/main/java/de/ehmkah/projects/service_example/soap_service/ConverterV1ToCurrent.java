package de.ehmkah.projects.service_example.soap_service;

import com.ehmkah.services.gardening.ResponseType;
import de.ehmkah.projects.service_versioning_example.soap.v1.RequestType;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

/**
 * @author Michael Krausse (ehmkah)
 */
@Component
public class ConverterV1ToCurrent {

  private ModelMapper modelMapper = new ModelMapper();

  public com.ehmkah.services.gardening.RequestType map(RequestType requestV1) {
    com.ehmkah.services.gardening.RequestType result = modelMapper.map(requestV1, com.ehmkah.services.gardening.RequestType.class);

    return result;
  }

  public de.ehmkah.projects.service_versioning_example.soap.v1.ResponseType map(ResponseType responseTypeCurrent) {
    de.ehmkah.projects.service_versioning_example.soap.v1.ResponseType result = modelMapper.map(responseTypeCurrent, de.ehmkah.projects.service_versioning_example.soap.v1.ResponseType.class);

    return result;
  }
}
