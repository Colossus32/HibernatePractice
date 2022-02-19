package com.colossus.training.hibernate;

import com.colossus.training.hibernate.Entity.Author;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class AuthorHelper {
    private SessionFactory sessionFactory;

    public AuthorHelper() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public List<Author> getAuthorList(){

        // open session for manipulating persistence objects
        Session session = sessionFactory.openSession();

        session.get(Author.class, 1L);

        //prepare request
        //object constructor for Criteria API requests
        CriteriaBuilder cb = session.getCriteriaBuilder();

        CriteriaQuery cq = cb.createQuery(Author.class);

        Root<Author> root = cq.from(Author.class); // первостепенный корневой entity (в sql запросе from)

        cq.select(root); // optional operator if you just want to get all values

        //here is the request
        Query query = session.createQuery(cq);

        List<Author> authorList = query.getResultList();

        session.close();

        return authorList;
    }
}
