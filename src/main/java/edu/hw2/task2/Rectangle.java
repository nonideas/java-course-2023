package edu.hw2.task2;

class Rectangle {
    protected int width;
    protected int height;

    Rectangle setWidth(int width) {
        this.width = width;
        return this;
    }

    Rectangle setHeight(int height) {
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

