package com.framework.tests;

import com.framework.base.BaseTest;
import com.framework.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(description = "Verify validation for invalid login credentials", groups = {"P2", "LOGIN"})
    public void verifyValidationForInvalidLoginCredentials() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.load();

        loginPage.enterEmail("invalid.user@example.com");
        loginPage.enterPassword("invalidPassword");
        loginPage.clickLoginButton();

        Assert.assertTrue(
            loginPage.isLoginErrorMessageContaining("incorrect"),
            "Expected login error to contain 'incorrect' but was: " + loginPage.getLoginErrorMessage()
        );
    }
}
