package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pageobjects.LoginPage;
import pageobjects.SecurePage;

import static org.testng.Assert.assertTrue;

public class TestLogin extends BaseTest{

    @Test
    public void loginSucceeded() {
        LoginPage loginPage = new LoginPage(getWebDriver());
        loginPage.loginWithUsrPwd("tomsmith","SuperSecretPassword!");
        SecurePage securePage = new SecurePage(getWebDriver());
        assertTrue(securePage.isDataAlertDisplayed());
        securePage.logout();
    }
    @Test
    public void loginFail() {
        LoginPage loginPage = new LoginPage(getWebDriver());
        loginPage.loginWithUsrPwd("asasdsa","SuperSecretPassword!");
        assertTrue(loginPage.errorMsgIsDisplayed());
    }


}