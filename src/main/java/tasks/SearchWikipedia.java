package tasks;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import userinterfaces.WikipediaHomePage;

import java.time.Duration;
import java.util.List;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static userinterfaces.WikipediaHomePage.*;

public class SearchWikipedia implements Task {

    private final String searchText;

    AppiumDriver driver;
    public SearchWikipedia(String searchText, AppiumDriver driver) {

        this.searchText = searchText;
        this.driver = driver;
    }

    public static SearchWikipedia forText(String searchText, AppiumDriver driver){
        return new SearchWikipedia(searchText, driver);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {


        WebElement skipButton = (WebElement) new WebDriverWait(driver, Duration.ofSeconds(30)).until(
                ExpectedConditions.presenceOfElementLocated(AppiumBy.id(SEARCH_CONTAINER)));
        skipButton.click();

        WebElement searchElement = (WebElement) new WebDriverWait(driver, Duration.ofSeconds(30)).until(
                ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId(SEARCH_WIKIPEDIA)));
        searchElement.click();

        WebElement insertTextElement = (WebElement) new WebDriverWait(driver, Duration.ofSeconds(30)).until(
                ExpectedConditions.elementToBeClickable(AppiumBy.id(SEARCH_SRC_TEXT)));
        insertTextElement.sendKeys(searchText);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();

        }


    }
}

