package com.zebo.library.step_definitions;

import com.github.javafaker.Faker;
import com.zebo.library.Pages.addingNewUserPage;
import com.zebo.library.Pages.loginPage;
import com.zebo.library.utilities.BrowserUtil;
import com.zebo.library.utilities.ConfigurationReader;
import com.zebo.library.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Random;

public class addingUser  {
loginPage loginPage=new loginPage();
    addingNewUserPage addingNewUserPage=new addingNewUserPage();
  // WebDriverWait wait= new WebDriverWait(Driver.getDriver(),10);
    Faker faker1=new Faker(new Random(24));
    Faker faker2=new Faker(new Random(24));

   // String fullName=faker.name().fullName();



    @Given("I am  logged in and on the homePage")
    public void i_am_logged_in_and_on_the_home_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("qa2_url"));
        loginPage.emailInput.sendKeys(ConfigurationReader.getProperty("lib22_user"));
        loginPage.passwordInput.sendKeys(ConfigurationReader.getProperty("lib22_pass"));
        loginPage.signinBtn.click();
       // wait.until(ExpectedConditions.urlContains("dashboard"));

    }
    @When("I click Users module")
    public void i_click_users_module() {
    addingNewUserPage.usersModule.click();

    }

        @And("I click +Add User button")
        public void iClickAddUserButton() {
        addingNewUserPage.addUserBtn.click();


    }
    @When("I enter {string}, {string},{string} and {string}")
    public void iEnterAnd(String fullName,String password,String emailAddress,String FullAddress) {
        System.out.println("faker1.name().fullName() = " + faker1.name().fullName());
        System.out.println("faker2.name().fullName() = " + faker2.name().fullName());
        addingNewUserPage.fullNameField.sendKeys(faker1.name().fullName());

        addingNewUserPage.passwordField.sendKeys(faker1.internet().password());
        addingNewUserPage.emailField.sendKeys(faker1.internet().emailAddress());
        addingNewUserPage.addressField.sendKeys(faker1.address().fullAddress());

    }
    /*public static WebElement waitForClickablility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeout);
        return wait.until(ExpectedConditions.elementToBeClickable(element));

        public static void clickWithJS(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", element);
         JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    }
    } */
    @When("I click save changes")
    public void i_click_save_changes()  {

        addingNewUserPage.saveChangesBtn.click();
        BrowserUtil.waitFor(5);




      //  JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
       // js.executeScript("arguments[0].scrollIntoView(true);",Driver.getDriver().findElement(By.xpath("//button[@class='btn //btn-primary']")));
       // js.executeScript("arguments[0].click();",Driver.getDriver().findElement(By.xpath("//button[@class='btn //btn-primary']")));

        //Actions at = new Actions(Driver.getDriver());
       // at.moveToElement(addingNewUserPage.saveChangesBtn).click().perform();
        //addingNewUserPage.saveChangesBtn.click();
       // BrowserUtil.waitFor(5);
       // Driver.getDriver().findElement(By.xpath("//button[@class='btn btn-primary']")).click();
       // Thread.sleep(5);
       // Driver.getDriver().findElement(By.xpath("//button[.='Save changes']")).click();



    }



                @Then("I should see new users  in the first row of the web table")
                public void iShouldSeeNewUsersNameInTheFirstRowOfTheWebTable() {

        BrowserUtil.waitFor(10);
            // Driver.getDriver().navigate();
           // System.out.println(addingNewUserPage.dashboard.getText());

        String actualName= addingNewUserPage.firstRowName.getText();

        System.out.println("String actualName= "+ addingNewUserPage.firstRowName.getText());
        Assert.assertEquals(faker2.name().fullName(),actualName);
    }



}

