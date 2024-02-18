package edu.hw6.task5;

import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static java.net.http.HttpClient.newHttpClient;

public class HackerNews {
    private HackerNews() {
    }

    public static long[] hackerNewsTopStories() {

        String responseBody = getResponseBody("topstories.json");

        String[] stringIds = responseBody.substring(1, responseBody.length() - 1).split(",");

        return Arrays.stream(stringIds).mapToLong(Long::parseLong).toArray();
    }

    public static String news(long id) {

        String responseBody = getResponseBody("item/" + id + ".json");

        Pattern pattern = Pattern.compile("\"title\":\"(.*?)\"");
        Matcher matcher = pattern.matcher(responseBody);

        if (matcher.find()) {
            return matcher.group(1);
        } else {
            return null;
        }
    }

    private static String getResponseBody(String req) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://hacker-news.firebaseio.com/v0/" + req))
                .build();

            return newHttpClient().send(request, HttpResponse.BodyHandlers.ofString()).body();

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
