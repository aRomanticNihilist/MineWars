package org.iu.minesweeper.model;

@SuppressWarnings("serial")
public class EasyLevel extends Level {
	public EasyLevel() {
		super();
		this.Difficulty= "Easy";
		this.columns = 10;
		this.rows = 10;
		this.numMine = 10;
		this.densityFactor = 0.25;
		
		calculateDuration();
	}	
}
