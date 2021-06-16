package com.company;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        // set up the UI, everything is dealt with within GUIWindow
        GUIWindow window = new GUIWindow();
        JFrame jf = new JFrame();
        jf.setTitle("Futoshiki Solver");
        jf.setSize(500,500);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
        jf.add(window);
    }
}
