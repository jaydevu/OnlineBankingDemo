package com.groupCbanking.uis.controller;

import com.groupCbanking.uis.service.AccountService;
import com.groupCbanking.uis.service.AccountServiceImpl;
import com.groupCbanking.uis.model.AccountUser;
import com.groupCbanking.uis.model.Transaction;
import com.groupCbanking.uis.dao.AccountDaoImpl;
import com.groupCbanking.uis.dao.AccountDao;
import com.groupCbanking.uis.util.DbUtil;

import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;

public class UserController {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {


        Connection con = DbUtil.getConnection();
        if (con != null) {
            System.out.println("Hello. Connection Success");
        }

        AccountService accountService = new AccountServiceImpl();
        String decision;
        //String decision = "N";
        do {
            String operation = JOptionPane.showInputDialog("Enter an operation of your choice: \n| save \n| update \n| delete \n| initial deposit \n| update deposit \n| withdraw \n| check balance");
            switch (operation)
            {
                case "save":
                    AccountUser account = getAccount("save");
                    int saved = accountService.saveAccount(account);
                    if (saved >= 1) {
                        JOptionPane.showMessageDialog(null, "Account Info is saved in database");
                    } else {
                        JOptionPane.showMessageDialog(null, "Error in database");
                    }
                    break;

                case "update":
                    AccountUser updatedAccount = getAccount("update");
                    int updated = accountService.updateAccount(updatedAccount);
                    if (updated >= 1) {
                        JOptionPane.showMessageDialog(null, "Account info is updated in database");
                    } else {
                        JOptionPane.showMessageDialog(null, "Error in database");
                    }
                    break;

                case "delete":
                    int accountId = Integer.parseInt(JOptionPane.showInputDialog("Enter Account Id: "));
                    int deleted = accountService.deleteAccount(accountId);
                    if (deleted >= 1) {
                        JOptionPane.showMessageDialog(null, "Account is deleted from database");
                    } else {
                        JOptionPane.showMessageDialog(null, "Error in database");
                    }
                    break;

                case "initial deposit":
                    int accountId1 = Integer.parseInt(JOptionPane.showInputDialog("Enter Account Id: "));

                    double depositAmount = Integer.parseInt(JOptionPane.showInputDialog("Enter Money to Deposit: "));
                    Transaction trans1 = new Transaction();

                    trans1.setAccountId(accountId1);
                    trans1.setDepositedAmount(depositAmount);

                    double balance = trans1.getDepositedAmount();
                    trans1.setBalance(balance);
                    trans1.setWithdrawnAmount(0.0);

                    int deposited = accountService.depositAmount(trans1);


                    if (deposited >= 1) {
                        JOptionPane.showMessageDialog(null, "Money is entered into account");
                    } else {
                        JOptionPane.showMessageDialog(null, "Error in database");
                    }
                    break;

                case "update deposit":
                    int accountId2 = Integer.parseInt(JOptionPane.showInputDialog("Enter Account Id: "));

                    double depositAmount1 = Integer.parseInt(JOptionPane.showInputDialog("Enter Money to Deposit: "));
                    Transaction trans = new Transaction();

                    trans.setAccountId(accountId2);
                    trans.setDepositedAmount(depositAmount1);

                    double balance1 = trans.getBalance() + trans.getDepositedAmount();
                    trans.setBalance(balance1);
                    trans.setWithdrawnAmount(0.0);

                    int deposited1 = accountService.depositAmount(trans);


                    if (deposited1 >= 1) {
                        JOptionPane.showMessageDialog(null, "Money is entered into account");
                    } else {
                        JOptionPane.showMessageDialog(null, "Error in database");
                    }
                    break;

                case "withdraw":
                    int accountId3 = Integer.parseInt(JOptionPane.showInputDialog("Enter Account Id: "));

                    double withdrawAmount = Integer.parseInt(JOptionPane.showInputDialog("Enter Money to withdraw: "));
                    Transaction trans2 = new Transaction();

                    trans2.setAccountId(accountId3);
                    trans2.setWithdrawnAmount(withdrawAmount);

                    double balance2 = trans2.getBalance() - trans2.getWithdrawnAmount();
                    trans2.setBalance(balance2);
                    trans2.setDepositedAmount(0.0);

                    int withdrawn = accountService.withdrawnAmount(trans2);


                    if (withdrawn >= 1) {
                        JOptionPane.showMessageDialog(null, "Money is withdrawn from account");
                    } else {
                        JOptionPane.showMessageDialog(null, "Error in database");
                    }
                    break;

                case "check balance":
                    int accountId4 = Integer.parseInt(JOptionPane.showInputDialog("Enter Account Id: "));
                    Double balance3 = accountService.checkBalance(accountId4);
                    if (balance3 >= 1) {
                        JOptionPane.showMessageDialog(null, "Your balance is: " + balance3);
                    } else {
                        JOptionPane.showMessageDialog(null, "Error in database");
                    }
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Wrong selection");
            }
            decision = JOptionPane.showInputDialog("Do you want to continue? Enter (Y/N): ");
        } while (decision.equalsIgnoreCase("Y"));
        JOptionPane.showMessageDialog(null, "Thanks for using the service");

    }

    public static AccountUser getAccount(String type) {
        AccountUser account = new AccountUser();
        Transaction transaction = new Transaction();
        if (type.equals("update")) {
            int accountId = Integer.parseInt(JOptionPane.showInputDialog("Enter Account Id: "));
            account.setAccountId(accountId);
        }
        String accountName = JOptionPane.showInputDialog("Enter Account Name: ");
        String email = JOptionPane.showInputDialog("Enter Account Email: ");
        int accountNumber = Integer.parseInt(JOptionPane.showInputDialog("Enter Account Number: "));
        long mobileNo = Long.parseLong(JOptionPane.showInputDialog("Enter mobile no.: "));

        account.setAccountName(accountName);
        account.setAccountNumber(accountNumber);
        account.setEmail(email);
        account.setMobileNo(mobileNo);
        return account;
    }
}