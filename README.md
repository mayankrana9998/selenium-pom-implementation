# Selenium Java TestNG POM Framework

Production-ready UI test automation framework built with Selenium, TestNG, and Allure using a clean Page Object Model architecture.

## Package Structure

```text
src/test/java/com/framework
├── base
│   ├── BasePage.java
│   └── BaseTest.java
├── driver
│   └── DriverFactory.java
├── listeners
│   └── TestListener.java
├── pages
│   └── LoginPage.java
├── tests
│   └── LoginTest.java
└── utils
    ├── ActionUtil.java
    ├── AllureUtil.java
    ├── ConfigReader.java
    ├── ScreenshotUtil.java
    └── WaitUtil.java

src/test/resources
└── config.properties
```

## Key Capabilities

- Thread-safe `ThreadLocal<WebDriver>` driver management for parallel runs.
- Browser selection via `config.properties` (`chrome`/`firefox`).
- Configurable timeout and base URL.
- Reusable base page actions (`click`, `type`, `getText`, `waitForElement`) plus advanced interactions (`hover`, `doubleClick`, `rightClick`, `dragAndDrop`, dropdown selects, frame/window switching).
- Step-level Allure logging with screenshot attachment on **every** UI action.
- Automatic screenshot capture on test failures using TestNG listener.
- Explicit waits only (no hardcoded sleeps).

## How to Run

```bash
mvn clean test
```

## Allure Report

```bash
mvn allure:report
mvn allure:serve
```
