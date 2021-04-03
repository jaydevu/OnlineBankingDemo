package com.groupCbanking.uis.util;

public class AccountQueryUtil {

    public static final String SAVE_SQL = "insert into account_tbl(account_name, account_no, email,mobile_no)values(?,?,?,?)";
    public static final String UPDATE_SQL = "update account_tbl set account_name=?, account_no=?, mobile_no=?, email=? where id = ?";
    public static final String DELETE_SQL = "delete from account_tbl where id = ?";
//    public static final String LIST_SQL = "select * from user_tbl";
//    public static final String GET_BY_ID_SQL = "select * from user_tbl where id = ?";


}

