package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.mystore.utility.GenericMethods;
import com.store.base.BaseClass;

public class HomePage extends BaseClass {
	// Constructor that will be automatically called as soon as the object of the
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	// Elements in Home page
	@FindBy(css = ".subtitle.page-header")
	WebElement subHeaderLogin;
	@FindBy(css = "#io-only")
	WebElement userNLabel;
	@FindBy(css = "#username")
	WebElement userNField;
	@FindBy(id = "password")
	WebElement passwField;

	// Methods under Home page
	public String verifyHeader() {
		Assert.assertEquals((subHeaderLogin).isDisplayed(), true);
		return subHeaderLogin.getText();

	}

	public void verifyUsernameLabel() {
		Assert.assertEquals((userNLabel).isDisplayed(), true);

	}

	public void verifyUsernameField() {
		Assert.assertEquals((userNField).isDisplayed(), true);

	}

	public String getUserNameEntered() {
		GenericMethods.EnterText((userNField), "qwerty");
		String val = (userNField).getAttribute("value");
		return val;

	}

	public void enterUserNameAndPassword() {
		Assert.assertEquals((userNLabel).isDisplayed(), true);
		Assert.assertEquals((userNField).isDisplayed(), true);
		GenericMethods.EnterText((userNField), "qwerty");
		String val = (userNField).getAttribute("value");
		GenericMethods.EnterText((passwField), val);
		(passwField).sendKeys(val);

	}

}
