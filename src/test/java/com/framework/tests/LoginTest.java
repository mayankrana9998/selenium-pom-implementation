package com.framework.tests;

import com.framework.base.BaseTest;
import com.framework.pages.LoginPage;
import com.framework.utils.LoginHelper;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(description = "Verify validation on login page for invalid credentials", groups = {"P2", "AUTH"})
    public void verifyValidationOnLoginPageForInvalidCredentials() {
        LoginHelper loginHelper = new LoginHelper(getDriver());
        String invalidEmail = loginHelper.generateInvalidEmail("qa-user");

        loginHelper.openLoginPage();

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage
            .isLoaded()
            .login(invalidEmail, loginHelper.invalidPassword())
            .verifyErrorMessageDisplayed("Incorrect email or password");
    }
}
