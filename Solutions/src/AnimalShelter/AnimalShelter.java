package com.felix.ctci.AnimalShelter;

import java.util.LinkedList;

public class AnimalShelter {
    private final LinkedList<Cat> catShelter;
    private final LinkedList<Dog> dogShelter;

    public AnimalShelter() {
        catShelter = new LinkedList<>();
        dogShelter = new LinkedList<>();
    }

    public Animal dequeueAny() {
        return catShelter.size() > dogShelter.size() ? catShelter.getFirst() : dogShelter.getFirst();
    }

    public Cat dequeueCat() {
        return catShelter.getFirst();
    }

    public Dog dequeueDog() {
        return dogShelter.getFirst();
    }

    public void enqueue(Animal animal) {
        if (animal instanceof Cat) {
            catShelter.add((Cat)animal);
        } else if (animal instanceof Dog) {
            dogShelter.add((Dog)animal);
        }

        throw new IllegalArgumentException();
    }
}
