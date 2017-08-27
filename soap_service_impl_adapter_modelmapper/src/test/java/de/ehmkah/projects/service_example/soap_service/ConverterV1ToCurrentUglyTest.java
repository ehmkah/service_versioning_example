package de.ehmkah.projects.service_example.soap_service;

import de.ehmkah.projects.service_versioning_example.soap.v1.GetPriceRequestType;
import de.ehmkah.projects.service_versioning_example.soap.v1.PersonType;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * @author Michael Krausse (ehmkah)
 */
public class ConverterV1ToCurrentUglyTest {

  private ConverterV1ToCurrentUgly sut = new ConverterV1ToCurrentUgly();

  @Test
  public void testMapInheritance() throws Exception {
    // given
    GetPriceRequestType givenRequest = createGivenRequestType();

    // when
    com.ehmkah.services.gardening.GetPriceRequestType actual = sut.map(givenRequest);

    // then
    assertEquals("Manfred", ((com.ehmkah.services.gardening.PersonType) actual.getTransported()).getFirstname());
    assertEquals("Kohlmann", ((com.ehmkah.services.gardening.PersonType) actual.getTransported()).getSurname());
  }

  private GetPriceRequestType createGivenRequestType() {
    GetPriceRequestType givenRequest = new GetPriceRequestType();
    givenRequest.setTransported(Arrays.asList(createGivenPerson()));
    return givenRequest;
  }

  private PersonType createGivenPerson() {
    PersonType result = new PersonType();
    result.setFirstname("Manfred");
    // ignored, because it is not given to modelmapper
    // result.setSurname("Kohlmann");
    result.setId("paxa");

    return result;
  }
}