package org.iu.minesweeper.model;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.*;

@SuppressWarnings("serial")
public class Board implements Serializable{
	
	private Cell[][] field;
	private Level level;
	private Set<Cell> openedCells = new HashSet<>();
	private int secondsRemaining;
	private boolean isWon = false;
	private boolean isLost = false;
	
	public Board(Cell[][] field, Level level) {
		this.field = field;
		this.level = level;
	}
	
	public Board(Level level) {
		this.level = level;
		this.field = new Cell [this.level.rows][this.level.columns];
		this.secondsRemaining = level.calculateDuration();

		generateField();
		generateMines();
		determineCellValues();
	}

	public Board() {
	}

	private boolean isValid(Location location) {
		return location.xCoor >= 0 &&
				location.xCoor < level.rows &&
				location.yCoor >= 0 &&
				location.yCoor < level.columns;
	}
	
	private void generateField() {
		for (int i = 0; i < level.rows; i++) {
			for (int j = 0; j < level.columns; j++) {
				field[i][j] = new Cell(i, j);
				field[i][j].setHidden(true);
			}
		}
	}
	
	private void generateMines() {
		Random random = new Random();
		
		double densityFactor = this.level.densityFactor;
		
		int planted = 0;
		while (planted < level.numMine) {
			int i = random.nextInt(level.rows);
			int j = random.nextInt(level.columns);
			
	       	if (!field[i][j].isMine()) {
            // Check if the surrounding cells already have mines
            boolean isDense = false;
            for (Cell surrCell : getSurroundingCells(field[i][j])) {
               if (surrCell.isMine()) {
                   isDense = true;
                   break;
                }
            }

            // Apply clustering factor based on difficulty
            if (!isDense || random.nextDouble() <= densityFactor) {
                field[i][j].setMine(true);
                field[i][j].setValue(100);
                planted++;
            }
	       	}		
		}		
	}
	
	private ArrayList<Cell> getSurroundingCells(Cell cell){
		ArrayList<Cell> surrCells = new ArrayList<>();
		for (Location location : cell.getSurroundingLocations()) {
			if (isValid(location)) {
				surrCells.add(getCellAt(location));
			}
		}
		return surrCells;
	}
	
	public Cell getCellAt(Location location) {
		return field[location.getxCoor()][location.getyCoor()];
	}

	private void determineCellValues() {
		for (Cell cell : getAllCells()) {
			if (!cell.isMine()) {
				int count = 0;
				for (Cell surrCell : getSurroundingCells(cell)) {
					if (surrCell.isMine())
						count++;
				}
				cell.setValue(count);
			}
		}
	}
	
	public ArrayList<Cell> getAllCells() {
		ArrayList<Cell> allCells = new ArrayList<>();
		for (int i = 0; i < level.rows; i++) {
			allCells.addAll(Arrays.asList(field[i]).subList(0, level.columns));
		}
		return allCells;
	}

	public void updateGameField(Location userLocation) {
		Cell selectedCell = getCellAt(userLocation);
		uncoverCells(selectedCell);
		
		if (openedCells.size() == this.level.getColumns()*this.level.getRows() - this.level.getNumMine() && !selectedCell.isMine()) {
			setWon(true);
			uncoverAllCells();
		}
	}

	public boolean validateUserLocation(Location userLocation) {
		return isValid(userLocation) && getCellAt(userLocation).isHidden();
	}

	private void uncoverCells(Cell selectedCell) {
		if (selectedCell.isHidden()) {
			selectedCell.setHidden(false);
			this.openedCells.add(selectedCell);
			
			if (selectedCell.getValue() == 0) {
				for (Cell cell : getSurroundingCells(selectedCell)) {
					uncoverCells(cell);
				}
			}
			if (selectedCell.getValue() == 100) {
				setLost(true);
				uncoverAllCells();
			}
		}
	}
	
	private void uncoverAllCells() {
		for (Cell cell : getAllCells()) {
			cell.setHidden(false);
		}
	}

	public void save() 
	{	
		if (!isLost() && !isWon()) {
			try {
				CurrentState state = new CurrentState(field, level, openedCells, secondsRemaining);
				OutputStream file = new FileOutputStream("currentstate.millenial");
				OutputStream buffer = new BufferedOutputStream(file);
				ObjectOutput output = new ObjectOutputStream(buffer);
				output.writeObject(state);
				output.flush();
				output.close();
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
	}

	public void load() throws IOException, ClassNotFoundException 
	{
		CurrentState state;
		InputStream file;
		try {
			file = new FileInputStream("currentstate.millenial");
			InputStream buffer = new BufferedInputStream(file);
			ObjectInput input = new ObjectInputStream(buffer);
			state = (CurrentState)input.readObject();
			this.field = state.field;
			this.level = state.level;
			this.openedCells = state.openedCells;
			this.secondsRemaining = state.secondsRemaining;
			input.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Level getLevel() {
		return this.level;
	}
	
	public boolean isWon() {
		return this.isWon;
	}
	
	public boolean isLost() {
		return this.isLost;
	}
	
	public void setWon(boolean b) {
		this.isWon = b;
	}
	
	public void setLost(boolean b) {
		this.isLost = b;
	}

	public Cell[][] getField() {
		return field;
	}
	
	public int getSecondsRemaining() {
		return secondsRemaining;
	}

	public void setSecondsRemaining(int secondsRemaining) {
		this.secondsRemaining = secondsRemaining;
	}

}
