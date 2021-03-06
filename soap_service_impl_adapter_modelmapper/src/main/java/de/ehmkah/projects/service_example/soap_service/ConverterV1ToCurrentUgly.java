package de.ehmkah.projects.service_example.soap_service;

import de.ehmkah.projects.service_versioning_example.soap.v1.*;
import org.modelmapper.ModelMapper;
import org.modelmapper.Provider;

public class ConverterV1ToCurrentUgly {

  private ModelMapper modelMapper;


  public ConverterV1ToCurrentUgly() {
    modelMapper = new ModelMapper();

    modelMapper.createTypeMap(TransportedObjectType.class, com.ehmkah.services.gardening.TransportedObjectType.class)
            .include(PersonType.class, com.ehmkah.services.gardening.PersonType.class)
            .include(BikeType.class, com.ehmkah.services.gardening.BikeType.class)
            .include(DogType.class, com.ehmkah.services.gardening.DogType.class);

    modelMapper.typeMap(PersonType.class, com.ehmkah.services.gardening.TransportedObjectType.class).setProvider(new Provider<com.ehmkah.services.gardening.TransportedObjectType>() {
      public com.ehmkah.services.gardening.TransportedObjectType get(ProvisionRequest<com.ehmkah.services.gardening.TransportedObjectType> request) {
        PersonType source = (PersonType)request.getSource();
        com.ehmkah.services.gardening.PersonType result = new com.ehmkah.services.gardening.PersonType();
        result.setSurname(source.getSurname());
        return result;
      }
    });
    modelMapper.typeMap(DogType.class, com.ehmkah.services.gardening.TransportedObjectType.class).setProvider(new Provider<com.ehmkah.services.gardening.TransportedObjectType>() {
      public com.ehmkah.services.gardening.TransportedObjectType get(ProvisionRequest<com.ehmkah.services.gardening.TransportedObjectType> request) {
        return new com.ehmkah.services.gardening.PersonType();
      }
    });
    modelMapper.typeMap(BikeType.class, com.ehmkah.services.gardening.TransportedObjectType.class).setProvider(new Provider<com.ehmkah.services.gardening.TransportedObjectType>() {
      public com.ehmkah.services.gardening.TransportedObjectType get(ProvisionRequest<com.ehmkah.services.gardening.TransportedObjectType> request) {
        return new com.ehmkah.services.gardening.PersonType();
      }
    });

  }

  public com.ehmkah.services.gardening.GetPriceRequestType map(GetPriceRequestType requestV1) {
    com.ehmkah.services.gardening.GetPriceRequestType result = modelMapper.map(requestV1, com.ehmkah.services.gardening.GetPriceRequestType.class);
    return result;
  }
}
