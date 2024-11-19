package com.inetbanking.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.utils.FileUtil;
import com.inetbanking.utilities.ReadConfig;

public class BaseClass {

	ReadConfig rc = new ReadConfig();

	public String baseURL = rc.getApplicationURL();
	public String username = rc.getUserName();
	public String password = rc.getPassword();
	public static WebDriver driver;

	public static Logger logger;

	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {

		logger = Logger.getLogger("ebanking");
		PropertyConfigurator.configure("Log4j.properties");

		if (br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", rc.getChromePath());
			driver = new ChromeDriver();
		} else if (br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", rc.getFireFoxPath());
			driver = new FirefoxDriver();

		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseURL);

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	public void captureScreen(WebDriver driver, String tname) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File Destination = new File(System.getProperty("user.dir") + "/Screeshots/" + tname + ".png");
		FileUtils.copyFile(source, Destination);
		System.out.println("Screenshot Captured");

	}

	public String randomString() {

		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return (generatedString);

	}

	public String randomnum() {

		String generatedString1 = RandomStringUtils.randomNumeric(4);
		return (generatedString1);
	}

}
