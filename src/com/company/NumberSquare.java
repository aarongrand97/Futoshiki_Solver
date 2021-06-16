package com.company;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class NumberSquare extends InputSquare {
    String[] numberCycleArray = {"", "1", "2", "3", "4", "5"};
    int currentNumberIndex = 0;
    public NumberSquare(){
        super();
        tf.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                currentNumberIndex++;
                currentNumberIndex %= 6; // return to 0 after exceeds 5
                tf.setText(numberCycleArray[currentNumberIndex]);
            }

            // REDUNDANT
            @Override
            public void mousePressed(MouseEvent e) {

            }
            // REDUNDANT
            @Override
            public void mouseReleased(MouseEvent e) {

            }
            // REDUNDANT
            @Override
            public void mouseEntered(MouseEvent e) {

            }
            // REDUNDANT
            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }
}
