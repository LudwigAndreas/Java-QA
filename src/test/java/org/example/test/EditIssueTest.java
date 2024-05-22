package org.example.test;

import org.example.model.IssueData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.time.LocalDate;

public class EditIssueTest extends AuthBase {

    @BeforeEach
    public void setUp() {
        super.setUp();
    }

    @Test
    public void editIssueTest() {

        IssueData issueData = new IssueData("Selenium created issue 1",
                 "Selenium created description 1",
                LocalDate.parse("2025-01-01"));

        manager.navigationHelper().wayToIssueList();
        manager.navigationHelper().wayToNewIssue();
        manager.issueHelper().createNewIssue(issueData);

        Integer lastId = manager.navigationHelper().wayToLastCreatedIssue();
        manager.issueHelper().editIssue(issueData);

         IssueData savedIssueData = manager.issueHelper().getCreatedIssueData(lastId);
         Assertions.assertEquals(issueData.getIssueSubject(), savedIssueData.getIssueSubject());
         Assertions.assertEquals(issueData.getIssueDescription(), savedIssueData.getIssueDescription());
         Assertions.assertEquals(issueData.getIssueDueDate(), savedIssueData.getIssueDueDate());

    }
}
