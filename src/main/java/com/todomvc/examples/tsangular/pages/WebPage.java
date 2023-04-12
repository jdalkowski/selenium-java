package com.todomvc.examples.tsangular.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

public abstract class WebPage {

    private static final int TIMEOUT_SECONDS = 30;
    protected final WebDriver driver;

    public WebPage(final WebDriver driver) {
        this.driver = driver;
        initWebElements();
    }

    private void initWebElements() {
        final ElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, TIMEOUT_SECONDS);
        PageFactory.initElements(factory, this);
    }
}
