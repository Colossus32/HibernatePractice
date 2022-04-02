package com.colossus.training.hibernate.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor

public class Author extends BaseEntity {

    @Column(name = "second_name")
    private String second_name;

    @OneToMany(targetEntity = Book.class,mappedBy = "author")
    private List<Book> books = new ArrayList<>();

}
