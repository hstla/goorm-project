package com.goorm.tricountapi.service;

import com.goorm.tricountapi.dto.ExpenseRequest;
import com.goorm.tricountapi.dto.ExpenseResult;
import com.goorm.tricountapi.repository.ExpenseRepository;
import com.goorm.tricountapi.repository.MemberRepository;
import com.goorm.tricountapi.repository.SettlementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExpenseService {
    private final ExpenseRepository expenseRepository;
    private final MemberRepository memberRepository;
    private final SettlementRepository settlementRepository;

    public ExpenseResult addExpense(ExpenseRequest expenseRequest) {

        return null;
    }
}
