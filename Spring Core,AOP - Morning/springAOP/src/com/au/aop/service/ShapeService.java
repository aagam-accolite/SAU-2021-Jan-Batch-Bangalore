package com.au.aop.service;

import com.au.aop.model.Circle;
import com.au.aop.model.Triangle;

public class ShapeService {
	
	private Circle circle;
	private Triangle triangle;
	public Circle getCircle() {
		return circle;
	}
	public void setCircle(Circle circle) {
		this.circle = circle;
	}
	public Triangle getTriangle() {
		// After Exception Part 
		//if(true)
			//throw new ArithmeticException();
		return triangle;
	}
	public void setTriangle(Triangle triangle) {
		this.triangle = triangle;
	}

}
