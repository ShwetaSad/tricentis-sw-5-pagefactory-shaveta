package com.tricentis.demowebshop.testsuite;

import com.tricentis.demowebshop.customerlisteners.CustomerListeners;
import com.tricentis.demowebshop.pages.*;
import com.tricentis.demowebshop.testbase.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import resources.testdata.Testdata;

@Listeners(CustomerListeners.class)
public class ComputerPageTest extends BaseTest {

    Homepage homepage;
    LoginPage loginPage;
    RegisterPage registerPage;
    ComputerPage computerPage;
    DesktopPage desktopPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homepage = new Homepage();
        loginPage = new LoginPage();
        registerPage = new RegisterPage();
        computerPage = new ComputerPage();
        desktopPage = new DesktopPage();
    }

    //1. verifyUserShouldNavigateToComputerPageSuccessfully()
    @Test(groups = {"Sanity"})
    public void verifyUserShouldNavigateToComputerPageSuccessfully() {

        //Click on the COMPUTER tab
        computerPage.clickOnComuter();

        //Verify "Computer" text
        Assert.assertEquals(computerPage.ComputerText(), "Computers", "Wrong Page");


    }

    //2. verifyUserShouldNavigateToDesktopsPageSuccessfully()

    @Test(groups = {"Smoke", "Regression"})
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        //Click on the COMPUTER tab
        computerPage.clickOnComuter();
        ;

        //Click on the Desktops link
        desktopPage.clickOnDesktop();

        //Verify "Desktops" text
        Assert.assertEquals(desktopPage.desktopText(), "Desktops", "Wrong Page");
    }

    //3. verifyThatUserShouldBuildYouOwnComputerAndAddThemToCartSuccessfully(String
    //processor, String ram, String hdd, String os, String software)

    @Test( dataProvider = "Data",dataProviderClass = Testdata.class)
    public void verifyThatUserShouldBuildYouOwnComputerAndAddThemToCartSuccessfully(String processor, String ram, String hdd, String os, String software) {

        //Click on the COMPUTER tab
        computerPage.clickOnComuter();

        //Click on the Desktops link
        desktopPage.clickOnDesktop();

        //Click on the product name "Build your own computer"
        computerPage.clickOnBuildyourownComputer();
        //Select processor "processor"
        computerPage.setSelectprocessorfromDropdown(processor);
        //Select RAM "ram"
        computerPage.setSelectRamFromDropdown(ram);
        //Select HDD "hdd"
        if (hdd == "320GB") {
            computerPage.selectHDD320();
        } else {
            computerPage.selectHDD400();
        }

        //Select OS "os"
        if (os == "Ubuntu") {
            computerPage.SelectOSUbuntu();
        } else if (os == "Window7[+50.00]") {
            computerPage.SelectOSWindows7();
        } else if (os == "Windows10[+60.00]") {
            computerPage.SelectWindows10();
        }

        //Select Software "software"
        if (software == "Microsft office[+50.00]") {
            computerPage.SelectSoftwareMicrosoftOffice();
        } else if (software == "Acrobat Reader[+10.00]") {
            computerPage.SelectSoftwareAcrobatReader();
        } else if (software == "Total Commander[+5.00]") {
            computerPage.SelectSoftwareTotalCommander();
        } else {
            System.out.println("Wrong Selection");
        }

        //Click on "ADD TO CART" Button
        computerPage.ClickonAddToCart();
        //Verify the message "The product has been added to your shopping cart"

    }


/*
    @DataProvider(name = "Data")
    public Object[][] computerdata() {
        Object[][] data = new Object[5][3];

            data[0][0] = "2.2 GHz Intel Pentium Dual-Core E2200";
        data[0][1] = "2 GB";
        data[0][2] = "320 GB";
        data[0][3] = "Windows 7 [+50.00]";
        data[0][4] = "Microsoft Office [+$50.00]";

        data[1][0] = "2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]";
        data[1][1] = "4GB [+$20.00]";
        data[1][2] = "400 GB [+$100.00]";
        data[1][3] = "Windows 10 [+60.00]";
        data[1][4] = "Acrobat Reader [+$10.00]";

        data[2][0] = "2.5 GHz Intel Pentium Dual-Core E2200";
        data[2][1] = "8GB [+$60.00]";
        data[2][2] = "320 GB";
        data[2][3] = "Ubuntu";
        data[2][4] = "Total Commander [+$5.00]";


        //DATA SET
        //| processor | ram | hdd | os | software |
        //| 2.2 GHz Intel Pentium Dual-Core E2200 | 2 GB | 320 GB | Windows 7 [+50.00] |
        //Microsoft Office [+$50.00] |
        //| 2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00] | 4GB [+$20.00] | 400 GB [+$100.00] |
        //Windows 10 [+60.00] | Acrobat Reader [+$10.00] |
        //| 2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00] | 8GB [+$60.00] | 320 GB | Ubuntu
        //| Total Commander [+$5.00] |
        return data;
    }

 */
}