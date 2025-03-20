package org.example.config;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static io.cucumber.core.options.Constants.PLUGIN_PROPERTY_NAME;

@ExtendWith(SpringExtension.class)  // Integracja Springa z JUnit5
@Suite
@IncludeEngines("cucumber")  // Wskazuje silnik Cucumbera do uruchomienia
@SelectClasspathResource("features")  // Ścieżka do katalogu, w którym znajdują się pliki .feature
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty,html:target/cucumber-report.html")  // Konfiguracja pluginu Cucumber
@SpringBootTest(classes = YourSpringBootApplication.class)  // Używamy Springa do konfiguracji testów
public class RunCucumberTest {
    // Testy Cucumber
}
