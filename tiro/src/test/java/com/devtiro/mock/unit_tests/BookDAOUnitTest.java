package com.devtiro.mock.unit_tests;

import com.devtiro.mock.repositories.BookDAO;
import com.devtiro.mock.entities.Book;
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
public class BookDAOUnitTest {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private BookDAO underTest;


    @Test
   public void testBookCreation(){
       Book book = Book.builder()
                       .isbn(123L).title("The way it goes").author_id(1L).build();
       underTest.create(book);

       verify(jdbcTemplate).update(
               eq("INSERT INTO books isbn,title,author_id VALUES(?,?,?)"),
               eq(123L),eq("The way it goes"),eq(1L)
       );
   }
    @Test
   public void testBookRead(){
       underTest.read(123L);

       verify(jdbcTemplate).query(
               eq("SELECT isbn,title,author_id FROM books WHERE isbn=? LIMIT 1"),
               ArgumentMatchers.<BookDAO.BookRowMapper>any(),
               eq(123L)
       );
   }
}
