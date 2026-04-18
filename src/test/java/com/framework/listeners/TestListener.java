package com.framework.listeners;

import com.framework.driver.DriverFactory;
import com.framework.utils.AllureUtil;
import io.qameta.allure.Allure;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        Allure.step("STARTED: " + testName(result));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Allure.step("PASSED: " + testName(result));
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Allure.step("FAILED: " + testName(result));
        try {
            AllureUtil.attachScreenshot(DriverFactory.getDriver(), "Failure Screenshot - " + testName(result));
        } catch (RuntimeException ignored) {
            Allure.step("Unable to capture screenshot because driver was unavailable.");
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        Allure.step("SKIPPED: " + testName(result));
    }

    @Override
    public void onStart(ITestContext context) {
        Allure.step("Execution started for suite: " + context.getSuite().getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        Allure.step("Execution finished for suite: " + context.getSuite().getName());
    }

    private String testName(ITestResult result) {
        return result.getTestClass().getRealClass().getSimpleName() + "." + result.getMethod().getMethodName();
    }
}
