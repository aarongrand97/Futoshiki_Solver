package com.company;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class InputSquare extends GridSquare{
    JTextField tf;
    public InputSquare(){
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        addTextField();
    }

    private void addTextField() {
        tf = new JTextField(){
            // no border so leave blank
            @Override public void setBorder(Border border) {

            }
        };
        // general appearance of text
        tf.setPreferredSize(new Dimension(30,30));
        tf.setFont(new Font("SansSerif", Font.BOLD, 20));
        tf.setHorizontalAlignment(JTextField.CENTER);
        tf.setEnabled(false);
        this.add(tf);
    }
}
