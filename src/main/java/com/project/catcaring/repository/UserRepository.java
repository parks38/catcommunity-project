package com.project.catcaring.repository;

import com.project.catcaring.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 회원 API (Repository)
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
