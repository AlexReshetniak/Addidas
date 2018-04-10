package com.ecm.webautomation.common;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.ecm.webautomation.coreng.WebDriverModule;

public class CommonMethod extends WebDriverModule {
	
	Actions action=new Actions(webDriver);

	public CommonMethod(WebDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
	}

	public void berforMethod(String URL) {
		deleteAllCookies();
		openUrl(URL);
		windowMaximize();
	}
	
	public void hoverNavigationMenu(String navigationMenu, By Locator) {
        for (WebElement menu : findElements(Locator)) {
            if (menu.getText().trim().equalsIgnoreCase(navigationMenu)) {
                action.moveToElement(menu).build().perform();
                waitForAjaxToComplete();
                break;
            }
        }
    }
	
	public void hoverNavigationMenu(WebElement navigationMenu) {
          action.moveToElement(navigationMenu).build().perform();
                waitForAjaxToComplete();

        
    }
	
//	public void hoverNavigationMenuAndClickSubMenu(String navigationMenu, String navigationSubMenu) {
//        for (WebElement menu : findElements(allNavigationMenu)) {
//            if (menu.getText().trim().equalsIgnoreCase(navigationMenu)) {
//                action.moveToElement(menu).build().perform();
//                for (WebElement subMenu : findElements(subMenuList)) {
//                    if (subMenu.getText().trim().equalsIgnoreCase(navigationSubMenu)) {
//                    	action.moveToElement(subMenu).build().perform();
//                        waitForAjaxToComplete();
//                        break;
//                    }
//                }
//                break;
//            }
//        }
//    }

}
