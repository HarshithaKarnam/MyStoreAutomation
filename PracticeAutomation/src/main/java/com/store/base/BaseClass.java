package com.store.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.mystore.utility.GenericMethods;

public class BaseClass {
	public static WebDriver driver;
	public static Properties prop;

	@BeforeTest
	public void LoadConfig() {
		prop = new Properties();
		FileInputStream ip;
		try {
			ip = new FileInputStream(GenericMethods.DirectoryPat() + "\\Configuration\\Config.properties");
			prop.load(ip);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@SuppressWarnings("deprecation")
	@BeforeMethod
	public void OpenBrowser() {
		String browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					GenericMethods.DirectoryPat() + "\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("FF")) {
			System.setProperty("webdriver.gecko.driver", GenericMethods.DirectoryPat() + "\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", GenericMethods.DirectoryPat() + "\\Drivers\\IEDriverServer.exe");
			
			driver = new InternetExplorerDriver();
//			DesiredCapabilities capabilities = DesiredCapabilities.();
//			capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		} else if (browserName.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", GenericMethods.DirectoryPat() + "\\Drivers\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		driver.get(prop.getProperty("url"));

	}

	@AfterMethod
	public void CloseBrowsers() {
		driver.quit();
	}

}
