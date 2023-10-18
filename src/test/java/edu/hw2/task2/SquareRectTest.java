package edu.hw2.task2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SquareRectTest {

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
        Square square = new Square().setWidth(10);
        assertEquals(10, square.getWidth());
        assertEquals(10, square.getHeight());
    }

    @Test
    @DisplayName("Нельзя использовать setHeight в Square")
    void testChainedSquare() {
        Rectangle rect = new Square().setWidth(10).setHeight(5);
        Square square = new Square().setWidth(10);

        assertEquals(50.0, rect.area());
        assertEquals(100.0, square.area());
    }

    @Test
    void testInvalidWidth() {
        IllegalArgumentException exception = org.junit.jupiter.api.Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> new Rectangle().setWidth(-1)
        );
        assertEquals("Width must be positive", exception.getMessage());
    }

    @Test
    void testInvalidHeight() {
        IllegalArgumentException exception = org.junit.jupiter.api.Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> new Rectangle().setHeight(-1)
        );
        assertEquals("Height must be positive", exception.getMessage());
    }
}

