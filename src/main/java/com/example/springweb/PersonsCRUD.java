package com.example.springweb;

import com.example.springweb.model.Person;
import org.hibernate.Session;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
public class PersonsCRUD {

//    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.example.springweb");
//
//    private static EntityManager getEntityManager() {
//        return emf.createEntityManager();
//    }

    public void save(Person person) {
        Session session = HibernateUtil.getSessionFactory().openSession(); //открываем сессию
        session.beginTransaction();
        session.save(person); //пользуемся ее методами
        session.flush();
        session.close();
    }

    public void delete(Person person) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(person);
        session.flush();
        session.close();
    }

    public List<Person> getAll(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.createCriteria(Person.class).list();
    }


    public Person getById(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Person person = session.get(Person.class, id);
        return person;
    }

//    public Person getById(Integer id) {
//        EntityManager em = getEntityManager();
//        Person person = em.find(Person.class, id);
//        em.detach(person);
//        return person;
//    }
}
