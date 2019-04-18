package com.java.neuralnetwork.helpers;



import java.util.Random;

public class GameHelper {

    /**
     * Utility methods available to scenarios
     */
    public static Random randomGenerator = new Random();

    public static float generateRandomNumberBetween(float min, float max){
        return randomGenerator.nextFloat() * (max - min) + min;
    }

    public static float betweenZeroAndOne(){
        return randomGenerator.nextInt(1);
    }


}
