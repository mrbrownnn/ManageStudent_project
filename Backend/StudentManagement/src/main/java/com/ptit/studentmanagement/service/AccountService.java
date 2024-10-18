package com.ptit.studentmanagement.service;

import com.ptit.studentmanagement.domain.entities.Accounts;
import com.ptit.studentmanagement.domain.playload.request.AccountRequest;

public interface AccountService {
    void addStudentAccount(AccountRequest accountRequest);
    // void updateStudentAccount(AccountRequest accountRequest);

    Accounts getStudentAccount(Long id);
}
