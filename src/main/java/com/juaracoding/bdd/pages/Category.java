package com.juaracoding.bdd.pages;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.juaracoding.bdd.driver.DriverSingleton;

public class Category {
	
	private  WebDriver driver;
	
	public Category() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "/html/body/div/div[1]/header/div[3]/div/div/div[6]/ul/li[1]")
	private WebElement btnWomen;
	
	
	
	
	public void categoryProduct() {
		scroll(driver);
		btnWomen.click();
		

			
	}
	
	public static void scroll(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;  
		js.executeScript("scrollBy(0, 500)");
	}

}
