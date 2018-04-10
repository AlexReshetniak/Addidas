package com.ecm.webautomation.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.ecm.webautomation.common.CommonMethod;
import com.ecm.webautomation.coreng.WebDriverModule;

public class HeaderAndFooter extends WebDriverModule {

	private CommonMethod commonMethod = new CommonMethod(webDriver);
	private final static By l1Category_MegaMenu = By.cssSelector(".flyout");
	private final static By l1Category_Name = By.cssSelector(".top-cat-link");
	private final static By l2SubCategory_MegaMenu = By.cssSelector(".headline");
	private final static By l3SubCategory_MegaMenu = By.xpath("//div[@class='col-5']/ul/li/a");

	public HeaderAndFooter(WebDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
	}

	public void clickGivenCategoryFromMegaMenu(String... listOfCategories) {

		Object[] Category = listOfCategories;
		int CategoryLength = Category.length;
		String InputCategoryName = null;
		for (int n = 0; n < Category.length; n++) {
			
			InputCategoryName = (String) Category[n];
			if (n != CategoryLength - 1) {
				hoverCategory(getInPutCategory(InputCategoryName), InputCategoryName);
			} else {
				clickCategory(getInPutCategory(InputCategoryName), InputCategoryName);
			}
		}

	}

	public By getInPutCategory(String Category) {
		By locator = null;
		HashMap<String, By> hm = new HashMap<>();
		hm.put("l1Category_MegaMenu", l1Category_MegaMenu);
		hm.put("l1Category_Name", l1Category_Name);
		hm.put("l2SubCategory_MegaMenu", l2SubCategory_MegaMenu);
		hm.put("l3SubCategory_MegaMenu", l3SubCategory_MegaMenu);

		for (Map.Entry<String, By> mp : hm.entrySet()) {
			if (mp.getKey().equalsIgnoreCase(Category)) {
				locator = mp.getValue();
			}

		}
		return locator;
	}

	public void clickCategory(By categorylocator, String CategoryName) {
		List<WebElement> categories = findElements(categorylocator);
		java.util.Iterator<WebElement> itr = categories.iterator();
		while (itr.hasNext()) {
			WebElement element = itr.next();
			String categoryText = element.getText();
			if (categoryText.equalsIgnoreCase(CategoryName)) {
				element.click();
				break;
			}
		}

	}

	public void hoverCategory(By categorylocator, String CategoryName) {
		List<WebElement> categories = findElements(categorylocator);
		java.util.Iterator<WebElement> itr = categories.iterator();
		while (itr.hasNext()) {
			WebElement element = itr.next();
			String categoryText = element.getText();
			if (categoryText.equalsIgnoreCase(CategoryName)) {
				commonMethod.hoverNavigationMenu(element);
			}
		}

	}

	public void clickGivenCategoryFromMegaMenu1(String... listOfCategories) {
		Object[] Category = listOfCategories;
		if (Category.length == 1) {
			for (WebElement currentCategory : findElements(l1Category_MegaMenu)) {
				if (((String) Category[0]).equalsIgnoreCase(currentCategory.findElement(l1Category_Name).getText())) {
					currentCategory.click();
					waitForAjaxToComplete();
				}
			}
		}
		if (Category.length == 2) {
			for (WebElement currentCategory : findElements(l1Category_MegaMenu)) {
				if (((String) Category[0]).equalsIgnoreCase(currentCategory.findElement(l1Category_Name).getText())) {
					commonMethod.hoverNavigationMenu(currentCategory.getText(), l1Category_MegaMenu);
					for (WebElement currentSubCategory : findElements(l2SubCategory_MegaMenu)) {
						if (((String) Category[1]).equalsIgnoreCase(currentSubCategory.getText())) {
							currentSubCategory.click();
							waitForAjaxToComplete();
						}
					}
				}
			}
		}
		if (Category.length == 3)
			for (WebElement currentCategory : findElements(l1Category_MegaMenu)) {
				if (((String) Category[0]).equalsIgnoreCase(currentCategory.findElement(l1Category_Name).getText())) {
					commonMethod.hoverNavigationMenu(currentCategory.getText(), l1Category_MegaMenu);
					for (WebElement currentSubCategory : findElements(l2SubCategory_MegaMenu)) {
						if (((String) Category[1]).equalsIgnoreCase(currentSubCategory.getText())) {
							commonMethod.hoverNavigationMenu(currentSubCategory.getText(), l2SubCategory_MegaMenu);
							for (WebElement currentL3SubCategory : findElements(l3SubCategory_MegaMenu)) {
								if (((String) Category[2]).equalsIgnoreCase(currentL3SubCategory.getText().trim())) {
									currentL3SubCategory.click();
									waitForAjaxToComplete();
									continue;
								}
							}
						}
					}
				}
			}
	}
	
    public void navigateTo(String... listOfCategories) throws InterruptedException {
        Thread.sleep(5000);
        for (int i=0; i<listOfCategories.length; i++) {
            Actions a = new Actions(webDriver);
            if ( i<listOfCategories.length-1) {
            a.moveToElement(findElement(
                    By.xpath("//a[contains(text(),'" + listOfCategories[i] + "')]"))).build().perform();
            }
            else {
                a.moveToElement(findElement(
                        By.xpath("//a[contains(text(),'" + listOfCategories[i] + "')]"))).click().build().perform();
            }
            Thread.sleep(5000);
        }
        waitForAjaxToComplete();

    }

	// public void clickGivenCategoryFromMegaMenu2(String... listOfCategories) {
	//
	// Object[] Category = listOfCategories;
	// int CategoryLength = Category.length;
	// WebElement currentCategory = null;
	// String CategoryText = null;
	// String InputCategory = null;
	//
	// for (int n = 0; n < Category.length; n++) {
	// String category = "Cat" + Integer.toString(n);
	// System.out.println("Category is " + category);
	// InputCategory = (String) Category[n];
	// currentCategory = findElement(By.cssSelector(Cat0));
	// CategoryText = currentCategory.getText();
	//
	// if (n != CategoryLength - 1) {
	// if (CategoryText.equalsIgnoreCase(InputCategory)) {
	// commonMethod.hoverNavigationMenu(currentCategory.getText(),
	// By.cssSelector(Cat0));
	// waitForAjaxToComplete();
	// }
	// } else if (n == CategoryLength - 1) {
	// clickCategory(l1Category_MegaMenu, InputCategory);
	// waitForAjaxToComplete();
	// }
	// }
	// }

}
