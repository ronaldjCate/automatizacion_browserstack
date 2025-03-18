package com.browserstack.runners;

import com.browserstack.hooks.AppiumTest;
import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.Actor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import tasks.SearchWikipedia;
import java.util.List;

@Test
public class FirstTestSP extends AppiumTest {

    private Actor user = Actor.named("Mobile Tester");

    @Test
    public void searchWikipediaTest() throws Exception{
        user.attemptsTo(
                SearchWikipedia.forText("BrowserStack",driver)
        );

        List<WebElement> allProductsName = driver.findElements(AppiumBy.className("android.widget.TextView"));
        Assert.assertTrue(allProductsName.size() > 0);
    }
}