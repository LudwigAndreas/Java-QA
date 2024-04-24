package org.example.helper;

import org.example.ApplicationManager;
import org.openqa.selenium.WebDriver;

public class HelperBase {

    protected WebDriver driver;

    protected ApplicationManager manager;

    public HelperBase(ApplicationManager manager) {
        this.manager = manager;
        this.driver = manager.getDriver();
    }
}
