package com.utility;

import com.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

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

}
