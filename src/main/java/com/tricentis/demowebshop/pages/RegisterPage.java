package com.tricentis.demowebshop.pages;

import com.aventstack.extentreports.Status;
import com.tricentis.demowebshop.customerlisteners.CustomerListeners;
import com.tricentis.demowebshop.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class RegisterPage extends Utility {

    //RegisterPage - Register Text, male-female radio, first name, Lastname, Date of Birth
    //drop-down, email, Password, Confirm Password, Register Button, "First name is required.",
    //"Last name is required.", "Email is required.", "Password is required.", "Password is required."
    //error message, "Your registration completed" message, "CONTINUE" button
    //Locators and their actions

    @CacheLookup
    @FindBy(xpath = "//h1")
    WebElement titleText;

    @CacheLookup
    @FindBy(id = "gender-female")
    WebElement gender;

    @CacheLookup
    @FindBy(id = "FirstName")
    WebElement firstName;

    @CacheLookup
    @FindBy(id = "LastName")
    WebElement lastName;

    @CacheLookup
    @FindBy(id = "Email")
    WebElement email;

    @CacheLookup
    @FindBy(id = "Password")
    WebElement password;

    @CacheLookup
    @FindBy(id = "ConfirmPassword")
    WebElement confirmPassword;

    @CacheLookup
    @FindBy(id = "register-button")
    WebElement registerButton;


    @CacheLookup
    @FindBy(xpath = "//div[@class='result']")
    WebElement registerSuccess;

    @CacheLookup
    @FindBy(xpath = "//input[@value='Continue']")
    WebElement continueBtn;

    @CacheLookup
    @FindBy(xpath = "//span[@for=\"FirstName\"]")
    WebElement firstNameRequired;

    @CacheLookup
    @FindBy(xpath = "//span[@for=\"LastName\"]")
    WebElement lastNemaRequired;

    @CacheLookup
    @FindBy(xpath = "//span[@for=\"Email\"]")
    WebElement emailisRequired;

    @CacheLookup
    @FindBy(xpath = "//span[@for=\"Password\"]")
    WebElement passwordisRequired;

    @CacheLookup
    @FindBy(xpath = "//span[@for=\"ConfirmPassword\"]")
    WebElement confirmPasswordisRequired;

    @CacheLookup
    @FindBy(xpath = "//div[@class=\"result\"]")
    WebElement registrationSuccessfullText;

    public String registrationsuccessfullText(){
        CustomerListeners.test.log(Status.PASS,"registrationsuccessfullText");
        Reporter.log("registrationsuccessfullText");
        return getTextFromElement(registrationSuccessfullText);
    }

    public String  firstNameIsRequired(){
        CustomerListeners.test.log(Status.PASS,"First Name is Required");
        Reporter.log("First NAme is Required");
        return getTextFromElement(firstNameRequired);
    }
    public String  lastNameIsRequired(){
        CustomerListeners.test.log(Status.PASS,"Last Name is Required");
        Reporter.log("Last Name is Required");
        return getTextFromElement(lastNemaRequired);
    }
    public String  emailIsRequired(){
        CustomerListeners.test.log(Status.PASS,"Email is Required");
        Reporter.log("Email is Required");
        return getTextFromElement(emailisRequired);
    }
    public String  PasswordIsRequired(){
        CustomerListeners.test.log(Status.PASS,"Password is Required");
        Reporter.log("Password is Reuired");
        return getTextFromElement(passwordisRequired);
    }
    public String  confirmPasswordIsRequired(){
        CustomerListeners.test.log(Status.PASS,"ConfirmPassword is Required");
        Reporter.log("Confirm PAssword is required");
        return getTextFromElement(confirmPasswordisRequired);
    }

    public String registerPageTitle() {
        CustomerListeners.test.log(Status.PASS, "Register Page Title");
        Reporter.log("Register Page Title");
        return getTextFromElement(titleText);
    }

    public void clickOnGender() {
        clickOnElement(gender);
        CustomerListeners.test.log(Status.PASS, "Click on Gender");
        Reporter.log("Click on Gender");
    }

    public void enterFirstName(String name) {
        sendTextToElement(firstName, name);
        CustomerListeners.test.log(Status.PASS, "Enter FirstName");
        Reporter.log("Enter First Name");
    }

    public void enterLastName(String name) {
        sendTextToElement(lastName, name);
        CustomerListeners.test.log(Status.PASS, "Enter LastName");
        Reporter.log("Enter LastName");
    }

    public void enterEmailAddress(String Email) {
        sendTextToElement(email, Email);
        CustomerListeners.test.log(Status.PASS, "Enter EmailAddress");
        Reporter.log("Enter Email");
    }

    public void enterPassword(String pass) {
        sendTextToElement(password, pass);
        CustomerListeners.test.log(Status.PASS, "Enter Password");
        Reporter.log("Enter Password");
    }

    public void enterConfirmPassword(String confirmPass) {
        sendTextToElement(confirmPassword, confirmPass);
        CustomerListeners.test.log(Status.PASS, "Enter Confirm Password");
        Reporter.log("Enter Confirm Password");
    }

    public void clickOnRegisterButton() {
        clickOnElement(registerButton);
        CustomerListeners.test.log(Status.PASS, "Click on Register Button");
        Reporter.log("Click on Register Button");
    }

    public String getRegisterSuccessMessage() {
        CustomerListeners.test.log(Status.PASS, "Register Success Message");
        Reporter.log("Register Success Message");
        return getTextFromElement(registerSuccess);

    }

    public void clickOnContinueButton() {
        clickOnElement(continueBtn);
        CustomerListeners.test.log(Status.PASS, "Click on Continue Button");
        Reporter.log("Click on Continue Button");

    }
}

