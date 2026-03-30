package com.ldcn.git.user_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ldcn.git.user_service.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

  User findByEmail(String email);
 default void deleteById(Long id) {
  throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
 }
}
