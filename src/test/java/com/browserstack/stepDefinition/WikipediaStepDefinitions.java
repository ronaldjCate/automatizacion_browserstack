package com.browserstack.stepDefinition;

import com.browserstack.hooks.AppiumTest;
import io.appium.java_client.AppiumBy;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import tasks.SearchWikipedia;

import java.util.List;

public class WikipediaStepDefinitions extends AppiumTest {

    private Actor user = Actor.named("Mobile Tester");


    @Given("que el usuario abre la aplicación Wikipedia")
    public void usuarioAbreLaAplicacion() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("Mobile Tester");
    }

    @When("busca el término {string}")
    public void buscaElTermino(String term) {
        user.attemptsTo(
                SearchWikipedia.forText(term,driver)
        );
    }

    @Then("debería ver resultados de búsqueda")
    public void deberiaVerResultadosDeBusqueda() {
        List<WebElement> allProductsName = driver.findElements(AppiumBy.className("android.widget.TextView"));
        Assert.assertTrue(allProductsName.size() > 0);
    }
}
