package edu.hw4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

public class AnimalTaskTest {
    public static Stream<Arguments> testData() {
        return Stream.of(
            Arguments.of(List.of(
                new Animal("Cat Mike", Animal.Type.CAT, Animal.Sex.M, 3, 35, 5, false),
                new Animal("Dog Vasil", Animal.Type.DOG, Animal.Sex.F, 4, 50, 8, true),
                new Animal("Bird Taras", Animal.Type.BIRD, Animal.Sex.M, 2, 20, 2, false),
                new Animal("Fish Fos", Animal.Type.FISH, Animal.Sex.F, 1, 15, 2, false),
                new Animal("Spider Spun", Animal.Type.SPIDER, Animal.Sex.M, 1, 5, 1, true),
                new Animal("BIRD", Animal.Type.BIRD, Animal.Sex.M, 3, 50, 6, false),
                new Animal("FISH", Animal.Type.FISH, Animal.Sex.F, 6, 135, 20, false),
                new Animal("SPIDER", Animal.Type.SPIDER, Animal.Sex.F, 3, 8, 2, true),
                new Animal("CAT", Animal.Type.CAT, Animal.Sex.M, 5, 151, 201, true),
                new Animal("DOG", Animal.Type.DOG, Animal.Sex.M, 23, -300, 800, false),
                new Animal("FISH2", Animal.Type.FISH, Animal.Sex.M, 20, 200, 500, true),
                new Animal("BIRD2", Animal.Type.BIRD, Animal.Sex.M, 4, 31, 5, false),
                new Animal("CAT2", Animal.Type.CAT, Animal.Sex.F, 12, -14, 2, false),
                new Animal("SPIDER2", Animal.Type.SPIDER, Animal.Sex.M, 2, 6, 7, false),
                new Animal("DOG2", Animal.Type.DOG, Animal.Sex.F, 5, 15, -2, false)
            ))
        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    void testTask1(List<Animal> inputAnimalList) {
        List<Animal> rightOutput = List.of(
            new Animal("DOG", Animal.Type.DOG, Animal.Sex.M, 23, -300, 800, false),
            new Animal("CAT2", Animal.Type.CAT, Animal.Sex.F, 12, -14, 2, false),
            new Animal("Spider Spun", Animal.Type.SPIDER, Animal.Sex.M, 1, 5, 1, true),
            new Animal("SPIDER2", Animal.Type.SPIDER, Animal.Sex.M, 2, 6, 7, false),
            new Animal("SPIDER", Animal.Type.SPIDER, Animal.Sex.F, 3, 8, 2, true),
            new Animal("Fish Fos", Animal.Type.FISH, Animal.Sex.F, 1, 15, 2, false),
            new Animal("DOG2", Animal.Type.DOG, Animal.Sex.F, 5, 15, -2, false),
            new Animal("Bird Taras", Animal.Type.BIRD, Animal.Sex.M, 2, 20, 2, false),
            new Animal("BIRD2", Animal.Type.BIRD, Animal.Sex.M, 4, 31, 5, false),
            new Animal("Cat Mike", Animal.Type.CAT, Animal.Sex.M, 3, 35, 5, false),
            new Animal("Dog Vasil", Animal.Type.DOG, Animal.Sex.F, 4, 50, 8, true),
            new Animal("BIRD", Animal.Type.BIRD, Animal.Sex.M, 3, 50, 6, false),
            new Animal("FISH", Animal.Type.FISH, Animal.Sex.F, 6, 135, 20, false),
            new Animal("CAT", Animal.Type.CAT, Animal.Sex.M, 5, 151, 201, true),
            new Animal("FISH2", Animal.Type.FISH, Animal.Sex.M, 20, 200, 500, true)
        );
        Assertions.assertEquals(rightOutput, AnimalTasks.task1(inputAnimalList));
    }

    @ParameterizedTest
    @MethodSource("testData")
    void testTask2(List<Animal> inputAnimalList) {
        int k = 2;
        List<Animal> rightOutput = List.of(
            new Animal("DOG", Animal.Type.DOG, Animal.Sex.M, 23, -300, 800, false),
            new Animal("FISH2", Animal.Type.FISH, Animal.Sex.M, 20, 200, 500, true)
        );
        Assertions.assertEquals(rightOutput, AnimalTasks.task2(inputAnimalList, k));
    }

    @ParameterizedTest
    @MethodSource("testData")
    void testTask3(List<Animal> inputAnimalList) {
        Map<Animal.Type, Integer> rightOutput = Map.of(
            Animal.Type.DOG, 3,
            Animal.Type.FISH, 3,
            Animal.Type.CAT, 3,
            Animal.Type.BIRD, 3,
            Animal.Type.SPIDER, 3
        );

        Assertions.assertEquals(rightOutput, AnimalTasks.task3(inputAnimalList));
    }

    @ParameterizedTest
    @MethodSource("testData")
    void testTask4(List<Animal> inputAnimalList) {
        Animal rightOutput = new Animal("Spider Spun", Animal.Type.SPIDER, Animal.Sex.M, 1, 5, 1, true);

        Assertions.assertEquals(rightOutput, AnimalTasks.task4(inputAnimalList));
    }

    @ParameterizedTest
    @MethodSource("testData")
    void testTask5(List<Animal> inputAnimalList) {
        Animal.Sex rightOutput = Animal.Sex.M;

        Assertions.assertEquals(rightOutput, AnimalTasks.task5(inputAnimalList));
    }

    @ParameterizedTest
    @MethodSource("testData")
    void testTask6(List<Animal> inputAnimalList) {
        Map<Animal.Type, Animal> rightOutput = Map.of(
            Animal.Type.DOG, new Animal("DOG", Animal.Type.DOG, Animal.Sex.M, 23, -300, 800, false),
            Animal.Type.FISH, new Animal("FISH2", Animal.Type.FISH, Animal.Sex.M, 20, 200, 500, true),
            Animal.Type.CAT, new Animal("CAT", Animal.Type.CAT, Animal.Sex.M, 5, 151, 201, true),
            Animal.Type.BIRD, new Animal("BIRD", Animal.Type.BIRD, Animal.Sex.M, 3, 50, 6, false),
            Animal.Type.SPIDER, new Animal("SPIDER2", Animal.Type.SPIDER, Animal.Sex.M, 2, 6, 7, false)
        );

        Assertions.assertEquals(rightOutput, AnimalTasks.task6(inputAnimalList));
    }

    @ParameterizedTest
    @MethodSource("testData")
    void testTask7(List<Animal> inputAnimalList) {
        int k = 3;

        Animal rightOutput = new Animal("CAT2", Animal.Type.CAT, Animal.Sex.F, 12, -14, 2, false);

        Assertions.assertEquals(rightOutput, AnimalTasks.task7(inputAnimalList, k));
    }

    @ParameterizedTest
    @MethodSource("testData")
    void testTask8(List<Animal> inputAnimalList) {
        int k = 10;

        Optional<Animal> rightOutput = Optional.of(new Animal("DOG", Animal.Type.DOG, Animal.Sex.M, 23, -300, 800, false));

        Assertions.assertEquals(rightOutput, AnimalTasks.task8(inputAnimalList, k));
    }

    @ParameterizedTest
    @MethodSource("testData")
    void testTask9(List<Animal> inputAnimalList) {
        Integer rightOutput = 54;

        Assertions.assertEquals(rightOutput, AnimalTasks.task9(inputAnimalList));
    }

    @ParameterizedTest
    @MethodSource("testData")
    void testTask10(List<Animal> inputAnimalList) {
        List<Animal> rightOutput = List.of(
            new Animal("Cat Mike", Animal.Type.CAT, Animal.Sex.M, 3, 35, 5, false),
            new Animal("Fish Fos", Animal.Type.FISH, Animal.Sex.F, 1, 15, 2, false),
            new Animal("Spider Spun", Animal.Type.SPIDER, Animal.Sex.M, 1, 5, 1, true),
            new Animal("BIRD", Animal.Type.BIRD, Animal.Sex.M, 3, 50, 6, false),
            new Animal("FISH", Animal.Type.FISH, Animal.Sex.F, 6, 135, 20, false),
            new Animal("SPIDER", Animal.Type.SPIDER, Animal.Sex.F, 3, 8, 2, true),
            new Animal("CAT", Animal.Type.CAT, Animal.Sex.M, 5, 151, 201, true),
            new Animal("DOG", Animal.Type.DOG, Animal.Sex.M, 23, -300, 800, false),
            new Animal("FISH2", Animal.Type.FISH, Animal.Sex.M, 20, 200, 500, true),
            new Animal("BIRD2", Animal.Type.BIRD, Animal.Sex.M, 4, 31, 5, false),
            new Animal("CAT2", Animal.Type.CAT, Animal.Sex.F, 12, -14, 2, false),
            new Animal("SPIDER2", Animal.Type.SPIDER, Animal.Sex.M, 2, 6, 7, false),
            new Animal("DOG2", Animal.Type.DOG, Animal.Sex.F, 5, 15, -2, false)
        );
        Assertions.assertEquals(rightOutput, AnimalTasks.task10(inputAnimalList));
    }

    @ParameterizedTest
    @MethodSource("testData")
    void testTask11(List<Animal> inputAnimalList) {
        List<Animal> rightOutput = List.of(
            new Animal("CAT", Animal.Type.CAT, Animal.Sex.M, 5, 151, 201, true),
            new Animal("FISH2", Animal.Type.FISH, Animal.Sex.M, 20, 200, 500, true)
        );
        Assertions.assertEquals(rightOutput, AnimalTasks.task11(inputAnimalList));
    }

    @ParameterizedTest
    @MethodSource("testData")
    void testTask12(List<Animal> inputAnimalList) {
        Integer rightOutput = 5;
        Assertions.assertEquals(rightOutput, AnimalTasks.task12(inputAnimalList));
    }

    @ParameterizedTest
    @MethodSource("testData")
    void testTask13(List<Animal> inputAnimalList) {
        List<Animal> rightOutput = List.of(
            new Animal("Cat Mike", Animal.Type.CAT, Animal.Sex.M, 3, 35, 5, false),
            new Animal("Dog Vasil", Animal.Type.DOG, Animal.Sex.F, 4, 50, 8, true),
            new Animal("Bird Taras", Animal.Type.BIRD, Animal.Sex.M, 2, 20, 2, false),
            new Animal("Fish Fos", Animal.Type.FISH, Animal.Sex.F, 1, 15, 2, false),
            new Animal("Spider Spun", Animal.Type.SPIDER, Animal.Sex.M, 1, 5, 1, true)
        );
        Assertions.assertEquals(rightOutput, AnimalTasks.task13(inputAnimalList));
    }

    @ParameterizedTest
    @MethodSource("testData")
    void testTask14(List<Animal> inputAnimalList) {
        Assertions.assertTrue(AnimalTasks.task14(inputAnimalList, 10));
        Assertions.assertFalse(AnimalTasks.task14(inputAnimalList, 70));
    }

    @ParameterizedTest
    @MethodSource("testData")
    void testTask15(List<Animal> inputAnimalList) {
        Map<Animal.Type, Integer> rightOutput = Map.of(
            Animal.Type.FISH, 520,
            Animal.Type.CAT, 2
        );
        Assertions.assertEquals(rightOutput, AnimalTasks.task15(inputAnimalList, 5, 21));
    }

    @ParameterizedTest
    @MethodSource("testData")
    void testTask16(List<Animal> inputAnimalList) {
        List<Animal> rightOutput = List.of(
            new Animal("CAT", Animal.Type.CAT, Animal.Sex.M, 5, 151, 201, true),
            new Animal("Cat Mike", Animal.Type.CAT, Animal.Sex.M, 3, 35, 5, false),
            new Animal("CAT2", Animal.Type.CAT, Animal.Sex.F, 12, -14, 2, false),
            new Animal("DOG", Animal.Type.DOG, Animal.Sex.M, 23, -300, 800, false),
            new Animal("DOG2", Animal.Type.DOG, Animal.Sex.F, 5, 15, -2, false),
            new Animal("Dog Vasil", Animal.Type.DOG, Animal.Sex.F, 4, 50, 8, true),
            new Animal("BIRD", Animal.Type.BIRD, Animal.Sex.M, 3, 50, 6, false),
            new Animal("BIRD2", Animal.Type.BIRD, Animal.Sex.M, 4, 31, 5, false),
            new Animal("Bird Taras", Animal.Type.BIRD, Animal.Sex.M, 2, 20, 2, false),
            new Animal("FISH2", Animal.Type.FISH, Animal.Sex.M, 20, 200, 500, true),
            new Animal("FISH", Animal.Type.FISH, Animal.Sex.F, 6, 135, 20, false),
            new Animal("Fish Fos", Animal.Type.FISH, Animal.Sex.F, 1, 15, 2, false),
            new Animal("SPIDER2", Animal.Type.SPIDER, Animal.Sex.M, 2, 6, 7, false),
            new Animal("Spider Spun", Animal.Type.SPIDER, Animal.Sex.M, 1, 5, 1, true),
            new Animal("SPIDER", Animal.Type.SPIDER, Animal.Sex.F, 3, 8, 2, true)
        );
        Assertions.assertEquals(rightOutput, AnimalTasks.task16(inputAnimalList));
    }

    @ParameterizedTest
    @MethodSource("testData")
    void testTask17(List<Animal> inputAnimalList) {
        Assertions.assertTrue(AnimalTasks.task17(inputAnimalList));
    }

    @Test
    void testTask18() {
        List<Animal> firstList = List.of(
            new Animal("CAT", Animal.Type.CAT, Animal.Sex.M, 7, 151, 201, true),
            new Animal("FISH1", Animal.Type.FISH, Animal.Sex.M, 20, 100, 200, true),
            new Animal("FISH2", Animal.Type.FISH, Animal.Sex.M, 13, 200, 100, true),
            new Animal("CAT1", Animal.Type.CAT, Animal.Sex.M, 8, 201, 300, true)
        );

        List<Animal> secondList = List.of(
            new Animal("DOG", Animal.Type.DOG, Animal.Sex.M, 7, 151, 201, true),
            new Animal("FISH3", Animal.Type.FISH, Animal.Sex.M, 20, 200, 500, true),
            new Animal("FISH4", Animal.Type.FISH, Animal.Sex.M, 13, 400, 600, true),
            new Animal("BIRD", Animal.Type.BIRD, Animal.Sex.M, 3, 201, 300, true),
            new Animal("SPIDER", Animal.Type.SPIDER, Animal.Sex.M, 1000, 1000, 1000, true)
        );

        List<List<Animal>> inputAnimalLists = new ArrayList<>();
        inputAnimalLists.add(firstList);
        inputAnimalLists.add(secondList);

        Animal rightOutput = new Animal("FISH4", Animal.Type.FISH, Animal.Sex.M, 13, 400, 600, true);

        Assertions.assertEquals(rightOutput, AnimalTasks.task18(inputAnimalLists));
    }

    @ParameterizedTest
    @MethodSource("testData")
    void testTask19(List<Animal> inputAnimalList) {
        Set<ValidationError> DOGErrors = Set.of(
            new ValidationError("height less zero")
        );

        Set<ValidationError> CAT2Errors = Set.of(
            new ValidationError("height less zero")
        );

        Set<ValidationError> DOG2Errors = Set.of(
            new ValidationError("weight less zero")
        );

        Map<String, Set<ValidationError>> rightOutput = Map.of(
            "DOG", DOGErrors,
            "CAT2", CAT2Errors,
            "DOG2", DOG2Errors
        );

        Assertions.assertEquals(rightOutput, AnimalTasks.task19(inputAnimalList));
    }

    @ParameterizedTest
    @MethodSource("testData")
    void testTask20(List<Animal> inputAnimalList) {
        Map<String, String> rightOutput = Map.of(
            "CAT2", "height less zero; ",
            "DOG2", "weight less zero; ",
            "DOG", "height less zero; "
        );
        System.out.println(AnimalTasks.task20(inputAnimalList));
        Assertions.assertEquals(rightOutput, AnimalTasks.task20(inputAnimalList));
    }
}
