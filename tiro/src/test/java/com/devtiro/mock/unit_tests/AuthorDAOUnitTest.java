package com.devtiro.mock.unit_tests;

import com.devtiro.mock.entities.Author;
import com.devtiro.mock.repositories.AuthorDAO;
import com.devtiro.mock.utils.TestDataUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class AuthorDAOUnitTest {
    @Mock
    private JdbcTemplate jdbcTemplate;
    @InjectMocks
    private AuthorDAO underTest;


    @Test
    public void testAuthorCreation(){
        Author author = TestDataUtil.testAuthorData();
        underTest.create(author);

        verify(jdbcTemplate).update(
                eq("INSERT INTO authors id,first_name,last_name,age VALUES(?,?,?,?)"),
                eq(1L),eq("Luke"),eq("Rockhold"),eq(45)
        );
    }

    @Test
    public void testAuthorRead(){
        underTest.read(1L);

        verify(jdbcTemplate).query(
                eq("SELECT id,first_name,last_name,age FROM authors WHERE id=?"),
                ArgumentMatchers.<AuthorDAO.AuthorRowMapper>any(),
                eq(1L)
        );
    }
}
