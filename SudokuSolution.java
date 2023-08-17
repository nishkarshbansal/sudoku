package com.example.sudokusolver;

import android.widget.EditText;

public class SudokuSolution {
    public static boolean isSafe(int[][] arr, int row, int col, int number){
        for (int i = 0; i < 9; i++){
            if (arr[row][i] == number) {
                return false;
            }
        }
        for (int i = 0; i < 9; i++){
            if (arr[i][col] == number) {
                return false;
            }
        }
        int br = (row/3)*3;
        int bc = (col/3)*3;
        for (int i = br; i < br + 3; i++){
            for (int j = bc; j < bc + 3; j++){
                if (arr[i][j] == number) {
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean helper(int[][] arr, int row, int col){
        if(row == arr.length){
            return true;
        }

        int nrow = 0;
        int ncol = 0;
        if(col != arr.length - 1){
            nrow = row;
            ncol = col + 1;
        }else{
            nrow = row + 1;
            ncol = 0;
        }

        if (arr[row][col] != 0){
            if (helper(arr, nrow, ncol)) {
                return true;
            }
        }else{
            for (int i = 1; i <= 9; i++) {
                if (isSafe(arr, row, col, i)) {
                    arr[row][col] = i;
                    if (helper(arr, nrow, ncol)) {
                        return true;
                    }else {
                        arr[row][col] = 0;
                    }
                }
            }
        }

        return false;
    }
    public static int[][] arrayReform(int[][] arr){
        helper(arr, 0, 0);
        return arr;
    }

}

