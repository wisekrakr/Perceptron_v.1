package com.java.neuralnetwork.subjects;

import com.badlogic.gdx.Gdx;
import com.java.neuralnetwork.training.Mapping;

public class PointAbstractContext implements PointContext {

    private float x;
    private float y;
    private float bias = 1;
    private int label;

    @Override
    public float pixelX() {
        return Mapping.map(x, -1,1,0, Gdx.graphics.getWidth());
    }

    @Override
    public float pixelY() {
        return Mapping.map(y, -1,1,0, Gdx.graphics.getHeight());
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getLabel() {
        return label;
    }

    public void setLabel(int label) {
        this.label = label;
    }

    public float getBias() {
        return bias;
    }

}
