package edu.hw2.task1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ExprTest {
    @Test
    @DisplayName("Test Constant")
    void testConstant() {
        Expr.Constant constant = new Expr.Constant(5.0);
        assertEquals(5.0, constant.evaluate());
    }

    @Test
    @DisplayName("Test Negate")
    void testNegate() {
        Expr.Constant constant = new Expr.Constant(5.0);
        Expr.Negate negate = new Expr.Negate(constant);
        assertEquals(-5.0, negate.evaluate());
    }

    @Test
    @DisplayName("Test Exponent")
    void testExponent() {
        Expr.Constant constant = new Expr.Constant(2.0);
        Expr.Exponent exponent = new Expr.Exponent(constant, 3);
        assertEquals(8.0, exponent.evaluate());
    }

    @Test
    @DisplayName("Test Addition")
    void testAddition() {
        Expr.Constant left = new Expr.Constant(3.0);
        Expr.Constant right = new Expr.Constant(2.0);
        Expr.Addition addition = new Expr.Addition(left, right);
        assertEquals(5.0, addition.evaluate());
    }

    @Test
    @DisplayName("Test Multiplication")
    void testMultiplication() {
        Expr.Constant left = new Expr.Constant(3.0);
        Expr.Constant right = new Expr.Constant(2.0);
        Expr.Multiplication multiplication = new Expr.Multiplication(left, right);
        assertEquals(6.0, multiplication.evaluate());
    }

    @Test
    @DisplayName("Test Constant with Negative Value")
    void testConstantWithNegativeValue() {
        Expr.Constant constant = new Expr.Constant(-5.0);
        assertEquals(-5.0, constant.evaluate());
    }

    @Test
    @DisplayName("Test Negate with Negative Value")
    void testNegateWithNegativeValue() {
        Expr.Constant constant = new Expr.Constant(-3.0);
        Expr.Negate negate = new Expr.Negate(constant);
        assertEquals(3.0, negate.evaluate());
    }

    @Test
    @DisplayName("Test Exponent with Negative Exponent")
    void testExponentWithNegativeExponent() {
        Expr.Constant constant = new Expr.Constant(2.0);
        Expr.Exponent exponent = new Expr.Exponent(constant, -1);
        assertEquals(0.5, exponent.evaluate());
    }

    @Test
    @DisplayName("Test Multiplication with Zero")
    void testMultiplicationWithZero() {
        Expr.Constant zero = new Expr.Constant(0.0);
        Expr.Constant constant = new Expr.Constant(10.0);
        Expr.Multiplication multiplication = new Expr.Multiplication(zero, constant);
        assertEquals(0.0, multiplication.evaluate());
    }
}
