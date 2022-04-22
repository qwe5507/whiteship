package com.java.study.whiteship.dashboard;

import org.kohsuke.github.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class dashboard {

    public static void main(String[] args) throws IOException {

        GitHub github = new GitHubBuilder().withOAuthToken("MY_TOKEN").build();

        //get Repository
        GHRepository repository = github.getRepository("whiteship/live-study");

        //get Issues
        List<GHIssue> issues = repository.getIssues(GHIssueState.ALL);

        Map<String, Double> userMap = new HashMap<>();

        for (GHIssue issue : issues) {
            List<GHIssueComment> comments = issue.getComments();

            for (GHIssueComment comment : comments) {
                String userName = comment.getUser().getName();
                userMap.put(userName, userMap.getOrDefault(userName, 0.0) + 1);
            }
        }

        for (String userName : userMap.keySet()) {
            Double percent = (userMap.get(userName) / issues.size()) * 100;
            System.out.printf("%s : %.2f ", userName, percent);
        }

    }
}
