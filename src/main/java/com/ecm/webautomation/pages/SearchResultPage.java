package com.ecm.webautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ecm.webautomation.coreng.WebDriverModule;

public class SearchResultPage extends WebDriverModule {

	private final static By Gender_Mens = By.xpath("//ul[@data-filtername='gender']/li");
	private final static By Product_Count = By.cssSelector("a[title='Shoes']");
	private final static By Product_Text = By.cssSelector("div[class='page-heading.clearfix']");
	private final static By category = By.cssSelector(".filter-wrapper");
	private final static By categoryName = By.cssSelector(".filtername");
	private final static By allSubCategories = By.cssSelector("li");
	private final static By subCategory = By.cssSelector(".filtervalue");
	private final static By subCategoryCount = By.cssSelector(".hitcount");
	private String ProductText;
	private String ProductCount;
	
	public SearchResultPage(WebDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
	}
	
	public void getProductText() {
		waitForAjaxToComplete();
		ProductText = getText(Product_Text);
		System.out.println(ProductText);
	}

	public void selectGender() {
		click(Gender_Mens);
		waitForAjaxToComplete();
	}

	public void productCount() {
		ProductCount = getText(Product_Count);
		waitForAjaxToComplete();
		System.out.println(ProductCount);
	}

	public void clickGivenCategorySubCategoryInSRP(String givenCategory, String givenSubCategory) throws InterruptedException {
		for (WebElement currentCategory : findElements(category)) {
			if (givenCategory.equalsIgnoreCase(currentCategory.findElement(categoryName).getText())) {
				clickGivenSubCategory(currentCategory, givenSubCategory);
				waitForAjaxToComplete();
			}

		}
	}

	private String clickGivenSubCategory(WebElement categoryElement, String givenSubCategory) {
		String hitCount = "";
		for (WebElement currentCategory : categoryElement.findElements(allSubCategories)) {
			if (givenSubCategory.equalsIgnoreCase(currentCategory.findElement(subCategory).getText())) {
				hitCount = currentCategory.findElement(subCategoryCount).getText().replace("(", "").replace(")", "")
						.trim();
				currentCategory.click();
				break;
			}
		}
		return hitCount;
	}



}
