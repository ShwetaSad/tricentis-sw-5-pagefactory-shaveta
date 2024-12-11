package com.tricentis.demowebshop.testsuite;

import com.tricentis.demowebshop.customerlisteners.CustomerListeners;
import com.tricentis.demowebshop.pages.Homepage;
import com.tricentis.demowebshop.pages.LoginPage;
import com.tricentis.demowebshop.pages.RegisterPage;
import com.tricentis.demowebshop.testbase.BaseTest;
import org.checkerframework.checker.units.qual.A;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomerListeners.class)
public class RegisterPageTest extends BaseTest {

    Homepage homepage;
    LoginPage loginPage;
    RegisterPage registerPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homepage = new Homepage();
        loginPage = new LoginPage();
        registerPage = new RegisterPage();

    }
    //1. verifyUserShouldNavigateToRegisterPageSuccessfully()

    @Test(groups = {"Sanity"})
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {


        //Click on the Register Link
        homepage.clickOnRegisterLink();

        //Verify "Register" text
        Assert.assertEquals(registerPage.registerPageTitle(), "Register", "Wrong Page");

    }

    //verifyThatFirstNameLastNameEmailPasswordAndConfirmPasswordFieldsAreMandatory(

    @Test(groups = {"Smoke,Regression"})
    public void verifyThatFirstNameLastNameEmailPasswordAndConfirmPasswordFieldsAreMandatory() {

        //Click on the Register Link
        homepage.clickOnRegisterLink();

        //Click on the "Register" button
        registerPage.clickOnRegisterButton();

        //Verify the error message "First name is required."
        Assert.assertEquals(registerPage.firstNameIsRequired(), "First name is required.");

        //Verify the error message "Last name is required."
        Assert.assertEquals(registerPage.lastNameIsRequired(), "Last name is required.");

        //Verify the error message "Email is required."
        Assert.assertEquals(registerPage.emailIsRequired(), "Email is required.");

        //Verify the error message "Password is required."
        Assert.assertEquals(registerPage.PasswordIsRequired(), "Password is required.");

        //Verify the error message "Password is required."
        Assert.assertEquals(registerPage.confirmPasswordIsRequired(), "Password is required.");

    }

    //2. verifyThatUserShouldCreateAccountSuccessfully()
    @Test(groups = {"Regression"})
    public void verifyThatUserShouldCreateAccountSuccessfully() {

        //Click on the Register Link
        homepage.clickOnRegisterLink();

        //Select gender "Female"
        registerPage.clickOnGender();

        //Enter the first name
        registerPage.enterFirstName("Shaveta");

        //Enter the last name
        registerPage.enterLastName("sethi");

        //Enter email
        registerPage.enterEmailAddress("sethiss@gmail.com");

        //Enter password
        registerPage.enterPassword("Sethi123");

        //Enter Confirm Password
        registerPage.enterConfirmPassword("Sethi123");

        //Click on the "Register" button
        registerPage.clickOnRegisterButton();

        //Verify the message "Your registration completed"
        Assert.assertEquals(registerPage.registrationsuccessfullText(),"Your registration completed","Registration not complete");
    }
}