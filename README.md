# Selenium POM Framework (Java + TestNG + Allure)

A scalable, maintainable Selenium framework using a modern Page Object Model architecture.

## Framework layers

- **Base layer**: `BasePage`, `BaseTest`
- **Config layer**: `ConfigManager` + `config.properties`
- **Driver layer**: thread-safe `DriverManager`
- **Utility layer**: waits, common actions, screenshots
- **Page layer**: page objects under `pages`
- **Test layer**: tests under `tests`
- **Reporting layer**: Allure attachments/listeners
- **Analyzer layer**: Retry analyzer for flaky failures

## Run locally

### Prerequisites
- Java 17+
- Maven 3.9+
- Chrome/Firefox/Edge installed (choose via config)

### Commands

Run tests:

```bash
mvn clean test
```

Run in headless mode:

```bash
mvn clean test -Dheadless=true
```

Run on Firefox:

```bash
mvn clean test -Dbrowser=firefox
```

Generate and open Allure report:

```bash
mvn allure:report
mvn allure:serve
```

## Built-in defaults

- Explicit wait: 15 seconds
- Implicit wait: 2 seconds
- Page load timeout: 30 seconds

## Test added

- Login validation for:
  - URL: `https://rahulshettyacademy.com/client/#/auth/login`
  - Username: `anshika@gmail.com`
  - Password: `Iamking@000`
