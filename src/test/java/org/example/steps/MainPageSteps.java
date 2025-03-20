package org.example.steps;
import io.cucumber.java.en.When;
import org.example.config.RunCucumberTest;
import org.example.pages.MainPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = RunCucumberTest.class)
public class MainPageSteps {

}
