package com.opencart.stepdefinitions;

import com.opencart.managers.DriverManager;
import com.opencart.pageobjects.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class HomePageSteps {
    WebDriver driver = DriverManager.getInstance().getDriver();
    HomePage homePage =  new HomePage(driver);

    @Given("Home Page is displayed")
    public void homePageIsDisplayed() {
        driver.get("https://andreisecuqa.host/");
        System.out.println("The driver accessed the home page");
    }

    @And("registerLink from Header menu is clicked")
    public void registerLinkFromHeaderMenuIsClicked()  {
        homePage.navigateToRegisterPageFromHeader();
        System.out.println("The Register Link has been accessed from Header Menu");
    }

    @And("logOutLink from Header menu is clicked")
    public void logOutLinkFromHeaderMenuIsClicked() {
        homePage.navigateToLogOutFromAccount();
        System.out.println("Log out from account");
    }
}
