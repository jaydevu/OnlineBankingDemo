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
            System.out.println("Hello");
        }

        AccountService accountService = new AccountServiceImpl();


        String decision = "N";

        do {
            String operation = JOptionPane.showInputDialog("Enter operation: save | update | delete | initial deposit | update deposit | withdraw");
            switch (operation) {

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


                default:
                    JOptionPane.showMessageDialog(null, "Wrong selection");

            }
            decision = JOptionPane.showInputDialog("Do you want to continue? Enter Y / N");
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
//    public static void printAccountInfo(AccountUser account){
//        System.out.println("+++++++");
//        System.out.println("Account id is: " + account.getAccountId());
//        System.out.println("Account Name is: " + account.getAccountName());
//        System.out.println(" Email is " + account.getEmail());
//        System.out.println("Mobile No. is:" + account.getMobileNo());
//        System.out.println("Account Number is: " + account.getAccountNumber());
//        System.out.println("+++++++");
//
//    }
//
//        double balance;
//        double previousTransaction;
//        String decision = "N";
//
//        public void depositAmount ( double amount){
//            if (amount != 0) {
//                balance = balance + amount;
//                previousTransaction = amount;
//            }
//        }
//
//        public void withdrawAmount ( double amount){
//            if (amount != 0) {
//                balance = balance - amount;
//                previousTransaction = -amount;
//            }
//        }
//        public void checkPreviousTransaction () {
//            if (previousTransaction > 0) {
//                System.out.println("Deposited: " + previousTransaction);
//                ;
//            } else if (previousTransaction < 0) {
//                System.out.println("Withdrawn: " + Math.abs(previousTransaction));
//            } else {
//                System.out.println("No transaction");
//            }
//
//            do {
//                String operation = JOptionPane.showInputDialog("Enter operation: createAccount | depositAmount | withdrawAmount | checkBalance");
//                switch (operation) {
//                    case "createAccount":
//                        break;
//                    case "depositAmount":
//                        System.out.println("===============");
//                        System.out.println("Enter an amount to deposit: ");
//                        System.out.println("================");
//                        break;
//                    case "withdrawAmount":
//                        System.out.println("===============");
//                        System.out.println("Enter an amount to withdraw: ");
//                        System.out.println("===============");
//                        break;
//                    case "checkBalance":
//                        System.out.println("================");
//                        System.out.println("Your balance is: " + balance);
//                        System.out.println("================");
//                        break;
//                    case "checkPreviousTransaction":
//                        System.out.println("================");
//                        System.out.println("================");
//                        break;
//                    default:
//                        JOptionPane.showMessageDialog(null, "Wrong selection");
//                }
//                decision = JOptionPane.showInputDialog("Do you want to continue? Enter y|n");
//
//            } while (decision.equalsIgnoreCase("y"));
//
//            JOptionPane.showMessageDialog(null, "Good Day.");
//
//
//        }


