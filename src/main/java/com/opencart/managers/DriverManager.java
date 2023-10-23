package com.opencart.managers;

import com.opencart.managers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverManager {

    private static String webDriverType = "Chrome";
    private static DriverManager instance;
    private WebDriver driver;

    private DriverManager(){
        switch (webDriverType.toUpperCase()){
            case "CHROME":
                driver = new ChromeDriver();
                System.out.println("The Chrome Driver is initiated");
                break;
            case "FIREFOX":
                driver = new FirefoxDriver();
                System.out.println("The Firefox Driver is initiated");
                break;
            case "EDGE":
                driver = new EdgeDriver();
                System.out.println("The Edge  Driver is initiated");
                break;
            case "SAFARI":
                driver = new SafariDriver();
                System.out.println("The Safari  Driver is initiated");
                break;
            default:


        }
    }
public static DriverManager getInstance(){
        if (instance == null){
            return new DriverManager();
        }
        return instance;
}

public WebDriver getDriver(){
        if(driver == null)
         getInstance();

        return driver;
}


}
