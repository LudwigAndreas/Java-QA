package org.example.model;

import java.time.LocalDate;

public class IssueData {

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private Integer id;

    private String issueSubject;

    private String issueDescription;

    private LocalDate issueDueDate;

    public IssueData(String issueSubject, String issueDescription, LocalDate issueDueDate) {
        this.issueSubject = issueSubject;
        this.issueDescription = issueDescription;
        this.issueDueDate = issueDueDate;
    }

    public IssueData() {
    }

    public String getIssueSubject() {
        return issueSubject;
    }

    public void setIssueSubject(String issueSubject) {
        this.issueSubject = issueSubject;
    }

    public String getIssueDescription() {
        return issueDescription;
    }

    public void setIssueDescription(String issueDescription) {
        this.issueDescription = issueDescription;
    }

    public LocalDate getIssueDueDate() {
        return issueDueDate;
    }

    public void setIssueDueDate(LocalDate issueDueDate) {
        this.issueDueDate = issueDueDate;
    }
}
