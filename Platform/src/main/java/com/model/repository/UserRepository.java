package com.model.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{

	List<User> findByCnpContainingOrRoleContainingOrNameContainingOrSurnameContaining(String cnp, String role, String name, String surname);

	Optional<User> findByInternalEmail(String internalEmail);

}
