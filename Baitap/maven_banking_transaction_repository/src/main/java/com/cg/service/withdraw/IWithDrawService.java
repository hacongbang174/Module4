package com.cg.service.withdraw;

import com.cg.model.Withdraw;
import com.cg.service.IGenaralService;

import java.math.BigDecimal;

public interface IWithDrawService extends IGenaralService<Withdraw> {
    boolean withdraw (Long id, BigDecimal amount);
}
