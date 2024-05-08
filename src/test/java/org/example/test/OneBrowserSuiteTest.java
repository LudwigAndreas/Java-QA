package org.example.test;

import org.example.ApplicationManager;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        LoginTest.class,
        IssueCreationTest.class,
        EditIssueTest.class
})
public class OneBrowserSuiteTest extends TestBase {

    ApplicationManager manager = ApplicationManager.GetInstance();


    @AfterClass
    public static void tearDown() {
        ApplicationManager.tearDown();
    }
}
