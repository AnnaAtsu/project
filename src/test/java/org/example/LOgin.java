package org.example;
import io.qameta.allure.junit5.AllureJunit5;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class LOgin {
    WebDriver driver;

    @BeforeEach
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    @ExtendWith(AllureJunit5.class)
    public void testGoogle() {
        driver.get("https://www.google.com");
        Assertions.assertEquals(driver.getCurrentUrl(), "https://www.google.com/");
    }

    @Test
    @ExtendWith(AllureJunit5.class)
    public void canLogin() {
        driver.get("https://test-zerno.mcx.gov.ru/login");
        login("Blinova", "пароль111");

        Assertions.assertEquals(driver.getCurrentUrl(), "https://test-zerno.mcx.gov.ru/login");
    }

    public void login(String user, String password) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[@placeholder='Введите логин']")).sendKeys(user);
        driver.findElement(By.id("input-71")).sendKeys(password);
        driver.findElement(By.xpath("//span[contains(.,'Войти')]")).click();
    }

}
