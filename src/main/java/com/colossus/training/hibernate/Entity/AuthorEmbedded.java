package com.colossus.training.hibernate.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@DynamicUpdate @DynamicInsert
@EqualsAndHashCode(of = "id")
@ToString(of = "name", includeFieldNames = false)

public class AuthorEmbedded {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "second_name")
    private String second_name;

    @Embedded
    private CommonFields commonFields;

    @OneToMany(targetEntity = Book.class, mappedBy = "author")
    private List<Book> list = new ArrayList<>();

}
