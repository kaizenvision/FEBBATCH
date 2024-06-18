package com.pomclasses;

import com.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;

public class LoginPagePom extends BaseClass {


	
	public LoginPagePom() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//p[text()='Username : Admin']")
	private WebElement  usernameText;
	
	@FindBy(xpath = "//p[text()='Password : admin123']")
	private WebElement passwordText;
	
	@FindBy(xpath = "//input[@name='username']")
	private WebElement usernameInput;
	
	@FindBy(xpath = "//input[@name='password']")
	private WebElement passwordInput;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement submitButton;
	
	@FindBy(xpath = "//div[@class='orangehrm-login-forgot']//child::p")
	private WebElement forgotPassword;
	
	public String getUsername() {
		String username =  Utility.getWebelementText(usernameText);
		return  username.substring(11);
	}
	
	public String getPassword() {
		String password =  Utility.getWebelementText(passwordText);
		return  password.substring(11);
	}
	
	public AdminPagePom login(String username, String password) {
		Utility.setText(usernameInput,username);
		Utility.setText(passwordInput,password);
		Utility.webelementClick(submitButton);
		return new AdminPagePom();
	}

	
}
