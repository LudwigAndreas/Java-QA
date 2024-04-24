package org.example;
import org.example.model.AccountData;
import org.example.model.IssueData;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import java.util.*;

public class RedminetestbasefirstTestTest extends TestBase{

    @Test
    public void redminetestbasefirstTest() {
        OpenURL();
        SetWindowSize();
        AccountData user = new AccountData("LudwigAndreas",
                "xnG^xWkX4aV");
        Login(user);
        OpenHomePage();
        IssueData issueData = new IssueData("Selenium created issue",
                "Selenium created description",
                "2025-01-02");
        CreateNewIssue(issueData);
    }


}
