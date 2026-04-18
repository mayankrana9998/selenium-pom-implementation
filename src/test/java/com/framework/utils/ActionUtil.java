package com.framework.utils;

import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ActionUtil {
    private final WebDriver driver;
    private final WaitUtil waitUtil;

    public ActionUtil(WebDriver driver) {
        this.driver = driver;
        this.waitUtil = new WaitUtil(driver);
    }

    public void safeClick(By locator) {
        WebElement element = waitUtil.waitForClickable(locator);
        element.click();
    }

    public void safeType(By locator, String text) {
        WebElement element = waitUtil.waitForVisibility(locator);
        element.clear();
        element.sendKeys(text);
    }

    public String safeGetText(By locator) {
        WebElement element = waitUtil.waitForVisibility(locator);
        return element.getText().trim();
    }

    public String safeGetAttribute(By locator, String attributeName) {
        WebElement element = waitUtil.waitForVisibility(locator);
        return element.getAttribute(attributeName);
    }

    public WebElement safeFindVisible(By locator) {
        return waitUtil.waitForVisibility(locator);
    }

    public boolean safeIsDisplayed(By locator) {
        return waitUtil.waitForVisibility(locator).isDisplayed();
    }

    public void safeHover(By locator) {
        WebElement element = waitUtil.waitForVisibility(locator);
        new Actions(driver).moveToElement(element).perform();
    }

    public void safeDoubleClick(By locator) {
        WebElement element = waitUtil.waitForClickable(locator);
        new Actions(driver).doubleClick(element).perform();
    }

    public void safeRightClick(By locator) {
        WebElement element = waitUtil.waitForClickable(locator);
        new Actions(driver).contextClick(element).perform();
    }

    public void safeDragAndDrop(By sourceLocator, By targetLocator) {
        WebElement source = waitUtil.waitForVisibility(sourceLocator);
        WebElement target = waitUtil.waitForVisibility(targetLocator);
        new Actions(driver).dragAndDrop(source, target).perform();
    }

    public void safeSelectByVisibleText(By locator, String visibleText) {
        Select select = new Select(waitUtil.waitForVisibility(locator));
        select.selectByVisibleText(visibleText);
    }

    public void safeSelectByValue(By locator, String value) {
        Select select = new Select(waitUtil.waitForVisibility(locator));
        select.selectByValue(value);
    }

    public void safeSelectByIndex(By locator, int index) {
        Select select = new Select(waitUtil.waitForVisibility(locator));
        select.selectByIndex(index);
    }

    public void safeSwitchToFrame(By frameLocator) {
        WebElement frame = waitUtil.waitForVisibility(frameLocator);
        driver.switchTo().frame(frame);
    }

    public void safeSwitchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    public void safeSwitchToWindowByTitle(String title) {
        Set<String> windowHandles = driver.getWindowHandles();
        for (String handle : windowHandles) {
            driver.switchTo().window(handle);
            if (driver.getTitle().contains(title)) {
                return;
            }
        }
        throw new NoSuchWindowException("Unable to find window with title containing: " + title);
    }

    public void safeSwitchToNewestWindow() {
        Set<String> windowHandles = driver.getWindowHandles();
        String newestHandle = null;
        for (String handle : windowHandles) {
            newestHandle = handle;
        }
        if (newestHandle == null) {
            throw new NoSuchWindowException("No browser windows available for switch.");
        }
        driver.switchTo().window(newestHandle);
    }
}
