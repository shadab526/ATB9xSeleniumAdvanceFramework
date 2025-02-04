package com.thetestingacademy.test.TestVWOLogin;

import com.thetestingacademy.Pages.PageObjectModel.vwoProject.DashBoardPage;
import com.thetestingacademy.Pages.PageObjectModel.vwoProject.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

public class TestVWOLogin_POM_01 {


    @Owner("Shadab")
    @Description("Verify That invalid creds give error message")
    @Test
    public void testLoginNegativeVWO (){
        WebDriver driver = new EdgeDriver();
        LoginPage loginPage_VWO = new LoginPage(driver);
        String error_msg = loginPage_VWO.loginToVWOLoginInvalidCreds("admin@gmail.com","ad@1234");
        assertThat(error_msg).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(error_msg,"Your email, password, IP address or location did not match");

    }
    @Owner("Shadab")
    @Description("Veryfythat valid creds and validatye user name on Dashboard")
    @Test
    public void testLoginPositiveVWO(){
        WebDriver driver = new EdgeDriver();
        LoginPage loginPage_VWO = new LoginPage(driver);
        loginPage_VWO.loginToVWOLoginValidCreds("sshadab526@gmail.com","SDSarms@12345");
        DashBoardPage dashBoardPage = new DashBoardPage(driver);
        String userNameLoggedIn = dashBoardPage.loggedInUserName();
        assertThat(userNameLoggedIn).isNotBlank().isNotEmpty().isNotNull();
        Assert.assertEquals(userNameLoggedIn, "Shadab Shaikh");
    }
}
