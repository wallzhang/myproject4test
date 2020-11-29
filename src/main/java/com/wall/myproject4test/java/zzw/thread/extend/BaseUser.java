package com.wall.myproject4test.java.zzw.thread.extend;


/** 
* @Description: 基础用户
* @Author: zhang.zw
* @Date: 2020/11/29 
*/
public class BaseUser {

    /**
     * 用户名称
     */
    private String userName;
    /**
     * 余额
     */
    private int account;

    public BaseUser(String userName, int account) {
        this.userName = userName;
        this.account = account;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public void delAccount(int amount){
        this.account-=amount;
    }
    public void addAccount(int amount){
        this.account+=amount;
    }
}
