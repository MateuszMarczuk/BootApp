package com.marczuk.repository;

import com.marczuk.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Mateusz Marczuk
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 08.03.2018.
 */
public interface UserRepository extends JpaRepository<User, String> {
    User findOneByEmail(String email);

    List<User> findByNameLike(String name);

}
