package com.andree.evaluacion.repositories;

import com.andree.evaluacion.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User,Integer> {
    User findByEmail(String email);
}
