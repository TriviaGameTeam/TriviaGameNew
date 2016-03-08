/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TriviaGameGUI;

import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author NaorHaguli
 */
public class mainForm {

    private JTextField textbox1;

    public static void main(String[] args) {
        WindowClass myWindow = new WindowClass("Trivia Game - By Naor Haguli & Meitar Cohen");
        myWindow.setLocationRelativeTo(null);
        myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myWindow.setSize(800, 500);
        myWindow.setVisible(true);
    }
}
