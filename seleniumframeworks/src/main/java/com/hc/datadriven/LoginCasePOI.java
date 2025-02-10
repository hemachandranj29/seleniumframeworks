package com.hc.datadriven;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginCasePOI {
	static WebDriver driver;
	static List<String> username = new ArrayList<String>();
	static List<String> password = new ArrayList<String>();

	public void login(String uname, String pword) {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		PageFactory.initElements(driver, CredentialsPO.class);
		CredentialsPO.username.sendKeys(uname);
		CredentialsPO.password.sendKeys(pword);
		CredentialsPO.signinButton.click();
		System.out.println("The username is: " + uname + " & the password is: " + pword);
	}

	public void getData() throws IOException {
		FileInputStream file = new FileInputStream("/home/hc/Downloads/eclipse/data.xlsx");
		Workbook workbook = new XSSFWorkbook(file);
		Sheet sheet = workbook.getSheetAt(0);
		Iterator<Row> rowIterator = sheet.iterator();
		while (rowIterator.hasNext()) {
			Row rowValue = rowIterator.next();
			Iterator<Cell> columnIterator = rowValue.iterator();
			int i = 2;
			while (columnIterator.hasNext()) {
				if (i % 2 == 0) {
					username.add(columnIterator.next().getStringCellValue());
				} else {
					password.add(columnIterator.next().getStringCellValue());
				}
				i++;
			}
		}
	}

	public void executeTest() {
		for (int i = 0; i < username.size(); i++) {
			login(username.get(i), password.get(i));
		}
	}

	public static void main(String[] args) throws IOException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		LoginCasePOI dataDriven = new LoginCasePOI();
		dataDriven.getData();
		System.out.println(username);
		System.out.println(password);
		dataDriven.executeTest();
		driver.quit();
	}

}
