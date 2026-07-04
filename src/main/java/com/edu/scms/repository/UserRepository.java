package com.edu.scms.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.edu.scms.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
 Optional<User> findByUsername(String username);
}