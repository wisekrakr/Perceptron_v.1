package com.java.neuralnetwork.training;

public class Trainer {

    private float[]inputs;
    private int answer;

    public Trainer(float x, float y, int a) {
        this.answer = a;
        inputs = new float[3];
        inputs[0] = x;
        inputs[1] = y;
        inputs[2] = 1; //bias input
    }


}
