package com.educandoweb.usercrud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.usercrud.entities.User;

// @Repository there is no need for the @repository annotation as in class
// UserService with @Service annotation because the interface is already inherited from Jparepository
public interface UserRepository extends JpaRepository<User, Long> {
    // Our repository will be interfaces because it extends from Jparepository by passing the entity type and entity ID type
    // this way we can instantiate a USER with several operations that are extended from jpaRepository

}
