package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    private By dataAlertError = By.cssSelector("#flash");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void typeUserName(String username){
        getDriver().findElement(By.id("username")).sendKeys(username);
    }

    public void typePassword(String password){
        getDriver().findElement(By.id("password")).sendKeys(password);
    }

    public void clickLoginButton(){
        getDriver().findElement(By.cssSelector("button")).click();
    }

    public void loginWithUsrPwd(String usr, String pwd){
        typeUserName(usr);
        typePassword(pwd);
        clickLoginButton();
    }

    public boolean errorMsgIsDisplayed(){
        if (getDriver().findElement(dataAlertError).isDisplayed())
            return true;
            return false;
    }
}
