package tests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.testng.Assert.assertTrue;

public class LoginTest {
    static WebDriver driver;

    public static void main(String[] args){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/login");
        driver.findElement( By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector("button")).click();
        assertTrue(driver.findElement(By.cssSelector(".flash.success")).isDisplayed());
        driver.quit();
    }
}
