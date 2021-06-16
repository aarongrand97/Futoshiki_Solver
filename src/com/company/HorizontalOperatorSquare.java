package com.company;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class HorizontalOperatorSquare extends InputSquare {
    String[] operatorCycleArray = {"", "<", ">"};
    int currentOperatorIndex = 0;
    public HorizontalOperatorSquare(){
        super();

        tf.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // cycle through each operator
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
