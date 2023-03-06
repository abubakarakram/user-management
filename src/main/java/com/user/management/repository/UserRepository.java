package com.user.management.repository;

import com.user.management.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);
}
