package com.ecm.webautomation.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.ecm.webautomation.common.CommonMethod;
import com.ecm.webautomation.coreng.WebDriverModule;

public class ProductListingPage extends WebDriverModule {

	private final static By Product_Count = By.cssSelector("a[title='Shoes']");
	private final static By Product_Text = By.cssSelector("div[class='page-heading.clearfix']");
	private final static By category = By.cssSelector(".filter-wrapper");
	private final static By categoryName = By.cssSelector(".filtername");
	private final static By allSubCategories = By.cssSelector("li");
	private final static By subCategory = By.cssSelector(".filtervalue");
	private final static By subCategoryCount = By.cssSelector(".hitcount");
	private final static By nextPage=By.cssSelector(".paging-arrow.pagging-next-page");
	private final static By previousPage=By.cssSelector(".paging-arrow pagging-previous-page");
	private final static By productPerPageCountSelection=By.cssSelector("#size_120");
	private final static By numberOfPages=By.cssSelector(".paging-total");
	private final static By ProductTile=By.cssSelector(".title");
	
	private String ProductID;
	private String ProductText;
	private String ProductCount;


	public ProductListingPage(WebDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
	}

	public void getProductText() {
		waitForAjaxToComplete();
		ProductText = getText(Product_Text);
		System.out.println(ProductText);
	}

	public void productCount() {
		ProductCount = getText(Product_Count);
		waitForAjaxToComplete();
		System.out.println(ProductCount);
	}

	public void clickGivenCategorySubCategoryInPLP(String givenCategory, String givenSubCategory) throws InterruptedException {
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
				hitCount = currentCategory.findElement(subCategoryCount).getText().replace("(", "").replace(")", "").trim();
				currentCategory.click();
				break;
			}
		}
		return hitCount;
	}
	
	public void clickNextPage() {
		click(nextPage);
		waitForAjaxToComplete();
	}
	
	public void clickPreviousPage() {
		click(previousPage);
		waitForAjaxToComplete();
	}
	
	public void selectProductsPerPage() {
		click(productPerPageCountSelection);
		waitForAjaxToComplete();
	}
	
	public void selectProduct(String ProductID) {
		clickByCssSelector(ProductID);
	}
	
	public void searchProductToSelect(String ProductID) {
		int count=Integer.parseInt(getPageCount());
		for(int i=0;i<count;i++) {
			List<WebElement> product = findElements(ProductTile);
			java.util.Iterator<WebElement> itr = product.iterator();
			while (itr.hasNext()) {
				WebElement element = itr.next();
				String productText = element.getText();
		if(productText.equalsIgnoreCase(ProductID)){
			element.click();
			waitForAjaxToComplete();
			}
		}
		clickNextPage();
		waitForAjaxToComplete();
		}
	}

	public String getPageCount() {
		String pageCount;
		pageCount = getText(numberOfPages).replace("из", "").trim();
		return pageCount;
		
	}
	
	
//	public void selectSportsFilter(String SportsElement) throws InterruptedException {
//	List<WebElement> sportFilter = findElements(Sprots_Filter);
//	for (WebElement Refinment : sportFilter) {
//		System.out.println(Refinment.getText());
//		if (Refinment.getText().contains(SportsElement)) {
//			Refinment.click();
//			waitForAjaxToComplete();
//			System.out.println("Matches found");
//			// break;
//		} else {
//			System.out.println("Matches not found");
//		}
//	}
//}
//
//public void selectSizeFilter(String SizeElement) throws InterruptedException {
//	List<WebElement> sizeFilter = findElements(Size_Filter);
//	for (WebElement Refinment : sizeFilter) {
//		System.out.println(Refinment.getText());
//		if (Refinment.getText().contains(SizeElement)) {
//			Refinment.click();
//			waitForAjaxToComplete();
//			Thread.sleep(5000);
//			System.out.println("Matches found");
//			// break;
//		} else {
//			System.out.println("Matches not found");
//		}
//	}
//
//}
//
//public void selectGenderFilter(String GenderElement) throws InterruptedException {
//	List<WebElement> genderFilter = findElements(Gender_Filter);
//	for (WebElement Refinment : genderFilter) {
//		System.out.println(Refinment.getText());
//		if (Refinment.getText().contains(GenderElement)) {
//			Refinment.click();
//			waitForAjaxToComplete();
//			Thread.sleep(5000);
//			System.out.println("Matches found");
//			// break;
//		} else {
//			System.out.println("Matches not found");
//		}
//	}
//
//}
}