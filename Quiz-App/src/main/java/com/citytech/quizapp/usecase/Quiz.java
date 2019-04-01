package com.citytech.quizapp.usecase;

import com.citytech.quizapp.adapter.FileToQuestionAdapter;
import com.citytech.quizapp.entities.Admin;
import com.citytech.quizapp.entities.Player;
import com.citytech.quizapp.entities.Question;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Quiz {

    List<Question> questions;
    Scanner scannerForInt = new Scanner(System.in);
    Scanner scannerForString = new Scanner(System.in);

    public Quiz() {
        questions = new ArrayList<Question>();
        loadQuestionFromFile();
    }

    public void loadQuestionFromFile() {
        FileToQuestionAdapter fileToQuestionAdapter = new FileToQuestionAdapter();
        questions = fileToQuestionAdapter.fileToQuestionAdapter();
    }

    public void startTheApp() {
        System.out.println("********** Welcome to the Quiz ************");
        System.out.println("Select Type of the User: \n 1.Admin \n 2.Player \n 3.To Exit the App");
        int choice = scannerForInt.nextInt();
        if (choice == 1 || choice == 2) {
            start(choice);
        } else if (choice == 3) {
            exitGreeting();
        }
    }

    public void start(int choice) {
        System.out.println("Enter Credintials ");
        System.out.print("UserName : ");
        String userName = scannerForString.nextLine();
        System.out.print("PassWord : ");
        String passWord = scannerForString.nextLine();
        validateUserAndStart(choice, userName, passWord);
    }

    public void validateUserAndStart(int choice, String userName, String passWord) {
        if (choice == 1) {
            Admin admin = new Admin();
            if (admin.validateUser(userName, passWord)) {
                admin.addQuestions(questions);
                startTheApp();
            } else {
                startTheApp();
            }
        } else {
            Player player = new Player();
            if (player.validateUser(userName, passWord)) {
                player.startAskingQuestions(questions);
            } else {
                System.out.println("UserName/Password Incorrect Try Again !!!!");
                startTheApp();
            }
        }
    }

    public void exitGreeting() {
        System.out.println("********** Exiting From the Quiz ************");
        System.out.println("############## Thank You For Playing #################");
        return;
    }
}