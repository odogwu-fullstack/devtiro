package com.devtiro.mock.interfaces;

import com.devtiro.mock.entities.Author;

import java.util.Optional;

public interface IAuthorDAO {
    Optional<Author> read(long l);
}
