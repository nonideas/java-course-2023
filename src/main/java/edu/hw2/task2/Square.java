package edu.hw2.task2;

final class Square extends Rectangle {
    @Override
    Square setWidth(int size) {
        super.setWidth(size);
        super.setHeight(size);
        return this;
    }
}
