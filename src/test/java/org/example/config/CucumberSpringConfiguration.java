package org.example.config;



import io.cucumber.spring.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@CucumberContextConfiguration
@ContextConfiguration
@SpringBootTest(classes = YourSpringBootApplication.class)
public class CucumberSpringConfiguration {
}