package org.iu.minesweeper.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Level implements Serializable{
	String Difficulty;
	int columns;
	int rows;
	int numMine;
	int duration;
	double densityFactor;

	public int calculateDuration() {
		this.duration = this.columns * this.rows * 3;
		return this.duration;
	}

	public int getColumns() {
		return this.columns;
	}

	public String getDifficulty() {
		return Difficulty;
	}

	public int getRows() {
		return rows;
	}

	public int getNumMine() {
		return numMine;
	}

	public int getDuration() {
		return duration;
	}

	public double getDensityFactor() {
		return densityFactor;
	}
}

