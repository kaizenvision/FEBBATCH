package com.testclasses;

import com.aventstack.extentreports.Status;
import com.baseclass.BaseClass;
import com.pomclasses.LoginPagePom;
import com.utility.ExcelReader;
import com.utility.ExtentReportUtility;
import com.utility.Utility;
import org.apache.poi.ss.usermodel.Sheet;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;


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

    @AfterMethod
    public void attachErrorLogs(ITestResult result){
        if(result.getStatus()==ITestResult.FAILURE){
            ExtentReportUtility.logger.log(Status.FAIL,result.getThrowable());
            ExtentReportUtility.logger.addScreenCaptureFromPath(projectpath + "\\screenshots\\"+result.getTestName()+".png");
        }
    }

    @Test(groups = {"adminlogin"}, dataProvider = "excelData")
    public void AdminloginTest(Map<String,Object> allData) throws IOException {
        ExtentReportUtility.extentReportCreateTest("AdminloginTest");
        LoginPagePom loginPagePom = new LoginPagePom();
        SoftAssert softAssert = new SoftAssert();
       // softAssert.assertEquals(loginPagePom.getUsername(),"Admin23");
       // softAssert.assertEquals(loginPagePom.getPassword(),"admin123");
        ExtentReportUtility.logger.info("username" + loginPagePom.getUsername());
        ExtentReportUtility.logger.info("password" + loginPagePom.getPassword());
        loginPagePom.login(allData.get("username").toString(), allData.get("password").toString());
        Utility.getScreenShot("Admin");
       // softAssert.assertAll();
    }

    @DataProvider(name = "excelData")
    public Object[][] getExcelSheetRowData() throws IOException {
        FileInputStream fis = ExcelReader.readExcelSheet("hr.xlsx");
        Sheet sh = ExcelReader.getSheet(fis,"Sheet2");
        return ExcelReader.getAllExcelData(sh);
    }
}
