package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class DesktopsPage extends Utility {

    @CacheLookup
    @FindBy(linkText = "Log in")
    WebElement loginLink;
    //By loginLink= By.linkText("Login")

    @CacheLookup
    @FindBy (linkText = "Register") WebElement registerLink;
    //  By registerLink = By.linkText("Register");

    public void clickOnLoginLink(){
        clickOnElement(loginLink);
    }

    public void clickOnRegisterLink(){
        clickOnElement(registerLink);
    }
}
