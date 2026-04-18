package com.framework.pages;

import com.framework.base.BasePage;
import com.framework.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private static final String PAGE_NAME = "Login page";

    private final By emailInput = By.id("userEmail");
    private final By passwordInput = By.id("userPassword");
    private final By loginButton = By.id("login");
    private final By errorMessage = By.cssSelector(".toast-message");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage load() {
        driver.get(ConfigReader.getBaseUrl());
        waitForElement(emailInput);
        return this;
    }

    public LoginPage enterEmail(String email) {
        type(emailInput, email, "Enter email on " + PAGE_NAME);
        return this;
    }

    public LoginPage enterPassword(String password) {
        type(passwordInput, password, "Enter password on " + PAGE_NAME);
        return this;
    }

    public LoginPage clickLoginButton() {
        click(loginButton, "Click login button on " + PAGE_NAME);
        return this;
    }

    public String getLoginErrorMessage() {
        waitForElement(errorMessage);
        return getText(errorMessage, "Read login error message on " + PAGE_NAME);
    }

    public boolean isLoginErrorMessageContaining(String expectedText) {
        return getLoginErrorMessage().toLowerCase().contains(expectedText.toLowerCase());
    }
}
