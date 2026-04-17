package com.framework.tests;

import com.framework.analyzers.RetryAnalyzer;
import com.framework.base.BaseTest;
import com.framework.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(description = "Verify user can login with valid credentials", retryAnalyzer = RetryAnalyzer.class)
    public void shouldLoginSuccessfully() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.load();
        loginPage.login("anshika@gmail.com", "Iamking@000");

        Assert.assertTrue(loginPage.isLoginSuccessful(), "Expected user to reach dashboard after login.");
    }
}
