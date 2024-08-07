package com.example.TheTechHeads.repository;

import com.example.TheTechHeads.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {
    UserAccount findByUsername(String username);
}
