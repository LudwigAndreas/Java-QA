package org.example.test;

import org.example.ApplicationManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    protected static ApplicationManager manager = ApplicationManager.GetInstance();
    @BeforeAll
    public static void setUpManager() {
        manager.navigationHelper().openUrl();
        manager.setWindowSize();
        manager.navigationHelper().openHomePage();
    }

    @AfterAll
    public static void tearDownManager() {
        ApplicationManager.tearDown();
    }

}
