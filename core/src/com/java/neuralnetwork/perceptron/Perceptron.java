package com.java.neuralnetwork.perceptron;


import com.java.neuralnetwork.helpers.GameHelper;

/**
 * The X, Y and Bias are all multiplied by their corresponding weight (w0x + w1y + w2b = 0)
 */
public class Perceptron extends PerceptronAbstractContext{

    private float[] weights;
    private float learningRate = 0.001f; //rate of correcting the error

    public Perceptron(int n) {
        this.weights = new float[n];

        for (int i = 0; i < weights.length; i++){
            weights[i] = GameHelper.generateRandomNumberBetween(-1,1);
        }
    }

    /**
     * Create a slope.
     * @param x
     * @return weight1/weight2 * x + bias (y intercept of the dividing line)
     */
    @Override
    public float guessY(float x){

        float w0 = weights[0];
        float w1 = weights[1];
        float w2 = weights[2];

        return -(w2/w1) - (w0/w1) * x;
    }

    @Override
    public int guess(float[] inputs){

        float sum = 0;
        //Loop through number of weights and create a sum of all the inputs multiplied by their corresponding weights.
        for (int i = 0; i < weights.length; i++){
            sum += inputs[i]*weights[i];
        }

        return activate(sum);
    }

    /**
     * The Activation function
     * @param sum of inputs multiplied by their weights
     * @return the output of the sum of inputs multiplied by their weights
     */
    @Override
    public int activate(float sum){
        //Math.signum(sum) can also be used.
        if (sum >= 0){
            return  1;
        }else {
            return  -1;
        }
    }

    /**
     *  Each weight should change according to the error multiplied by the corresponding input;
     * @param inputs
     * @param target answer we know
     */
    @Override
    public void train(float[] inputs, int target){
        int guess = guess(inputs);
        int error = target - guess;

        for (int i = 0; i < weights.length; i++){
            weights[i] += error * inputs[i] * learningRate;
        }
    }
}
