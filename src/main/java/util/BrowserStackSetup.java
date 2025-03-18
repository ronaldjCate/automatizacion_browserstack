package util;


import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserStackSetup {

    /*
    private static RemoteWebDriver driver;
    private static EnvironmentVariables environmentVariables;

    public static RemoteWebDriver setup(String environment) throws MalformedURLException {
        String browserStackUrl = "https://" +
                EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("browserstack.user") + ":" +
                EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("browserstack.key") +
                "@hub-cloud.browserstack.com/wd/hub";

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("environments." + environment + ".webdriver.capabilities.platformName"));
        caps.setCapability("deviceName", EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("environments." + environment + ".webdriver.capabilities.deviceName"));
        caps.setCapability("platformVersion", EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("environments." + environment + ".webdriver.capabilities.platformVersion"));
        caps.setCapability("app", EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("browserstack.app"));
        caps.setCapability("build", EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("browserstack.buildName"));
        caps.setCapability("project", EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("browserstack.projectName"));
        caps.setCapability("browserstack.local", EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("browserstack.local"));

        driver = new RemoteWebDriver(new URL(browserStackUrl), caps);
        return driver;
    }

    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

     */
}

