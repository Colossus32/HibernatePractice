package com.colossus.training.hibernate;

import java.util.logging.Logger;

public class Start {

    private static final Logger LOG = Logger.getLogger(AuthorHelper.class.getName());

    public static void main(String[] args) {

        new AuthorHelper().addAuthors(30);
    }
}
