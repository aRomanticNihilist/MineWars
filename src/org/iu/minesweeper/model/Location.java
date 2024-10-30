package org.iu.minesweeper.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Location implements Serializable{
	public int xCoor;
	public int yCoor;
	
	public Location(int xCoor, int yCoor) {
		this.xCoor = xCoor;
		this.yCoor = yCoor;
	}
	
	public Location() {
	}

	public int getxCoor() {
		return xCoor;
	}

	public void setxCoor(int xCoor) {
		this.xCoor = xCoor;
	}

	public int getyCoor() {
		return yCoor;
	}

	public void setyCoor(int yCoor) {
		this.yCoor = yCoor;
	}
}
