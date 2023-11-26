package com.goorm.tricountapi.service;

import com.goorm.tricountapi.dto.BalanceResult;
import com.goorm.tricountapi.model.Member;
import com.goorm.tricountapi.model.Settlement;
import com.goorm.tricountapi.repository.ExpenseRepository;
import com.goorm.tricountapi.repository.SettlementRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SettlementService {
    private final SettlementRepository settlementRepository;
    private final ExpenseRepository expenseRepository;


    public List<Settlement> createAndJoinSettlement(String settlementName, Member currentMember) {
        return null;
    }

    public void joinSettlement(Long settlementId, Long id) {

    }

    public List<BalanceResult> getBalanceResult(Long settlementId) {
        return null;
    }
}
