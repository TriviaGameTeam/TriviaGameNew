package TriviaGameGUI;

import TriviaGame.GameLogic;
import TriviaGame.Question;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class GameScreen extends JFrame implements ActionListener {

    GameLogic gameLogic;
    private JLabel questionContent = new JLabel("Here will be the Question from the DB!!");
    private JButton Next = new JButton("Next");
    private JRadioButton answer1;
    private JRadioButton answer2;
    private JRadioButton answer3;
    private JRadioButton answer4;
    private ButtonGroup buttongroup;
    Font font = new Font("Serif", Font.BOLD, 40);
    int countPoints = 0;

    Question question;

    public GameScreen(int numQuestions) {

        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setTitle("Trivia Game - By Meitar Cohen & Naor Haguli");
        this.setVisible(true);
        setSize(1000, 800);
        setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());

        this.add(questionContent, BorderLayout.NORTH);
        questionContent.setFont(font);

        answer1 = new JRadioButton("Answer #1");
        answer2 = new JRadioButton("Answer #2");
        answer3 = new JRadioButton("Answer #3");
        answer4 = new JRadioButton("Answer #4");

        buttongroup = new ButtonGroup();
        buttongroup.add(answer1);
        buttongroup.add(answer2);
        buttongroup.add(answer3);
        buttongroup.add(answer4);

        JPanel optionPanel = new JPanel(new GridLayout(4, 1));
        optionPanel.add(answer1);
        optionPanel.add(answer2);
        optionPanel.add(answer3);
        optionPanel.add(answer4);

        add(questionContent, BorderLayout.NORTH);
        this.add(optionPanel, BorderLayout.CENTER);
        add(Next, BorderLayout.SOUTH);
        Next.addActionListener(this);

        gameLogic = new GameLogic(numQuestions);

        question = gameLogic.getCurrentQuestion();

        questionContent.setText(question.getQuestionString());
        answer1.setText(question.getAnswers()[0]);
        answer2.setText(question.getAnswers()[1]);
        answer3.setText(question.getAnswers()[2]);
        answer4.setText(question.getAnswers()[3]);
        addListeners();
    }

    public void addListeners() {
        this.addWindowListener(new MyWindowListener());
    }

    class MyWindowListener extends WindowAdapter {

        /* All other 6 methods of the listener were already implemented in the 
            * WindowAdapter
         */
        @Override
        public void windowClosing(WindowEvent we) {
            showExitDialog();
        }
    }

    public void showExitDialog() {
        int result = JOptionPane.showConfirmDialog(GameScreen.this, // parent component
                "Are you sure you want to quit?", // message
                "Exit Dialog", // title of the dialog box
                JOptionPane.YES_NO_OPTION,// indicates buttons ot display
                JOptionPane.QUESTION_MESSAGE);
        //null);//new ImageIcon("images/questionmark.png")); 
        if (result == JOptionPane.YES_OPTION) {
            System.exit(0);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean correct = false;

        if (answer1.isSelected() && question.getRightAnswer() == 1) {
            correct = true;
        } else if (answer2.isSelected() && question.getRightAnswer() == 2) {
            correct = true;
        } else if (answer3.isSelected() && question.getRightAnswer() == 3) {
            correct = true;
        } else if (answer4.isSelected() && question.getRightAnswer() == 4) {
            correct = true;
        }
        if (correct) {
            //send to DB question points
            countPoints += question.getPoints();
            System.out.println("Now you have " + countPoints + " points.");
        }

        gameLogic.moveToNextQuestion();

        // check if the game is over - if it is over - show a message dialog
        // if not - continue to the next question
        if (gameLogic.isGameOver()) {
            dispose();
            setVisible(false);
            JOptionPane.showMessageDialog(this, "Game is Over!!\n Your Points is: "+countPoints+"!");
            
            
        } else {

            // this gets the current Question details
            question = gameLogic.getCurrentQuestion();

            // this updates the view with the details of the new question
            questionContent.setText(question.getQuestionString());
            answer1.setText(question.getAnswers()[0]);
            answer2.setText(question.getAnswers()[1]);
            answer3.setText(question.getAnswers()[2]);
            answer4.setText(question.getAnswers()[3]);
            
            buttongroup.clearSelection();
        }
    }
}
