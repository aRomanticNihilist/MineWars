package org.iu.minesweeper.model;

import java.io.Serializable;
import java.util.Set;

@SuppressWarnings("serial")
public class CurrentState implements Serializable{
	public Cell[][] field;
	public Level level;
	public Set<Cell> openedCells;
	public int secondsRemaining;

	public CurrentState(Cell[][] field, Level level, Set<Cell> openedCells, int secondsRemaining) {
		{
			this.field = field;
			this.level = level;
			this.openedCells = openedCells;
			this.secondsRemaining = secondsRemaining;
		}
	}
}
