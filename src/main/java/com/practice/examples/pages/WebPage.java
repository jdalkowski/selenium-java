package com.practice.examples.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class WebPage {

    private static final int TIMEOUT_SECONDS = 30;
    protected final WebDriver driver;
    WebDriverWait wait;

    public WebPage(final WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_SECONDS));
        initWebElements();
    }

    private void initWebElements() {
        final ElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, TIMEOUT_SECONDS);
        PageFactory.initElements(factory, this);
    }
}