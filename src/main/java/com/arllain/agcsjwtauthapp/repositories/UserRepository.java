package com.arllain.agcsjwtauthapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arllain.agcsjwtauthapp.domain.User;

/**
 * @author arllain
 *
 */
public interface UserRepository extends JpaRepository<User, Integer> {


}
