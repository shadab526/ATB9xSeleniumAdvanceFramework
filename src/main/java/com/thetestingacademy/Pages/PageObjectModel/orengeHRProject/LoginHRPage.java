package com.thetestingacademy.Pages.PageObjectModel.orengeHRProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginHRPage {
    WebDriver driver;

    public LoginHRPage(WebDriver driver){
        this.driver = driver;
    }
    private By userName = By.xpath("//input[@placeholder=\"Username\"]");
    private By password = By.xpath("//input[@placeholder=\"Password\"]");
    private By login = By.xpath("//button[@type=\"submit\"]");

    public void validHrLoginCreds(String user, String pwd){
        driver.get("https://awesomeqa.com/hr/web/index.php/auth/login");
        driver.findElement(userName).sendKeys(user);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(login).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}
