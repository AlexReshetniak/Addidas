package com.ecm.webautomation.modules;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ecm.webautomation.coreng.WebDriverModule;
import com.ecm.webautomation.pages.HomePage;
import com.ecm.webautomation.pages.ProductDetailPage;
import com.ecm.webautomation.pages.ProductListingPage;
import com.ecm.webautomation.pages.SearchResultPage;

public class ShopNav extends WebDriverModule {

	private HomePage homepage=new HomePage(webDriver);
	private ProductListingPage productListingPage=new ProductListingPage(webDriver);
	private SearchResultPage searchResultPage=new SearchResultPage(webDriver);
	private ProductDetailPage productDetailPage=new ProductDetailPage(webDriver);
	private final static By productTile=By.cssSelector(".product-tile");
	private final static By ProductTileText=By.cssSelector(".title");
		
	
	public ShopNav(WebDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
	}
	
	public void selectProductFromProductID(String ProductID) {
		for (WebElement currentProduct : findElements(productTile)) {
			System.out.println(currentProduct.getAttribute("id"));
		if (ProductID.equalsIgnoreCase(currentProduct.getAttribute("id"))){
			currentProduct.click();
			waitForAjaxToComplete();
		}
		else{
			productListingPage.clickNextPage();
			}
		}
	}
	
	public void selectProductFromtext(String GivenProduct) {
		for (WebElement currentProduct : findElements(productTile)) {
			if (GivenProduct.equalsIgnoreCase(currentProduct.findElement(ProductTileText).getText())) {
				currentProduct.click();
				waitForAjaxToComplete();
			}
			else {
				productListingPage.clickNextPage();
			}

		}
	
	}
}
