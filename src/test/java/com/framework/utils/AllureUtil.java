package com.framework.utils;

import io.qameta.allure.Allure;
import java.io.ByteArrayInputStream;
import org.openqa.selenium.WebDriver;

public final class AllureUtil {
    private AllureUtil() {
    }

    public static void logStepWithScreenshot(WebDriver driver, String stepName, Runnable action) {
        Allure.step(stepName, () -> {
            try {
                action.run();
            } finally {
                attachScreenshot(driver, stepName + " - screenshot");
            }
        });
    }

    public static void attachScreenshot(WebDriver driver, String attachmentName) {
        byte[] screenshot = ScreenshotUtil.captureScreenshot(driver);
        if (screenshot.length > 0) {
            Allure.addAttachment(attachmentName, "image/png", new ByteArrayInputStream(screenshot), ".png");
        }
    }
}
