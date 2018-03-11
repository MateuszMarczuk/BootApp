package com.marczuk.entity;

import lombok.Data;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Created by Mateusz Marczuk
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 08.03.2018.
 */
@Entity
@Data
@Table(name = "MyUser")
public class User {
    @Id
    @Email
    @NotEmpty
    @Column(unique = true)
    private String email;

    @NotEmpty
    private String name;

    @NotEmpty
    @Size(min = 5)
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Task> tasks;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLE", joinColumns = {
        @JoinColumn(name = "USER_EMAIL", referencedColumnName = "email")
    }, inverseJoinColumns = {@JoinColumn(name = "ROLE_NAME", referencedColumnName = "name")})
    private List<Role> roles;
}
