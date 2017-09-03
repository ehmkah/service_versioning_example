package de.ehmkah.projects;

import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRule;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.PactFragment;
import org.junit.Rule;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;


public class ConsumerAnnotationTest {
  @Rule
  public PactProviderRule mockProvider =
          new PactProviderRule("aProvider", this);

  @Pact(consumer = "Service_Consumer")
  public PactFragment createFragment(PactDslWithProvider builder) {
    Map<String, String> expectedVersionHeader = new HashMap<>();
    expectedVersionHeader.put("Content-Type", "application/vnd.ehmkah.app-1.0+json");

    return builder
            .uponReceiving("a root request")
            .headers("Accept", "application/vnd.ehmkah.app-1.0+json")
            .method("GET")
            .path("/movies")
            .willRespondWith()
            .status(200)
            .headers(expectedVersionHeader)
            .body("[{\"movie_id\":null,\"title\":\"HUHU, version 1.0\",\"description\":null,\"rating\":null,\"price\":null,\"image\":null}]")
            .toFragment();
  }

  @Test
  @PactVerification
  public void runTest() throws Exception {
    final Consumer consumer = Consumer.of(mockProvider.getConfig().url());
    assertEquals(consumer.run(), "[{\"movie_id\":null,\"title\":\"HUHU, version 1.0\",\"description\":null,\"rating\":null,\"price\":null,\"image\":null}]");
  }
}
