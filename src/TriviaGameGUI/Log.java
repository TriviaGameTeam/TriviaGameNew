/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TriviaGameGUI;

/**
 *
 * @author NaorHaguli
 */
import TriviaGame.playGame;
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
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        actionlogin();
    }

    public void actionlogin() {
        blogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                int ans = Integer.valueOf(userAns.getText());
                if (ans > 0 && ans <= 5) {
                   // playGame pGame;
                    //pGame = new playGame(Integer.valueOf(userAns.getText()));
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
