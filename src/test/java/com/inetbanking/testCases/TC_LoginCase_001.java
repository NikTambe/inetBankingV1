package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObject.LoginPage;

public class TC_LoginCase_001 extends BaseClass {

	@Test
	public void loginTest() throws IOException {

		logger.info("URL is opened");

		LoginPage lp = new LoginPage(driver);

		lp.setUserName(username);
		logger.info("Enter UserName");
		lp.setPassword(password);
		logger.info("Entern Password");

		lp.clickSubmit();

		if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) {

			Assert.assertTrue(true);
			logger.info("Passed");
		} else {

			Assert.assertFalse(false);
			logger.warn("Test Case Failed");
		}

		captureScreen(driver, "loginTest");
		Assert.assertTrue(false);
		logger.info("Login test Failed");

	}

}
