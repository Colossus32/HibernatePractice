package com.colossus.training.hibernate.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "com.colossus.training.hibernate.Entity.Author")
public class Author extends BaseEntity {

    public Author(String s1, String s2){
        setName(s1);
        this.second_name = s2;
    }

    @Column(name = "second_name")
    private String second_name;

    @OneToMany(targetEntity = Book.class,mappedBy = "author")
    private List<Book> books = new ArrayList<>();

}
