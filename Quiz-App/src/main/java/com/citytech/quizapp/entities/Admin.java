package com.citytech.quizapp.entities;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Admin extends User {

    @Override
    public boolean validateUser(String userName, String passWord) {
        if (super.validateUser(userName, passWord) == false) {
            return false;
        } else {
            if (userName.equalsIgnoreCase("admin") && passWord.equalsIgnoreCase("admin")) {
                System.out.println("You can Add Questions for the Quiz");
                return true;
            } else {
                System.out.println("UserName/Password Incorrect Try Again !!!!");
                return false;
            }
        }
    }

    public void addQuestions(List<Question> questions) {
        Question question = new Question();
        int continueAddingQuestion = 1;
        do {
            System.out.print("Enter Question :");
            question.setQuestion(scannerForString.nextLine());

            System.out.print("Enter Option A :");
            question.setOptionA(scannerForString.nextLine());

            System.out.print("Enter Option B :");
            question.setOptionB(scannerForString.nextLine());

            System.out.print("Enter Option C :");
            question.setOptionC(scannerForString.nextLine());

            System.out.print("Enter Option D :");
            question.setOptionD(scannerForString.nextLine());

            System.out.print("Enter Correct Option:");
            question.setCorrectOption(scannerForString.nextLine());

            questions.add(question);

            System.out.println("Wanna Add Question to File ? \n1.yes  2.No");
            if (scannerForInt.nextInt() == 1) {
                try {
                    FileWriter fileWriter = new FileWriter("E:\\java-learning\\Quiz-App\\QuizQuestions.txt", true);
                    fileWriter.write(question.getQuestion() + ":" + question.getOptionA() + ":" + question.getOptionB() + ":" + question.getOptionC() + ":" + question.getOptionD() + ":" + question.getCorrectOption() + "\n");

                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("Wanna Add More Questions ? \n1.yes  2.No");
            continueAddingQuestion = scannerForInt.nextInt();
            question = new Question();


        } while (continueAddingQuestion == 1);
    }
}
