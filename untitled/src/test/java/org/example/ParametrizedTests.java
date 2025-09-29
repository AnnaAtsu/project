package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;


public class ParametrizedTests {

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

    public void login(String user, String password) {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[@placeholder='Введите логин']")).sendKeys(user);
        driver.findElement(By.id("input-71")).sendKeys(password);
        driver.findElement(By.xpath("//span[contains(.,'Войти')]")).click();

    }


    @ExtendWith(AllureJunit5.class)
    @ParameterizedTest
    @CsvSource({
            "Blinova, пароль111",
            "Savina, пароль111",
            "Samsonova, пароль111"
    })
    public void canLogin(String username, String password) {
       driver.get("https://test-zerno.mcx.gov.ru/login");
        login(username, password);

        // Проверка: если после неудачного логина остаёмся на /login
        Assertions.assertEquals(driver.getCurrentUrl(), "https://test-zerno.mcx.gov.ru/login");
    }


    @ExtendWith(AllureJunit5.class)
    @ParameterizedTest
    @ValueSource(strings = {"Blinova", "Savina", "Samsonova"})
    public void canLoginWithSamePassword(String username) {
        String password = "пароль111"; // общий пароль
      driver.get("https://test-zerno.mcx.gov.ru/login");
        login(username, password);

        Assertions.assertEquals("https://test-zerno.mcx.gov.ru/login", driver.getCurrentUrl());
    }


    @ExtendWith(AllureJunit5.class)
    @ParameterizedTest
    @MethodSource("provideLoginData")
    public void canLoginWithMethod(String username, String password) {
        driver.get("https://test-zerno.mcx.gov.ru/login");
        login(username, password);
        Assertions.assertEquals("https://test-zerno.mcx.gov.ru/login", driver.getCurrentUrl());
    }

    // Статический метод, возвращающий Stream<Arguments>
    static Stream<Arguments> provideLoginData() {
        return Stream.of(
                Arguments.of("Blinova", "пароль111"),
                Arguments.of("Savina", "пароль111"),
                Arguments.of("Samsonova", "пароль111")
        );
    }

}
