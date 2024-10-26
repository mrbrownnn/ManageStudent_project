/*package com.ptit.studentmanagement.service.impl;

import com.ptit.studentmanagement.domain.entities.Accounts;
import com.ptit.studentmanagement.domain.playload.request.AccountRequest;
import com.ptit.studentmanagement.exceptions.BadRequestException;
import com.ptit.studentmanagement.repositry.AccountRepository;
import com.ptit.studentmanagement.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountRepository accountRepository;
    @Override
    public void addStudentAccount(AccountRequest accountsRequest) {
        if (accountRepository.findByStudentIdOrUsername(accountsRequest.getStudentId(), accountsRequest.getUsername()).isPresent()) {
            throw new BadRequestException("Student id and username must be unique");
        }
        Accounts accounts = new Accounts(accountsRequest);

        accountRepository.save(accounts);
    }

    @Override
    public Accounts getStudentAccount(Long id) {
        return accountRepository.findById(id).orElseThrow(() -> new BadRequestException("Account not found"));
    }
}
*/
