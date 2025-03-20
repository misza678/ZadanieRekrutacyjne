package org.example.steps;

import io.cucumber.java.en.Given;
import org.example.config.RunCucumberTest;
import org.example.pages.MainPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = RunCucumberTest.class)
@SpringBootTest
public class MainPageSteps {
    private final MainPage mainPage;
    @Autowired
    public MainPageSteps(MainPage mainPage) {
        this.mainPage = mainPage;
    }

    @Given("Z górnej belki wybierz")
    public void chooseButtonFromHeader() {
        mainPage.acceptCookies();
        mainPage.at();
    }
}
