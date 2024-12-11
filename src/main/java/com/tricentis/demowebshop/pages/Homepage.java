package com.tricentis.demowebshop.pages;

import com.aventstack.extentreports.Status;
import com.tricentis.demowebshop.customerlisteners.CustomerListeners;
import com.tricentis.demowebshop.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class Homepage extends Utility {

    //2.HomePage - All Menu (Seven menus), LoginLink, registerLink, , My
    //account link, and LogOut link locatores
    //and create appropriate methods for it.

    @CacheLookup
    @FindBy(linkText = "Log in")
    WebElement loginLink;


    @CacheLookup
    @FindBy(linkText = "Register")
    WebElement registerLink;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Log out']")
    WebElement logout;

    @CacheLookup
    @FindBy(xpath = "//a[@class=\"ico-logout\"]")
    WebElement logoutText;



    public void clickOnLoginLink() {
        clickOnElement(loginLink);
        CustomerListeners.test.log(Status.PASS, "Clicking on Login Link");
        Reporter.log("Click on Login Link");
    }

    public void clickOnRegisterLink() {
        clickOnElement(registerLink);
        CustomerListeners.test.log(Status.PASS, "Clicking on register Link");
        Reporter.log("Click on register Link");
    }

    public void clickOnLogOutButton() {
        clickOnElement(logout);
        CustomerListeners.test.log(Status.PASS, "Clicking on Logout Link");
        Reporter.log("Click on Logout Link");
    }

    public String VerifyLogoutText(){
        Reporter.log("Verify Logout Text");
        CustomerListeners.test.log(Status.PASS, "Logout Text");
        return getTextFromElement(logoutText);

    }

}
