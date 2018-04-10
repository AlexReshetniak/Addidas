package com.ecm.webautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ecm.webautomation.coreng.WebDriverModule;

public class DeliveryPage extends WebDriverModule {

	private final static By Shipping_FName=By.cssSelector("input[data-ci-test-id='firstNameField']");
	private final static By Shipping_LName=By.cssSelector("input[data-ci-test-id='lastNameField']");
	private final static By Shipping_City=By.cssSelector("input[data-ci-test-id='cityField']");
	private final static By Shipping_ZipCode=By.cssSelector("input[data-ci-test-id='zipField']");
	private final static By Shipping_Add1=By.cssSelector("input[data-ci-test-id='address1Field']");
	private final static By Shipping_HouseNo=By.cssSelector("input[data-ci-test-id='houseNumberField']");
	private final static By Shipping_AppNo=By.cssSelector("input[data-ci-test-id='apartmentNumberField']");
	private final static By Shipping_PhNo=By.cssSelector("input[data-ci-test-id='phoneField']");
	private final static By Shipping_Add2=By.cssSelector("input[data-ci-test-id='address2Field']");
	private final static By Shipping_Email=By.cssSelector("input[data-ci-test-id='eMailField']");
	private final static By Shipping_VerifyAddress=By.cssSelector("#dwfrm_delivery_savedelivery");

	public DeliveryPage(WebDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
	}
	
	public void fillAddress(String FName, String LName, String City, String Zipcode, String Address1, String HouseNo, String AppratNo, String PhoneNo, String Address2, String Email) {
		waitForAjaxToComplete();
		typeInByJavascript(Shipping_FName, FName);
		typeInByJavascript(Shipping_LName, LName);
		typeInByJavascript(Shipping_City, City);
		typeInByJavascript(Shipping_ZipCode, Zipcode);
		typeInByJavascript(Shipping_Add1, Address1);
		typeInByJavascript(Shipping_HouseNo, HouseNo);
		typeInByJavascript(Shipping_AppNo, AppratNo);
		typeInByJavascript(Shipping_PhNo, PhoneNo);
		typeInByJavascript(Shipping_Add2, Address2);
		typeInByJavascript(Shipping_Email, Email);
		
	}
	
	public void CheckoutProduct() {
		waitForAjaxToComplete();
		click(Shipping_VerifyAddress);
	}

}