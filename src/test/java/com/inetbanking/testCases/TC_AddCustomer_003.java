package com.inetbanking.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObject.AddCustomerPage;
import com.inetbanking.pageObject.LoginPage;

public class TC_AddCustomer_003 extends BaseClass {

	@Test
	public void addNewCust() throws Exception {

		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Entered Username");
		lp.setPassword(password);
		logger.info("Password Entered");
		lp.clickSubmit();

		AddCustomerPage addcust = new AddCustomerPage(driver);
		addcust.clicknewCustomer();

		logger.info("Customer Details entered");

		addcust.custName("Nikhil");
		addcust.custGender("Male");
		addcust.custDob("10", "23", "1990");

		Thread.sleep(3000);

		addcust.custAddress("India");
		addcust.custCity("Mumbai");
		addcust.custState("Maharastra");
		addcust.custPinno("12101");
		addcust.custMobno("8934123433");
		String email = randomString() + "@gmail.com";
		addcust.custEmail(email);
		addcust.custPassword("12345");
		addcust.custSubmit();

		Thread.sleep(3000);

		logger.info("Validation started");
		Boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
		if (res == true) {

			Assert.assertTrue(true);
			logger.info("TestCase passed");
		} else {

			captureScreen(driver, "addNewCust");
			Assert.assertFalse(false);
			logger.info("TestCase failed");
		}

	}

}
