package com.inetbanking.testCases;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObject.LoginPage;
import com.inetbanking.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass {

	@Test(dataProvider = "LoginData")
	public void loginDDT(String user, String pwd) throws Exception {

		LoginPage lp = new LoginPage(driver);
		lp.setUserName(user);
		logger.info("Enter UserName");
		lp.setPassword(pwd);
		logger.info("Enter Password");
		lp.clickSubmit();
		
		Thread.sleep(3000);

		if (isAlertPresent() == true) {

			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Login Failed");
		} else {

			Assert.assertTrue(true);
			logger.info("Login Successful");
			lp.clickLogout();
			
			Thread.sleep(3000);
			
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();

		}

	}

	public boolean isAlertPresent() {

		try {
			driver.switchTo().alert();
			return true;

		} catch (NoAlertPresentException e) {
			return false;
		}

	}

	@DataProvider(name = "LoginData")
	String[][] getData() throws Exception {

		String path = System.getProperty("user.dir") + "/src/test/java/com/inetbanking/testData/LoginData.xlsx";
		int rowNum = XLUtils.getRowCount(path, "Sheet1");
		int colCount = XLUtils.getCellCount(path, "Sheet1", 1);

		String logindata[][] = new String[rowNum][colCount];

		for (int i = 1; i <= rowNum; i++) {

			for (int j = 0; j < colCount; j++) {

				// i = 2D array,j = exceldata
				logindata[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j); // 1,0

			}
		}

		return logindata;
	}

}
