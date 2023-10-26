package edu.hw2.task2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class SquareRectTest {
    private static double isLsp(Rectangle rectangle) {
        return rectangle.setHeight(10).setWidth(20).area();
    }

    @Test
    @DisplayName("Площадь прямоугольника в функции")
    void testSquareRect() {
        assertEquals(200, isLsp(new Square()));
    }

    @Test
    @DisplayName("Площадь прямоугольника")
    void testRectangleArea() {
        Rectangle rect = new Rectangle().setWidth(10).setHeight(5);
        assertEquals(50.0, rect.area());
    }

    @Test
    @DisplayName("Площадь квадрата")
    void testSquareArea() {
        Rectangle square = new Square();
        square.setWidth(10);
        assertEquals(100.0, square.area());
    }

    @Test
    @DisplayName("Длина и высота квадрата")
    void testSquareWidthAndHeight() {
        Rectangle square = new Square().setWidth(10);
        assertEquals(10, square.getWidth());
        assertEquals(10, square.getHeight());
    }

    @Test
    @DisplayName("Нельзя использовать setHeight в Square")
    void testChainedSquare() {
        Rectangle rect = new Square().setWidth(10).setHeight(5);
        Rectangle square = new Square().setWidth(10);

        assertEquals(50.0, rect.area());
        assertEquals(100.0, square.area());
    }
}

