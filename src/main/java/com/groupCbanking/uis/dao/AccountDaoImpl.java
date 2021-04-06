package com.groupCbanking.uis.dao;

import com.groupCbanking.uis.model.AccountUser;
import com.groupCbanking.uis.model.Transaction;
import com.groupCbanking.uis.util.AccountQueryUtil;
import com.groupCbanking.uis.util.DbUtil;
import com.groupCbanking.uis.util.TransactionQueryUtil;


import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AccountDaoImpl implements AccountDao {

    //Transaction trans = new Transaction();

    @Override
    public int saveAccount(AccountUser account) {


        int status = 0;
        int status1 = 0;
        try (
                PreparedStatement ps = DbUtil.getConnection().prepareStatement(AccountQueryUtil.SAVE_SQL1);
//                PreparedStatement ps1 = DbUtil.getConnection().prepareStatement(TransactionQueryUtil.UPDATE_SQL);

        ) {


            ps.setString(1, account.getAccountName());
            ps.setInt(2, account.getAccountNumber());
            ps.setString(3, account.getEmail());
            ps.setLong(4, account.getMobileNo());


//            ps1.setDouble(1, trans.getDepositedAmount());


            System.out.println(ps);
//            System.out.println(ps1);
            status = ps.executeUpdate();
//            status1 = ps1.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public int updateAccount(AccountUser account) {
        int updated = 0;
        try (
                PreparedStatement ps = DbUtil.getConnection().prepareStatement(AccountQueryUtil.UPDATE_SQL1);
        ) {
            ps.setInt(5, account.getAccountId());

            System.out.println(account.getAccountId());
            System.out.println(account.getAccountName());

            ps.setString(1, account.getAccountName());
            ps.setString(4, account.getEmail());
            ps.setLong(3, account.getMobileNo());
            ps.setInt(2, account.getAccountNumber());

            System.out.println(ps);

            updated = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return updated;
    }

    @Override
    public int deleteAccount(int accountId) {
        int deleted = 0;
        try (
                PreparedStatement ps = DbUtil.getConnection().prepareStatement(AccountQueryUtil.DELETE_SQL1);
        ) {

            ps.setInt(1, accountId);


            deleted = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return deleted;
    }

    @Override
    public int depositAmount(Transaction trans) {
        AccountUser account = new AccountUser();
        int deposit = 0;

        try (
                PreparedStatement ps = DbUtil.getConnection().prepareStatement(TransactionQueryUtil.UPDATE_SQL2);

        ) {

            ps.setInt(4, trans.getAccountId());
            ps.setDouble(1, (trans.getBalance() + trans.getDepositedAmount()));
            ps.setDouble(2, trans.getWithdrawnAmount());
            ps.setDouble(3, trans.getDepositedAmount());

            System.out.println(ps);


            deposit = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return deposit;


    }

    @Override
    public int initialDeposit(Transaction trans1) {
        AccountUser account = new AccountUser();
        int deposit1 = 0;

        try (
                PreparedStatement ps1 = DbUtil.getConnection().prepareStatement(TransactionQueryUtil.SAVE_SQL2);
        ) {

            ps1.setInt(1, trans1.getAccountId());
            ps1.setDouble(2, trans1.getBalance());
            ps1.setDouble(3, trans1.getWithdrawnAmount());
            ps1.setDouble(4, trans1.getDepositedAmount());

            System.out.println(ps1);

            deposit1 = ps1.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return deposit1;
    }

    @Override
    public int withdrawnAmount(Transaction trans2) {
        int withdraw = 0;
        try (
                PreparedStatement ps2 = DbUtil.getConnection().prepareStatement(TransactionQueryUtil.UPDATE_SQL2);
        ) {

            ps2.setInt(4, trans2.getAccountId());
            ps2.setDouble(1, trans2.getBalance());
            ps2.setDouble(2, trans2.getWithdrawnAmount());
            ps2.setDouble(3, trans2.getDepositedAmount());

            System.out.println(ps2);


            withdraw = ps2.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return withdraw;
    }

    @Override
    public Double checkBalance(int accountId) {
        //int checked = 0;
        Double balance = 0.00;
        try (
                PreparedStatement ps = DbUtil.getConnection().prepareStatement(TransactionQueryUtil.CHECK_SQL2);

        ) {

            ps.setInt(1, accountId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()){
                balance = rs.getDouble("balance");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return balance;
    }

}

