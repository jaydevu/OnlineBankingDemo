package com.groupCbanking.uis.model;

import java.time.LocalDate;

public class Transaction {

    private int accountId;
    private double balance;
    private double withdrawnAmount;
    private double depositedAmount;
    //private double initialDeposit;

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getWithdrawnAmount() {
        return withdrawnAmount;
    }

    public void setWithdrawnAmount(double withdrawnAmount) {
        this.withdrawnAmount = withdrawnAmount;
    }

    public double getDepositedAmount() {
        return depositedAmount;
    }

    public void setDepositedAmount(double depositedAmount) {
        this.depositedAmount = depositedAmount;
    }


/*public Transaction() {

    }

    public Transaction(int id, String accountName, int accountNumber, long mobileNo, String email, double balance, double depositedAmount, double withdrawnAmount) {
        super(id, accountName, accountNumber, email, mobileNo);
        this.balance = balance;
        this.withdrawnAmount = withdrawnAmount;
        this.depositedAmount = depositedAmount;
    }*/

}
