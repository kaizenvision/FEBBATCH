package com.utility;

import com.baseclass.BaseClass;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class Utility extends BaseClass {

    public static String getWebelementText(WebElement ele){
        return ele.getText();
    }

    public static void setText(WebElement ele, String text){
        ele.sendKeys(text);
    }

    public static void webelementClick(WebElement ele){
        ele.click();
    }

    public static void setImplicitWeight(Duration sec){
        driver.manage().timeouts().implicitlyWait(sec);
    }

    public static Actions getActionClass(){
        return new Actions(driver);
    }

    public static void getScreenShot(String testName) throws IOException {
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String destinationPath = projectpath+"/screenshots/"+testName+".png";
        FileUtils.copyFile(screenshotFile,new File(destinationPath));
    }

    public void applyExplicitWait(WebElement ele){
        WebDriverWait webDriverWait = new WebDriverWait(driver,Duration.ofSeconds(2));
        webDriverWait.until(ExpectedConditions.visibilityOf(ele));
        webDriverWait.pollingEvery(Duration.ofSeconds(1));
    }

}
