package org.example;


import org.example.repositories.AnimalRepository;
import org.example.repositories.HibernateRepository;

public class Main {
    public static void main(String[] args) {

        AnimalRepository animalRepository = new HibernateRepository();
        AnimalHelper animalHelper = new AnimalHelper(animalRepository);

        animalHelper.create();

        animalHelper.read();

        animalHelper.update();

        animalHelper.delete();

        animalHelper.getAll();

    }
}
