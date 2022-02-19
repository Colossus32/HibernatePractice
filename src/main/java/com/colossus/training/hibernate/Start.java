package com.colossus.training.hibernate;

import com.colossus.training.hibernate.Entity.Book;
import org.hibernate.Session;

public class Start {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        for (Book book: new BookHelpper().getBookList()
             ) {
            System.out.println("book " + book.getName());
        }
    }
}
