package org.example.steps;

import io.cucumber.java.en.Given;
import org.example.config.WebDriverConfig;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

public class MasterSteps {
    private final WebDriver driver;
    private final WebDriverConfig webDriverConfig;

    @Autowired
    public MasterSteps(WebDriver driver, WebDriverConfig webDriverConfig) {
        this.driver = driver;
        this.webDriverConfig = webDriverConfig;
    }

    @Given("Otwórz odpowiednią przeglądarkę")
    public void openTheBrowser() {
        // Bean WebDriver został już utworzony zgodnie z ustawieniami (np. browser=chrome w application.properties)
        driver.get("https://example.com");
    }

    @Given("Przejdź na stronę: {string}")
    public void goToPage(String URL) {
        driver.get(URL);
    }

    @Given("Zamknij przeglądarkę")
    public void closeTheBrowser() {
        // Możesz bezpośrednio wywołać quit() lub użyć metody z WebDriverConfig, która przyjmuje bean WebDriver
        webDriverConfig.quitWebDriver(driver);
    }
}
