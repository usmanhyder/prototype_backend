package com.prototype.eitproject.repository;

import com.prototype.eitproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource(exported = false)
public interface UserRepository extends JpaRepository<User, String>, CustomUserRepository {

}
