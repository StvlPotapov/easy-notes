package com.example.easynotes.repository;

import com.example.easynotes.model.UserAuthAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAuthAccountRepository extends JpaRepository<UserAuthAccount, Long> {
}
