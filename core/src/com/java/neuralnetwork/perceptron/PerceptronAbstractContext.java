package com.java.neuralnetwork.perceptron;

public class PerceptronAbstractContext implements PerceptronContext{


    @Override
    public float guessY(float x) {
        return 0;
    }

    @Override
    public int guess(float[] inputs) {
        return 0;
    }

    @Override
    public int activate(float sum) {
        return 0;
    }

    @Override
    public void train(float[] inputs, int target) {

    }
}
