package com.codemind.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility {
	static WebDriver driver;

	public static WebDriver getWebDriver() throws IOException {
		System.setProperty("webdriver.chrome.driver", Utility.getProperty("driverPath"));
		driver = new ChromeDriver();
		return driver;
	}

	public static String getProperty(String key) throws IOException {
		File file = new File("src/test/resources/testData.properties");
		FileInputStream fileInputStream = new FileInputStream(file);

		Properties properties = new Properties();
		properties.load(fileInputStream);
		return properties.getProperty(key);
	}

	public static void switchToFrame(WebDriver driver, WebElement frameLocator) {
		driver.switchTo().frame(frameLocator);
	}

	public static void switchBackToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	public static void waitForElementToBeAvailble(WebDriver driver, long duration, String elm) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elm)));
	}

	public static List<String> readExcel() throws IOException {

		List<String> userData = new ArrayList<String>();

		File file = new File("src/test/resources/userData.xlsx");
		FileInputStream fileInputStream = new FileInputStream(file);

		@SuppressWarnings("resource")
		XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fileInputStream);
		XSSFSheet sheet = xssfWorkbook.getSheetAt(0);

		int lastRowNum = sheet.getLastRowNum();
		int lastCellNum;
		XSSFRow row;
		for (int i = 1; i <= lastRowNum; i++) {
			row = sheet.getRow(i);
			lastCellNum = row.getLastCellNum();

			for (int j = 0; j < lastCellNum; j++) {
				userData.add(row.getCell(j).getStringCellValue());
			}
		}
		return userData;
	}

	public static void takesScreenshot(WebDriver driver, String name) throws IOException {
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File file = takesScreenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("src/test/resources/screenshots/" + name + ".png"));
	}
}
