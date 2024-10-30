package org.iu.minesweeper.model;

@SuppressWarnings("serial")
public class MediumLevel extends Level {
	public MediumLevel() {
		super();
		this.Difficulty= "Medium";
		this.columns = 20;
		this.rows = 20;
		this.numMine = 45;
		this.densityFactor = 0.40;

		calculateDuration();
	}
}	
	

