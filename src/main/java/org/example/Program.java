package org.example;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.example.model.IssueData;
import org.example.wrapper.IssueDataListWrapper;

public class Program {

    public static void main(String[] args) {
        String type = args[0];
        int count = Integer.parseInt(args[1]);
        String filename = args[2];
        String format = args[3];

        if (type.equals("issues")) {
            try {
                GenerateForIssues(count, filename, format);
            } catch (IOException e) {
                System.out.println("An error occurred." + e.getMessage());
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("Unrecognized type of data " + type);
        }
    }

    private static void GenerateForIssues(int count, String filename, String format) throws IOException {
        List<IssueData> issueDataList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            IssueData issueData = new IssueData();
            issueData.setIssueSubject(RandomizeString(97, 122, 10));
            issueData.setIssueDescription(RandomizeString(97, 122, 10));

            issueDataList.add(issueData);
        }
        if (format.equals("xml")) {
            File file = new File("target/" + filename);
            WriteGroupsToXmlFile(issueDataList, file);
        } else {
            System.out.println("Unrecognized format " + format);
        }
    }

    static void WriteGroupsToXmlFile(List<IssueData> groups, File file) throws IOException {
        XmlMapper mapper = new XmlMapper();
        mapper.writeValue(file, new IssueDataListWrapper(groups));
    }

    static String RandomizeString(int leftLimit, int rightLimit, int targetStringLength) {
        Random random = new Random();
        return random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
