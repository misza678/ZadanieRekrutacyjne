package org.example.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.example.config.RunCucumberTest;
import org.example.config.WebDriverConfig;
import org.example.pages.MainPage;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;


@SpringBootTest
@ContextConfiguration(classes = RunCucumberTest.class)
public class MasterSteps {
    private WebDriver driver;
    private final WebDriverConfig webDriverConfig;
    @Autowired
    public MasterSteps(WebDriverConfig webDriverConfig) {
        this.webDriverConfig = webDriverConfig;
        System.out.println("WebDriverConfig: " + webDriverConfig);

    }

    @Given("Otwórz przeglądarkę: {string}")
    public void openTheBrowser(String browserType) {
        driver = webDriverConfig.getWebDriver(browserType);
        driver.get("https://example.com");
    }
    @Given("Przejdź na stronę: {string}")
    public void goToPage(String URL) {
        driver.get(URL);
    }

    @Given("Zamknij przeglądarkę")
    public void iCloseTheBrowser() {
        webDriverConfig.quitWebDriver();
    }





}
