package com.todomvc.examples.tsangular.core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class ChromeRunner {

    WebDriver driver;

    @BeforeClass
    public void initWebDriver() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = WebDriverManager.chromedriver().capabilities(chromeOptions).create();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
