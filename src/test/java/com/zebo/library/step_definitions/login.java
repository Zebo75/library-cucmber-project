package com.zebo.library.step_definitions;

import com.zebo.library.Pages.loginPage;
import com.zebo.library.utilities.BrowserUtil;
import com.zebo.library.utilities.ConfigurationReader;
import com.zebo.library.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class login {

    loginPage loginPage=new loginPage();
    WebDriverWait wait= new WebDriverWait(Driver.getDriver(),10);

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("qa2_url"));

    }
    @When("I login as a librarian")
    public void i_login_as_a_librarian() {
      loginPage.emailInput.sendKeys(ConfigurationReader.getProperty("lib22_user"));
      loginPage.passwordInput.sendKeys(ConfigurationReader.getProperty("lib22_pass"));
      loginPage.signinBtn.click();



    }
    @Then("dashboard should be displayed")
    public void dashboard_should_be_displayed() {
        wait.until(ExpectedConditions.urlContains("dashboard"));

        System.out.println("Driver.getDriver().getCurrentURL()= "+ Driver.getDriver().getTitle());
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("dashboard"));

    }

}
