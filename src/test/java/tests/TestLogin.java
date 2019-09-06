package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pageobjects.LoginPage;

import static org.testng.Assert.assertTrue;

public class TestLogin extends BaseTest{

    @Test
    public void loginSucceeded() {
        LoginPage loginPage = new LoginPage(getWebDriver());
        loginPage.loginWithUsrPwd("tomsmith","SuperSecretPassword!");
        assertTrue(getWebDriver().findElement(By.cssSelector(".flash.success")).isDisplayed());
    }
    @Test
    public void loginFail() {
        LoginPage loginPage = new LoginPage(getWebDriver());
        loginPage.loginWithUsrPwd("asasdsa","SuperSecretPassword!");
        assertTrue(!getWebDriver().findElement(By.cssSelector(".flash.success")).isDisplayed());
    }


}