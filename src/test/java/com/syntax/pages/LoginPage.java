package com.syntax.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.syntax.utils.BaseClass;
import com.syntax.utils.CommonMethods;

public class LoginPage extends BaseClass{

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[contains(@src, 'logo')]")
	public WebElement logo;
	
	@FindBy(id="txtUsername")
	public WebElement username;
	
	@FindBy(id="txtPassword")
	public WebElement password;
	
	@FindBy(id="btnLogin")
	public WebElement btnLogin;
	
	@FindBy(id="spanMessage")
	public WebElement errorMessage;
	

	
	public void login(String userName, String pwd) {
		CommonMethods.enterValue(username, userName);
		CommonMethods.enterValue(password, pwd);
		CommonMethods.click(btnLogin);
	}
	
}
