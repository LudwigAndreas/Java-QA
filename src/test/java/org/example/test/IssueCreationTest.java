package org.example.test;

import org.example.model.IssueData;
import org.junit.Assert;
import org.junit.Test;

public class IssueCreationTest extends TestBase {

    @Test
    public void issueCreationTest() {
        if (!manager.toLogin().isLogged(authBase.getAccountData())) {
            manager.toLogin().login(authBase.getAccountData());
        }
        manager.navigationHelper().openHomePage();
        IssueData issueData = new IssueData("Selenium created issue 1",
                "Selenium created description 1",
                "01/01/2025");

//        Navigate to the issue list page
        manager.navigationHelper().wayToIssueList();
        manager.navigationHelper().wayToNewIssue();

        manager.issueHelper().createNewIssue(issueData);
        Integer lastId = manager.navigationHelper().wayToLastCreatedIssue();
        IssueData savedIssueData = manager.issueHelper().getCreatedIssueData(lastId);
        Assert.assertEquals(issueData.getIssueSubject(), savedIssueData.getIssueSubject());
        Assert.assertEquals(issueData.getIssueDescription(), savedIssueData.getIssueDescription());
        Assert.assertEquals(issueData.getIssueDueDate(), savedIssueData.getIssueDueDate());

    }
}
