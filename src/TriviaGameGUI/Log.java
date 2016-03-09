package TriviaGameGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.util.Locale;
import javax.swing.JFrame;
import java.util.Scanner;

public class Log extends JFrame {

    public static void main(String[] args) {
        Log logForm = new Log();
    }

    JButton blogin = new JButton("Start Game!");
    JPanel panel = new JPanel();
    JLabel textLable = new JLabel("Please enter the number of question that you want to answer! (Max 15)");
    JTextField userAns = new JTextField(2);

    public Log() {
        super("Welcom to Trivia Game!");
        panel.setLayout(null);

        setSize(500, 190);
        setLocationRelativeTo(null);
        textLable.setBounds(35, 30, 400, 20);
        userAns.setBounds(160, 60, 150, 20);
        blogin.setBounds(185, 90, 105, 20);
        setVisible(true);

        panel.add(blogin);
        panel.add(textLable);
        panel.add(userAns);

        getContentPane().add(panel);
        userAns.requestFocusInWindow();
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        actionlogin();
        addListeners();
    }
        public void addListeners()
    { 
        this.addWindowListener(new MyWindowListener());
    }
    class MyWindowListener extends WindowAdapter
    {
           /* All other 6 methods of the listener were already implemented in the 
            * WindowAdapter
            */
        @Override
        public void windowClosing(WindowEvent we) {
                showExitDialog();
        }
    }
    
    public void showExitDialog()
    {
         int result = JOptionPane.showConfirmDialog(Log.this,         // parent component
                                        "Are you sure you want to quit?", // message
                                        "Exit Dialog",      // title of the dialog box
                                        JOptionPane.YES_NO_OPTION,// indicates buttons ot display
                                        JOptionPane.QUESTION_MESSAGE);
                                        //null);//new ImageIcon("images/questionmark.png")); 
            if(result == JOptionPane.YES_OPTION)
                System.exit(0);
            
    }
    public void actionlogin() {
        blogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                int ans = Integer.valueOf(userAns.getText()); //the max questions that the client can answer
                if (ans > 0 && ans <= 15) {
                    GameScreen mainScreen = new GameScreen(ans);
                    
                    dispose();
                    setVisible(false);

                } else {
                    JOptionPane.showMessageDialog(null, "Wrong Insert!");
                }
                userAns.setText("");
                userAns.requestFocus();
            }
        });
    }
}
