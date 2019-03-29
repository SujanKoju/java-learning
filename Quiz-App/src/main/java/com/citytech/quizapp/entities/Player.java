package com.citytech.quizapp.entities;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class Player extends User {
    static SecureRandom random = new SecureRandom();

    @Override
    public boolean validateUser(String userName, String passWord) {
        if (super.validateUser(userName, passWord) == false) {
            return false;
        } else {
            if (userName.equalsIgnoreCase("player") && passWord.equalsIgnoreCase("player")) {
                return true;
            } else {
                System.out.println("UserName/Password Incorrect Try Again !!!!");
                return false;
            }
        }
    }

    public void startAskingQuestions(List<Question> questions) {
        String playerChoice;
        List<Integer> previousGeneratedRandomNos = new ArrayList();
        int correctAnsCount = 0;
        if (questions.size() == 0) {
            System.out.println("No Question !! First Admin have to add Questions");
        }
        for (int questionNo = 0; questionNo < questions.size(); questionNo++) {
            System.out.println("Question No " + (questionNo + 1));
            int randomQues = getRandomQues(questions, previousGeneratedRandomNos);
            previousGeneratedRandomNos.add(randomQues);

            System.out.println(questions.get(randomQues).getQuestion());
            System.out.println("A." + questions.get(randomQues).getOptionA());
            System.out.println("B." + questions.get(randomQues).getOptionB());
            System.out.println("C." + questions.get(randomQues).getOptionC());
            System.out.println("D." + questions.get(randomQues).getOptionD());

            playerChoice = scannerForString.nextLine();

            if (questions.get(randomQues).getCorrectOption().equalsIgnoreCase(playerChoice)) {
                correctAnsCount++;
                System.out.println("Correct Answer !!!");
            } else {
                System.out.println("Wrong Answer .. Corect Option was :" + questions.get(questionNo).getCorrectOption());
            }
        }
        System.out.println("You Give " + correctAnsCount + " Correct Answers out of " + questions.size() + " Questions");

        System.out.println("Wanna Play Again ? \n1.Yes \n2.No");
        if (scannerForInt.nextInt() == 1) {
            startAskingQuestions(questions);
        } else {
            exitGreeting();
        }
    }

    private int getRandomQues(List<Question> questions, List<Integer> previousGeneratedRandomNos) {
        int randomQues = random.nextInt(questions.size());
        while (previousGeneratedRandomNos.indexOf(randomQues) != -1) {
            randomQues = random.nextInt(questions.size());
        }
        return randomQues;
    }
}
