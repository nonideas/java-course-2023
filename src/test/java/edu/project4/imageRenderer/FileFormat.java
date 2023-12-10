package edu.project4.imageRenderer;

public enum FileFormat {
    PNG("png"),
    JPEG("jpeg"),
    JPG("jpg");

    private final String stringRepresentation;

    FileFormat(String stringRepresentation) {
        this.stringRepresentation = stringRepresentation;
    }

    @Override public String toString() {
        return stringRepresentation;
    }
}
