package com.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtility {
    //crete report
    //attach report
    //logger
    public static String projectPath = System.getProperty("user.dir");

    public static ExtentSparkReporter extentSparkReporter ;
    public static ExtentReports extentReports ;
    public static ExtentTest logger;


    public static void extentReportInitialisation() {
        extentSparkReporter = new ExtentSparkReporter(projectPath+"//extentReport//testReport.html");
        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);
    }


    public static void extentReportgeneration() {
        extentReports.flush();
    }


    public static void extentReportCreateTest(String testName) {
        logger = extentReports.createTest(testName);
    }
}
