package com.ecm.webautomation.tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ecm.webautomation.common.CommonMethod;
import com.ecm.webautomation.common.ConfigurationReader;
import com.ecm.webautomation.coreng.WebDriverTestNGModule;
import com.ecm.webautomation.modules.ShopNav;
import com.ecm.webautomation.pages.AddressReviewPage;
import com.ecm.webautomation.pages.CartPage;
import com.ecm.webautomation.pages.DeliveryPage;
import com.ecm.webautomation.pages.HeaderAndFooter;
import com.ecm.webautomation.pages.HomePage;
import com.ecm.webautomation.pages.PaymentPage;
import com.ecm.webautomation.pages.ProductDetailPage;
import com.ecm.webautomation.pages.ProductListingPage;
import com.ecm.webautomation.pages.SearchResultPage;

public class MyAssessmentTestCases extends WebDriverTestNGModule {

	private AddressReviewPage addressReviewPage;
	private CartPage cartPage;
	private DeliveryPage deliveryPage;
	private HomePage homePage;
	private PaymentPage paymentPage;
	private ProductDetailPage productDetailsPage;
	private ProductListingPage productListingPage;
	private CommonMethod commonMethod;
	private HeaderAndFooter headerAndFooter;
	private SearchResultPage searchResultPage;
	private ShopNav shopNav;
		
	private String ID=ConfigurationReader.get("ID");
	private String Text=ConfigurationReader.get("Text");
	private String FName=ConfigurationReader.get("FName");
	private String LName=ConfigurationReader.get("LName");
	private String City=ConfigurationReader.get("City");
	private String Zipcode=ConfigurationReader.get("Zipcode");
	private String Address1=ConfigurationReader.get("Address1");
	private String HouseNo=ConfigurationReader.get("HouseNo");
	private String AppratNo=ConfigurationReader.get("AppratNo");
	private String PhoneNo=ConfigurationReader.get("PhoneNo");
	private String Address2=ConfigurationReader.get("Address2");
	private String Email=ConfigurationReader.get("Email");
	private String CCNumber=ConfigurationReader.get("CCNumber");
	private String CCName=ConfigurationReader.get("CCName");
	private String CVV=ConfigurationReader.get("CVV");
	private String Month=ConfigurationReader.get("Month");
	private String Year=ConfigurationReader.get("Year");
	private String URL=ConfigurationReader.get("URL");
	private String SportsElement=ConfigurationReader.get("SportsElement");
	private String GenderElement=ConfigurationReader.get("GenderElement");
	private String SizeElement=ConfigurationReader.get("SizeElement");
	private String givenCategory=ConfigurationReader.get("givenCategory");
	private String givenSubCategory=ConfigurationReader.get("givenSubCategory");
	private String l1Category_MegaMenu=ConfigurationReader.get("l1Category_MegaMenu");
	private String l2SubCategory_MegaMenu=ConfigurationReader.get("l2SubCategory_MegaMenu");
	private String l3SubCategory_MegaMenu=ConfigurationReader.get("l3SubCategory_MegaMenu");
	private String listOfCategories=ConfigurationReader.get("listOfCategories");
	private String ProductID=ConfigurationReader.get("ProductID");
	private String GivenProduct=ConfigurationReader.get("GivenProduct");
	private String ProductSize=ConfigurationReader.get("ProductSize");
	private String Quantity=ConfigurationReader.get("Quantity");
	
	@BeforeMethod(alwaysRun = true)
	public void beforeMethod() {
		commonMethod = new CommonMethod(webDriver);
		addressReviewPage=new AddressReviewPage(webDriver);
		cartPage=new CartPage(webDriver);
		deliveryPage=new DeliveryPage(webDriver);
		homePage=new HomePage(webDriver);
		paymentPage= new PaymentPage(webDriver);
		productDetailsPage=new ProductDetailPage(webDriver);
		productListingPage=new ProductListingPage(webDriver);
		headerAndFooter=new HeaderAndFooter(webDriver);
		searchResultPage=new SearchResultPage(webDriver);
		shopNav=new ShopNav(webDriver);
		commonMethod.berforMethod(URL);
	}
	
	@Test(groups="GuestUserCheckout", description = "[Checkout] - Guest User Checkout", enabled =true)
	public void guestUserCheckout() {
		homePage.closePopUp();
		homePage.searchProduct(ID);
		productDetailsPage.selectProductSize(ProductSize);
		productDetailsPage.selectProductQuantity(Quantity);
		productDetailsPage.addToCart();
		productDetailsPage.viewCart();
		cartPage.checkoutFromCart();
		deliveryPage.fillAddress(FName, LName, City, Zipcode, Address1, HouseNo, AppratNo, PhoneNo, Address2, Email);
		deliveryPage.CheckoutProduct();
		addressReviewPage.continueCheckout();
		paymentPage.selectPaymentMethod();
		paymentPage.enterCCDetails(CCNumber, CCName, CVV, Month, Year);
		paymentPage.submitOrder();
	}
	
	@Test(groups="SearchText", description = "[ShopNav] - Search Flow", enabled=true)
	public void searchText() throws InterruptedException {
		homePage.closePopUp();
		homePage.searchByText(Text);
//		searchResultPage.clickGivenCategorySubCategoryInSRP(givenCategory, givenSubCategory);
//		shopNav.selectProductFromProductID(ProductID);
		shopNav.selectProductFromtext(GivenProduct);

	}
	
	@Test(groups="BreadCrumbText", description = "[ShopNav] - Breadcrum verification", enabled=true)
	public void breadCrumbText() throws InterruptedException {
		homePage.closePopUp();
		headerAndFooter.clickGivenCategoryFromMegaMenu1(l1Category_MegaMenu, l2SubCategory_MegaMenu, l3SubCategory_MegaMenu);
		Thread.sleep(5000);
		productListingPage.clickGivenCategorySubCategoryInPLP(givenCategory, givenSubCategory);
		Thread.sleep(5000);
		productListingPage.searchProductToSelect(GivenProduct);
		productDetailsPage.selectProductSize(ProductSize);
		productDetailsPage.selectProductQuantity(Quantity);
//		shopNav.selectProductFromtext(GivenProduct);
	}

}
