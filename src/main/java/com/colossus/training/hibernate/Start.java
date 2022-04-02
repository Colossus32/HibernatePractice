package com.colossus.training.hibernate;

import com.colossus.training.hibernate.Entity.Author;

import java.util.List;
import java.util.logging.Logger;

public class Start {

    private static final Logger LOG = Logger.getLogger(AuthorHelper.class.getName());

    public static void main(String[] args) {

        //new AuthorHelper().addAuthors(30);
        System.out.println("start this shit");

        new AuthorHelper().addAuthors(10);

        List<Author> list = new AuthorHelper().getAuthorList();

        new AuthorHelper().deleteAuthor();

        for (Author author: list
             ) {
            System.out.println(author.getId());
            System.out.println(author.getName());
            System.out.println(author.getSecond_name());
            System.out.println("---------------------");
        }
    }
}
