package com.inetbanking.pageObject;

import javax.xml.xpath.XPath;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditCustomer {

	WebDriver idriver;

	public EditCustomer(WebDriver driver) {
		// TODO Auto-generated constructor stub
	}

	public void editCust(WebDriver rdriver) {

		idriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "/html/body/div[3]/div/ul/li[3]/a")
	WebElement lnkEditCust;

	@FindBy(name = "cusid")
	WebElement txtID;

	@FindBy(name = "AccSubmit")
	WebElement btnSubmit;

	// Action Class

	public void clickEditCust() {

		lnkEditCust.click();
	}

	public void custID(String id) {

		txtID.sendKeys(String.valueOf(id));
	}

	public void custSubmit() {

		btnSubmit.click();
	}

}
