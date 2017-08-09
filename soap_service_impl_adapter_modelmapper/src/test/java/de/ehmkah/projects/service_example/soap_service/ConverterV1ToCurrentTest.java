package de.ehmkah.projects.service_example.soap_service;

import com.ehmkah.services.gardening.ResponseType;
import de.ehmkah.projects.service_versioning_example.soap.v1.RequestType;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author Michael Krausse (ehmkah)
 */
public class ConverterV1ToCurrentTest {

  private ConverterV1ToCurrent sut = new ConverterV1ToCurrent();

  @Test
  public void testV1toCurrent() {
    // given
    RequestType requestV1 = new RequestType();
    requestV1.setSpeciesOne("tomato");
    requestV1.setSpeciesTwo("potato");

    // when
    com.ehmkah.services.gardening.RequestType actual = sut.map(requestV1);

    // then
    assertNotNull(actual);
    assertEquals("tomato", actual.getSpeciesOne());
    assertEquals("potato", actual.getSpeciesTwo());
  }

  @Test
  public void testCurrentToV1() {
    // given
    ResponseType responseTypeCurrent = new ResponseType();
    responseTypeCurrent.setAreGoodNeighbours("YES");

    // when
    de.ehmkah.projects.service_versioning_example.soap.v1.ResponseType actual = sut.map(responseTypeCurrent);

    // then
    assertNotNull(actual);
    assertEquals("YES", actual.getAreGoodNeighbours());
  }

}