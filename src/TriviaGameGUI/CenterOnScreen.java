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
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import javax.swing.JFrame;

public class CenterOnScreen extends JFrame {

    public CenterOnScreen(int x, int y, String title) {

        initUI(x, y, title);
    }

    private void initUI(int X, int Y, String title) {

        setSize(X, Y);
        centerFrame();
        setTitle(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void centerFrame() {

        Dimension windowSize = getSize();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Point centerPoint = ge.getCenterPoint();

        int dx = centerPoint.x - windowSize.width / 2;
        int dy = centerPoint.y - windowSize.height / 2;
        setLocation(dx, dy);
    }
}
