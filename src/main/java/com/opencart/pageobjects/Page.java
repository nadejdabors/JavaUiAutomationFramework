package com.opencart.pageobjects;

import com.opencart.managers.ScrollManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.security.cert.X509Certificate;

public abstract class Page {

    @FindBy(xpath = "//i[@class='fa-solid fa-user']")
    protected WebElement myAccountIcon;
    @FindBy(xpath = "//a[@class='dropdown-item'][normalize-space()='Register']")
    protected WebElement registerBtn;

    @FindBy(xpath = "//a[@class='dropdown-item'][normalize-space()='Login']")
    protected WebElement loginBtn;
    @FindBy(xpath = "//a[@class='dropdown-item'][normalize-space()='Logout']")
    protected WebElement logOutBtn;

    private WebDriver driver = null;

    public Page(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public void navigateToRegisterPageFromHeader(){
        myAccountIcon.click();
        registerBtn.click();
    }
    public void navigateToLoginFromHeader(){
       // ScrollManager.scrollTheElement(myAccountIcon,driver);
        myAccountIcon.click();
        loginBtn.click();

    }

    public void  navigateToLogOutFromAccount(){
        ScrollManager.scrollTheElement(myAccountIcon,driver);
        myAccountIcon.click();
        logOutBtn.click();
    }
}
