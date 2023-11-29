package edu.project3.logWorkers;

import edu.project3.Table;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.logging.log4j.LogManager;

public class LogParser {
    private static final org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger();
    private static final List<String> COLUMN_NAMES = Arrays.asList(
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

    private static final Pattern DATE_TIME_PATTERN = Pattern.compile(
        "\\d{2}/[A-Z][a-z]{2}/\\d{4}:\\d{2}:\\d{2}:\\d{2} [\\-|\\+]\\d{4}"
    );

    private static final Pattern LOG_PATTERN = Pattern.compile(
        "(\\d{1,4}\\.\\d{1,4}\\.\\d{1,4}\\.\\d{1,4}) - ([^ ]+) "
            + "\\[(" + DATE_TIME_PATTERN + ")\\] \\\"(\\w+) {1}(.+) "
            + "(HTTP/.+)\\\" (\\d+) (\\d+) \\\"(.+)\\\" \\\"(.+)\\\""
    );

    private LogParser() {
    }

    public static Table parseAllLogs(List<String> logs) {
        List<Map<String, String>> parsedLogs = new ArrayList<>();
        for (String log : logs) {
            Map<String, String> parsedLog = parseLog(log);
            if (parsedLog != null) {
                parsedLogs.add(parsedLog);
            }
        }
        return new Table(parsedLogs);
    }

    public static Map<String, String> parseLog(String log) {
        Matcher matcher = LOG_PATTERN.matcher(log);
        if (!matcher.matches()) {
            return null;
        }

        Map<String, String> parsedLog = new HashMap<>();
        for (int i = 1; i <= matcher.groupCount(); i++) {
            parsedLog.put(COLUMN_NAMES.get(i - 1), matcher.group(i));
        }

        return parsedLog;
    }

    public static List<String> combineLogs(List<String> sources) {
        List<String> nonParsedSources = new ArrayList<>();
        for (String src : sources) {
            try {
                if (src.matches("^(?:http)s?:\\/\\/.*$")) {
                    nonParsedSources.addAll(Arrays.asList(Objects.requireNonNull(new URL(src).getContent()).toString()
                        .split("\n")));
                } else {
                    nonParsedSources.addAll(Files.readAllLines(Paths.get(src)));
                }
            } catch (IOException e) {
                LOGGER.info(e.getMessage());
            }
        }
        return nonParsedSources;
    }
}
