package com.devtiro.mock.repositories;

import com.devtiro.mock.entities.Author;
import com.devtiro.mock.interfaces.IAuthorDAO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
@Component
public class AuthorDAO implements IAuthorDAO {
    private JdbcTemplate jdbcTemplate;

    public AuthorDAO(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void create(Author author) {
        jdbcTemplate.update("INSERT INTO authors (id,first_name,last_name,age) VALUES(?,?,?,?)",
                author.getId(),author.getFirst_name(),author.getLast_name(),author.getAge()
                );
    }

    @Override
    public Optional<Author> read(long l) {
        List<Author> result = jdbcTemplate.query(
                "SELECT id,first_name,last_name,age FROM authors WHERE id=?", new AuthorRowMapper(),1L
        );
        return result.stream().findFirst();
    }

    public static class AuthorRowMapper implements RowMapper<Author> {

        @Override
        public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
            return Author.builder()
                    .id(rs.getLong("id"))
                    .first_name(rs.getString("first_name"))
                    .last_name(rs.getString("last_name"))
                    .age(rs.getInt("age"))
                    .build();
        }
    }
}
