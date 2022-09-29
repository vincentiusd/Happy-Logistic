package com.happy.demo.repository;

import com.happy.demo.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AccountRepository extends JpaRepository<Account, String> {

    @Query("""
            SELECT COUNT(*)
            FROM Account acc
            WHERE acc.username = :username
            """)
    public Long checkUsernameByCount(@Param("username") String username);
}