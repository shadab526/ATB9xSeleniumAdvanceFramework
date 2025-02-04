package com.thetestingacademy.Driver;

import com.thetestingacademy.Utils.PropertyReader;
import org.apache.poi.hpsf.Property;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Locale;
import java.util.Properties;

public class DriverManager {
    public static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        DriverManager.driver = driver;
    }
    //When we want to start the browser
    public static void init(){
        String browser = PropertyReader.readKey("browser");
        browser = browser.toLowerCase();
        if(driver == null){
            switch (browser){
                case "edge" :
                    EdgeOptions edgeOptions = new EdgeOptions();
                    edgeOptions.addArguments("--start-maximized");
                    edgeOptions.addArguments("--guest");
                    driver = new EdgeDriver(edgeOptions);
                    break;

                case "chrome":
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("start-maximized");
                    driver = new ChromeDriver(chromeOptions);
                    break;

                case "firefox" :
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.addArguments("start-maximized");
                    driver = new FirefoxDriver(firefoxOptions);
                default:
                    System.out.println("Browser not found!!");
            }
        }


    }

    //When we want to close the browser
    public static void down(){
        if(driver != null){
            driver.quit();
            driver =null;
        }


    }

}
