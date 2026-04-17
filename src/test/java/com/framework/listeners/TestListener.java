package com.framework.listeners;

import com.framework.driver.DriverManager;
import com.framework.reports.AllureAttachments;
import com.framework.utils.ScreenshotUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        if (DriverManager.getDriver() != null) {
            byte[] screenshot = ScreenshotUtils.takeScreenshotAsBytes(DriverManager.getDriver());
            AllureAttachments.attachScreenshot(screenshot);
        }
    }

    @Override
    public void onStart(ITestContext context) {
        // test suite start hook
    }

    @Override
    public void onFinish(ITestContext context) {
        // test suite finish hook
    }
}
