package com.cg.service.deposit;

import com.cg.model.Deposit;
import com.cg.service.IGenaralService;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;

public interface IDepositService extends IGenaralService<Deposit> {
    boolean deposit(Long id, BigDecimal amount);
}
