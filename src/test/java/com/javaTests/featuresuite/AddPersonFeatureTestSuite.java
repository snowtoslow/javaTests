package com.javaTests.featuresuite;


import com.javaTests.integrationtests.repository_test.PersonRepositoryIntegrationTests;
import com.javaTests.UnitTests.controller_test.PersonControllerIntegrationTest;
import com.javaTests.UnitTests.service_test.PersonServiceIntegrationTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({PersonServiceIntegrationTest.class,PersonRepositoryIntegrationTests.class, PersonControllerIntegrationTest.class})
public class AddPersonFeatureTestSuite {






}
