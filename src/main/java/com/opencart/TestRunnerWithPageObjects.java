package com.opencart;



import com.opencart.managers.DriverManager;
import com.opencart.managers.RandomDataManager;
import com.opencart.pageobjects.HomePage;
import com.opencart.pageobjects.LoginPage;
import com.opencart.pageobjects.RegisterPage;
import dev.failsafe.internal.util.Assert;
import org.asynchttpclient.util.Assertions;
import org.openqa.selenium.*;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class TestRunnerWithPageObjects {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = DriverManager.getInstance().getDriver();
        driver.get("https://andreisecuqa.host/");

        HomePage homePage = new HomePage(driver);
        homePage.navigateToRegisterPageFromHeader();

        RegisterPage registerPage = new RegisterPage(driver);


        String randomEmail = RandomDataManager.generateRandomEmail();
        String password = RandomDataManager.generatePassword();

        System.out.println(randomEmail);
        System.out.println(password);

        registerPage.fillInTheRegisterForm(RandomDataManager.generateFirstName(),RandomDataManager.generateLastName(),randomEmail,password,true);

        registerPage.clickTheContinueButton();


        System.out.println(driver.getTitle());

        homePage.navigateToLogOutFromAccount();

        homePage.navigateToLoginFromHeader();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillInTheLoginForm(randomEmail,password);
        loginPage.clickLoginBtn();

        homePage.navigateToLogOutFromAccount();

        System.out.println("The execution is over");

    }


}

