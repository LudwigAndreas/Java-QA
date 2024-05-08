package org.example;

import org.example.helper.IssueHelper;
import org.example.helper.LoginHelper;
import org.example.helper.NavigationHelper;
import org.junit.AfterClass;
import org.junit.Before;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;

public class ApplicationManager {

    private static WebDriver driver;
    private Map<String, Object> vars;
    private JavascriptExecutor js;

    private final NavigationHelper navigationHelper;

    public WebDriver getDriver() {
        return driver;
    }

    private final IssueHelper issueHelper;
    private final LoginHelper loginHelper;

    private static ApplicationManager instance;

    private ApplicationManager() {
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
        issueHelper = new IssueHelper(this);
        loginHelper = new LoginHelper(this);
        navigationHelper = new NavigationHelper(this);
    }

    public static ApplicationManager GetInstance() {
        ApplicationManager localInstance = instance;
        if (localInstance == null) {
            synchronized (ApplicationManager.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new ApplicationManager();
                }
            }
        }
        return localInstance;
    }

    @Before
    public void setUp() {

    }

    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public IssueHelper issueHelper() {
        return issueHelper;
    }

    public NavigationHelper navigationHelper() {
        return navigationHelper;
    }

    public LoginHelper toLogin() {
        return loginHelper;
    }
    public void setWindowSize() {
        driver.manage().window().setSize(new Dimension(1920, 973));
    }

}
