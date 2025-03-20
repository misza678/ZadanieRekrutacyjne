package org.example.steps;
import io.cucumber.java.en.When;
import org.example.config.RunCucumberTest;
import org.example.pages.MainPage;
import org.springframework.beans.factory.annotation.Autowired;


public class MainPageSteps {

    @Autowired
    private MainPage mainPage;

  @When("Z górnej belki wybierz")
    public void chooseButtonFromHeader() {
        mainPage.at();
        mainPage.acceptCookies();
    }
}
