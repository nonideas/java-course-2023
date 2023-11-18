package edu.project3.parsers;

import edu.project3.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ParserLog implements Parser {
    List<String> columnNames = List.of(
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

    String logRegex =
        "(\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}) - ([^ ]+) " +
            "\\[(\\d{2}/[A-Z][a-z]{2}/\\d{4}:\\d{2}:\\d{2}:\\d{2} [\\-|\\+]\\d{4})\\] " +
            "\\\"(\\w+) {1}(.+) (HTTP/.+)\\\" (\\d+) (\\d+) \\\"(.+)\\\" \\\"(.+)\\\"";

    public Table parseLogs(String logs) {
        for (String log : logs.split("\n")) {
            var map = parseLog(log);
        }
    }

    public Map<String, String> parseLog(String log) {
        if (!log.matches(logRegex))
            return null;
    }
}
