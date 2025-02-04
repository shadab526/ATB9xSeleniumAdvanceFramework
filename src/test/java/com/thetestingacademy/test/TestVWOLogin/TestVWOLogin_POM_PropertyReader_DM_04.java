package com.thetestingacademy.test.TestVWOLogin;

import com.thetestingacademy.Base.CommonToAllTest;
import com.thetestingacademy.Driver.DriverManager;
import com.thetestingacademy.Pages.PageObjectModel.vwoProject.DashBoardPage;
import com.thetestingacademy.Pages.PageObjectModel.vwoProject.LoginPage;
import com.thetestingacademy.Utils.PropertyReader;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import jdk.jpackage.internal.Log;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestVWOLogin_POM_PropertyReader_DM_04 extends CommonToAllTest {
    private static final Logger logger = LogManager.getLogger(TestVWOLogin_POM_PropertyReader_DM_04.class);


    @Owner("Shadab")
    @Description("Verify That invalid creds give error message")
    @Test
    public void testLoginNegativeVWO (){
        logger.info("Staring the TestCases Page Object Model");

        LoginPage loginPage_VWO = new LoginPage(DriverManager.getDriver());
        String error_msg = loginPage_VWO.loginToVWOLoginInvalidCreds(PropertyReader.readKey("invalid_username"),PropertyReader.readKey("invalid_password"));
        logger.info("End and Asserting the Output!!");
        assertThat(error_msg).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(error_msg,PropertyReader.readKey("error_message"));

    }
    @Owner("Shadab")
    @Description("Veryfythat valid creds and validatye user name on Dashboard")
    @Test
    public void testLoginPositiveVWO(){
        LoginPage loginPage_VWO = new LoginPage(DriverManager.getDriver());
        loginPage_VWO.loginToVWOLoginValidCreds(PropertyReader.readKey("username"),PropertyReader.readKey("password"));
        DashBoardPage dashBoardPage = new DashBoardPage(DriverManager.getDriver());
        String userNameLoggedIn = dashBoardPage.loggedInUserName();
        assertThat(userNameLoggedIn).isNotBlank().isNotEmpty().isNotNull();
        Assert.assertEquals(userNameLoggedIn, PropertyReader.readKey("expected_username"));
    }
}
