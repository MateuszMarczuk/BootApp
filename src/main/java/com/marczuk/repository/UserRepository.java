package com.marczuk.repository;

import com.marczuk.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Mateusz Marczuk
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 08.03.2018.
 */
public interface UserRepository extends JpaRepository<User, String> {
    User findOneByEmail(String email);
}
