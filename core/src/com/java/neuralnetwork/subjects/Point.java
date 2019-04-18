package com.java.neuralnetwork.subjects;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.java.neuralnetwork.helpers.GameHelper;

public class Point extends PointAbstractContext {

    private boolean fill;
    private ShapeRenderer shapeRenderer;

    public Point() {
        setX(GameHelper.generateRandomNumberBetween(-1, 1));
        setY(GameHelper.generateRandomNumberBetween(-1, 1));

        float lineY = curve(getX());

        if (getY() > lineY){
            setLabel(1);
        }else {
            setLabel(-1);
        }
    }

    public Point(float x, float y) {
        setX(x);
        setY(y);

        float lineY = curve(getX());

        if (getY() > lineY){
            setLabel(1);
        }else {
            setLabel(-1);
        }
    }

    /**
     * y = mx + b
     * @param x
     * @return a line
     */
    public float curve(float x){
        return -0.3f * x - 0.2f;
    }

    public void setFill(boolean fill) {
        this.fill = fill;
    }

    public boolean isFill() {
        return fill;
    }
}
