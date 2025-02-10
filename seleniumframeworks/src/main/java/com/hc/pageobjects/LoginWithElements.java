package com.hc.pageobjects;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class LoginWithElements {
	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		LoginWithElementsPO.username(driver).sendKeys("Admin");
		LoginWithElementsPO.password(driver).sendKeys("admin123");
		LoginWithElementsPO.loginButton(driver).click();
		Assert.assertEquals(LoginWithElementsPO.profile(driver).getText(), "Dashboard");
	}
}
