package com.example.demo.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Include
    private Long id;
    private String name;
    private String address;

    @OneToMany
    @Transient
    private Set<Book> books;

    public Publisher(String name, String address) {
        this.name = name;
        this.address = address;
    }
}
