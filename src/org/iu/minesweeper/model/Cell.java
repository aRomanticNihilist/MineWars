package org.iu.minesweeper.model;

import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class Cell implements Serializable{
	public Location location = new Location();
	private int value;
	private boolean isMine;
	private boolean isHidden;
	private boolean isFlagged = false;

	public Cell(int xCoor, int yCoor) {
		this.location.setxCoor(xCoor);
		this.location.setyCoor(yCoor);
	}
	
	public ArrayList<Location> getSurroundingLocations() {
		ArrayList<Location> surrLocations = new ArrayList<Location>();
		// Top left
		surrLocations.add(new Location(this.location.getxCoor() - 1,
				this.location.getyCoor() - 1));
		// Top middle
		surrLocations.add(new Location(this.location.getxCoor() - 1,
				this.location.getyCoor()));
		// Top right
		surrLocations.add(new Location(this.location.getxCoor() - 1,
				this.location.getyCoor() + 1));
		// Left
		surrLocations.add(new Location(this.location.getxCoor(),
				this.location.getyCoor() - 1));
		// Right
		surrLocations.add(new Location(this.location.getxCoor(),
				this.location.getyCoor() + 1));
		// Bottom left
		surrLocations.add(new Location(this.location.getxCoor() + 1,
				this.location.getyCoor() - 1));
		// Bottom middle
		surrLocations.add(new Location(this.location.getxCoor() + 1,
				this.location.getyCoor()));
		// Bottom right
		surrLocations.add(new Location(this.location.getxCoor() + 1,
				this.location.getyCoor() + 1));
		return surrLocations;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public boolean isMine() {
		return this.isMine;
	}

	public void setMine(boolean isMine) {
		this.isMine = isMine;
	}

	public boolean isHidden() {
		return isHidden;
	}

	public void setHidden(boolean isHidden) {
		this.isHidden = isHidden;
	}

	@Override
	public String toString() {
		return this.isHidden ? "?" : Integer.toString(this.value);
	}

	public void toggleFlagged() {
		this.isFlagged = !this.isFlagged ;
	}

	public boolean isFlagged() {
		return isFlagged;
	}

	public Location getLocation() {
		return location;
	}
	
}
