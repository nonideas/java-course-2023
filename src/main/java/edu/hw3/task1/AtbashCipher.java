package edu.hw3.task1;

public class AtbashCipher {
    private AtbashCipher() {
    }

    public static String atbash(String text) {
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char offset = Character.isLowerCase(c) ? 'a' : 'A';
                char mirroredChar = (char) (offset + ('z' - Character.toLowerCase(c)));
                result.append(mirroredChar);
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
}

