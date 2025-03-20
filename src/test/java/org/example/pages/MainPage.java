package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MainPage  {

    @FindBy(xpath = "//button[contains(text(),'Urządzenia')]")
    public WebElement devicesButton;

    @FindBy(id = "didomi-notice-agree-button")
    public WebElement acceptCookiesButton;



    public void at() {

    }

    public void acceptCookies() {

    }
}
