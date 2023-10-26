package edu.hw2.task4;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class CallingInfoTest {

    @Test
    @DisplayName("Проверка имени класса и метода")
    void callingInfoReturnCorrectStackTraceElement() {
        CallingInfo callingInfo = CallingInfo.callingInfo();

        assertEquals("edu.hw2.task4.CallingInfoTest", callingInfo.className());
        assertEquals("callingInfoReturnCorrectStackTraceElement", callingInfo.methodName());
    }

    @Test
    @DisplayName("Имя класса и имя метода не null")
    void callingInfoShouldNotNull() {
        CallingInfo callingInfo = CallingInfo.callingInfo();

        assertNotNull(callingInfo.className());
        assertNotNull(callingInfo.methodName());
    }

    @Test
    @DisplayName("Имя класса и имя метода не Empty")
    void callingInfoShouldNonEmpty() {
        CallingInfo callingInfo = CallingInfo.callingInfo();

        assertFalse(callingInfo.className().isEmpty());
        assertFalse(callingInfo.methodName().isEmpty());
    }
}

