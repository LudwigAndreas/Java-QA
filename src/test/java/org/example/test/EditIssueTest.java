package org.example.test;

import org.example.model.IssueData;
import org.junit.Assert;
import org.junit.Test;

public class EditIssueTest extends TestBase {

    @Test
    public void editIssueTest() {
        if (!manager.toLogin().isLogged(authBase.getAccountData())) {
            manager.toLogin().login(authBase.getAccountData());
        }
        Integer lastId = manager.navigationHelper().wayToLastCreatedIssue();
        IssueData issueData = new IssueData("Selenium created issue 1",
                 "Selenium created description 1",
                 "01/01/2025");

        manager.navigationHelper().wayToIssue(lastId);

         manager.issueHelper().editIssue(issueData);

         IssueData savedIssueData = manager.issueHelper().getCreatedIssueData(lastId);
         Assert.assertEquals(issueData.getIssueSubject(), savedIssueData.getIssueSubject());
         Assert.assertEquals(issueData.getIssueDescription(), savedIssueData.getIssueDescription());
         Assert.assertEquals(issueData.getIssueDueDate(), savedIssueData.getIssueDueDate());

    }
}
