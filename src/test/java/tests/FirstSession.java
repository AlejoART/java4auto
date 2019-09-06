package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class FirstSession extends BaseTest{
    private WebDriver driver;

    @Test
    public void dropdownTest(){
        getWebDriver().findElement(By.linkText("Dropdown")).click();
        WebElement titulo = getWebDriver().findElement(By.cssSelector("div .example h3"));
        assertTrue(titulo.getText().equals("Dropdown List"));

        WebElement dropdown = getWebDriver().findElement(By.cssSelector("#dropdown"));
        Select dropdownSelect = new Select(dropdown);
        WebElement dropdownOption2 = getWebDriver().findElement(By.cssSelector("#dropdown > option:nth-child(3)"));
        dropdownSelect.selectByVisibleText("Option 2");

        assertTrue(dropdownSelect.getFirstSelectedOption().getText().equals("Option 2"));

        System.out.println("");
    }


}


