package com.java.neuralnetwork.perceptron;

public interface PerceptronContext {

    float guessY(float x);
    int guess(float[] inputs);
    int activate(float sum);
    void train(float[] inputs, int target);

}
