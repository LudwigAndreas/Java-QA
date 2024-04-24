package org.example;

import org.example.model.AccountData;
import org.example.model.IssueData;
import org.junit.Assert;
import org.junit.Test;


public class RedminetestbasefirstTestTest extends TestBase {

    @Test
    public void loginTest() {
        manager.Navigate().OpenUrl();
        manager.SetWindowSize();
        AccountData user = new AccountData("LudwigAndreas",
                "xnG^xWkX4aV");
        manager.toLogin().Login(user);
    }

    @Test
    public void redminetestbasefirstTest() {
//        manager.Navigate().OpenUrl();
//        manager.SetWindowSize();
//        AccountData user = new AccountData("LudwigAndreas",
//                "xnG^xWkX4aV");
//        manager.toLogin().Login(user);
        manager.Navigate().OpenHomePage();
        IssueData issueData = new IssueData("Selenium created issue 1",
                "Selenium created description 1",
                "01/02/2025");
        manager.groupNew().CreateNewIssue(issueData);
        manager.Navigate().WayToIssue();
        Integer lastId = manager.Navigate().WayToLastCreatedIssue();
        IssueData savedIssueData = manager.groupNew().GetCreatedGroupData(lastId);
        Assert.assertEquals(issueData.getIssueSubject(), savedIssueData.getIssueSubject());
        Assert.assertEquals(issueData.getIssueDescription(), savedIssueData.getIssueDescription());
        Assert.assertEquals(issueData.getIssueDueDate(), savedIssueData.getIssueDueDate());

    }


}
