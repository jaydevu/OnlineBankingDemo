package com.groupCbanking.uis.dao;

import com.groupCbanking.uis.model.AccountUser;
import com.groupCbanking.uis.model.Transaction;

public interface AccountDao {


    int saveAccount (AccountUser account);
    int updateAccount (AccountUser account);
    int deleteAccount (int accountId);

    int depositAmount(Transaction trans);
//    int withdrawAmount(AccountUser account);

//    int withdrawAmount()

}
