package org.example.helper;

import org.example.ApplicationManager;
import org.example.model.AccountData;
import org.example.model.IssueData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.NoSuchElementException;

public class IssueHelper extends HelperBase {

    public IssueHelper(ApplicationManager manager) {
        super(manager);
    }

    public void createNewIssue(IssueData issueData) {
        driver.findElement(By.id("issue_subject")).sendKeys(issueData.getIssueSubject());
        driver.findElement(By.id("issue_description")).sendKeys(issueData.getIssueDescription());
        driver.findElement(By.id("issue_due_date")).sendKeys(issueData.getIssueDueDate().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        driver.findElement(By.name("commit")).click();
        driver.findElement(By.cssSelector("html")).click();
    }

    public void editIssue(IssueData issueData) {
        driver.findElement(By.linkText("Edit")).click();

        driver.findElement(By.id("issue_subject")).clear();
        driver.findElement(By.id("issue_subject")).sendKeys(issueData.getIssueSubject());
        driver.findElement(By.cssSelector("a > .icon")).click();
        driver.findElement(By.id("issue_description")).clear();
        driver.findElement(By.id("issue_description")).sendKeys(issueData.getIssueDescription());
        driver.findElement(By.id("issue_due_date")).clear();
        driver.findElement(By.id("issue_due_date")).sendKeys(issueData.getIssueDueDate().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        driver.findElement(By.cssSelector("input:nth-child(7)")).click();
    }

    public Integer lastCreatedIssueId() {
        List<WebElement> ids = driver.findElements(By.className("id"));
        return ids.stream()
                .map(WebElement::getText)
                .mapToInt(Integer::parseInt)
                .max().orElseThrow(NoSuchElementException::new);
    }

    public Integer lastCreatedIssueId(AccountData user) {
        List<WebElement> issues = driver.findElements(By.className("issue"));
        return issues.stream()
                .filter(issue -> issue.findElement(By.className("author")).getText().equals(user.getUsername())
                        || issue.findElement(By.className("author")).getText().equals(user.getFullNameReversed()))
                .map(issue -> issue.findElement(By.className("id")).getText())
                .mapToInt(Integer::parseInt)
                .max().orElseThrow(NoSuchElementException::new);
    }

    public IssueData getCreatedIssueData(Integer id) {
        IssueData issueData = new IssueData();
        issueData.setId(id);
        issueData.setIssueSubject(
                driver.findElement(By.className("subject")).getText()
        );
        issueData.setIssueDescription(
            driver.findElement(By.className("wiki")).getText()
        );
        issueData.setIssueDueDate(
                LocalDate.parse(driver.findElement(By.className("due-date")).getText().split("\n")[1], DateTimeFormatter.ofPattern("MM/dd/yyyy"))
        );
        return issueData;
    }

    public boolean isIssueEditable(AccountData user) {
        return driver.findElement(By.cssSelector(".author > .user")).getText().equals(
                user.getFullNameReversed()
        );
    }
}
