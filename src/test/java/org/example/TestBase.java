package org.example;

import org.example.model.AccountData;
import org.example.model.IssueData;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;

public class TestBase {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;
    @Before
    public void setUp() {
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }
    @After
    public void tearDown() {
        driver.quit();
    }

    public void CreateNewIssue(IssueData issueData) {
        driver.findElement(By.linkText("Projects")).click();
        driver.findElement(By.linkText("Test")).click();
        driver.findElement(By.linkText("Issues")).click();
        driver.findElement(By.linkText("New issue")).click();
        driver.findElement(By.id("issue_subject")).sendKeys(issueData.getIssueSubject());
        driver.findElement(By.id("issue_description")).sendKeys(issueData.getIssueDescription());
        driver.findElement(By.id("issue_due_date")).sendKeys(issueData.getIssueDueDate());
        driver.findElement(By.name("commit")).click();
        driver.findElement(By.cssSelector("html")).click();
    }

    public void SetWindowSize() {
        driver.manage().window().setSize(new Dimension(1920, 973));
    }

    public void OpenHomePage() {
        driver.findElement(By.linkText("Home")).click();
    }

    public void Login(AccountData accountData) {
        driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By.id("username")).sendKeys(accountData.getUsername());
        driver.findElement(By.id("password")).sendKeys(accountData.getPassword());
        driver.findElement(By.id("password")).sendKeys(Keys.ENTER);
    }

    public void OpenURL() {
        driver.get("http://redmine.testbase.ru/");
    }
}
