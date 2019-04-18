package com.java.neuralnetwork.training;

public class Mapping {

    public static float map(float value, int minA, int maxA, int minB, int maxB){
        return (1-((value - minA) / (maxA - minA))) * minB + ((value - minA) / (maxA - minA)) * maxB;
    }


}
