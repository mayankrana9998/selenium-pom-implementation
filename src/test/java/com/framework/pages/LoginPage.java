package com.framework.pages;

import com.framework.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage extends BasePage {
    private static final String PAGE_NAME = "Login Page";

    private final By emailInput = By.id("userEmail");
    private final By passwordInput = By.id("userPassword");
    private final By loginButton = By.id("login");
    private final By errorMessage = By.cssSelector(".toast-message");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage isLoaded() {
        Assert.assertTrue(
            isDisplayed(emailInput, "Verify email field is visible on " + PAGE_NAME),
            "Expected email input to be visible on " + PAGE_NAME
        );
        return this;
    }

    public LoginPage enterEmail(String email) {
        type(emailInput, email, "Enter email in " + PAGE_NAME);
        return this;
    }

    public LoginPage enterPassword(String password) {
        type(passwordInput, password, "Enter password in " + PAGE_NAME);
        return this;
    }

    public LoginPage clickLoginButton() {
        click(loginButton, "Click login button on " + PAGE_NAME);
        return this;
    }

    public LoginPage login(String email, String password) {
        return enterEmail(email)
            .enterPassword(password)
            .clickLoginButton();
    }

    public LoginPage verifyErrorMessageDisplayed(String expectedMessage) {
        String actualMessage = getText(errorMessage, "Read login error message from " + PAGE_NAME);
        Assert.assertTrue(
            actualMessage.toLowerCase().contains(expectedMessage.toLowerCase()),
            "Expected error to contain: " + expectedMessage + ", but got: " + actualMessage
        );
        return this;
    }
}
