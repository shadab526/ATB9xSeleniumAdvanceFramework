package com.thetestingacademy.Pages.PageObjectModel.vwoProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashBoardPage {
    WebDriver driver;
    public DashBoardPage(WebDriver driver){
        this.driver = driver;
    }
    By userNameOnDashBoard = By.cssSelector("[data-qa='lufexuloga']");

    public String loggedInUserName(){
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return driver.findElement(userNameOnDashBoard).getText();

    }


}
