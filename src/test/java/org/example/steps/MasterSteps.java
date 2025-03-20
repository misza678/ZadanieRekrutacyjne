package org.example.steps;

import io.cucumber.java.en.Given;
import org.example.config.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

public class MasterSteps {

    private final WebDriver driver;

    @Autowired
    public MasterSteps(WebDriver driver) {
        this.driver = driver;
    }

    @Given("Otwórz odpowiednią przeglądarkę: {string}")
    public void runBrowser(String browserType) {
        System.out.println("Inicjalizacja WebDrivera dla: " + browserType);
        WebDriverFactory.setBrowser(browserType);  // Ustawienie przeglądarki przed uruchomieniem testu
        driver.get("about:blank"); // Otwiera pustą stronę, by driver był aktywny
    }

    @Given("Przejdź na stronę: {string}")
    public void goToURL(String url) {
        if (driver == null) {
            throw new IllegalStateException("Przeglądarka nie została otwarta.");
        }
        if (url == null || url.trim().isEmpty()) {
            throw new IllegalArgumentException("Adres URL nie może być pusty.");
        }
        try {
            System.out.println("Przechodzę do strony: " + url);
            driver.get(url);
        } catch (Exception e) {
            throw new RuntimeException("Nie udało się przejść do strony: " + url, e);
        }
    }
}
