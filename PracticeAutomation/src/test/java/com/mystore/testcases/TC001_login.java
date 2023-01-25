package com.mystore.testcases;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.mystore.pageobjects.HomePage;
import com.mystore.utility.ExcelLibrary;
import com.store.base.BaseClass;

public class TC001_login extends BaseClass {
	HomePage home;

	@Test
	public void TC001_loginTest() {

		home = new HomePage();
		Assert.assertEquals("Login", home.verifyHeader());
		home.enterUserNameAndPassword();
	}

	@Test
	public void TC002_Verify() {
		home = new HomePage();
		Assert.assertEquals("Login", home.verifyHeader());
		home.verifyUsernameField();
	}

	@Test
	public void TC002_Verify2() {
		home = new HomePage();
		Assert.assertEquals("Login", home.verifyHeader());
		home.verifyUsernameLabel();
	}

	@Test
	public void TC002_Verify3() {
		try {
			home = new HomePage();
			// String path = GenericMethods.DirectoryPat() +
			// "\\scr\\test\\resources\\TestData\\InputData.xlsx";

			// String data = GenericMethods.getExcelData(path, "sample", 1, 1);
			ExcelLibrary lib = new ExcelLibrary("./PracticeAutomation/scr/test/resources/TestData/InputData.xlsx");
			String data = lib.getCellData("sample", 1, 1);
			Assert.assertEquals(data, home.verifyHeader());
			Assert.assertEquals("qwerty", home.getUserNameEntered());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
