package com.testclasses;

import com.baseclass.BaseClass;
import com.pomclasses.AdminPagePom;
import com.pomclasses.LoginPagePom;
import com.utility.ExcelReader;
import com.utility.ExtentReportUtility;
import com.utility.Utility;
import org.apache.poi.ss.usermodel.Sheet;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

@Listeners(MyListner.class)
public class AdminPageTest extends BaseClass {
    @BeforeClass
    public void setup(){
        //launchWeb();
    }
    public void teardown(){}

    @Test(groups = {"adduser"}, dependsOnGroups = {"adminlogin"})
    public void addUserTest() throws IOException {
        ExtentReportUtility.extentReportCreateTest("addUserTest");
        AdminPagePom adminPagePom = new AdminPagePom();
        adminPagePom.gotoAdminPage();
        adminPagePom.addUser();
        Map<String,Object> userData = getExcelSheetRowData();
        ExtentReportUtility.logger.info("user role "+userData.get("User Role").toString());
        ExtentReportUtility.logger.info("userdata "+userData);
        adminPagePom.setUserRole(userData.get("User Role").toString());
        //adminPagePom.setUserStatus(userData.get("Status").toString());
        adminPagePom.setEmployeename(userData.get("Employee Name").toString());
        adminPagePom.setUserDetails(userData.get("User Name").toString(),
                userData.get("Password").toString(),userData.get("Confirm Password").toString());

    }

    public Map<String, Object> getExcelSheetRowData() throws IOException {
        FileInputStream fis = ExcelReader.readExcelSheet("User_Details.xlsx");
        Sheet sh = ExcelReader.getSheet(fis,"Add User");
        Map<String,Object> rowData = ExcelReader.getRowData(sh,1);
        return rowData;
    }

}
