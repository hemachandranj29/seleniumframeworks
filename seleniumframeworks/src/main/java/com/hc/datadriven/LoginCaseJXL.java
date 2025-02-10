package com.hc.datadriven;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class LoginCaseJXL {
	WebDriver driver;
	String data[][];

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

	public String[][] excelData() throws BiffException, IOException {
		FileInputStream file = new FileInputStream("/home/hc/Downloads/eclipse/data.xls");
		Workbook workbook = Workbook.getWorkbook(file);
		Sheet sheet = workbook.getSheet(0);
		int rowsCount = sheet.getRows();
		int columnsCount = sheet.getColumns();
		String[][] testData = new String[rowsCount - 1][columnsCount];
		for (int i = 1; i < rowsCount; i++) {
			for (int j = 0; j < columnsCount; j++) {
				testData[i - 1][j] = sheet.getCell(j, i).getContents();
			}
		}
		return testData;
	}

	@DataProvider(name = "loginCred")
	public String[][] getData() throws BiffException, IOException {
		data = excelData();
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
