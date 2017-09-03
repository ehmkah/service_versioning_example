package de.ehmkah.projects;

import au.com.dius.pact.provider.junit.PactRunner;
import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.loader.PactFolder;
import au.com.dius.pact.provider.junit.target.HttpTarget;
import au.com.dius.pact.provider.junit.target.Target;
import au.com.dius.pact.provider.junit.target.TestTarget;
import de.ehmkah.projects.service_versioning_example.contract_test.ApplicationRestContractTestImpl;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;

// abgeschaltet, damit der gesamte build durchlaeuft
//@Ignore
@RunWith(PactRunner.class) // Say JUnit to run tests with custom Runner
@Provider("aProvider") // Set up name of tested provider
@PactFolder("pacts") // Point where to find pacts (See also section Pacts source in documentation)
public class ServiceTest {

  //Method will be run once: before whole contract test suite
  @BeforeClass
  public static void setUpService() {
    SpringApplication.run(ApplicationRestContractTestImpl.class);

  }

  /**
   * Method will be run before each test of interaction
   **/
  @Before
  public void before() {
    // Rest data
    // Mock dependent service responses
    // ...
  }


  @TestTarget // Annotation denotes Target that will be used for tests
  public final Target target = new HttpTarget(8080); // Out-of-the-box implementation of Target (for more information take a look at Test Target section)


  //@State("default", "no-data") // Method will be run before testing interactions that require "default" or "no-data" state
  //public void toDefaultState() {
  // Prepare service before interaction that require "default" state
  // ...
  //System.out.println("Now service in default state");
  //}

  //@State("with-data") // Method will be run before testing interactions that require "with-data" state
  //public void toStateWithData(Map data) {
  // Prepare service before interaction that require "with-data" state. The provider state data will be passed
  // in the data parameter
  // ...
  //  System.out.println("Now service in state using data " + data);
  //}


}



