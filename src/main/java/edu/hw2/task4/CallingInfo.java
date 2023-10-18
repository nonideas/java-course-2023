package edu.hw2.task4;

public record CallingInfo(String className, String methodName) {

    public static CallingInfo callingInfo() {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        // Получаем элемент стека вызова, индекс 2 - это вызывающий метод, индекс 1 - это его класс
        StackTraceElement callingMethod = stackTraceElements[2];
        return new CallingInfo(callingMethod.getClassName(), callingMethod.getMethodName());
    }
}



