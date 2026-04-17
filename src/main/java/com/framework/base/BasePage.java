package com.framework.base;

import com.framework.config.ConfigManager;
import com.framework.utils.CommonActions;
import com.framework.utils.WaitUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    protected final WebDriver driver;
    protected final WaitUtils waitUtils;
    protected final CommonActions actions;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
        this.actions = new CommonActions(driver);
        PageFactory.initElements(driver, this);
    }

    protected void loadUrl(String url) {
        driver.get(url);
    }

    protected void loadBaseUrl() {
        loadUrl(ConfigManager.getString("base.url"));
    }
}
