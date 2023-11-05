package com.joe.project.reposietpry;

import com.joe.project.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

//@Repository("userRepo")
public interface UserRepository extends JpaRepository<User, UUID> {
    void deleteById(int id);

    Optional<User> findById(int id);
}
