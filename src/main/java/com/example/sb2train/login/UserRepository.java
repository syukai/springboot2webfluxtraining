package com.example.sb2train.login;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<Account, Integer> {

	@Query("select a from Account a where myName = :username")
	public Optional<Account> findByUsername(@Param("username") String username);
}
