package com.hc.datadriven;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CredentialsBothCorrect {
	@Test
	@Parameters({ "uname", "pword" })
	public void bothCorrect(String uname, String pword) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		PageFactory.initElements(driver, CredentialsPO.class);
		CredentialsPO.username.sendKeys(uname);
		CredentialsPO.password.sendKeys(pword);
		CredentialsPO.signinButton.click();
		System.out.println("The uname and pword for the class BothCorrect is " + uname + " & " + pword);
		driver.quit();
	}
}
