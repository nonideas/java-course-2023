package edu.hw2.task2;

final class Square extends Rectangle {
    @Override
    Rectangle setWidth(int size) {
        if (this.height == 0) {
            this.width = size;
            this.height = size;
            return this;
        } else if (this.height == size) {
            return this;
        } else {
            Rectangle rectangle = new Rectangle();
            rectangle.setWidth(size);
            rectangle.setHeight(this.height);
            return rectangle;
        }
    }

    @Override
    Rectangle setHeight(int size) {
        if (this.width == 0) {
            this.width = size;
            this.height = size;
            return this;
        } else if (this.width == size) {
            return this;
        } else {
            Rectangle rectangle = new Rectangle();
            rectangle.setWidth(this.width);
            rectangle.setHeight(size);
            return rectangle;
        }
    }
}
