package TriviaGameGUI;

import javax.swing.JFrame;
import javax.swing.JTextField;

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
