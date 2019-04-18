package com.java.neuralnetwork.matrix;

import java.util.Arrays;

public class Matrix extends MatrixAbstractContext{
    private int rows;
    private int columns;
    private int[][]value;

    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;

        value = new int[rows][columns];

        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                value[i][j] = 1;

            }
        }

    }

    @Override
    public void randomize() {
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                value[i][j] *= Math.floor(Math.random() * 10);
            }
        }
    }

    @Override
    public void multiply(Object n){
        if (n instanceof Matrix){
            for (int i = 0; i < rows; i++){
                for (int j = 0; j < columns; j++){
                    value[i][j] += ((Matrix) n).value[i][j];
                }
            }
        }else {
            for (int i = 0; i < rows; i++){
                for (int j = 0; j < columns; j++){
                    value[i][j] *= (Integer) n;
                }
            }
        }
    }

    @Override
    public void add(Object n) {
        if (n instanceof Matrix){
            for (int i = 0; i < rows; i++){
                for (int j = 0; j < columns; j++){
                    value[i][j] += ((Matrix) n).value[i][j];
                }
            }
        }else {
            for (int i = 0; i < rows; i++){
                for (int j = 0; j < columns; j++){
                    value[i][j] += (Integer) n;
                }
            }
        }
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }
}
