package com.tricentis.demowebshop.pages;

import com.aventstack.extentreports.Status;
import com.tricentis.demowebshop.customerlisteners.CustomerListeners;
import com.tricentis.demowebshop.utilities.Utility;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.security.cert.X509Certificate;

public class LoginPage extends Utility {
    //1.LoginPage - Email, password, Login Button, and "Welcome, Please Sign In!" text Locators
    //and create appropriate methods for it.


    @CacheLookup
    @FindBy(xpath = "//h1[normalize-space()=\"Welcome, Please Sign In!\"]")
    WebElement welcomeText;

    @CacheLookup
    @FindBy(id = "Email")
    WebElement emailField;

    @CacheLookup
    @FindBy(name = "Password")
    WebElement passwordField;

    @CacheLookup
    @FindBy(xpath = "//input[@value = 'Log in']")
    WebElement loginButton;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'validation-summary-errors']")
    WebElement errorMessage;

    @CacheLookup
    @FindBy(xpath = "//a[@class=\"ico-login\"]")
    WebElement loginText;




    public String getWelcomeText() {
        CustomerListeners.test.log(Status.PASS,"Get Welcome Text");
        Reporter.log("Welcome Text");
        return getTextFromElement(welcomeText);
    }

    public void enterEmailId(String email) {
        sendTextToElement(emailField, email);
        CustomerListeners.test.log(Status.PASS, "Enter EmailId " + email);
        Reporter.log("Enter Email");
    }

    public void enterPassword(String password) {
        sendTextToElement(passwordField, password);
        CustomerListeners.test.log(Status.PASS, "Enter password " + password);
        Reporter.log("Enter Password");
    }

    public void clickOnLoginButton() {
        clickOnElement(loginButton);
        CustomerListeners.test.log(Status.PASS, "Click on loginButton");
        Reporter.log("Click on Login");
    }

    public String getErrorMessage() {
        CustomerListeners.test.log(Status.PASS, "Error Message");
        Reporter.log("Error Message");
        return getTextFromElement(errorMessage);

    }
    public String verifyLoginLink(){
        CustomerListeners.test.log(Status.PASS,"Verify Login Link");
        Reporter.log("Verify Login Link");
        return getTextFromElement(loginText);
    }

}

