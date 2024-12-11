package com.tricentis.demowebshop.pages;

import com.aventstack.extentreports.Status;
import com.tricentis.demowebshop.customerlisteners.CustomerListeners;
import com.tricentis.demowebshop.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class DesktopPage extends Utility {

    //4.DesktopsPage - Desktops text, Sortby, Display, selectProductList Locators and it's actions

    @CacheLookup
    @FindBy(xpath = "//li[@class=\"active\"]//a[normalize-space()=\"Desktops\"]")
    WebElement desktopTab;

    @CacheLookup
    @FindBy(xpath = "//h1[normalize-space()=\"Desktops\"]")
    WebElement desktopText;


    public void clickOnDesktop(){
        clickOnElement(desktopTab);
        CustomerListeners.test.log(Status.PASS,"Desktp Tab");
        Reporter.log("click on Desktop");
    }

    public String desktopText(){
        CustomerListeners.test.log(Status.PASS,"Desktp Text");
        Reporter.log("DesktopText");
        return getTextFromElement(desktopText);
    }
}
