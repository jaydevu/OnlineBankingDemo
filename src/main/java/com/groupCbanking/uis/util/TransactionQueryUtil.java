package com.groupCbanking.uis.util;

public class TransactionQueryUtil {

    public static final String SAVE_SQL2 = "insert into transaction_tbl set account_id =?, balance = ?, withdrawn_amount = ?, deposit_amount =?";
    public static final String UPDATE_SQL2 = "update transaction_tbl set balance = ?, withdrawn_amount = ?, deposit_amount =? where account_id = ?";
    public static final String CHECK_SQL2 = "select balance from transaction_tbl where account_id = ?";
}
