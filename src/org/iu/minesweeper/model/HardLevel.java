package org.iu.minesweeper.model;

@SuppressWarnings("serial")
public class HardLevel extends Level {
	public HardLevel() {
		super();
		this.Difficulty= "Hard";
		this.columns = 20;
		this.rows = 35;
		this.numMine = 150;
		this.densityFactor = 0.60;
		
		calculateDuration();
	}
}	
	
	
	
