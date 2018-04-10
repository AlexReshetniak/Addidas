package com.ecm.webautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.ecm.webautomation.coreng.WebDriverModule;

public class HomePage extends WebDriverModule {

	private final static By Search_Box = By.cssSelector("input[name='q']");
	private final static By PopUp_Close = By.xpath("//span[@id='ui-dialog-title-dialogcontainer']/parent::div/a");
	private final static By Category_Men = By.cssSelector(".nav-button > a[href$='muzhchiny']");
	private final static By SubCategory_Men = By.cssSelector("a[href$='muzhchiny-vysokie_krossovki']");

	

	public HomePage(WebDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
	}

	public void closePopUp() {
		click(PopUp_Close);
	}

	public void searchProduct(String ID) {
		click(Search_Box);
		typeInAndPressEnter(Search_Box, ID);
		waitForAjaxToComplete();
	}

	public void searchByText(String Text) {
		click(Search_Box);
		typeInAndPressEnter(Search_Box, Text);
		waitForAjaxToComplete();
	}

	public void categoryHover() throws InterruptedException {
		waitForAjaxToComplete();
		moveToElement(findElement(Category_Men));
		Thread.sleep(5000);
		moveToElement(findElement(SubCategory_Men));
		click(SubCategory_Men);
		waitForAjaxToComplete();

	}
}



//	public void clickGivenCategoryFromMegaMenu(String givenL1Category) throws InterruptedException {
//		for (WebElement currentCategory : findElements(l1Category_MegaMenu)) {
//			if (givenL1Category.equalsIgnoreCase(currentCategory.findElement(l1Category_Name).getText())) {
//				currentCategory.click();
//				waitForAjaxToComplete();
//			}
//		}
//	}
//
//	public void clickGivenCategoryFromMegaMenu(String givenL1Category, String givenL2SubCategory)
//			throws InterruptedException {
//		for (WebElement currentCategory : findElements(l1Category_MegaMenu)) {
//			if (givenL1Category.equalsIgnoreCase(currentCategory.findElement(l1Category_Name).getText())) {
//				commonMethod.hoverNavigationMenu(currentCategory.getText(), l1Category_MegaMenu);
//				for (WebElement currentSubCategory : findElements(l2SubCategory_MegaMenu)) {
//					if(givenL2SubCategory.equalsIgnoreCase(currentSubCategory.getText())) {
//						currentSubCategory.click();
//						waitForAjaxToComplete();
//					}
//				}
//			}
//		}
//	}
//
//	public void clickGivenCategoryFromMegaMenu(String givenL1Category, String givenL2SubCategory, String givenL3SubCategory)
//			throws InterruptedException {
//		for (WebElement currentCategory : findElements(l1Category_MegaMenu)) {
//			if (givenL1Category.equalsIgnoreCase(currentCategory.findElement(l1Category_Name).getText())) {
//				commonMethod.hoverNavigationMenu(currentCategory.getText(), l1Category_MegaMenu);
//				for (WebElement currentSubCategory : findElements(l2SubCategory_MegaMenu)) {
//					if(givenL2SubCategory.equalsIgnoreCase(currentSubCategory.getText())) {
//						commonMethod.hoverNavigationMenu(currentSubCategory.getText(), l2SubCategory_MegaMenu);
//						for(WebElement currentL3SubCategory : findElements(allSubCategory_MegaMenu)) {
//							if(givenL3SubCategory.equalsIgnoreCase(currentL3SubCategory.getText().trim())) {
//								currentL3SubCategory.click();
//								waitForAjaxToComplete();
//							}
//						}
//					}
//				}
//			}
//		}
//	}



