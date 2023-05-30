package com.cg.repository;

import com.cg.model.Deposit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface IDepositRepository extends JpaRepository<Deposit, Long> {
    @Query(value = "CALL deposit(:id, :amount)",nativeQuery = true)
    boolean deposit(@Param("id") Long id, @Param("amount") BigDecimal amount);
}
