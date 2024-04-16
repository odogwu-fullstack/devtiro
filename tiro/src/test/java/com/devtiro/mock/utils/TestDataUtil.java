package com.devtiro.mock.utils;
import com.devtiro.mock.entities.Author;

public final class TestDataUtil {
    private TestDataUtil(){

    }

    public static Author testAuthorData() {
        return Author.builder()
                .id(1L)
                .first_name("Luke")
                .last_name("Rockhold")
                .age(45)
                .build();
    }
}
