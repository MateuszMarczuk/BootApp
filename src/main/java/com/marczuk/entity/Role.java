package com.marczuk.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

/**
 * Created by Mateusz Marczuk
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 08.03.2018.
 */
@Data
@NoArgsConstructor
@Entity
public class Role {

    @Id
    private String name;
    @ManyToMany(mappedBy = "roles")
    private List<User> users;
}
