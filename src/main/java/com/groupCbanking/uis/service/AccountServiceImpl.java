package com.groupCbanking.uis.service;

import com.groupCbanking.uis.dao.AccountDao;
import com.groupCbanking.uis.dao.AccountDaoImpl;
import com.groupCbanking.uis.model.AccountUser;
import com.groupCbanking.uis.model.Transaction;

public class AccountServiceImpl implements AccountService{

    AccountDao accountDao = new AccountDaoImpl();

    @Override
    public int saveAccount(AccountUser account) {
        return accountDao.saveAccount(account);
    }

    @Override
    public int updateAccount(AccountUser account) {
        return accountDao.updateAccount(account);
    }

    @Override
    public int deleteAccount(int accountId) {
        return accountDao.deleteAccount(accountId);
    }

    @Override
    public int depositAmount(Transaction trans){
        return accountDao.depositAmount(trans);
    }
}
