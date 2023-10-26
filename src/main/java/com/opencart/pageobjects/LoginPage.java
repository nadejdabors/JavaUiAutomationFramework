package com.opencart.pageobjects;

import com.opencart.managers.ScrollManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.logging.XMLFormatter;

public class LoginPage extends Page{
    @FindBy( xpath = "//input[@id='input-email']")
    private WebElement emailInput;
    @FindBy(xpath = "//input[@id='input-password']")
    private WebElement passwordInput;
    @FindBy(xpath = "//button[normalize-space()='Login']")
    private WebElement loginBtn;

    private WebDriver driver = null;

    public LoginPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }


    public void fillInTheLoginForm(String username,String password){

        emailInput.sendKeys(username);
        passwordInput.sendKeys(password);

    }

    public void clickLoginBtn(){
        ScrollManager.scrollTheElement(loginBtn,driver);
        loginBtn.click();

    }



}
