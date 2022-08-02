package com.zebo.library.Pages;

import com.zebo.library.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class addingNewUserPage {

    @FindBy(xpath ="//a[@href='#users']")
    public WebElement usersModule;
    @FindBy(xpath = "//a[@href='tpl/add-user.html']")
    public WebElement addUserBtn;
    @FindBy(xpath = "//input[@name='full_name']")
    public WebElement fullNameField;
    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordField;
    @FindBy(xpath="//input[@name='email']")
    public WebElement emailField;
    @FindBy(id = "address")
    public WebElement addressField;
    @FindBy (xpath = "//button[.='Save changes']")
    public WebElement saveChangesBtn;

    @FindBy (xpath = "//div[.='The user has been created.']")
    public WebElement confirmedMessageForNewUser;
    @FindBy(xpath = "//div[@id='ajax']")
    public WebElement dashboard;
    @FindBy(xpath = "//table[@aria-describedby='tbl_users_info']//tbody//tr[1]//td[3]")
    public WebElement firstRowName;




    public addingNewUserPage(){
    PageFactory.initElements(Driver.getDriver(), this);
}}
