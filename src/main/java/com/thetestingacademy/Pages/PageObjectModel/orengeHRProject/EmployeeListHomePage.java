package com.thetestingacademy.Pages.PageObjectModel.orengeHRProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmployeeListHomePage {
    WebDriver driver;

    public EmployeeListHomePage(WebDriver driver) {
        this.driver = driver;
    }
    //Page Locator
    private By header = By.xpath("//h6[normalize-space()='PIM']");

    //Page Actions
    public String loggedInUser(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return driver.findElement(header).getText();
    }
}
