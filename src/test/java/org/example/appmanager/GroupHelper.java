package org.example.appmanager;

import org.example.model.IssueData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.NoSuchElementException;

public class GroupHelper extends HelperBase {

    public GroupHelper(ApplicationManager manager) {
        super(manager);
    }

    public void CreateNewIssue(IssueData issueData) {
        manager.Navigate().WayToIssue();
        manager.Navigate().WayToNewIssue();
        driver.findElement(By.id("issue_subject")).sendKeys(issueData.getIssueSubject());
        driver.findElement(By.id("issue_description")).sendKeys(issueData.getIssueDescription());
        driver.findElement(By.id("issue_due_date")).sendKeys(issueData.getIssueDueDate());
        driver.findElement(By.name("commit")).click();
        driver.findElement(By.cssSelector("html")).click();
    }

    public Integer LastCreatedGroupId() {
        List<WebElement> ids = driver.findElements(By.className("id"));
        Integer maxid = ids.stream()
                .map(WebElement::getText)
                .mapToInt(Integer::parseInt)
                .max().orElseThrow(NoSuchElementException::new);
        return maxid;
    }

    public IssueData GetCreatedGroupData(Integer id) {
        IssueData issueData = new IssueData();
        issueData.setId(id);
        issueData.setIssueSubject(
                driver.findElement(By.className("subject")).getText()
        );
        issueData.setIssueDescription(
            driver.findElement(By.className("wiki")).getText()
        );
        issueData.setIssueDueDate(
                driver.findElement(By.className("due-date")).getText().split("\n")[1]
        );
        return issueData;
    }
}
