package org.example.repositories;

import org.example.entities.Animal;

import java.util.List;

public interface AnimalRepository {

    Animal create(Animal animal);

    Animal read(int id);

    void update(Animal animal);

    void delete(Animal animal);

    List<Animal> getAllAnimals();
}
