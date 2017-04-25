package task3;

import javax.swing.*;

class MyFrame extends JFrame {
    MyPanel panel;
    private static final int WIDTH = 500;
    private static final int HEIGTH = 1000;
    MyFrame() {
        panel = new MyPanel();
        setTitle("Task3");
        setSize(WIDTH,HEIGTH);
        add(panel);
    }
}