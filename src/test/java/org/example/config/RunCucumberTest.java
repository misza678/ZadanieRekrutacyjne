package org.example.config;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;
import org.springframework.boot.test.context.SpringBootTest;

import static io.cucumber.core.options.Constants.PLUGIN_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features") // Ścieżka do folderu z plikami .feature
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty") // Pluginy do raportów

@SpringBootTest(classes = YourSpringBootApplication.class) // Klasa startowa Spring Boot
public class RunCucumberTest {
}
