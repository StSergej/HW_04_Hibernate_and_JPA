package org.example;

import org.example.entities.Animal;
import org.example.repositories.AnimalRepository;

import java.util.ArrayList;
import java.util.List;

public class AnimalHelper {

    private final AnimalRepository animalRepository;

    public AnimalHelper(AnimalRepository animalRepository){
        this.animalRepository = animalRepository;
    }

    public void create(){
        System.out.println("----------------------------");

        List<Animal> animals =  new ArrayList<Animal>();

        animals.add(new Animal("cat", 3, true));
        animals.add(new Animal("panda", 5, false));
        animals.add(new Animal("dog", 7, true));
        animals.add(new Animal("boar", 2, false));
        animals.add(new Animal("chimp", 9, false));

        for(Animal newAnimals : animals){
            Animal createdAnimal = animalRepository.create(newAnimals);
            System.out.println(createdAnimal);
        }
    }

    public void read(){
        System.out.println("----------------------------");
        Animal animalDb = animalRepository.read(3);
        System.out.println(animalDb);
    }

    public void update(){
        System.out.println("----------------------------");
        Animal animalToUpdate = animalRepository.read(5);
        animalToUpdate.setName("gorilla");
        animalToUpdate.setAge(4);
        animalRepository.update(animalToUpdate);
        System.out.println(animalToUpdate);

    }

    public void delete(){
        System.out.println("----------------------------");
        Animal animalToDelete = animalRepository.read(4);
        animalRepository.delete(animalToDelete);

        System.out.println(animalToDelete);
    }

    public void getAll(){
        System.out.println("----------------------------");
        List<Animal> animals = animalRepository.getAllAnimals();
        for(Animal animalsAll : animals){
            System.out.println(animalsAll);
        }
    }


}
