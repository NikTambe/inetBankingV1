package com.inetbanking.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {

	WebDriver idriver;

	public AddCustomerPage(WebDriver rdriver) {

		idriver = rdriver;
		PageFactory.initElements(rdriver, this);

	}

	@FindBy(xpath = "/html/body/div[3]/div/ul/li[2]/a")
	WebElement lnkNewCustomer;

	@FindBy(name = "name")
	WebElement txtCustName;

	@FindBy(name = "rad1")
	WebElement radioGender;

	@FindBy(id = "dob")
	WebElement txtDoB;

	@FindBy(name = "addr")
	WebElement txtAddress;

	@FindBy(name = "city")
	WebElement txtCity;

	@FindBy(name = "state")
	WebElement txtState;

	@FindBy(name = "pinno")
	WebElement txtPinno;

	@FindBy(name = "telephoneno")
	WebElement txtMobNo;

	@FindBy(name = "emailid")
	WebElement txtEmailID;

	@FindBy(name = "password")
	WebElement txtPwd;

	@FindBy(name = "sub")
	WebElement btnSubmit;

	// Action class

	public void clicknewCustomer() {

		lnkNewCustomer.click();

	}

	public void custName(String cname) {

		txtCustName.sendKeys(cname);
	}

	public void custGender(String cgender) {

		radioGender.click();

	}

	public void custDob(String mm, String dd, String yy) {

		txtDoB.sendKeys(mm);
		txtDoB.sendKeys(dd);
		txtDoB.sendKeys(yy);
	}

	public void custAddress(String cadd) {

		txtAddress.sendKeys(cadd);
	}

	public void custCity(String city) {

		txtCity.sendKeys(city);
	}

	public void custState(String cstate) {

		txtState.sendKeys(cstate);
	}

	public void custPinno(String cpinno) {

		txtPinno.sendKeys(String.valueOf(cpinno));
	}

	public void custMobno(String cmob) {

		txtMobNo.sendKeys(cmob);
	}

	public void custEmail(String cemail) {

		txtEmailID.sendKeys(cemail);
	}

	public void custPassword(String cpwd) {

		txtPwd.sendKeys(cpwd);
	}

	public void custSubmit() {
		
		btnSubmit.click();
	}

}
