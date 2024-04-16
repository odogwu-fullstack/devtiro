package com.devtiro.mock.repositories;

import com.devtiro.mock.entities.Book;
import com.devtiro.mock.interfaces.IBookDAO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class BookDAO implements IBookDAO {
    private JdbcTemplate jdbcTemplate;

    public BookDAO(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public void create(Book book) {
        jdbcTemplate.update("INSERT INTO books isbn,title,author_id VALUES(?,?,?)",
                book.getIsbn(),book.getTitle(),book.getAuthor_id());

    }

    @Override
    public Optional<Book> read(Long isbn) {
        List<Book> books = jdbcTemplate.query("SELECT isbn,title,author_id FROM books WHERE isbn=? LIMIT 1",
                new BookRowMapper(), isbn);
        return books.stream().findFirst();
    }

    public static class BookRowMapper implements RowMapper<Book>{
        @Override
        public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
            return Book.builder()
                    .title(rs.getString("title"))
                    .isbn(rs.getLong("isbn"))
                    .author_id(rs.getLong("author_id"))
                    .build();
        }
    }

}
