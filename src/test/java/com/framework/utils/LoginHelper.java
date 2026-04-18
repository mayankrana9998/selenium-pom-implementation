package com.framework.utils;

import java.time.Instant;
import org.openqa.selenium.WebDriver;

public class LoginHelper {
    private static final String INVALID_PASSWORD = "invalidPassword";
    private final WebDriver driver;

    public LoginHelper(WebDriver driver) {
        this.driver = driver;
    }

    public String generateInvalidEmail(String prefix) {
        return prefix + "." + Instant.now().toEpochMilli() + "@example.com";
    }

    public void openLoginPage() {
        driver.get(ConfigReader.getBaseUrl());
    }

    public String invalidPassword() {
        return INVALID_PASSWORD;
    }
}
