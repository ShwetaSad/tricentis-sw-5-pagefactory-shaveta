package com.tricentis.demowebshop.testsuite;

import com.tricentis.demowebshop.customerlisteners.CustomerListeners;
import com.tricentis.demowebshop.pages.Homepage;
import com.tricentis.demowebshop.pages.LoginPage;
import com.tricentis.demowebshop.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomerListeners.class)
public class LoginPageTest extends BaseTest {


    Homepage homePage;
    LoginPage loginPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new Homepage();
        loginPage = new LoginPage();
    }


    //1.userShouldNavigateToLoginPageSuccessFully().
    @Test(groups = {"Sanity"})
    public void userShouldNavigateToLoginPageSuccessFully() {

        //Click on the login link
        homePage.clickOnLoginLink();

        //verify that the "Welcome, Please Sign In!" message display
        String expectedMessage = "Welcome, Please Sign In!";
        String actualMessage = loginPage.getWelcomeText();
        Assert.assertEquals(expectedMessage, actualMessage, "Login page not displayed");
    }


    //2. verifyTheErrorMessageWithInValidCredentials()
    @Test(groups = {"Smoke","Regression"})
    public void verifyTheErrorMessageWithInValidCredentials() {

        //Click on the login link
        homePage.clickOnLoginLink();

        //Enter EmailId
        loginPage.enterEmailId("prime@gmail.com");

        //Enter Password
        loginPage.enterPassword("prime123");

        //Click on the Login Button
        loginPage.clickOnLoginButton();

        //Verify that the Error message
        String expectedErrorMessage = "Login was unsuccessful. Please correct the errors and try again.\n"
                + "No customer account found";
        String actualErrorMessage = loginPage.getErrorMessage();
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage, "Error message not displayed");
    }


    //3. verifyThatUserShouldLogInSuccessFullyWithValidCredentials.
    @Test(groups = {"Smoke","Regression"})
    public void verifyThatUserShouldLogInSuccessFullyWithValidCredentials() {


        //Click on the login link
        homePage.clickOnLoginLink();

        //Enter EmailId
        loginPage.enterEmailId("prime1234@gmail.com");

        //Enter Password
        loginPage.enterPassword("Prime123");

        //Click on the Login Button
        loginPage.clickOnLoginButton();

        //Verify that the LogOut link is displayed
     Assert.assertEquals(homePage.VerifyLogoutText(),"Log out","Not logged in");

    }

    //4. VerifyThatUserShouldLogOutSuccessFully()

    @Test(groups = {"Regression"})
    public void VerifyThatUserShouldLogOutSuccessFully() {
        //Click on the login link
        homePage.clickOnLoginLink();

        //Enter EmailId
        loginPage.enterEmailId("prime1234@gmail.com");

        //Enter Password
        loginPage.enterPassword("Prime123");

        //Click on the Login Button
        loginPage.clickOnLoginButton();

        //Click on the LogOut Link
        homePage.clickOnLogOutButton();

        //Verify that the LogIn Link Display
    Assert.assertEquals(loginPage.verifyLoginLink(),"Log in","Not Logged Out");

    }
}