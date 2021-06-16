package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class Solver {
    int[][] numberGrid;
    ArrayList<Constraint> constraints;

    public Solver(int[][] numberGrid, ArrayList<Constraint> constraints) {
        this.numberGrid = numberGrid;
        this.constraints = constraints;
    }

    // recursively called to test all numbers in all positions
    public boolean solve(){
        // Go through the grid
        for(int row = 0; row < 5; row++){
            for(int col = 0; col < 5; col++){
                // If there is a free space, try and fill it
                if(numberGrid[row][col] == 0){
                    for(int num = 1; num <=5; num++){
                        if(isValid(num, row, col)) { // if number is valid fill it in
                            numberGrid[row][col] = num;
                            if(solve()){
                                return true;
                            }
                            else{
                                numberGrid[row][col] = 0; // reset number if no solution from this point
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(int num, int row, int col) {
        // check if the value is already in the row or column
        if(!checkRow(num, row)){
            return false;
        }
        if(!checkCol(num, col)){
            return false;
        }

        // check if putting it there would break any constraints
        if(!checkConstraints(num, row, col)){
            return false;
        }

        // passed all checks so return true
        return true;
    }

    private boolean checkConstraints(int num, int row, int col) {
        // create copy of grid
        int[][] numberGridCopy = new int[5][5];
        for(int rowId = 0; rowId < 5; rowId++){
            for(int colId = 0; colId < 5; colId++){
                numberGridCopy[rowId][colId] = numberGrid[rowId][colId];
            }
        }

        // set the prospective value
        numberGridCopy[row][col] = num;

        // see if any of the constraints are broken by the prospective value
        for(Constraint constraint : constraints){
            if(!constraint.apply(numberGridCopy)){
                return false;
            }
        }
        return true;
    }

    // Checks if a value is already present in a row
    private boolean checkRow(int num, int row) {
        for(int col = 0; col < 5; col++){
            if(numberGrid[row][col] == num){
                return false;
            }
        }
        return true;
    }

    // Checks if a value is already present in a column
    private boolean checkCol(int num, int col) {
        for(int row = 0; row < 5; row++){
            if(numberGrid[row][col] == num){
                return false;
            }
        }
        return true;
    }

    public int[][] getSolution() {
        return numberGrid;
    }
}
