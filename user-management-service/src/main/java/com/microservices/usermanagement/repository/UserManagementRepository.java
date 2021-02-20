package com.microservices.usermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservices.usermanagement.model.User;

@Repository
public interface UserManagementRepository extends JpaRepository<User, Long> {

}
