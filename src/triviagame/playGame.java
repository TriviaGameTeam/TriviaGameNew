/*
---------------------------------------------------------------------
לא צריך את המחלקה הזו הכל נמצא במחלה גיים לוגיק
--------------------------------------------------------------------
*/
package TriviaGame;

import TriviaGameGUI.gameForm;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class playGame {
    //יצירת המערכים שהם קבועים וסופיים לכל המשחק

    private static final String[] Questions = {"How many stars there are in the flag of the USA?", "What is the capital city of ISrael?", "How many letters there are in the english language?", "How many grams there are in 1 kilogram has?", "What are the three primary colors?"};
    private static final String[] Answers = {"25", "36", "51", "60", "Tel-Aviv", "Jerusalem", "Eilat", "Hebron", "20", "18", "22", "26", "100", "500", "1000", "10", "Yellow,Red,Blue", "Green,Yellow,Red", "Red,Green,Blue", "None of the answer"};
    private static final int[] correctAnswers = {3, 2, 4, 3, 3};
    private static Question[] questionsList = {new Question(), new Question(), new Question(), new Question(), new Question()};
    boolean found = false;

    //בנאי שיוצר אוספים של שאלות ושל תשובות
    public playGame(int countQuestionsAnswers) {
        List<String> questions = new ArrayList<String>(5);//אוסף של שאלות
        List<String> answers = new ArrayList<String>(20);//אוסף של תשובות
        List<String> questionShown = new ArrayList<String>(5);// אוסף השאלות שנשאלו
        List<String> answerShown = new ArrayList<String>(20);//אוסף התשובות של השאלות שנשאלו
        questions.addAll(Arrays.asList(Questions));
        answers.addAll(Arrays.asList(Answers));
        String[] answerArr = new String[4];
        for (int i = 0, h = 0; i < 5; i++, h += 4) {
            Question tempQuestion = questionsList[i];
            tempQuestion.setQuestionString(questions.get(i));
            tempQuestion.setRightAnswer(correctAnswers[i]);
//            tempQuestion.setQuestionString(questions[i]);

            for (int j = h, k = 0; j < (h + 4); j++, k++) {
                answerArr[k] = Answers[j];
            }
            tempQuestion.setAnswers(answerArr);
            tempQuestion.setRightAnswer(correctAnswers[i]);
            questionsList[i] = tempQuestion;
            
        }
        Random rmd = new Random();
        gameForm gf1;
        int randomNumber;
//        Question tempQuestion;
        while (!found) {
            if (countQuestionsAnswers > 0 && !(questions.isEmpty())) {
                int Low = 0;
                int High = 5;
                randomNumber = rmd.nextInt(High - Low) + Low;
                System.out.println(randomNumber);
                Question tempQ = questionsList[randomNumber];
                questionShown.add(questions.get(randomNumber));
                Iterator< String> iterator = questions.iterator();
                for (int i = 0; i <= 4; i++) {
                    if (questionShown.contains(iterator.next())) {
                        iterator.remove();
                    }
                }
                tempQ.setShown(true);
                countQuestionsAnswers -= 1;
                gf1 = new gameForm(tempQ, countQuestionsAnswers);
//                if (!tempQ.isShown()) {
//
//                    tempQ.setShown(true);
//                    countQuestionsAnswers -= 1;
//                    gf1 = new gameForm(tempQ, countQuestionsAnswers);
//                    found = true;
//                }
            } else {
                break;
            }
        }
        /*   questions.addAll(Arrays.asList(Questions));//הוספת השאלות בסיבוב אחד בלבד
        answers.addAll(Arrays.asList(Answers));//הוספת התשובות בסיבוב אחד בלבד
        Scanner input = new Scanner(System.in);
        int xyz = 0;//משתנה שכל תפקידו הוא לוודא שהמשתמש מקבל את כמות השאלות שהוא ביקש
        int currentAns = 0;//משתנה עזר שתפקידו לעזור לעבור על אוסף השאלות ולהציגן למשתמש
        Random rmd = new Random();
        int Low = 0;
        int High = 5;
        int currentQuestion = rmd.nextInt(High - Low) + Low;//משתנה עזר שנותן להציג בכל משחק את השאלות בסדר אקראי
        boolean[] wasQuestion = new boolean[5];//מערך בוליאני שדואג שהמספרים שהיו לא יחזרו על עצמם
        Arrays.fill(wasQuestion, Boolean.FALSE);//false-איתחול המערך הבוליאני ב
        //לולאה שתפקידה להציג כל פעם שאלה אחרת ולדאוג שהיא לא חורגת מכמות השאלות שהמשתמש ביקש
        for (char i ='A' ; xyz < countQuestionsAnswers; xyz++, i++, currentQuestion = rmd.nextInt(High - Low) + Low) {
            if (wasQuestion[currentQuestion] == true) {
                i--;
                xyz--;
                continue;//במידה ויש חזרה על השאלה מדלגים למספר חדש שהוא נשפלף מראש הלולאה
                
            } else {
                wasQuestion[currentQuestion] = true;//במידה ולא כאן מתבצעת השמה לזה שהוא שומש כבר.
            }
            //Replace the Swich Case Loop! nothing else!!!(** MUST TO FIND ANADER WAY!!!** ) 
            //יש צורך להתמיע את המחלקה שאלות (Question) כאן!
            if (currentQuestion == 0) {
                System.out.print(i + ") ");
                System.out.println(questions.get(0));
                for (int j = 0; j < 4; j++, currentAns++) {
                    System.out.print((j+1)+") ");
                    System.out.println(answers.get(currentAns));
                }
                System.out.println("Please enter answer between 1-4:");
                int currentAnswer = input.nextInt();
                if (currentAnswer == 3) {
//                    gamePoint += questions[0].getPoints(); // Not necessary at the moment
                    System.out.println("You are Currect!");
                } else {
                    System.out.println("You worng!");
                }
            }
            if (currentQuestion == 1) {
                System.out.print(i + ") ");
                System.out.println(questions.get(1));
                currentAns = 4;
                for (int j = 0; j < 4; j++, currentAns++) {
                    System.out.print((j+1)+") ");
                    System.out.println(answers.get(currentAns));
                }
                System.out.println("Please enter answer between 1-4:");
                int currentAnswer = input.nextInt();
                if (currentAnswer == 2) {
//                    gamePoint += questions[1].getPoints(); // Not necessary at the moment
                    System.out.println("You are Currect!");
                } else {
                    System.out.println("You worng!");
                }
            }
            if (currentQuestion == 2) {
                System.out.print(i + ") ");
                System.out.println(questions.get(2));
                currentAns = 8;
                for (int j = 0; j < 4; j++, currentAns++) {
                    System.out.print((j+1)+") ");
                    System.out.println(answers.get(currentAns));
                }
                System.out.println("Please enter answer between 1-4:");
                int currentAnswer = input.nextInt();
                if (currentAnswer == 4) {
//                    gamePoint += questions[2].getPoints(); // Not necessary at the moment
                    System.out.println("You are Currect!");
                } else {
                    System.out.println("You worng!");
                }
            }
            if (currentQuestion == 3) {
                System.out.print(i + ") ");
                System.out.println(questions.get(3));
                currentAns = 12;
                for (int j = 0; j < 4; j++, currentAns++) {
                    System.out.print((j+1)+") ");
                    System.out.println(answers.get(currentAns));
                }
                System.out.println("Please enter answer between 1-4:");
                int currentAnswer = input.nextInt();
                if (currentAnswer == 3) {
//                    gamePoint += questions[3].getPoints(); // Not necessary at the moment
                    System.out.println("You are Currect!");
                } else {
                    System.out.println("You worng!");
                }
            }
            if (currentQuestion == 4) {
                System.out.print(i + ") ");
                System.out.println(questions.get(4));
                currentAns = 16;
                for (int j = 0; j < 4; j++, currentAns++) {
                    System.out.print((j+1)+") ");
                    System.out.println(answers.get(currentAns));
                }
                System.out.println("Please enter answer between 1-4:");
                int currentAnswer = input.nextInt();
                if (currentAnswer == 3) {
//                    gamePoint += questions[4].getPoints(); // Not necessary at the moment
                    System.out.println("You are Currect!");
                } else {
                    System.out.println("You worng!");
                }
            }
        }*/
    }
}
