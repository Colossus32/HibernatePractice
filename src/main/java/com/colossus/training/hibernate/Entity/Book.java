package com.colossus.training.hibernate.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor

public class Book extends BaseEntity {

    @ManyToOne
    @JoinColumn
    private Author author;
}
