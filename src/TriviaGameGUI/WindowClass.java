
package TriviaGameGUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.*;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

/**
 *
 * @author NaorHaguli
 */
public class WindowClass extends JFrame implements ActionListener {

    JButton okButton;
    JTextField usernameText;
    String username;
    JButton cardImageButton;

    JMenuBar myMenuBar = new JMenuBar();
    JMenu fileMenu = new JMenu("File");
    JMenu helpMenu = new JMenu("Help");
    JMenuItem newMenuItem = new JMenuItem("New");
    JMenuItem openMenuItem = new JMenuItem("Open");
    JMenuItem exitMenuItem = new JMenuItem("Exit");
    JMenuItem aboutMenuItem = new JMenuItem("About");

    JRadioButton option1Button = new JRadioButton("London");
    JRadioButton option2Button = new JRadioButton("Paris");
    JPanel optionsPanel = new JPanel(new GridLayout(4, 1));
    ButtonGroup answersGroup = new ButtonGroup();

    public WindowClass(String title) {
        super(title);

        initComponents();
        addListeners();
        buildMenu();

        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    public void initComponents() {
        okButton = new JButton("OK");
        usernameText = new JTextField("Enter user name");
        cardImageButton = new JButton(new ImageIcon("images/Card.png"));
        this.add(okButton, BorderLayout.SOUTH);
        this.add(usernameText, BorderLayout.NORTH);
        this.add(cardImageButton, BorderLayout.CENTER);

        answersGroup.add(option1Button);
        answersGroup.add(option2Button);

        optionsPanel.add(option1Button);
        optionsPanel.add(option2Button);
        this.add(optionsPanel, BorderLayout.CENTER);
    }

    public void addListeners() {

        okButton.addActionListener(this);
        cardImageButton.addActionListener(this);
        this.addWindowListener(new MyWindowListener());
        exitMenuItem.addActionListener(this);
    }

    public void buildMenu() {
        fileMenu.add(newMenuItem);
        fileMenu.add(openMenuItem);
        fileMenu.add(exitMenuItem);
        myMenuBar.add(fileMenu);

        helpMenu.add(aboutMenuItem);
        myMenuBar.add(helpMenu);

        // this adds the entire bar to the top of the frame
        this.setJMenuBar(myMenuBar);
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
        int result = JOptionPane.showConfirmDialog(WindowClass.this, // parent component
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
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == cardImageButton) {
            cardImageButton.setIcon(new ImageIcon("images/cat.png"));
        } else if (ae.getSource() == okButton) {
            username = usernameText.getText();
            System.out.println("User chosen is " + username);
            String selectedAnswer = "";
            if (option1Button.isSelected()) {
                selectedAnswer = option1Button.getText();
            } else if (option2Button.isSelected()) {
                selectedAnswer = option2Button.getText();
            }

            System.out.println("You selected " + selectedAnswer);
        } else if (ae.getSource() == exitMenuItem) {
            showExitDialog();
        }
    }

}
