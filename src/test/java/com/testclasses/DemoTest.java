package com.testclasses;

import com.baseclass.BaseClass;
import com.utility.ExtentReportUtility;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DemoTest  {

    @Test(groups = {"regression"}, priority = 4)
    public void test1(){
        System.out.println("in test 1");
    }
    @Test(groups = {"regression","sanity"}, priority = 1)
    public void test2(){
        System.out.println("in test2");
    }
    @Test(invocationCount = 3, priority = -2)
    public void test3(){
        System.out.println("in test 3");
    }
    @Test(enabled = false)
    public void test4(){
        System.out.println("in test 4");
    }
    @Test()
    public void test5(){
        System.out.println("in test 5");
    }
}
