package edu.hw4;

import java.util.HashSet;
import java.util.Set;

public record ValidationError(String message) {
    public static Set<ValidationError> validateAnimal(Animal animal) {
        Set<ValidationError> errors = new HashSet<>();

        if (animal.name().isEmpty()) {
            errors.add(new ValidationError("name is empty"));
        }
        if (animal.age() < 0) {
            errors.add(new ValidationError("age less zero"));
        }
        if (animal.weight() < 0) {
            errors.add(new ValidationError("weight less zero"));
        }
        if (animal.height() < 0) {
            errors.add(new ValidationError("height less zero"));
        }
        if (animal.paws() < 0) {
            errors.add(new ValidationError("number of paws less zero"));
        }
        return errors;
    }
}
