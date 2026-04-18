package com.framework.driver;

import com.framework.utils.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public final class DriverFactory {
    private static final ThreadLocal<WebDriver> THREAD_LOCAL_DRIVER = new ThreadLocal<>();

    private DriverFactory() {
    }

    public static void initDriver() {
        String browser = ConfigReader.getBrowser().toLowerCase();
        WebDriver driver;

        switch (browser) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                driver = new FirefoxDriver(firefoxOptions);
                break;
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                driver = new ChromeDriver(chromeOptions);
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser configured: " + browser + ". Supported values: chrome, firefox");
        }

        THREAD_LOCAL_DRIVER.set(driver);
        configureDriver(driver);
    }

    private static void configureDriver(WebDriver driver) {
        int timeout = ConfigReader.getTimeout();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(timeout));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(timeout));
    }

    public static WebDriver getDriver() {
        WebDriver driver = THREAD_LOCAL_DRIVER.get();
        if (driver == null) {
            throw new IllegalStateException("WebDriver is not initialized. Call initDriver() before using getDriver().");
        }
        return driver;
    }

    public static void quitDriver() {
        WebDriver driver = THREAD_LOCAL_DRIVER.get();
        if (driver != null) {
            driver.quit();
            THREAD_LOCAL_DRIVER.remove();
        }
    }
}
