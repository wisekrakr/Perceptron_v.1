package com.java.neuralnetwork.rendering;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.java.neuralnetwork.subjects.Point;

public class SubjectRenderer {

    public static void renderPoints(ShapeRenderer shapeRenderer, Point point){

        float pixelX = point.pixelX();
        float pixelY = point.pixelY();

        if (point.getLabel() == 1){
            shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
            shapeRenderer.setColor(Color.ORANGE);
            shapeRenderer.circle(pixelX,pixelY,10);
            shapeRenderer.end();
        }else {
            shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
            shapeRenderer.setColor(Color.CYAN);
            shapeRenderer.circle(pixelX,pixelY, 10);
            shapeRenderer.end();
        }
        if (point.isFill()){
            shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
            shapeRenderer.setColor(Color.GREEN);
            shapeRenderer.circle(pixelX,pixelY,5);
            shapeRenderer.end();
        }else {
            shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
            shapeRenderer.setColor(Color.RED);
            shapeRenderer.circle(pixelX,pixelY,5);
            shapeRenderer.end();
        }
    }


    public static void drawLine(ShapeRenderer shapeRenderer, float x, float y, float x2, float y2){
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.setColor(Color.GOLD);
        shapeRenderer.line(x,y, x2, y2);
        shapeRenderer.end();
    }
}
