package com.zebo.library.Pages;

import com.zebo.library.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
    // page_url = https://library2.cydeo.com/login.html

    @FindBy(id = "inputEmail")
    public WebElement emailInput;

    @FindBy(id = "inputPassword")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement signinBtn;

    // No page elements added

    public loginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
