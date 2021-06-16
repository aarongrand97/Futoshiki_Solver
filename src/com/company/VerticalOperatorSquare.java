package com.company;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class VerticalOperatorSquare extends InputSquare {
    String[] operatorCycleArray = {"", "^", "v"};
    int currentOperatorIndex = 0;
    public VerticalOperatorSquare(){
        super();

        tf.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Cycle through operators
                currentOperatorIndex++;
                currentOperatorIndex %= 3;
                tf.setText(operatorCycleArray[currentOperatorIndex]);
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
