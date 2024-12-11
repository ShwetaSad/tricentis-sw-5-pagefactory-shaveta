package com.tricentis.demowebshop.pages;

import com.aventstack.extentreports.Status;
import com.tricentis.demowebshop.customerlisteners.CustomerListeners;
import com.tricentis.demowebshop.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class ComputerPage extends Utility {

    //3.ComputerPage - Computers text, DesktopsLink, NotebooksLink, SoftwareLink Locators
    //and create appropriate methods for it.

    @CacheLookup
    @FindBy(linkText = "Computers")
    WebElement computersTab;

    @CacheLookup
    @FindBy(xpath = "//h1[normalize-space()=\"Computers\"]")
    WebElement computerText;

    @CacheLookup
    @FindBy(xpath = "//img[@title=\"Show details for Build your own computer\"]")
    WebElement buildyourownComputer;

    @CacheLookup
    @FindBy(xpath = "//select[@id=\"product_attribute_16_5_4\"]")
    WebElement selectprocessorfromDropdown;

    @CacheLookup
    @FindBy(xpath = "//select[@id=\"product_attribute_16_6_5\"]")
    WebElement selectRamFromDropdown;

    @CacheLookup
    @FindBy(xpath = "//input[@id=\"product_attribute_16_3_6_19\"]" )
    WebElement HDD400;

    @CacheLookup
    @FindBy(xpath = "//input[@id=\"product_attribute_16_3_6_18\"]" )
    WebElement HDD320;

    @CacheLookup
    @FindBy(xpath = "//input[@id=\"product_attribute_16_4_7_44\"]" )
    WebElement OSUbuntu;

    @CacheLookup
    @FindBy(xpath = "//input[@id=\"product_attribute_16_4_7_44\"]" )
    WebElement OSWindows7;

    @CacheLookup
    @FindBy(xpath = "//input[@id=\"product_attribute_16_4_7_21\"]" )
    WebElement OSWindows10 ;

    @CacheLookup
    @FindBy(xpath = "//input[@id=\"product_attribute_16_8_8_22\"]" )
    WebElement SoftwareMicrosoftOffice;

    @CacheLookup
    @FindBy(xpath = "//input[@id=\"product_attribute_16_8_8_23\"]" )
    WebElement SoftwareAcrobatReader;

    @CacheLookup
    @FindBy(xpath = "//input[@id=\"product_attribute_16_8_8_24\"]" )
    WebElement SoftwareTotalCommander;

    @CacheLookup
    @FindBy(xpath = "//input[@id=\"add-to-cart-button-16\"]")
    WebElement addtoCart;


    public void clickOnBuildyourownComputer(){
        CustomerListeners.test.log(Status.PASS,"BuildyouownComputer");
        clickOnElement(buildyourownComputer);
        Reporter.log("clickOnBuildyourownComputer");

    }

    public void setSelectprocessorfromDropdown(String Processor){
        CustomerListeners.test.log(Status.PASS,"setSelectprocessorfromDropdown");
        selectByVisibleTextFromDropDown(selectprocessorfromDropdown,Processor);
        Reporter.log("setSelectprocessorfromDropdown");
    }

    public void setSelectRamFromDropdown(String ram){
        selectByVisibleTextFromDropDown(selectRamFromDropdown,ram);
        CustomerListeners.test.log(Status.PASS,"setSelectRamFromDropdown");
        Reporter.log("setSelectRamFromDropdown");

    }

    public void selectHDD320( ){
        clickOnElement(HDD320);
        CustomerListeners.test.log(Status.PASS,"Selected HDD320");
        Reporter.log("Selected HDD320");
    }
    public void selectHDD400 (){
        clickOnElement(HDD400);
        CustomerListeners.test.log(Status.PASS,"selectHDD400 ");
        Reporter.log("selectHDD400 ");
    }

    public void SelectOSUbuntu(){
        clickOnElement(OSUbuntu);
        CustomerListeners.test.log(Status.PASS,"SelectOSUbuntu");
        Reporter.log("SelectOSUbuntu");
    }
    public void SelectOSWindows7(){
        clickOnElement(OSWindows7);
        CustomerListeners.test.log(Status.PASS,"SelectWindows7");
        Reporter.log("SelectWindows7");
    }
    public void SelectWindows10(){
        clickOnElement(OSWindows10);
        CustomerListeners.test.log(Status.PASS,"SelectWindows10");
        Reporter.log("SelectWindows10");
    }
    public void SelectSoftwareMicrosoftOffice  (){
        clickOnElement(SoftwareMicrosoftOffice);
        CustomerListeners.test.log(Status.PASS,"SelectSoftwareMicrosoftOffice");
        Reporter.log("SelectSoftwareMicrosoftOffice");
    }

    public void SelectSoftwareAcrobatReader(){
        clickOnElement(SoftwareAcrobatReader);
        CustomerListeners.test.log(Status.PASS,"SelectSoftwareAcrobatReader");
        Reporter.log("SelectSoftwareAcrobatReader");
    }

    public void SelectSoftwareTotalCommander (){
        clickOnElement(SoftwareTotalCommander);
        CustomerListeners.test.log(Status.PASS,"SelectSoftwareTotalCommander");
        Reporter.log("SelectSoftwareTotalCommander");
    }

    public void ClickonAddToCart(){
        clickOnElement(addtoCart);
        CustomerListeners.test.log(Status.PASS,"Click on Add to Cart");
        Reporter.log("Click on Add to Cart");
    }

    public void clickOnComuter(){
        clickOnElement(computersTab);
        CustomerListeners.test.log(Status.PASS,"Computer Tab");
        Reporter.log("");
    }

    public String ComputerText(){
        CustomerListeners.test.log(Status.PASS,"Computer Text");
        Reporter.log("");
        return getTextFromElement(computerText);


    }
}
