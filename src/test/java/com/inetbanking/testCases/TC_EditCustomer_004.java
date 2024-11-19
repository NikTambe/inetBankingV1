package com.inetbanking.testCases;

import org.testng.annotations.Test;

import com.inetbanking.pageObject.EditCustomer;
import com.inetbanking.pageObject.LoginPage;

public class TC_EditCustomer_004 extends BaseClass {
	
	@Test
	
	public void editNewCust() {
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		lp.setPassword(password);
		lp.clickSubmit();
		
		EditCustomer editcust = new EditCustomer(driver);
		editcust.clickEditCust();
		
		editcust.custID("20725");
		editcust.custSubmit();
		
	}

}
