package edu.project3.logWorkers;

import edu.project3.Table;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogParser {

    private final List<String> columnNames = Arrays.asList(
        "remote_addr",
        "remote_user",
        "time_local",
        "request_type",
        "request",
        "protocol",
        "status",
        "body_bytes_sent",
        "http_referer",
        "http_user_agent"
    );

    private final Pattern dateTimePattern = Pattern.compile(
        "\\d{2}/[A-Z][a-z]{2}/\\d{4}:\\d{2}:\\d{2}:\\d{2} [\\-|\\+]\\d{4}"
    );

    private final Pattern logPattern = Pattern.compile(
        "(\\d{1,4}\\.\\d{1,4}\\.\\d{1,4}\\.\\d{1,4}) - ([^ ]+) " +
            "\\[(" + dateTimePattern + ")\\] \\\"(\\w+) {1}(.+) " +
            "(HTTP/.+)\\\" (\\d+) (\\d+) \\\"(.+)\\\" \\\"(.+)\\\""
    );

    public Table parseAllLogs(List<String> logs) {
        List<Map<String, String>> parsedLogs = new ArrayList<>();
        for (String log : logs) {
            Map<String, String> parsedLog = parseLog(log);
            if (parsedLog != null) {
                parsedLogs.add(parsedLog);
            }
        }
        return new Table(parsedLogs);
    }

    public Map<String, String> parseLog(String log) {
        Matcher matcher = logPattern.matcher(log);
        if (!matcher.matches()) {
            return null;
        }

        Map<String, String> parsedLog = new HashMap<>();
        for (int i = 1; i <= matcher.groupCount(); i++) {
            parsedLog.put(columnNames.get(i - 1), matcher.group(i));
        }

        return parsedLog;
    }

    public List<String> combineLogs(List<String> sources) {
        List<String> nonParsedSources = new ArrayList<>();
        for (String src : sources) {
            try {
                if (src.matches("^(?:http)s?:\\/\\/.*$")) {
                    nonParsedSources.addAll(Arrays.asList(Objects.requireNonNull(new URL(src).getContent()).toString().split("\n")));
                } else {
                    nonParsedSources.addAll(Files.readAllLines(Paths.get(src)));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return nonParsedSources;
    }
}
