package com.juaracoding.bdd.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.juaracoding.bdd.driver.DriverSingleton;

public class LoginPage {

	private WebDriver driver;
	
	public LoginPage() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "email")
	private WebElement inputEmail;
	
	@FindBy(name = "passwd")
	private WebElement inputPassword;
	
	@FindBy(id = "SubmitLogin")
	private WebElement btnLogin;
	
	@FindBy(className = "page-heading")
	private WebElement txtWelcome;
	
	
	
	public void loginForm(String email, String password) {
		inputEmail.sendKeys(email);
		inputPassword.sendKeys(password);
		btnLogin.click();
	}
	
	public String getTxtWelcome() {
		return txtWelcome.getText();
	}
}
