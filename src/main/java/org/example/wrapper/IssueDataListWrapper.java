package org.example.wrapper;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import org.example.model.IssueData;

import java.util.List;

public class IssueDataListWrapper {
    @JacksonXmlElementWrapper(localName = "issueDataList", useWrapping = false)
    @JacksonXmlProperty(localName = "issueData")
    private List<IssueData> issueDataList;

    public IssueDataListWrapper(List<IssueData> issueDataList) {
        this.issueDataList = issueDataList;
    }

    public IssueDataListWrapper() {
    }

    public void setIssueDataList(List<IssueData> issueDataList) {
        this.issueDataList = issueDataList;
    }

    public List<IssueData> getIssueDataList() {
        return issueDataList;
    }


}
