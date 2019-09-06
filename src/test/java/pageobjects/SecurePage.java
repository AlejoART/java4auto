package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecurePage extends BasePage {

    private By dataAlertMsg = By.cssSelector("#flash");
    private By logoutBtn = By.cssSelector("#content > div > a");

    public SecurePage(WebDriver driver) {
        super(driver);
    }

    public boolean isDataAlertDisplayed(){
        if (getDriver().findElement(dataAlertMsg).isDisplayed())
        return true;
        return false;
    }

    public void logout(){
        getDriver().findElement(logoutBtn).click();
    }
}
