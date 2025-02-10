package com.hc.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginWithElementsPO {
	public static WebElement username(WebDriver driver) {
		return driver.findElement(
				By.xpath("//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input"));
	}

	public static WebElement password(WebDriver driver) {
		return driver.findElement(
				By.xpath("//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input"));
	}

	public static WebElement loginButton(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));
	}

	public static WebElement profile(WebDriver driver) {
		return driver.findElement(By.tagName("h6"));
	}
}
