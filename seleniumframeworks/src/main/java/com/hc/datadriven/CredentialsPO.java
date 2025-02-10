package com.hc.datadriven;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CredentialsPO {
	@FindBy(xpath = "//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input")
	public static WebElement username;
	@FindBy(xpath = "//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input")
	public static WebElement password;
	@FindBy(xpath = "//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")
	public static WebElement signinButton;
}
