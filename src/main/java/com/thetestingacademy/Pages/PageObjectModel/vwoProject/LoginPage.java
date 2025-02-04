package com.thetestingacademy.Pages.PageObjectModel.vwoProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.thetestingacademy.Utils.PropertyReader;

import java.util.Properties;

public class LoginPage {
    //Page Class
    //Page Locators
    WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver = driver;

    }
    // Step 1 - Page Locators
    private By email = By.id("login-username");
    private By password = By.id("login-password");
    private By signButton = By.id("js-login-btn");
    private By errorMessage = By.id("js-notification-box-msg");

    //Step 2 - Page Actions

    public String loginToVWOLoginInvalidCreds(String mail,String pwd){
        //driver.get(PropertiesReader.readKeys("url"));
        driver.get(PropertyReader.readKey("url"));
        driver.findElement(email).sendKeys(mail);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(signButton).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String error_message_text = driver.findElement(errorMessage).getText();
        return error_message_text;

    }
    public void loginToVWOLoginValidCreds(String mail, String pwd){

        driver.get(PropertyReader.readKey("url"));
        driver.findElement(email).sendKeys(mail);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(signButton).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }


}
