package com.testclasses;

import com.utility.Utility;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class MyListner implements ITestListener {

    @Override
    public void onTestSuccess(ITestResult result) {
        try {
            Utility.getScreenShot(result.getTestName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void onTestFailure(ITestResult result) {
        try {
            Utility.getScreenShot(result.getName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
