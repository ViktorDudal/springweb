package com.example.springweb;

import com.example.springweb.model.Person;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonsCRUD {

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
}
