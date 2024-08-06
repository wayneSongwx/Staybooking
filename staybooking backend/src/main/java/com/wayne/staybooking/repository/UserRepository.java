package com.wayne.staybooking.repository;

import com.wayne.staybooking.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

}
// <User, String>: These are the type parameters for JpaRepository.
// User is the entity type that the repository manages.
// String is the type of the entity's ID.
