package com.colossus.training.hibernate;

import com.colossus.training.hibernate.Entity.Author;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.stat.Statistics;

import java.util.List;

public class AuthorHelper {

    private SessionFactory sessionFactory;

    private static Statistics stat;

    public AuthorHelper() {
        sessionFactory = HibernateUtil.getSessionFactory();
        stat = sessionFactory.getStatistics();
        stat.clear();
        stat.setStatisticsEnabled(true);
    }

    public List<Author> getAuthorList(){

        // open session for manipulating persistence objects
        Session session = sessionFactory.openSession();

        //session.get(Author.class, 1L);

        //prepare request
        //object constructor for Criteria API requests
        CriteriaBuilder cb = session.getCriteriaBuilder();

        CriteriaQuery cq = cb.createQuery(Author.class);

        Root<Author> root = cq.from(Author.class); // первостепенный корневой entity (в sql запросе from)

        Selection[] selection = {root.get("id"), root.get("name")}; // выборка полей из таблицы, если нужны конкретные

        ParameterExpression<String> nameParam = cb.parameter(String.class, "name");

        cq.select(cb.construct(Author.class ,selection))
                .where(cb.like(root.get("name"), nameParam));

        //here is the request
        Query query = session.createQuery(cq);
        query.setParameter("name", "%е%");

        List<Author> authorList = query.getResultList();

        session.close();

        return authorList;
    }

    public Author addAuthor(Author author){

        Session session = sessionFactory.openSession();

        session.beginTransaction();

        session.persist(author);

        session.getTransaction().commit();

        session.close();

        return author;
    }

    public void addAuthors(int number){
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        //flush and circle
        StringBuilder fName = new StringBuilder("Alex");
        StringBuilder sName = new StringBuilder("Pushkin");

        for (int i = 1; i <= number; i++) {
            char travelling = fName.charAt(0);
            fName.deleteCharAt(0);
            fName.append(travelling);

            travelling = sName.charAt(0);
            sName.deleteCharAt(0);
            sName.append(travelling);

            if (i % 10 == 0) session.flush();

            session.persist(new Author(fName.toString(), sName.toString()));
        }

        session.getTransaction().commit();

        session.close();

    }

    public void deleteAuthor(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaDelete<Author> criteriaDelete = cb.createCriteriaDelete(Author.class);
        Root<Author> root = criteriaDelete.from(Author.class);
        ParameterExpression<String> parameterExpression = cb.parameter(String.class, "name");

        criteriaDelete.where(cb.like(root.get("name"), parameterExpression));

        Query query = session.createQuery(criteriaDelete);

        query.setParameter("name", "%е%");

        query.executeUpdate();

        session.getTransaction().commit();
        session.close();
    }

    public Author getAuthor(long id){
        Session session = sessionFactory.openSession();
        Author author = session.get(Author.class, id);

        printStatistics();

        return author;
    }

    public static void printStatistics(){
        System.out.println("Requires to DB: " + stat.getQueryExecutionCount());
        System.out.println("Found in cache: " + stat.getSecondLevelCacheHitCount());
        System.out.println("Added to cache: " + stat.getSecondLevelCachePutCount());
        stat.clear();
    }

}
