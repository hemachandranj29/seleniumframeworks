package com.hc.pageobjects;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class LoginWithoutFindBy {
	WebDriver driver;
	public static WebElement username;
	public static WebElement password;

	@Test
	public void login() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		PageFactory.initElements(driver, LoginWithoutFindBy.class);
		LoginWithoutFindBy.username.sendKeys("Admin");
		LoginWithoutFindBy.password.sendKeys("admin123");
	}
}
