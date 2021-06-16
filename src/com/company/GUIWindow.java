package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GUIWindow extends JPanel {
    JButton solveButton = new JButton("SOLVE");
    GridBagConstraints gbc = new GridBagConstraints();

    Grid grid = new Grid(); // grid that holds the squares

    GUIWindow(){
        setLayout(new GridBagLayout());
        gbc.insets = new Insets(10,10,10,10);

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(grid, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(solveButton, gbc);

        solveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // get the inputted numbers and constraints
                int [][] numberGrid = grid.getNumberGrid();
                ArrayList<Constraint> constraints = grid.getConstraints();
                // create solver and attempt to solve
                Solver solver = new Solver(numberGrid, constraints);
                boolean result = solver.solve();

                // show solution if one is found
                if(result) {
                    numberGrid = solver.getSolution();
                    grid.setValues(numberGrid);
                }
            }
        });
    }
}
