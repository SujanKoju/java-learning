package com.citytech.quizapp.adapter;

import com.citytech.quizapp.entities.Question;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileToQuestionAdapter {

    public List<Question> fileToQuestionAdapter() {
        List<Question> questions = new ArrayList<Question>();
        File quizQuesFile = new File("E:\\java-learning\\Quiz-App\\QuizQuestions.txt");
        Scanner scannerForFile = null;
        try {
            scannerForFile = new Scanner(quizQuesFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (scannerForFile.hasNextLine()) {
            String[] quesWithCorrOption = scannerForFile.nextLine().split(":");
            Question question = new Question();
            question.setQuestion(quesWithCorrOption[0]);
            question.setOptionA(quesWithCorrOption[1]);
            question.setOptionB(quesWithCorrOption[2]);
            question.setOptionC(quesWithCorrOption[3]);
            question.setOptionD(quesWithCorrOption[4]);
            question.setCorrectOption(quesWithCorrOption[5]);
            questions.add(question);
        }
        return questions;
    }
}
