package com.banking.repository;

import com.banking.model.User;
import com.banking.model.dto.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User getByUsername(String username);

    Optional<User> findByUsername(String username);

    @Query("SELECT NEW com.banking.model.dto.UserDTO (u.id, u.username) FROM User u WHERE u.username = ?1")
    Optional<UserDTO> findUserDTOByUsername(String username);

}
