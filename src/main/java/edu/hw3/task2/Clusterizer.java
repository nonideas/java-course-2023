package edu.hw3.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Clusterizer {

    private Clusterizer() {
    }

    public static List<String> clusterize(String input) {
        List<String> clusters = new ArrayList<>();
        Stack<Character> stack = new Stack<>();
        StringBuilder currentCluster = new StringBuilder();

        for (char ch : input.toCharArray()) {
            if (ch == '(') {
                currentCluster.append(ch);
                stack.push(ch);
            } else if (ch == ')') {
                if (stack.isEmpty()) {
                    return new ArrayList<>();
                }
                stack.pop();
                currentCluster.append(ch);
                if (stack.isEmpty()) {
                    clusters.add(currentCluster.toString());
                    currentCluster.setLength(0);
                }
            }
        }

        if (!stack.isEmpty()) {
            return new ArrayList<>();
        }

        return clusters;
    }
}

