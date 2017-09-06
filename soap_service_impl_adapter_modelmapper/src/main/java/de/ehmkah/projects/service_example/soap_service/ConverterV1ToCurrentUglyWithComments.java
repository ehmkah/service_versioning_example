package de.ehmkah.projects.service_example.soap_service;

import de.ehmkah.projects.service_versioning_example.soap.v1.*;
import org.modelmapper.ModelMapper;
import org.modelmapper.Provider;

/**
 * Example if you use modelmapper for mapping types.
 *
 * If you have inheretance in your class model, than you have to provide some additional informations to modelmapper.
 *
 * * You have to provide all specialised classes if a field definition only has supertype
 * * You have to provide setters also for collections (if you generate them from WSDL, make sure you enable it)
 */
public class ConverterV1ToCurrentUglyWithComments {

  private ModelMapper modelMapper;


  public ConverterV1ToCurrentUglyWithComments() {
    // the nice part
    modelMapper = new ModelMapper();

    // a mapping where you say modelmapper, to which target type a source type should be matched
    modelMapper.createTypeMap(TransportedObjectType.class, com.ehmkah.services.gardening.TransportedObjectType.class)
            .include(PersonType.class, com.ehmkah.services.gardening.PersonType.class)
            .include(BikeType.class, com.ehmkah.services.gardening.BikeType.class)
            .include(DogType.class, com.ehmkah.services.gardening.DogType.class);

    // if modelmapper sees that type you gave about comes in, you have provide your own implementation
    // if you forget to map the fields of persontypes, they remain empty.
    // e.g. there is no implementation for setFirstname and therefore firstname stays null :-(
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
