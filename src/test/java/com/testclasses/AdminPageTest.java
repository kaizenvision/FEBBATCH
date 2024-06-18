package com.testclasses;

import com.baseclass.BaseClass;
import com.pomclasses.AdminPagePom;
import com.pomclasses.LoginPagePom;
import com.utility.ExcelReader;
import org.apache.poi.ss.usermodel.Sheet;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

public class AdminPageTest extends BaseClass {
    @BeforeClass
    public void setup(){
        launchWeb();
    }
    public void teardown(){}

    @Test
    public void addUserTest() throws IOException {
        LoginPagePom loginPagePom = new LoginPagePom();
        Assert.assertEquals(loginPagePom.getUsername(),"Admin");
        Assert.assertEquals(loginPagePom.getPassword(),"admin123");
        AdminPagePom adminPagePom = loginPagePom.login(loginPagePom.getUsername(), loginPagePom.getPassword());
        adminPagePom.gotoAdminPage();
        adminPagePom.addUser();
        Map<String,Object> userData = getExcelSheetRowData();
        System.out.println(userData.get("User Role").toString());
        adminPagePom.setUserRole(userData.get("User Role").toString());
        adminPagePom.setEmployeename(userData.get("Employee Name").toString());
        adminPagePom.setUserDetails(userData.get("User Name").toString(),
                userData.get("Password").toString(),userData.get("Confirm Password").toString());

    }

    public Map<String, Object> getExcelSheetRowData() throws IOException {
        FileInputStream fis = ExcelReader.readExcelSheet("User_Details.xlsx");
        Sheet sh = ExcelReader.getSheet(fis,"Add User");
        Map<String,Object> rowData = ExcelReader.getRowData(sh,1);
        System.out.println(rowData);
        return rowData;
    }

}
