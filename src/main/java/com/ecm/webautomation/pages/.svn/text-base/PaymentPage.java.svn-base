package com.ecm.webautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ecm.webautomation.coreng.WebDriverModule;

public class PaymentPage extends WebDriverModule{

	private final static By Select_Payment_Method=By.cssSelector(".adyen_creditcard paymentmethod");
	private final static By CC_Number=By.cssSelector("input[data-ci-test-id='cardNumberField']");
	private final static By CC_Name=By.cssSelector("input[data-ci-test-id='nameOnCardField']");
	private final static By CC_Month_Drop_Down=By.cssSelector("div[data-ci-test-id='monthDropdown']");
	private final static By CC_Year_Drop_Down=By.cssSelector("div[data-ci-test-id='yearDropdown']");
	private final static By CC_CVV=By.cssSelector("input[data-ci-test-id='CVVField']");
	
	public PaymentPage(WebDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
	}
	
	public void selectPaymentMethod() {
		click(Select_Payment_Method);
	}
	
	public void enterCCDetails(String CCNumber, String CCName, String CVV, String Month, String year) {
		typeInByJavascript(CC_Number, CCNumber);
		typeInByJavascript(CC_Name, CCName);
		click(CC_Month_Drop_Down);
		click(CC_Month_Drop_Down);
		typeInByJavascript(CC_Month_Drop_Down, Month);
		click(CC_Year_Drop_Down);
		click(CC_Year_Drop_Down);
		typeInByJavascript(CC_Year_Drop_Down, year);
		
	}

	
}