package com.framework.pages;

import com.framework.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "userEmail")
    private WebElement emailInput;

    @FindBy(id = "userPassword")
    private WebElement passwordInput;

    @FindBy(id = "login")
    private WebElement loginButton;

    @FindBy(css = "[routerlink*='dashboard']")
    private WebElement homeNavLink;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void load() {
        loadBaseUrl();
    }

    public void login(String email, String password) {
        actions.type(emailInput, email);
        actions.type(passwordInput, password);
        actions.click(loginButton);
    }

    public boolean isLoginSuccessful() {
        return waitUtils.waitForUrlContains("/dashboard") && homeNavLink.isDisplayed();
    }
}
