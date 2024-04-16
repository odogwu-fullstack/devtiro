package com.devtiro.mock.controllers;

import com.devtiro.mock.services.AuthorsService;
import com.devtiro.mock.utils.CustomResponseObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/v1")
public class AuthorController {

    private AuthorsService service;
    public AuthorController(AuthorsService authorsService){
        this.service = authorsService;
    }

    @GetMapping("/authors")
    public ResponseEntity<CustomResponseObject> getAuthors(){

        return new ResponseEntity(CustomResponseObject
                .builder()
                .isSuccess(true)
                .code(10202)
                .data(service.getAllAuthors())
                .error(null)
                .message("Authors successfully retrieved")
                .build(),
                HttpStatus.OK);
    }

}
