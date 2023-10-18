package edu.hw2.task2;

class Rectangle {
    private int width;
    private int height;

    Rectangle setWidth(int width) {
        if (width <= 0) {
            throw new IllegalArgumentException("Width must be positive");
        }
        this.width = width;
        return this;
    }

    final Rectangle setHeight(int height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Height must be positive");
        }
        this.height = height;
        return this;
    }

    int getWidth() {
        return width;
    }

    int getHeight() {
        return height;
    }

    double area() {
        return width * height;
    }
}

