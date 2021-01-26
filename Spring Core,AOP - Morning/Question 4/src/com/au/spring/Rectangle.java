package com.au.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value="prototype")
public class Rectangle {
	@Autowired
	@Qualifier("PointA")
	private Point pointA;
	
	@Autowired
	@Qualifier("PointB")
	private Point pointB;
	
	@Autowired
	@Qualifier("PointC")
	private Point pointC;
	
	@Autowired
	@Qualifier("PointD")
	private Point pointD;

	public Point getPointA() {
		return pointA;
	}

	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}

	public Point getPointB() {
		return pointB;
	}

	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}

	public Point getPointC() {
		return pointC;
	}

	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}

	public Point getPointD() {
		return pointD;
	}

	public void setPointD(Point pointD) {
		this.pointD = pointD;
	}
	
	public void draw() {
		
		System.out.println("Point A.x " + getPointA().getX() + "\tPoint A.y "+ getPointA().getY());
		System.out.println("Point B.x " + getPointB().getX() + "\tPoint B.y "+ getPointB().getY());
		System.out.println("Point C.x " + getPointC().getX() + "\tPoint C.y "+ getPointC().getY());
		System.out.println("Point D.x " + getPointD().getX() + "\tPoint D.y "+ getPointD().getY());
	}		
}
