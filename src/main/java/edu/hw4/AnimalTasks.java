package edu.hw4;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AnimalTasks {
    private AnimalTasks() {
    }

    // Отсортировать животных по росту от самого маленького к самому большому -> List<Animal>
    public static List<Animal> task1(List<Animal> animals) {
        return animals.stream()
            .sorted(Comparator.comparingInt(Animal::height)).toList();
    }

    // Отсортировать животных по весу от самого тяжелого к самому легкому, выбрать k первых -> List<Animal>
    public static List<Animal> task2(List<Animal> animals, int k) {
        return animals.stream()
            .sorted(Comparator.comparingInt(Animal::weight).reversed()).limit(k).toList();
    }

    // Сколько животных каждого вида -> Map<Animal.Type, Integer>
    public static Map<Animal.Type, Integer> task3(List<Animal> animals) {
        return animals.stream()
            .collect(Collectors.groupingBy(Animal::type, Collectors.summingInt(animal -> 1)));
    }

    // У какого животного самое длинное имя -> Animal
    public static Animal task4(List<Animal> animals) {
        return animals.stream()
            .max(Comparator.comparingInt(animal -> animal.name().length())).orElse(null);
    }

    // Каких животных больше: самцов или самок -> Sex
    public static Animal.Sex task5(List<Animal> animals) {
        long male = animals.stream()
            .filter(animal -> animal.sex() == Animal.Sex.M).count();

        long female = animals.stream()
            .filter(animal -> animal.sex() == Animal.Sex.F).count();

        return male > female ? Animal.Sex.M : Animal.Sex.F;
    }

    // Самое тяжелое животное каждого вида -> Map<Animal.Type, Animal>
    public static Map<Animal.Type, Animal> task6(List<Animal> animals) {
        return animals.stream()
            .collect(Collectors.toMap(
                Animal::type,
                Function.identity(),
                BinaryOperator.maxBy(Comparator.comparingInt(Animal::weight))
            ));
    }

    // K-е самое старое животное -> Animal
    public static Animal task7(List<Animal> animals, int k) {
        return animals.stream()
            .sorted(Comparator.comparingInt(Animal::age).reversed())
            .skip(k - 1).findFirst().orElse(null);
    }

    // Самое тяжелое животное среди животных ниже k см -> Optional<Animal>
    public static Optional<Animal> task8(List<Animal> animals, int k) {
        return animals.stream()
            .filter(animal -> animal.height() < k)
            .max(Comparator.comparingInt(Animal::weight));
    }

    // Сколько в сумме лап у животных в списке -> Integer
    public static Integer task9(List<Animal> animals) {
        return animals.stream()
            .mapToInt(Animal::paws).sum();
    }

    // Список животных, возраст у которых не совпадает с количеством лап -> List<Animal>
    public static List<Animal> task10(List<Animal> animals) {
        return animals.stream()
            .filter(animal -> animal.paws() != animal.age()).toList();
    }

    // Список животных, которые могут укусить (bites == null или true) и рост которых превышает 100 см -> List<Animal>
    @SuppressWarnings("MagicNumber")
    public static List<Animal> task11(List<Animal> animals) {
        return animals.stream()
            .filter(animal -> animal.bites() && animal.height() > 100).toList();
    }

    // Сколько в списке животных, вес которых превышает рост -> Integer
    public static Integer task12(List<Animal> animals) {
        return (int) animals.stream()
            .filter(animal -> animal.weight() > animal.height()).count();
    }

    // Список животных, имена которых состоят из более чем двух слов -> List<Animal>
    public static List<Animal> task13(List<Animal> animals) {
        return animals.stream()
            .filter(animal -> animal.name().split(" ").length >= 2).toList();
    }

    // Есть ли в списке собака ростом более k см -> Boolean
    public static Boolean task14(List<Animal> animals, int k) {
        return animals.stream()
            .anyMatch(animal -> animal.height() > k && animal.type() == Animal.Type.DOG);
    }

    // Найти суммарный вес животных каждого вида, которым от k до l лет -> Integer
    public static Map<Animal.Type, Integer> task15(List<Animal> animals, int k, int l) {
        return animals.stream()
            .filter(animal -> animal.age() > k && animal.age() < l)
            .collect(Collectors.groupingBy(Animal::type, Collectors.summingInt(Animal::weight)));
    }

    // Список животных, отсортированный по виду, затем по полу, затем по имени -> List<Integer>
    public static List<Animal> task16(List<Animal> animals) {
        return animals.stream()
            .sorted(Comparator
                .comparing(Animal::type)
                .thenComparing(Animal::sex)
                .thenComparing(Animal::name)
            ).toList();
    }

    // Правда ли, что пауки кусаются чаще, чем собаки -> Boolean (если данных для ответа недостаточно, вернуть false)
    public static Boolean task17(List<Animal> animals) {
        long biteSpiders = animals.stream()
            .filter(animal -> animal.type() == Animal.Type.SPIDER && animal.bites()).count();

        long biteDogs = animals.stream()
            .filter(animal -> animal.type() == Animal.Type.DOG && animal.bites()).count();

        return biteSpiders > biteDogs;
    }

    // Найти самую тяжелую рыбку в 2-х или более списках -> Animal
    public static Animal task18(List<List<Animal>> animalLists) {
        return animalLists.stream()
            .flatMap(List::stream)
            .filter(animal -> animal.type() == Animal.Type.FISH)
            .max(Comparator.comparing(Animal::weight)).orElse(null);
    }

    // Животные, в записях о которых есть ошибки: вернуть имя и список ошибок -> Map<String, Set<ValidationError>>.
    //Класс ValidationError и набор потенциальных проверок нужно придумать самостоятельно.
    public static Map<String, Set<ValidationError>> task19(List<Animal> animals) {
        return animals.stream()
            .collect(Collectors.toMap(Animal::name, ValidationError::validateAnimal))
            .entrySet().stream()
            .filter(entry -> !entry.getValue().isEmpty())
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    // Сделать результат предыдущего задания более читабельным:
    // вернуть имя и названия полей с ошибками, объединенные в строку -> Map<String, String>
    public static Map<String, String> task20(List<Animal> animals) {
        return animals.stream()
            .collect(Collectors.toMap(
                Animal::name,
                animal -> {
                    Set<ValidationError> errors = ValidationError.validateAnimal(animal);
                    StringBuilder errorsBuilder = new StringBuilder();
                    for (ValidationError error : errors) {
                        errorsBuilder.append(error.message()).append("; ");
                    }
                    return errorsBuilder.toString();
                }
            )).entrySet().stream()
            .filter(entry -> !entry.getValue().isEmpty())
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
