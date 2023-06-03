package com.omayo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OmayoCreatBlogPage {
	// Creat blog page related locators
	WebDriver driver;
	WebElement creatBlogLink;

	public OmayoCreatBlogPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getCreatBlogLink() {
		setCreatBlogLink();
		return creatBlogLink;
	}

	public void setCreatBlogLink() {
		this.creatBlogLink = driver.findElement(By.xpath("//a[text()='Create your blog']"));
	}
}
