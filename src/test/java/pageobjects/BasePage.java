package pageobjects;

import org.openqa.selenium.WebDriver;

public class BasePage {

    private WebDriver _driver;

    public BasePage(WebDriver driver) {
        _driver = driver;
    }

    public WebDriver getDriver(){
        return _driver;
    }
}