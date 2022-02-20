package com.colossus.training.hibernate.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@DynamicInsert
@DynamicUpdate
public class Author implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //генерация id в mysql через autoincrement
    private long id;

    @NonNull
    private String name;

    @NonNull
    @Column(name = "second_name")
    private String second_name;

}
