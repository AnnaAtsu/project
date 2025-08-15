package step;

import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$x;


public class KlavogonkiSteps {

    private final SelenideElement closeWindowButton = $x("//input[@value='Закрыть']");
    private final SelenideElement startGameButton  = $x("//a[@id='host_start']");
    private final SelenideElement highLightWord = $x("//span[@id='typefocus']");
    private final SelenideElement inputField = $x("//input[@id='inputtext']");
    private final SelenideElement afterFocus = $x("//span[@id='afterfocus']");


    @When("Начинаем игру")
    public void startGame() {
        closeWindowButton.click();
        if(startGameButton.isDisplayed()) {
            startGameButton.click();
        }
    }

    @And("Ждем начала игры")
    public void waitForStartGame() {
     highLightWord.click();
    }

    @And("Вводим подсвеченное слово в цикле")
    public void playGame() {

        while (true){
            String currentWord = highLightWord.getText();
            String afterfocusSymbol = afterFocus.getText();
            inputField.sendKeys(currentWord);
            if(afterfocusSymbol.equals(".")) {
                inputField.sendKeys(".");
                break;
            }
            inputField.sendKeys(Keys.SPACE);

        }
    }

    @Then("Фиксируем что игра завершена и символов в минуту больше чем {int}")
    public void endGame(int minValue) {
        System.out.println(minValue);

    }
}
