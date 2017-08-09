package de.ehmkah.projects.service_example.soap_service.domain;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Michael Krausse (ehmkah)
 */
public class NeigbhbourCheckServiceTest {

  @Test
  public void testGoodNeighbour1() throws Exception {
    NeigbhbourCheckService sut = new NeigbhbourCheckService();
    Assert.assertEquals("YES", sut.areGood("TOMATO", "SPINACH"));
  }

  @Test
  public void testGoodNeighbour2() throws Exception {
    NeigbhbourCheckService sut = new NeigbhbourCheckService();
    Assert.assertEquals("NO", sut.areGood("TOMATO", "POTATO"));
  }
}