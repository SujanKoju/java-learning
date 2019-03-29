package com.citytech.quizapp.entities;

import com.citytech.quizapp.utils.PrivilageEnum;

import java.util.Scanner;

public class User {
    Scanner scannerForInt = new Scanner(System.in);
    Scanner scannerForString = new Scanner(System.in);
    private String userName;
    private String passWord;
    private PrivilageEnum privilage;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public PrivilageEnum getPrivilage() {
        return privilage;
    }

    public void setPrivilage(PrivilageEnum privilage) {
        this.privilage = privilage;
    }

    public boolean validateUser(String userName, String passWord) {
        if (userName.equals("") || passWord.equals("")) {
            System.out.println("UserName/Password cannot be empty");
            return false;
        }
        return true;
    }
 public void exitGreeting() {
        System.out.println("********** Exiting From the Quiz ************");
        System.out.println("############## Thank You For Playing #################");
        return;
    }
}
