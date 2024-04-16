package com.devtiro.mock.integration_tests;

import com.devtiro.mock.entities.Author;
import com.devtiro.mock.repositories.AuthorDAO;
import com.devtiro.mock.utils.TestDataUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CreateAuthorIntegrationTest {

    private AuthorDAO underTest;
    @Autowired
    public CreateAuthorIntegrationTest(AuthorDAO underTest){
        this.underTest = underTest;
    }
    @Test
    public void createAndReadAuthor () {
        Author author = TestDataUtil.testAuthorData();
        underTest.create(author);
        Optional<Author> result = underTest.read(23L);
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(author);
    }

}
