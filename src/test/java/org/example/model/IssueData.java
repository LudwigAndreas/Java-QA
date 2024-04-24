package org.example.model;

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

    private String issueDueDate;

    public IssueData(String issueSubject, String issueDescription, String issueDueDate) {
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

    public String getIssueDueDate() {
        return issueDueDate;
    }

    public void setIssueDueDate(String issueDueDate) {
        this.issueDueDate = issueDueDate;
    }
}
