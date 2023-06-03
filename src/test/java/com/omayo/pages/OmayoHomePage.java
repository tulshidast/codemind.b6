package com.omayo.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class OmayoHomePage {

	// Home page related locators
	WebDriver driver;
	WebElement multiSelectDropdown;
	WebElement onePageLink;
	WebElement maleRadioButton;
	WebElement creatBlog;
	WebElement frame1;

	public OmayoHomePage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getMultiSelectDropdown() {
		setMultiSelectDropdown();
		return multiSelectDropdown;
	}

	public void setMultiSelectDropdown() {
		this.multiSelectDropdown = driver.findElement(By.xpath("//select[@id='multiselect1']"));
	}

	public WebElement getOnePageLink() {
		setOnePageLink();
		return onePageLink;
	}

	public void setOnePageLink() {
		this.onePageLink = driver.findElement(By.xpath("//a[text()='Page One']"));
	}

	public WebElement getMaleRadioButton() {
		setMaleRadioButton();
		return maleRadioButton;
	}

	public void setMaleRadioButton() {
		this.maleRadioButton = driver.findElement(By.xpath("//input[@id='radio1']"));
	}

	public WebElement getCreatBlog() {
		setCreatBlog();
		return creatBlog;
	}

	public void setCreatBlog() {
		this.creatBlog = driver.findElement(By.xpath("//a[@id='b-getorpost']"));
	}

	public WebElement getFrame1() {
		setFrame1();
		return frame1;
	}

	public void setFrame1() {
		this.frame1 = driver.findElement(By.xpath("//iframe[@id='navbar-iframe']"));
	}

	public void selectMultiSelectDropdownOption(String visibleText) {
		Select select = new Select(getMultiSelectDropdown());
		select.selectByVisibleText(visibleText);
	}

	public List<String> getAllSelectedOptions() {
		Select select = new Select(getMultiSelectDropdown());
		List<String> optionsSelectedFromDropdown = new ArrayList<String>();
		List<WebElement> selectedOptions = select.getAllSelectedOptions();
		for (WebElement elm : selectedOptions) {
			optionsSelectedFromDropdown.add(elm.getText());
		}
		return optionsSelectedFromDropdown;
	}

	public String getHomePageTitle() {
		return driver.getTitle();
	}

	public String getHomePageUrl() {
		return driver.getCurrentUrl();
	}
}
