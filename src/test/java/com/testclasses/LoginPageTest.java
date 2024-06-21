package com.testclasses;

import com.baseclass.BaseClass;
import com.pomclasses.LoginPagePom;
import com.utility.ExcelReader;
import com.utility.ExtentReportUtility;
import com.utility.Utility;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;


public class LoginPageTest extends BaseClass {

    @BeforeTest
    public void setup(){
        launchWeb();
        ExtentReportUtility.extentReportInitialisation();
    }

    @AfterTest
    public void teardown(){
        ExtentReportUtility.extentReportgeneration();
    }

    @Test(groups = {"adminlogin"})
    public void AdminloginTest() throws IOException {
        ExtentReportUtility.extentReportCreateTest("AdminloginTest");
        LoginPagePom loginPagePom = new LoginPagePom();
        Assert.assertEquals(loginPagePom.getUsername(),"Admin");
        Assert.assertEquals(loginPagePom.getPassword(),"admin123");
        ExtentReportUtility.logger.info("username" + loginPagePom.getUsername());
        ExtentReportUtility.logger.info("password" + loginPagePom.getPassword());
        loginPagePom.login(loginPagePom.getUsername(), loginPagePom.getPassword());
        Utility.getScreenShot("Admin");
    }
}
