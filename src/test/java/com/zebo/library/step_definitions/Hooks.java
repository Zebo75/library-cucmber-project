package com.zebo.library.step_definitions;

import com.zebo.library.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {
    //before is coming from cucumber not junit.It is running before each scenario
    @Before
    public void setUpScenario(){
        System.out.println("--->Before Scenario is running from Hooks");
    }
    // @After is coming from cucumber.It is running after each scenario
    @After
    public void tearDownScenario(Scenario scenario){
        System.out.println("--->After Scenario is running");
        if (scenario.isFailed()) {

            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
       Driver.closeDriver();
    }
}
