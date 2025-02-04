package com.thetestingacademy.Pages.PageObjectModel.vwoProject.improved_pom;

import com.thetestingacademy.Base.CommonToAllPage;
import com.thetestingacademy.Utils.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import sun.util.logging.internal.LoggingProviderImpl;

import java.util.logging.LogManager;
import java.util.logging.Logger;

public class LoginPage_improved extends CommonToAllPage {

    //Page Locators
    WebDriver driver;
    public LoginPage_improved (WebDriver driver){

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
        openVWOUrl();
        enterInput(email,mail);
        enterInput(password,pwd);
        clickElement(signButton);
        presenceOfElement(errorMessage);
        return getText(errorMessage);
    }
    public void loginToVWOLoginValidCreds(String mail, String pwd){

        openVWOUrl();
        enterInput(email,mail);
        enterInput(password,pwd);
        clickElement(signButton);
        customWait();



    }


}
