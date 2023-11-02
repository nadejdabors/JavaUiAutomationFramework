package com.opencart;

import com.opencart.managers.DriverManager;
import com.opencart.managers.RandomDataManager;
import com.opencart.pageobjects.HomePage;
import com.opencart.pageobjects.LoginPage;
import com.opencart.pageobjects.RegisterPage;
import io.netty.handler.codec.json.JsonObjectDecoder;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestRegistrationFlowWithJunit {

    WebDriver driver;
    HomePage homePage;
    RegisterPage registerPage;
    LoginPage loginPage;

    @BeforeAll
    public static void executeThisMethodBeforeAllTheTest(){
        System.out.println("The execution of the test suite has started ");
    }
    @BeforeEach
    public void executeTheCodeBeforeEachTest(){
        System.out.println("The code is executed before each test case");
        driver = DriverManager.getInstance().getDriver();
        driver.get("https://andreisecuqa.host/");
        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);
        loginPage = new LoginPage(driver);
        homePage.navigateToRegisterPageFromHeader();


    }
    @Test
    @DisplayName("The registration of the new user with valid data redirects to the Account Page")
    public void registerWithValidCredentialsTest() throws InterruptedException {
        System.out.println("This is the number 1 test");

        String randomEmail = RandomDataManager.generateRandomEmail();
        String password = RandomDataManager.generatePassword();

        System.out.println(randomEmail);
        System.out.println(password);

        registerPage.fillInTheRegisterForm(RandomDataManager.generateFirstName(),
                RandomDataManager.generateLastName(),randomEmail,password,true);
        registerPage.clickTheContinueButton();

        Thread.sleep(500);
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertTrue(currentUrl.contains("route=account/success"),"Does not contain");



    }
   @Test
    @DisplayName("The user is remaining on Register page when trying to register with invalid password")
    public void registerWitInvalidPasswordTest() throws InterruptedException {
       System.out.println("This is the number 2 test");

        String randomEmail = RandomDataManager.generateRandomEmail();
        String password = "1";

        System.out.println(randomEmail);
        System.out.println(password);

        registerPage.fillInTheRegisterForm(RandomDataManager.generateFirstName(),
                RandomDataManager.generateLastName(),randomEmail,password,true);
        registerPage.clickTheContinueButton();

        Thread.sleep(500);
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://andreisecuqa.host/index.php?route=account/register&language=en-gb";

        Assertions.assertEquals(expectedUrl,actualUrl,"The urls should be equals");



    }
    @Test
    @DisplayName("The user is remaining on Register page when trying to register with invalid password")
    public void errorMessageIsDisplayedWhenInvalidPasswordForRegisterFlow() throws InterruptedException {
        System.out.println("This is the number 3 test");

        String randomEmail = RandomDataManager.generateRandomEmail();
        String password = "1";

        System.out.println(randomEmail);
        System.out.println(password);

        registerPage.fillInTheRegisterForm(RandomDataManager.generateFirstName(),
                RandomDataManager.generateLastName(), randomEmail, password, true);
        registerPage.clickTheContinueButton();

        Thread.sleep(500);

        String actualErrorMessageForInvalidPassword = driver.findElement(By.id("error-password")).getText();
        String expectedErrorMessageForInvalidPassword = "Password must be between 4 and 20 characters!";
        Assertions.assertEquals(expectedErrorMessageForInvalidPassword,actualErrorMessageForInvalidPassword,
                "The message are not the same");

    }

        @AfterEach
    public void executeTheCodeAfterEachTest(){
        DriverManager.getInstance().quiteTheDriver();
        System.out.println("The test case execution has been finished");


    }
    @AfterAll
    public static void executeThisMethodAfterAllTheTest(){
        System.out.println("The suite execution is finished");

    }



}
