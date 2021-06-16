package com.company;

public class Constraint {
    int subjectRow, subjectCol, comparisonRow, comparisonCol;
    Operator operator;

    public Constraint(String sign, int row, int col){
        if(sign.equals("<") || sign.equals(">")){
            createHorizontalConstraint(sign, row, col);
        }
        else{
            createVerticalConstraint(sign, row, col);
        }
    }

    private void createHorizontalConstraint(String sign, int row, int col) {
        // convert row/col indices to numberGrid row/col indices
        subjectRow = row/2;
        comparisonRow = row/2;
        subjectCol = (col - 1)/2;
        comparisonCol = (col + 1)/2;

        operator = stringToOperator(sign);
    }

    private void createVerticalConstraint(String sign, int row, int col) {
        // convert row/col indices to numberGrid row/col indices
        subjectRow = (row - 1)/2;
        comparisonRow = (row + 1)/2;
        subjectCol = col/2;
        comparisonCol = col/2;

        operator = stringToOperator(sign);
    }

    private Operator stringToOperator(String sign) {
        if(sign.equals("<") || sign.equals("^")){
            return Operator.LESSTHAN;
        }
        else{
            return Operator.GREATERTHAN;
        }
    }

    public boolean apply(int[][] numberGrid) {
        // get the two numbers
        int subject = numberGrid[subjectRow][subjectCol];
        int comparison = numberGrid[comparisonRow][comparisonCol];
        if(subject == 0 || comparison == 0){
            return true;
        }
        // check the constraint
        else{
            return operator.apply(subject, comparison);
        }
    }
}
