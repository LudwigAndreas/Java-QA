package org.example.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.example.model.IssueData;
import org.example.wrapper.IssueDataListWrapper;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;


public class IssueCreationTest extends TestBase {

    public static List<IssueData> issueDataFromXmlFile(String filename) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        return xmlMapper.readValue(new File(filename), IssueDataListWrapper.class).getIssueDataList();
    }

    @Test
    public void issueCreationTest() {
        if (!manager.toLogin().isLogged(authBase.getAccountData())) {
            manager.toLogin().login(authBase.getAccountData());
        }
        manager.navigationHelper().openHomePage();
        IssueData issueData = new IssueData("Selenium created issue 1",
                "Selenium created description 1",
                LocalDate.parse("2025-01-01"));

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

    @Test
    public void generatedIssueCreationTest() throws IOException {
        if (!manager.toLogin().isLogged(authBase.getAccountData())) {
            manager.toLogin().login(authBase.getAccountData());
        }
        manager.navigationHelper().openHomePage();
        List<IssueData> issueDataList = issueDataFromXmlFile("target/issues.xml");
        for (IssueData issueData : issueDataList) {
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
}
