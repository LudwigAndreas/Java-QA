package org.example.appmanager;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;

public class ApplicationManager implements AutoCloseable {

    WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;

    private NavigationHelper navigationHelper;

    public WebDriver getDriver() {
        return driver;
    }

    private GroupHelper groupHelper;
    private LoginHelper loginHelper;

    private static ApplicationManager instance;

    private ApplicationManager() {
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
        groupHelper = new GroupHelper(this);
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

    @After
    public void tearDown() {

    }


    public GroupHelper groupNew() {
        return groupHelper;
    }

    public NavigationHelper Navigate() {
        return navigationHelper;
    }

    public LoginHelper toLogin() {
        return loginHelper;
    }
    public void SetWindowSize() {
        driver.manage().window().setSize(new Dimension(1920, 973));
    }

    @Override
    public void close() throws Exception {
        driver.quit();
    }
}
