package com.devtiro.mock.interfaces;

import com.devtiro.mock.entities.Book;

import java.util.Optional;

public interface IBookDAO {
     void create(Book book);

     Optional<Book> read (Long isbn);
}
