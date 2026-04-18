package com.framework.tests;

import com.framework.base.BaseTest;
import com.framework.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(description = "Verify user gets error for invalid login credentials")
    public void shouldShowErrorForInvalidCredentials() {
        LoginPage loginPage = new LoginPage(getDriver());

        String errorMessage = loginPage
            .login("invalid.user@example.com", "invalidPassword")
            .getLoginErrorMessage();

        Assert.assertTrue(
            errorMessage.toLowerCase().contains("incorrect"),
            "Expected login error to contain 'incorrect' but was: " + errorMessage
        );
    }
}
