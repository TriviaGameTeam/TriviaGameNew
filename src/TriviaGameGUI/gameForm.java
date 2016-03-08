/*
 ----------------------------------------------------------------------------
לא צריך את המחלקה הזו הכל נמצא במחלקה גיים סקרין
-----------------------------------------------------------------------------
 */
package TriviaGameGUI;

import TriviaGame.Question;
import TriviaGame.playGame;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author NaorHaguli
 */
public class gameForm extends JFrame implements ActionListener {

    private JLabel questionContent = new JLabel("Here will be the Question from the DB!!");
    private JButton Next = new JButton("Next");
    private JRadioButton answer1;
    private JRadioButton answer2;
    private JRadioButton answer3;
    private JRadioButton answer4;
    private ButtonGroup buttongroup;
    Font font = new Font("Serif", Font.BOLD, 40);
    Question question = new Question();
    int remainedQuestions;

    public gameForm(Question question, int remainedQuestions) {
        setTitle("Trivia Game - By Meitar Cohen");
        this.setVisible(true);
        setSize(1000,800);
        setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.question = question;
        this.add(questionContent, BorderLayout.NORTH);
        questionContent.setFont(font);
        this.remainedQuestions = remainedQuestions;
        questionContent.setText(question.getQuestionString());
        answer1 = new JRadioButton(question.getAnswers()[0]);
      //  answer1.setText(question.getAnswer()[0]);
        answer2 = new JRadioButton(question.getAnswers()[1]);
        answer3 = new JRadioButton(question.getAnswers()[2]);
        answer4 = new JRadioButton(question.getAnswers()[3]);

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

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean correct = false;
        if (e.getSource() == Next) {
            if (buttongroup.getSelection() == answer1 && question.getRightAnswer() == 1) {
                correct = true;
            } else if (buttongroup.getSelection() == answer2 && question.getRightAnswer() == 2) {
                correct = true;
            } else if (buttongroup.getSelection() == answer3 && question.getRightAnswer() == 3) {
                correct = true;
            } else if (buttongroup.getSelection() == answer4 && question.getRightAnswer() == 4) {
                correct = true;
            }
            if(correct){
                //send to DB += question points
            }
            playGame pg = new playGame(remainedQuestions);
            this.dispose();
        }
    }

}
