package com.mystore.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.testng.Assert;

import com.store.base.BaseClass;

public class GenericMethods extends BaseClass {
	public static Boolean Exists(WebElement element) {
		try {

			if (element.isDisplayed()) {
				return true;
			}

		} catch (NoSuchElementException e) {
			return false;
		}

		catch (StaleElementReferenceException e) {
			return false;
		} catch (Exception e) {
			return false;
		}
		return false;
	}

	public static void EnterText(WebElement element, String text) {
		try {
			if (Exists(element)) {
				element.clear();
				element.sendKeys(text);
				Assert.assertEquals(text, element.getAttribute("value"));
			} else {
				// Console.WriteLine(element.getAttribute("Name") + " element is not found");
			}
		} catch (Exception e) {
			Assert.fail("The occurred exception is" + e);
		}

	}

	public static void EnterTextAndVerify(WebElement element, String text) {
		try {
			if (Exists(element)) {
				element.clear();
				element.sendKeys(text);
				Assert.assertEquals(text, element.getAttribute("value"));
			} else {
				// Console.WriteLine(element.getAttribute("Name") + " element is not found");
			}
		} catch (Exception e) {
			Assert.fail("The occurred exception is" + e);
		}

	}

	public static void ClickandEnterText(WebElement element, String text) {
		try {
			if (Exists(element)) {
				while (element.getAttribute("value").length() > 0) {
					element.clear();
				}

				element.click();
				element.sendKeys(Keys.HOME);
				element.sendKeys(text);
				Assert.assertEquals(text, element.getAttribute("value"));
			} else {
				// Console.WriteLine(element.getAttribute("Name") + " element is not found");
			}
		}

		catch (Exception e) {
			Assert.fail("The occurred exception is" + e);
		}
	}

	public static void SelectRadioButton(WebElement element) {
		try {
			Wait(2000);
			// DynamicWait(element);
			if (!(Exists(element))) {
				Wait(2000);
			}

			element.click();
			Assert.assertTrue(element.isSelected());
		} catch (Exception e) {
			Assert.fail("The occurred exception is" + e);
		}
	}

	public static void Wait(int milliseconds) throws InterruptedException {
		Thread.sleep(milliseconds);
	}

	public static void SelectValueFromSelectList(WebElement element, String selText) {
		try {
			if (Exists(element)) {
				Select select = new Select(element);
				select.selectByVisibleText(selText);
				Assert.assertEquals(selText, select.getFirstSelectedOption().getText(),
						"The " + selText + " option is not selected.");
			} else {
				// Console.WriteLine(element.getAttribute("Name") + " element is not found");
			}
		} catch (Exception e) {
			Assert.fail("The occurred exception is" + e);
		}

	}

	public static void SelectValueFromListByIndex(WebElement element, int index) {
		try {
			if (Exists(element)) {
				Select select = new Select(element);
				select.selectByIndex(index);

			} else {
				// Console.WriteLine(element.getAttribute("Name") + " element is not found");
			}
		} catch (Exception e) {
			Assert.fail("The occurred exception is" + e);
		}

	}

	public static void SelectValueFromListByValue(WebElement element, String value) {
		try {
			if (Exists(element)) {
				Select select = new Select(element);
				select.selectByValue(value);

			} else {
				// Console.WriteLine(element.getAttribute("Name") + " element is not found");
			}
		} catch (Exception e) {
			Assert.fail("The occurred exception is" + e);
		}
	}

	public static void ClickElementJavaScript(WebElement element, WebDriver Driver) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	public static void ScrollTTillElementJS(WebDriver driver, WebElement element) {
		try {
			if (Exists(element)) {
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].scrollIntoView(true);", element);
				Wait(500);
			} else {
				Assert.fail("Element is not exist");
			}
		} catch (Exception e) {
			Assert.fail("Problem in scrolling the element" + e);
		}
	}

	public static Boolean ContainsText(String searchtext, String originalText) {
		try {
			if (originalText.contains(searchtext)) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

	public static String getSubstringOfText(String text, int startingIndex, int lastIndex) {
		try {
			return text.substring(text.length() - startingIndex, lastIndex);
		} catch (Exception e) {
			Assert.fail("Problem in getting substring" + e);
			return null;
		}
	}

	public static void MouseHover(WebDriver driver, WebElement element) {
		try {
			Actions action = new Actions(driver);
			action.moveToElement(element).build().perform();

		} catch (Exception e) {
			Assert.fail("Problem in mouse hovering" + e);
		}
	}

	// Method to generate random numbers of given range of numbers
	public static String generateRandomChars(String candidateChars, int length) {
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			sb.append(candidateChars.charAt(random.nextInt(candidateChars.length())));
		}

		return sb.toString();
	}

	// Method to mouse hover and click element
	public static void MouseHoverAndClick(WebDriver driver, WebElement elementToHover, WebElement elementToClick) {
		try {
			Actions action = new Actions(driver);
			action.moveToElement(elementToHover).click(elementToClick).build().perform();
		} catch (Exception e) {
			Assert.fail("Problem in mouse hovering and clicking element" + e);
		}
	}

	public static void DoubleClick(WebDriver driver, WebElement element) {
		try {
			Actions action = new Actions(driver);
			action.doubleClick(element).build().perform();
		} catch (Exception e) {
			Assert.fail("The occurred exception is" + e);

		}
	}

	public static Boolean Enabled(WebElement element) {
		try {
			if (element.isEnabled()) {
				return true;
			}
		} catch (NoSuchElementException e) {
			return false;
		} catch (StaleElementReferenceException e) {
			return false;
		} catch (Exception e) {
			return false;
		}
		return false;
	}

	public static String DirectoryPat() {
		String pathT = Paths.get("").toAbsolutePath().toString();
		return pathT;
	}

	@SuppressWarnings("deprecation")
	public static boolean switchToFrameByIndex(WebDriver driver, int index) {
		boolean flag = false;
		try {
			new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe")));
			driver.switchTo().frame(index);
			flag = true;
			return true;
		} catch (Exception e) {

			return false;
		} finally {
			if (flag) {
				System.out.println("Frame with index \"" + index + "\" is selected");
			} else {
				System.out.println("Frame with index \"" + index + "\" is not selected");
			}
		}
	}

	public static boolean switchToFrameByName(WebDriver driver, String nameValue) {
		boolean flag = false;
		try {
			driver.switchTo().frame(nameValue);
			flag = true;
			return true;
		} catch (Exception e) {

			return false;
		} finally {
			if (flag) {
				System.out.println("Frame with Name \"" + nameValue + "\" is selected");
			} else if (!flag) {
				System.out.println("Frame with Name \"" + nameValue + "\" is not selected");
			}
		}
	}

	public static boolean Alert(WebDriver driver) {
		boolean presentFlag = false;
		Alert alert = null;

		try {
			// Check the presence of alert
			alert = driver.switchTo().alert();
			// if present consume the alert
			alert.accept();
			presentFlag = true;
		} catch (NoAlertPresentException ex) {
			// Alert present; set the flag

			// Alert not present
			ex.printStackTrace();
		} finally {
			if (!presentFlag) {
				System.out.println("The Alert is handled successfully");
			} else {
				System.out.println("There was no alert to handle");
			}
		}

		return presentFlag;
	}

	public static String getExcelData(String filePath, String sheetName, int rowVal, int colVal) throws IOException {

		File src = new File(filePath);
		FileInputStream fis;
		String data = null;

		fis = new FileInputStream(src);
		XSSFWorkbook xsf = new XSSFWorkbook(fis);
		XSSFSheet sheet = xsf.getSheet(sheetName);
		data = sheet.getRow(rowVal).getCell(colVal).getStringCellValue();
		return data;

	}
}
