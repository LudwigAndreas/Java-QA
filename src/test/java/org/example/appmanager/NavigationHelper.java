package org.example.appmanager;

import org.openqa.selenium.By;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(ApplicationManager manager) {
        super(manager);
    }

    public void WayToIssue() {
        driver.findElement(By.linkText("Projects")).click();
        driver.findElement(By.linkText("Test")).click();
        WayToListOfIssues();
    }

    public void WayToNewIssue() {
        driver.findElement(By.linkText("New issue")).click();
    }

    public Integer WayToLastCreatedIssue() {
        Integer lastId = manager.groupNew().LastCreatedGroupId();
        driver.findElement(By.linkText(lastId.toString())).click();
        return lastId;
    }

    public void WayToListOfIssues() {
        driver.findElement(By.linkText("Issues")).click();
    }

    public void WayToLogin() {
        driver.findElement(By.linkText("Sign in")).click();
    }

    public void OpenHomePage() {
        driver.findElement(By.linkText("Home")).click();
    }

    public void OpenUrl() {
        driver.get("http://redmine.testbase.ru/");
    }

}
