package org.example.repositories;

import org.example.entities.Animal;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class HibernateRepository implements AnimalRepository{

    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public HibernateRepository() { }


    public Animal create(Animal animal){
        System.out.println("\nStart of CREATE...");

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.save(animal);

        session.getTransaction().commit();
        session.close();
        return animal;
    }



    public Animal read(int id) {
        System.out.println("\nStart of READ...");

        Session session = sessionFactory.openSession();
        Animal animalRead = session.get(Animal.class, id);

        System.out.println("End of READ...");
        return animalRead;
    }


    public void update(Animal animal){
        System.out.println("\nStart of UPDATE...");

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.saveOrUpdate(animal);

        session.getTransaction().commit();
        session.close();

        System.out.println("End of UPDATE...");
    }


    public void delete(Animal animal){
        System.out.println("\nStart of DELETE...");

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.delete(animal);

        session.getTransaction().commit();
        session.close();

        System.out.println("End of DELETE...");
    }


    public List<Animal> getAllAnimals(){
        Session session = sessionFactory.openSession();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(Animal.class);

        Root<Animal> root = cq.from(Animal.class);
        cq.select(root);

        Query query = session.createQuery(cq);

        List<Animal> animalList = query.getResultList();

        session.close();
        return animalList;
    }
}
