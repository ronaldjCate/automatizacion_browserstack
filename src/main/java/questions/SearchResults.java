package questions;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import userinterfaces.WikipediaHomePage;

import java.util.Collections;
import java.util.List;

import static userinterfaces.WikipediaHomePage.TEXT_VIEW;

public class SearchResults implements Question<Boolean> {

    AppiumDriver driver;
    public SearchResults(AppiumDriver driver) {

        this.driver = driver;
    }
    public static SearchResults areDisplayed(AppiumDriver driver) {
        return new SearchResults(driver);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        List<WebElement> allProductsName = driver.findElements(AppiumBy.className(TEXT_VIEW));
        Assert.assertTrue(allProductsName.size() > 0);
        return !allProductsName.isEmpty();
    }
}

