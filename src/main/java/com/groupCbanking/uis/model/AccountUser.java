package com.groupCbanking.uis.model;

import java.time.LocalDate;

public class AccountUser {

    int accountId;
    String accountName;
    int accountNumber;
    long mobileNo;

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public long getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(long mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    String email;

    /*public AccountUser(int accountId, String accountName, int accountNumber, String email, long mobileNo) {
        this.accountId = accountId;
        this.accountName = accountName;
        this.accountNumber = accountNumber;
        this.email = email;
        this.mobileNo = mobileNo;
    }

    public AccountUser(){

    }*/
}
