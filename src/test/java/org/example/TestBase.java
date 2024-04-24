package org.example;

import org.example.appmanager.ApplicationManager;
import org.junit.After;
import org.junit.Before;

public class TestBase {

    protected ApplicationManager manager = ApplicationManager.GetInstance();

    @Before
    public void setUp() {
        manager.setUp();
    }

    @After
    public void tearDown() {
        manager.tearDown();
    }

}
