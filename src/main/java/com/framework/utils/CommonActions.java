package com.framework.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Set;

public class CommonActions {

    private final WebDriver driver;
    private final WaitUtils waitUtils;
    private final Actions actions;

    public CommonActions(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
        this.actions = new Actions(driver);
    }

    public void type(WebElement element, String text) {
        WebElement webElement = waitUtils.waitForVisibility(element);
        webElement.clear();
        webElement.sendKeys(text);
    }

    public void click(WebElement element) {
        waitUtils.waitForClickability(element).click();
    }

    public void jsClick(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", waitUtils.waitForVisibility(element));
    }

    public String getElementText(WebElement element) {
        return waitUtils.waitForVisibility(element).getText().trim();
    }

    public void hover(WebElement element) {
        actions.moveToElement(waitUtils.waitForVisibility(element)).perform();
    }

    public void doubleClick(WebElement element) {
        actions.doubleClick(waitUtils.waitForVisibility(element)).perform();
    }

    public void rightClick(WebElement element) {
        actions.contextClick(waitUtils.waitForVisibility(element)).perform();
    }

    public void dragAndDrop(WebElement source, WebElement target) {
        actions.dragAndDrop(waitUtils.waitForVisibility(source), waitUtils.waitForVisibility(target)).perform();
    }

    public void dragAndDropByOffset(WebElement source, int xOffset, int yOffset) {
        actions.dragAndDropBy(waitUtils.waitForVisibility(source), xOffset, yOffset).perform();
    }

    public void scrollIntoView(WebElement element) {
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({behavior:'instant',block:'center'});", waitUtils.waitForVisibility(element));
    }

    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    public String getAlertText() {
        return driver.switchTo().alert().getText();
    }

    public void typeIntoAlert(String text) {
        driver.switchTo().alert().sendKeys(text);
    }

    public void selectByVisibleText(WebElement dropdownElement, String text) {
        new Select(waitUtils.waitForVisibility(dropdownElement)).selectByVisibleText(text);
    }

    public void selectByValue(WebElement dropdownElement, String value) {
        new Select(waitUtils.waitForVisibility(dropdownElement)).selectByValue(value);
    }

    public void selectByIndex(WebElement dropdownElement, int index) {
        new Select(waitUtils.waitForVisibility(dropdownElement)).selectByIndex(index);
    }

    public List<WebElement> getSelectOptions(WebElement dropdownElement) {
        return new Select(waitUtils.waitForVisibility(dropdownElement)).getOptions();
    }

    public void switchToFrame(WebElement frameElement) {
        driver.switchTo().frame(waitUtils.waitForVisibility(frameElement));
    }

    public void switchToFrame(int frameIndex) {
        driver.switchTo().frame(frameIndex);
    }

    public void switchToFrame(String frameNameOrId) {
        driver.switchTo().frame(frameNameOrId);
    }

    public void switchToParentFrame() {
        driver.switchTo().parentFrame();
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    public Set<String> getWindowHandles() {
        return driver.getWindowHandles();
    }

    public String getCurrentWindowHandle() {
        return driver.getWindowHandle();
    }

    public void switchToWindow(String windowHandle) {
        driver.switchTo().window(windowHandle);
    }

    public void switchToNewWindow(String parentWindowHandle) {
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(parentWindowHandle)) {
                driver.switchTo().window(handle);
                return;
            }
        }
        throw new IllegalStateException("No new window found to switch.");
    }

    public void closeCurrentWindowAndSwitchBack(String parentWindowHandle) {
        driver.close();
        driver.switchTo().window(parentWindowHandle);
    }
}
