package com.ecm.webautomation.pages;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ecm.webautomation.coreng.WebDriverModule;

public class ProductDetailPage extends WebDriverModule {

	private final static By Size_Drop_Down=By.cssSelector(".size-dropdown-block");
	private final static By Select_Size=By.cssSelector("ul[data-cts='500']>li>span");
	private final static By select_Size_Text=By.cssSelector("span[data-val]");
	private final static By Quantity_Drop_Down=By.cssSelector(".quantity-dropdown");
	private final static By Select_Quantity=By.cssSelector("ul[data-cts='500']>li>span");
	private final static By Add_To_Cart=By.className("buttons-container-outer");
	private final static By View_Cart=By.xpath("//div[@aria-labelledby='ui-dialog-title-dialogcontainer_overlay']/div[2]/div/div[2]/a");
	
	public ProductDetailPage(WebDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
	}
	
	public void selectSize(String ProductSize) {
		waitForAjaxToComplete();
		click(Size_Drop_Down);
		for (WebElement currentSize : findElements(Select_Size)) {
			System.out.println(currentSize);
			if (ProductSize.equalsIgnoreCase(currentSize.findElement(Select_Size).getText().trim())) {
				currentSize.click();
				waitForAjaxToComplete();
			}
		}
	}
	
	public void selectQuanity(String Quantity) {
		waitForAjaxToComplete();
		for(WebElement currentQuanitity:findElements(Quantity_Drop_Down)) {
			if(Quantity.equalsIgnoreCase(currentQuanitity.findElement(Select_Quantity).getText().trim())) {
				currentQuanitity.click();
				waitForAjaxToComplete();
			}
		}
	}
	
	public void selectProductSize(String ProductSize) {
		waitForAjaxToComplete();
		click(Size_Drop_Down);
		List<WebElement> Sizes = findElements(Select_Size);
		java.util.Iterator<WebElement> itr = Sizes.iterator();
		while (itr.hasNext()) {
			WebElement element = itr.next();
			String categoryText = element.getText();
			if (categoryText.equalsIgnoreCase(ProductSize)) {
				element.click();
				break;
			}
		}

	}
	
	public void selectProductQuantity(String Quantity) {
		waitForAjaxToComplete();
		click(Quantity_Drop_Down);
		List<WebElement> Quantities = findElements(Select_Quantity);
		System.out.println(Quantities.size());
		java.util.Iterator<WebElement> itr = Quantities.iterator();
		while (itr.hasNext()) {
			WebElement element = itr.next();
			String categoryText = element.getText();
			if (categoryText.equalsIgnoreCase(Quantity)) {
				element.click();
				break;
			}
		}

	}
	
	public void addToCart() {
		click(Add_To_Cart);
	}
	
	public void viewCart() {
		waitForAjaxToComplete();
		click(View_Cart);
	}
	
}