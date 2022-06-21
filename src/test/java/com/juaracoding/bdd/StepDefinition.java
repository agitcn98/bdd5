package com.juaracoding.bdd;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.juaracoding.bdd.config.AutomationFrameworkConfig;
import com.juaracoding.bdd.driver.DriverSingleton;
import com.juaracoding.bdd.pages.Category;
import com.juaracoding.bdd.pages.LoginPage;
import com.juaracoding.bdd.utils.ConfigurationProperties;
import com.juaracoding.bdd.utils.Constants;

import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;

@CucumberContextConfiguration
@ContextConfiguration(classes = AutomationFrameworkConfig.class)
public class StepDefinition {

	private static WebDriver driver;
	private LoginPage loginPage;
	private Category category;
	
	@Autowired
	ConfigurationProperties configurationProperties;
	
	@Before
	public void setUp() {
		DriverSingleton.getInstance(configurationProperties.getBrowser());
		loginPage = new LoginPage();
		category = new Category();
	}
	
	@AfterAll
	public static void quitDriver() {
		tunggu(5);
		driver.quit();
	}
	
	// MODUL LOGIN
	@Given("Customer mengakses url")
	public void customer_mengakses_url() {
		driver = DriverSingleton.getDriver();
		driver.get(Constants.URL);
	}
	
	@When("Customer login dengan username dan password")
	public void customer_login_dengan_username_password() {
		loginPage.loginForm(configurationProperties.getEmail(), configurationProperties.getPassword());
	}
	
	@Then("Customer berhasil login")
	public void customer_berhasil_login() {
		driver.navigate().refresh();
		tunggu(5);		
		assertEquals(configurationProperties.getTxtWelcome(), loginPage.getTxtWelcome());
	}
	
	//MODUL CATEGORY
	@When("Customer click category women")
	public void customer_click_category_women() {
		category.categoryProduct();
	}
	
	@Then("Customer masuk category women")
	public void customer_masuk_category_women() {
		
	}
		
	
	public static void tunggu(int detik) {
		try {
			Thread.sleep(1000*detik);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
