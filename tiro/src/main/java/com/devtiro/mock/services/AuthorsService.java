package com.devtiro.mock.services;

import com.devtiro.mock.entities.Author;
import com.devtiro.mock.repositories.AuthorDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorsService {
    @Autowired
    private AuthorDAO authorRepo;

    public AuthorsService(AuthorDAO authorRepo){
        this.authorRepo = authorRepo;
    }
    public Optional<Author> getAllAuthors () {

        return authorRepo.read(1L);
    }
}
