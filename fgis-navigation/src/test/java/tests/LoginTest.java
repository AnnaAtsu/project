package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static manager.ApplicationManager.driver;

public class LoginTest  extends TestBase{
    WebDriver driver;

    @Test
    void canLogin() {
        WebDriverManager.chromedriver().setup(); // автоматически скачает и настроит ChromeDriver
        WebDriver driver = new ChromeDriver();
        app.session().login("Blinova", "пароль111");
        Assertions.assertTrue(app.session().isLoggedIn());
    }




}
