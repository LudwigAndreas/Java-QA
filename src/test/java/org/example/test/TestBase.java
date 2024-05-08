package org.example.test;

import org.example.ApplicationManager;
import org.junit.AfterClass;
import org.junit.Before;

public class TestBase {

    protected ApplicationManager manager = ApplicationManager.GetInstance();

    protected AuthBase authBase = new AuthBase();

    @Before
    public void setUp() {
        manager.setUp();

        manager.navigationHelper().openUrl();
        manager.setWindowSize();
    }

//    @AfterClass
    public static void tearDown() {
//        ApplicationManager.tearDown();
    }

}
