package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Grid extends JPanel {
    GridSquare[][] squareHolder = new GridSquare[9][9];

    public Grid(){
        setLayout(new GridLayout(9,9));
        addSquaresToHolder();
        addSquaresToGrid();
    }

    // adds the ordered squares to the grid from holder
    private void addSquaresToGrid() {
        for(int row = 0; row < 9; row++){
            for(int col = 0; col < 9; col++){
                add(squareHolder[row][col]);
            }
        }
    }

    // adds the squares in order to a holder so can be added in sequence
    private void addSquaresToHolder() {
        for(int row = 0; row < 9; row+=2){
            for(int col = 0; col < 9; col++){
                if(col % 2 == 0){
                    squareHolder[row][col] = new NumberSquare();
                }
                else{
                    squareHolder[row][col] = new HorizontalOperatorSquare();
                }
            }
        }
        for(int row = 1; row < 9; row+=2){
            for(int col = 0; col < 9; col++){
                if(col % 2 == 0){
                    squareHolder[row][col] = new VerticalOperatorSquare();
                }
                else{
                    squareHolder[row][col] = new EmptySquare();
                }
            }
        }
    }

    // returns the numbers from the grid
    public int[][] getNumberGrid(){
        int [][] ret = new int[5][5];
        for(int row = 0; row < 9; row += 2){
            for(int col = 0; col < 9; col += 2){
                NumberSquare sq = (NumberSquare) squareHolder[row][col];
                String str = sq.tf.getText();
                if(!str.isEmpty()) {
                    ret[row/2][col/2] = Integer.valueOf(str);
                }
            }
        }
        return ret;
    }

    // returns the constraints from the grid
    public ArrayList<Constraint> getConstraints() {
        ArrayList<Constraint> ret = new ArrayList<Constraint>();
        for(int row = 0; row < 9; row += 2){
            for(int col = 1; col < 9; col += 2){
                HorizontalOperatorSquare sq = (HorizontalOperatorSquare) squareHolder[row][col];
                String str = sq.tf.getText();
                if(!str.isEmpty()){
                    ret.add(new Constraint(str, row, col));
                }
            }
        }

        for(int row = 1; row < 9; row +=2){
            for(int col = 0; col < 9; col+=2){
                VerticalOperatorSquare sq = (VerticalOperatorSquare) squareHolder[row][col];
                String str = sq.tf.getText();
                if(!str.isEmpty()){
                    ret.add(new Constraint(str, row, col));
                }
            }
        }

        return ret;
    }

    // sets the number values in the grid
    public void setValues(int[][] numberGrid){
        for(int row = 0; row < 9; row+=2){
            for(int col = 0; col < 9; col+=2){
                NumberSquare nSq= (NumberSquare)squareHolder[row][col];
                nSq.tf.setText(String.valueOf(numberGrid[row/2][col/2]));
            }
        }
    }
}
