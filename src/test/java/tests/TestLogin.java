package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class TestLogin {

    private WebDriver driver;
    @AfterTest
    public void tearDown() {
        driver.quit();
    }
    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/vendor/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/login");
    }
    @Test
    public void loginSucceeded() {

        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector("button")).click();
        assertTrue(driver.findElement(By.cssSelector(".flash.success")).isDisplayed());
    }
    @Test
    public void loginFail() {

        driver.findElement(By.id("username")).sendKeys("asdasd");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector("button")).click();
        assertTrue(driver.findElement(By.cssSelector(".flash.success")).isDisplayed());
    }
}