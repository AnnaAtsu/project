package step;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BeforeStep {
    protected static WebDriver driver;


    @Given("Открываем сайт {string}")
    public void открываем_сайт(String url) {

        WebDriverManager.chromedriver().setup(); // Автоскачивание chromedriver
      //  driver = new ChromeDriver();
       // driver.manage().window().maximize();
        // Edge
        WebDriverManager.edgedriver().setup();
       driver = new EdgeDriver();
        Configuration.timeout = 60000;
        Selenide.open(url);

    }


}
