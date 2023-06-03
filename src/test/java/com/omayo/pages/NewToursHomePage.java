package com.omayo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewToursHomePage {

	WebDriver driver;
	WebElement registerLink;

	public NewToursHomePage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getRegisterLink() {
		setRegisterLink();
		return registerLink;
	}

	public void setRegisterLink() {
		this.registerLink = driver.findElement(By.xpath("//a[text()='REGISTER']"));
	}

	public void clickOnRegisterLink() {
		getRegisterLink().click();
	}
}
