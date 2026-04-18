package com.framework.base;

import com.framework.utils.ActionUtil;
import com.framework.utils.AllureUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class BasePage {
    protected final WebDriver driver;
    private final ActionUtil actionUtil;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        this.actionUtil = new ActionUtil(driver);
    }

    protected void click(By locator, String stepName) {
        AllureUtil.logStepWithScreenshot(driver, stepName, () -> actionUtil.safeClick(locator));
    }

    protected void type(By locator, String text, String stepName) {
        AllureUtil.logStepWithScreenshot(driver, stepName, () -> actionUtil.safeType(locator, text));
    }

    protected String getText(By locator, String stepName) {
        final String[] text = new String[1];
        AllureUtil.logStepWithScreenshot(driver, stepName, () -> text[0] = actionUtil.safeGetText(locator));
        return text[0];
    }

    protected String getAttribute(By locator, String attributeName, String stepName) {
        final String[] attributeValue = new String[1];
        AllureUtil.logStepWithScreenshot(driver, stepName, () -> attributeValue[0] = actionUtil.safeGetAttribute(locator, attributeName));
        return attributeValue[0];
    }

    protected boolean isDisplayed(By locator, String stepName) {
        final boolean[] displayed = new boolean[1];
        AllureUtil.logStepWithScreenshot(driver, stepName, () -> displayed[0] = actionUtil.safeIsDisplayed(locator));
        return displayed[0];
    }

    protected WebElement waitForElement(By locator) {
        final WebElement[] element = new WebElement[1];
        AllureUtil.logStepWithScreenshot(driver, "Wait for element: " + locator, () -> element[0] = actionUtil.safeFindVisible(locator));
        return element[0];
    }

    protected void hover(By locator, String stepName) {
        AllureUtil.logStepWithScreenshot(driver, stepName, () -> actionUtil.safeHover(locator));
    }

    protected void doubleClick(By locator, String stepName) {
        AllureUtil.logStepWithScreenshot(driver, stepName, () -> actionUtil.safeDoubleClick(locator));
    }

    protected void rightClick(By locator, String stepName) {
        AllureUtil.logStepWithScreenshot(driver, stepName, () -> actionUtil.safeRightClick(locator));
    }

    protected void dragAndDrop(By sourceLocator, By targetLocator, String stepName) {
        AllureUtil.logStepWithScreenshot(driver, stepName, () -> actionUtil.safeDragAndDrop(sourceLocator, targetLocator));
    }

    protected void selectByVisibleText(By locator, String visibleText, String stepName) {
        AllureUtil.logStepWithScreenshot(driver, stepName, () -> actionUtil.safeSelectByVisibleText(locator, visibleText));
    }

    protected void selectByValue(By locator, String value, String stepName) {
        AllureUtil.logStepWithScreenshot(driver, stepName, () -> actionUtil.safeSelectByValue(locator, value));
    }

    protected void selectByIndex(By locator, int index, String stepName) {
        AllureUtil.logStepWithScreenshot(driver, stepName, () -> actionUtil.safeSelectByIndex(locator, index));
    }

    protected void switchToFrame(By frameLocator, String stepName) {
        AllureUtil.logStepWithScreenshot(driver, stepName, () -> actionUtil.safeSwitchToFrame(frameLocator));
    }

    protected void switchToDefaultContent(String stepName) {
        AllureUtil.logStepWithScreenshot(driver, stepName, actionUtil::safeSwitchToDefaultContent);
    }

    protected void switchToWindowByTitle(String title, String stepName) {
        AllureUtil.logStepWithScreenshot(driver, stepName, () -> actionUtil.safeSwitchToWindowByTitle(title));
    }

    protected void switchToNewestWindow(String stepName) {
        AllureUtil.logStepWithScreenshot(driver, stepName, actionUtil::safeSwitchToNewestWindow);
    }
}
