package com.ecm.webautomation.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ecm.webautomation.coreng.WebDriverModule;

public class PaymentPage extends WebDriverModule{

	private final static By Select_Payment_Method=By.cssSelector(".adyen_creditcard");
	private final static By CC_Number=By.cssSelector("input[data-ci-test-id='cardNumberField']");
	private final static By CC_Name=By.cssSelector("input[data-ci-test-id='nameOnCardField']");
	private final static By CC_Month_Drop_Down=By.cssSelector("div[data-ci-test-id='monthDropdown']");
	private final static By CC_Month_Select=By.cssSelector("ul[data-cts='500']>li>span");
	private final static By CC_Year_Drop_Down=By.cssSelector("div[data-ci-test-id='yearDropdown']");
	private final static By CC_Year_Select=By.cssSelector("ul[data-cts='500']>li>span");
	private final static By CC_CVV=By.cssSelector("input[data-ci-test-id='CVVField']");
	private final static By Submit_Order=By.cssSelector("div[data-ci-test-id='paymentSubmitButton']>div>button");
	
	public PaymentPage(WebDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
	}
	
	public void selectPaymentMethod() {
		click(Select_Payment_Method);
		waitForAjaxToComplete();
	}
	
	public void enterCCDetails(String CCNumber, String CCName, String CVV, String Month, String Year) {
		typeInByJavascript(CC_Number, CCNumber);
		typeInByJavascript(CC_Name, CCName);
		waitForAjaxToComplete();
		selectCCMonth(Month);
		selectCCYear(Year);
		waitForAjaxToComplete();
		typeInByJavascript(CC_CVV, CVV);
		waitForAjaxToComplete();
	}
	

	public void selectCCMonth(String Month) {
		waitForAjaxToComplete();
		click(CC_Month_Drop_Down);
		List<WebElement> Months = findElements(CC_Month_Select);
		System.out.println(Months.size());
		java.util.Iterator<WebElement> itr = Months.iterator();
		while (itr.hasNext()) {
			WebElement element = itr.next();
			String MonthText = element.getText();
			if (MonthText.equalsIgnoreCase(Month)) {
				element.click();
				break;
			}
		}
	}
	
	public void selectCCYear(String Year) {
		waitForAjaxToComplete();
		click(CC_Year_Drop_Down);
		List<WebElement> Years = findElements(CC_Year_Select);
		System.out.println(Years.size());
		java.util.Iterator<WebElement> itr = Years.iterator();
		while (itr.hasNext()) {
			WebElement element = itr.next();
			String YearText = element.getText();
			if (YearText.equalsIgnoreCase(Year)) {
				element.click();
				break;
			}
		}
	}
	
	public void submitOrder() {
		click(Submit_Order);
		waitForAjaxToComplete();
	}
}