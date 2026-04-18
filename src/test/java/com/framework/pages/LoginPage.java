package com.framework.pages;

import com.framework.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private final By emailInput = By.id("userEmail");
    private final By passwordInput = By.id("userPassword");
    private final By loginButton = By.id("login");
    private final By errorMessage = By.cssSelector(".toast-message");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage enterEmail(String email) {
        type(emailInput, email, "Enter email");
        return this;
    }

    public LoginPage enterPassword(String password) {
        type(passwordInput, password, "Enter password");
        return this;
    }

    public LoginPage clickLogin() {
        click(loginButton, "Click login button");
        return this;
    }

    public String getLoginErrorMessage() {
        waitForElement(errorMessage);
        return getText(errorMessage, "Read login error message");
    }

    public LoginPage login(String email, String password) {
        return enterEmail(email)
            .enterPassword(password)
            .clickLogin();
    }
}
