package com.testclasses;

import com.baseclass.BaseClass;
import com.pomclasses.LoginPagePom;
import com.utility.ExcelReader;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseClass {

    @BeforeClass
    public void setup(){
        launchWeb();
    }
    public void teardown(){}

    @Test
    public void AdminloginTest() {

        LoginPagePom loginPagePom = new LoginPagePom();
        Assert.assertEquals(loginPagePom.getUsername(),"Admin");
        Assert.assertEquals(loginPagePom.getPassword(),"admin123");

        loginPagePom.login(loginPagePom.getUsername(), loginPagePom.getPassword());
    }
}
