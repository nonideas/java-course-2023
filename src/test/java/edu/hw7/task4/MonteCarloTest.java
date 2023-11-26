package edu.hw7.task4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MonteCarloTest {
    @Test
    void testMono() {
        MonteCarlo monteCarloPi = new MonteCarloMono();
        double result = monteCarloPi.calculatePi(10000000);
        Assertions.assertTrue(result > 3.14 && result < 3.15);
    }

    @Test
    void testAsync() {
        MonteCarlo monteCarloPi = new MonteCarloAsync(4);
        double result = monteCarloPi.calculatePi(10000000);
        Assertions.assertTrue(result > 3.14 && result < 3.15);
    }


    @Test
    void testDiffAsyncMono() {
        MonteCarlo monteCarloPi = new MonteCarloMono();
        double resultSingleThread = monteCarloPi.calculatePi(10000000);
        monteCarloPi = new MonteCarloAsync(4);
        double resultMultipleThread = monteCarloPi.calculatePi(10000000);
        Assertions.assertEquals(resultSingleThread, resultMultipleThread, 0.01);
    }

    @Test
    void calculateTime() {
        MonteCarlo monteCarloPi = new MonteCarloMono();
        double startMono = System.currentTimeMillis();
        double resultSingleThread = monteCarloPi.calculatePi(10000000);
        double endMono = System.currentTimeMillis();
        monteCarloPi = new MonteCarloAsync(4);
        double startAsync = System.currentTimeMillis();
        double resultMultipleThread = monteCarloPi.calculatePi(10000000);
        double endAsync = System.currentTimeMillis();
        System.out.println(resultSingleThread);
        System.out.println(resultMultipleThread);
        System.out.println(endMono - startMono);
        System.out.println(endAsync - startAsync);
        System.out.println( (endMono - startMono) / (endAsync - startAsync));
    }
    /* для 10 млн измерений ускорение примерно в 3.3 раза, погрешность 0,001
    *  для 100 млн измерений ускорение примерно в 3.7 раза, погрешность 0,0001
    *  для 1 млрд измерений ускорение примерно в 3.63 раза, погрешность 0,00004
    */
}
