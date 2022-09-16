/**
 * 
 */
package com.meli.challenge.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.meli.challenge.security.entity.User;

/**
 * @author german
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	 Optional<User> findByUsername(String username);
}
