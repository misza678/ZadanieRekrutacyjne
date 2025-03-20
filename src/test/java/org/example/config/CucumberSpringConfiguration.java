package org.example.config;

import io.cucumber.spring.*;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = YourSpringBootApplication.class)
public class CucumberSpringConfiguration {
}