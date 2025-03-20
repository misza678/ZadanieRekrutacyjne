package org.example.steps;

import io.cucumber.java.en.Given;
import org.example.config.RunCucumberTest;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = RunCucumberTest.class)
@SpringBootTest
public class MasterSteps {

    private final WebDriver driver;

    @Autowired
    public MasterSteps(WebDriver driver) {
        this.driver = driver;
    }

    // Implementacja kroku otwierania przeglądarki
    @Given("Otwórz odpowiednią przeglądarkę: {string}")
    public void otwórz_odpowiednią_przeglądarkę(String browserType) {
        // W tym przypadku, przekazujesz typ przeglądarki
        System.out.println("Inicjalizacja WebDrivera dla: " + browserType);
        driver.get("about:blank"); // Inicjalizacja i otwarcie pustej strony
    }

    // Implementacja kroku przejścia na stronę
    @Given("Przejdź na stronę: {string}")
    public void przejdź_na_stronę(String url) {
        if (driver == null) {
            throw new IllegalStateException("Przeglądarka nie została otwarta.");
        }
        if (url == null || url.trim().isEmpty()) {
            throw new IllegalArgumentException("Adres URL nie może być pusty.");
        }
        try {
            System.out.println("Przechodzę do strony: " + url);
            driver.get(url); // Otwarcie strony
        } catch (Exception e) {
            throw new RuntimeException("Nie udało się przejść do strony: " + url, e);
        }
    }
}
