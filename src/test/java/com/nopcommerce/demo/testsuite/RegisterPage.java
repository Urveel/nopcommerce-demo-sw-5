package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.LoginPage;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

public class RegisterPage extends BaseTest {

    @Listeners(CustomListeners.class)
    public class RegisterPageTest extends BaseTest {

        HomePage homePage;
        LoginPage loginPage;

        @BeforeMethod
        public void inIt() {
            homePage = new HomePage();
            loginPage = new LoginPage();
        }

        @Test(groups={"sanity","regression"})
        public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
            homePage.clickOnLoginLink();
            String expectedMessage = "Welcome, Please Sign In!";
            String actualMessage = loginPage.getWelcomeText();
            Assert.assertEquals(expectedMessage, actualMessage, "Login page not displayed");
        }

        @Test(groups={"sanity","smoke","regression"})
        public void verifyThatFirstNameLastNameEmailPasswordAndConfirmPasswordFieldsAreMandatory() {
            homePage.clickOnLoginLink();
            loginPage.enterEmailId("prime123@gmail.com");
            loginPage.enterPassword("prime123");
            loginPage.clickOnLoginButton();
            String expectedErrorMessage = "Login was unsuccessful. Please correct the errors and try again.\n"
                    + "No customer account found";
            String actualErrorMessage = loginPage.getErrorMessage();
            Assert.assertEquals(expectedErrorMessage, actualErrorMessage, "Error message not displayed");
        }

        @Test(groups={"sanity","regression1","smoke","regression"})
        public void verifyThatUserShouldCreateAccountSuccessfully() {
            homePage.clickOnLoginLink();
            loginPage.enterEmailId("prime123@gmail.com");
            loginPage.enterPassword("prime123");
            loginPage.clickOnLoginButton();
            String expectedErrorMessage = "Login was unsuccessful. Please correct the errors and try again.\n"
                    + "No customer account found";
            String actualErrorMessage = loginPage.getErrorMessage();
            Assert.assertEquals(expectedErrorMessage, actualErrorMessage, "Error message not displayed");
        }

    }
}
