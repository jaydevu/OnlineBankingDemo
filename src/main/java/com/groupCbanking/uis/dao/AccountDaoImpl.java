package com.groupCbanking.uis.dao;

import com.groupCbanking.uis.model.AccountUser;
import com.groupCbanking.uis.model.Transaction;
import com.groupCbanking.uis.util.AccountQueryUtil;
import com.groupCbanking.uis.util.DbUtil;
import com.groupCbanking.uis.util.TransactionQueryUtil;


import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AccountDaoImpl implements AccountDao{

    Transaction trans = new Transaction();

    @Override
    public int saveAccount(AccountUser account) {


        int status = 0;
        int status1 = 0;
        try(
                PreparedStatement ps = DbUtil.getConnection().prepareStatement(AccountQueryUtil.SAVE_SQL);
//                PreparedStatement ps1 = DbUtil.getConnection().prepareStatement(TransactionQueryUtil.UPDATE_SQL);

        ) {


            ps.setString(1, account.getAccountName());
            ps.setString(3, account.getEmail());
            ps.setLong(4, account.getMobileNo());
            ps.setInt(2, account.getAccountNumber());


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
        try(
                PreparedStatement ps = DbUtil.getConnection().prepareStatement(AccountQueryUtil.UPDATE_SQL);
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
        try(
                PreparedStatement ps = DbUtil.getConnection().prepareStatement(AccountQueryUtil.DELETE_SQL);
        ) {

            ps.setInt(1,accountId);



            deleted = ps.executeUpdate();
        } catch ( Exception e) {
            e.printStackTrace();
        }
        return deleted;
    }

    public int depositAmount(Transaction trans){
        int deposit = 0;
        try(
                PreparedStatement ps = DbUtil.getConnection().prepareStatement(TransactionQueryUtil.SAVE_SQL);
        ) {

            ps.setInt(1, trans.getAccountId());
            ps.setDouble(2, trans.getBalance());
            ps.setDouble(3, trans.getWithdrawnAmount());
            ps.setDouble(4, trans.getDepositedAmount());

            System.out.println(ps);


            deposit = ps.executeUpdate();
        } catch ( Exception e) {
            e.printStackTrace();
        }
        return deposit;


    }
}
