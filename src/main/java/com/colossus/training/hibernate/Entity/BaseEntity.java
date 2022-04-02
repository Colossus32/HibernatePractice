package com.colossus.training.hibernate.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.io.Serializable;

@MappedSuperclass
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@DynamicInsert @DynamicUpdate
@EqualsAndHashCode(of = "id")
@ToString (of = "name" , includeFieldNames = false)


public class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public BaseEntity (long id, String name){
        this.id = id;
        this.name = name;
    }

}
