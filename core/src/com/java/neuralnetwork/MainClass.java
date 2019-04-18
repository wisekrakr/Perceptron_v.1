package com.java.neuralnetwork;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.java.neuralnetwork.matrix.Matrix;
import com.java.neuralnetwork.perceptron.Perceptron;
import com.java.neuralnetwork.rendering.SubjectRenderer;
import com.java.neuralnetwork.subjects.Point;

import java.util.Arrays;

public class MainClass extends ApplicationAdapter {

	private Perceptron perceptron;
	private Point[] points = new Point[100];
	private int trainingIndex = 0;

	private ShapeRenderer shapeRenderer;

	private Matrix matrix;

	@Override
	public void create () {

		shapeRenderer = new ShapeRenderer();

		for (int i = 0; i < points.length; i++){
			points[i] = new Point();
		}

		perceptron = new Perceptron(3); //number of weights (x,y,bias)

		matrix = new Matrix(3,2);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		for (Point point: points){
			float[] inputs = {point.getX(), point.getY(), point.getBias()};
			int guess = perceptron.guess(inputs);

			if (guess == point.getLabel()){
				point.setFill(true);
			}else {
				point.setFill(false);
			}

			SubjectRenderer.renderPoints(shapeRenderer, point);

			float x1 = -1;
			float y1 = point.curve(x1);
			float x2 = 1;
			float y2 = point.curve(x2);

			Point p1 = new Point(x1, y1);
			Point p2 = new Point(x2, y2);

			SubjectRenderer.drawLine(shapeRenderer, p1.pixelX(), p1.pixelY(), p2.pixelX(), p2.pixelY());

			Point guessPoint1 = new Point(x1, perceptron.guessY(x1));
			Point guessPoint2 = new Point(x2, perceptron.guessY(x2));
			SubjectRenderer.drawLine(shapeRenderer, guessPoint1.pixelX(), guessPoint1.pixelY(), guessPoint2.pixelX(), guessPoint2.pixelY());


		}

		perceptronPush();
	}



	private void perceptronPush(){
		//Train in one push or one at a time
		if (Gdx.input.isButtonPressed(0)) {


			for (Point point : points) {
				float[] inputs = {point.getX(), point.getY(), point.getBias()};
				int target = point.getLabel();
				perceptron.train(inputs, target);
			}
		}else if (Gdx.input.isButtonPressed(1)){
			Point trainingPoint = points[trainingIndex];
			float[] inputs = {trainingPoint.getX(), trainingPoint.getY(), trainingPoint.getBias()};
			int target = trainingPoint.getLabel();
			perceptron.train(inputs, target);
			trainingIndex++;

			if (trainingIndex == points.length){
				trainingIndex = 0;
			}
		}
	}
	
	@Override
	public void dispose () {
		shapeRenderer.dispose();
	}
}
