package com.groupCbanking.uis.service;

import com.groupCbanking.uis.model.AccountUser;
import com.groupCbanking.uis.model.Transaction;

public interface AccountService {

    int saveAccount(AccountUser account);

    int updateAccount(AccountUser account);

    int deleteAccount(int accountId);


    int depositAmount(Transaction trans);

    int initialDeposit(Transaction trans1);

    int withdrawnAmount(Transaction trans2);

    Double checkBalance (int accountId);

}
