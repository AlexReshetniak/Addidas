package com.ecm.webautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ecm.webautomation.coreng.WebDriverModule;

public class AddressReviewPage extends WebDriverModule {

	private final static By Continu_checkout=By.cssSelector("input[data-ci-test-id='reviewAndPayButton']");
	public AddressReviewPage(WebDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
	}
	
	public void continueCheckout() {
		click(Continu_checkout);
	}

}