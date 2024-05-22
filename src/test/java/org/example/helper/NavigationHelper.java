package org.example.helper;

import org.example.ApplicationManager;
import org.example.settings.Settings;
import org.openqa.selenium.By;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(ApplicationManager manager) {
        super(manager);
    }

    public void wayToIssueList() {
        driver.findElement(By.linkText("Projects")).click();
        driver.findElement(By.linkText("Test")).click();
        driver.findElement(By.linkText("Issues")).click();
    }

    public void wayToNewIssue() {
        driver.findElement(By.linkText("New issue")).click();
    }

    public void wayToIssue(Integer id) {
        wayToIssueList();
        driver.findElement(By.linkText(id.toString())).click();
    }

    public Integer wayToLastCreatedIssue() {
        wayToIssueList();
        Integer lastId = manager.issueHelper().lastCreatedIssueId();
        driver.findElement(By.linkText(lastId.toString())).click();
        return lastId;
    }

    public void wayToLogin() {
        driver.findElement(By.linkText("Sign in")).click();
    }

    public void openHomePage() {
        driver.findElement(By.linkText("Home")).click();
    }

    public void openUrl() {
        driver.get(Settings.getBaseUrl());
    }

}
