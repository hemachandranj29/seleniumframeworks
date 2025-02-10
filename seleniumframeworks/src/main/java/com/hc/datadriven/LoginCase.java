package com.hc.datadriven;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginCase {
	WebDriver driver;
	String[][] data = { { "admina", "admin" }, { "admina", "admin123" }, { "Admin", "admin" },
			{ "Admin", "admin123" } };

	@BeforeTest
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

	@DataProvider(name = "loginCred")
	public String[][] loginData() {
		return data;
	}

	@Test(dataProvider = "loginCred")
	public void login(String uname, String pword) {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		PageFactory.initElements(driver, CredentialsPO.class);
		CredentialsPO.username.sendKeys(uname);
		CredentialsPO.password.sendKeys(pword);
		CredentialsPO.signinButton.click();
		System.out.println("The username is: " + uname + " & the password is: " + pword);
	}
}
