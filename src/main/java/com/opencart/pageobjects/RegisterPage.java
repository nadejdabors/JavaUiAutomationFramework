package com.opencart.pageobjects;

import com.opencart.managers.ScrollManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends Page {
    WebDriver driver = null;
    public RegisterPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    @FindBy(id = "input-firstname")
    private WebElement firstNameInput;
    @FindBy(css = "#input-lastname")
    private WebElement lastNameInput;
    @FindBy(css = "#input-email")private WebElement emailInput;
    @FindBy(css = "#input-password")
    private WebElement passwordInput;

    @FindBy(css = "input[value='1'][name='agree']")
    private WebElement privacyToggle;
    @FindBy(css = "button[type='submit']")
    private WebElement continueBtn;

    public void fillInTheRegisterForm(String firstName, String lastName, String email, String password,Boolean toggle ) throws InterruptedException {

        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);



        if (toggle)
        {
           ScrollManager.scrollTheElement(privacyToggle,driver);
            privacyToggle.click();
        }

    }
    public void clickTheContinueButton(){
        ScrollManager.scrollTheElement(continueBtn,driver);
       // ScrollManager.scrollTheElement(continueBtn);
        continueBtn.click();
    }

}
