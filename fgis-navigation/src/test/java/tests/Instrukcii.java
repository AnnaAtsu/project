package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class Instrukcii extends TestBase{


    @Test
    void ProsmotrInstrukcii() {
        app.session().login("Fokin", "12345");
        app.session().goToInstrukcii();
        app.session().goToPublicInstrukcii();
        app.session().downloadInstrukcii();
        Assertions.assertTrue(app.helper().isElementPresent(By.tagName("a")));

    }
}
