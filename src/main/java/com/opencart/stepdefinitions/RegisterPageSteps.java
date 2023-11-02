package com.opencart.stepdefinitions;

import com.opencart.managers.DriverManager;
import com.opencart.managers.RandomDataManager;
import com.opencart.pageobjects.RegisterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPageSteps {

    WebDriver driver = DriverManager.getInstance().getDriver();
    RegisterPage registerPage = new RegisterPage(driver);

    @When("the register form is populated with valid random data")
    public void theRegisterFormIsPopulatedWithValidRandomData() throws InterruptedException {

        String randomEmail = RandomDataManager.generateRandomEmail();
        String password = RandomDataManager.generatePassword();

        System.out.println(randomEmail);
        System.out.println(password);

        registerPage.fillInTheRegisterForm(RandomDataManager.generateFirstName(),
                RandomDataManager.generateLastName(), randomEmail, password, true);
        System.out.println("The register form is populated with valid random data");

    }

    @And("Continue button is clicked")
    public void continueButtonIsClicked() throws InterruptedException {
        Thread.sleep(500);
        registerPage.clickTheContinueButton();
        System.out.println("The continue button has been clicked");
    }

    @When("the register form is populated with invalid password")
    public void theRegisterFormIsPopulatedWithInvalidPassword() throws InterruptedException {

        String randomEmail = RandomDataManager.generateRandomEmail();
        String password = "1";

        System.out.println(randomEmail);
        System.out.println(password);

        registerPage.fillInTheRegisterForm(RandomDataManager.generateFirstName(),
                RandomDataManager.generateLastName(), randomEmail, password, true);
        registerPage.clickTheContinueButton();


    }

    @Then("Error Message is displayed")
    public void errorMessageIsDisplayed() throws InterruptedException {
        Thread.sleep(500);

        String actualErrorMessageForInvalidPassword = driver.findElement(By.id("error-password")).getText();
        String expectedErrorMessageForInvalidPassword = "Password must be between 4 and 20 characters!";
        Assertions.assertEquals(expectedErrorMessageForInvalidPassword,actualErrorMessageForInvalidPassword,
                "The message are not the same");

    }
}


