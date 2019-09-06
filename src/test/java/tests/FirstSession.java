package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class FirstSession {
    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/vendor/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void dropdownTest(){
        driver.findElement(By.linkText("Dropdown")).click();
        WebElement titulo = driver.findElement(By.cssSelector("div .example h3"));
        assertTrue(titulo.getText().equals("Dropdown List"));

        WebElement dropdown = driver.findElement(By.cssSelector("#dropdown"));
        Select dropdownSelect = new Select(dropdown);
        WebElement dropdownOption2 = driver.findElement(By.cssSelector("#dropdown > option:nth-child(3)"));
        dropdownSelect.selectByVisibleText("Option 2");

        assertTrue(dropdownSelect.getFirstSelectedOption().getText().equals("Option 2"));

        System.out.println("");
    }


}


