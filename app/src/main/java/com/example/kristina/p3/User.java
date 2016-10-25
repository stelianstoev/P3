package com.example.kristina.p3;

/**
 * Created by Kristina on 16.10.2016.
 */

public class User {

    private String roomNumber;
    private double accountBalance;

    public User (String roomNumber) {
        this.roomNumber = roomNumber;
        accountBalance = 0;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }
}
