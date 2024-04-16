package com.devtiro.mock.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Author {
    private Long id;
    private String first_name;
    private String last_name;
    private Integer age;
}
