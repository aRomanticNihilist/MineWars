package org.iu.minesweeper.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class MinesweeperGameView extends JPanel{
    private MinesweeperFrame frame;
    private JPanel gamePanel;
    private JLabel timerLabel;
	private JMenuBar menuBar;
    private JMenu gameMenu;
    private JMenuItem saveMenuItem, backMenuItem, exitMenuItem;
    private int duration;
    private int numCol, numRow;
    private JButton[][] field;

    public MinesweeperGameView(MinesweeperFrame frame, int numRow, int numCol, int duration, int numMine, double densityFactor) {
        
    	this.frame = frame;
    	this.numRow = numRow;
    	this.numCol = numCol;
    	this.duration = duration;
    	this.menuBar = new JMenuBar();
        this.gameMenu = new JMenu("Options");
        this.saveMenuItem = new JMenuItem("Save");
        
        this.backMenuItem = new JMenuItem("Menu");
        backMenuItem.addActionListener(e -> {
        	this.frame.getCardLayout().show(this.frame.getMainPanel(), "Menu");
        });
        
        this.exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.addActionListener(e -> System.exit(0));
         
        gameMenu.add(saveMenuItem);
        gameMenu.add(backMenuItem);
        gameMenu.add(exitMenuItem);
        menuBar.add(gameMenu);
      
        frame.setJMenuBar(menuBar);

        setLayout(new BorderLayout());

        timerLabel = new JLabel("Time: " + this.duration);
        add(timerLabel, BorderLayout.SOUTH);
        
        

        this.gamePanel = new JPanel(new GridLayout(this.numRow, this.numCol));
        this.field = new JButton[this.numRow][this.numCol];
        Font font = new Font("News Gothic", Font.BOLD, 20);
        
        for (int row = 0; row < this.numRow; row++) {
            for (int col = 0; col < this.numCol; col++) {
                field[row][col] = new JButton();
                field[row][col].setFont(font);
                this.gamePanel.add(field[row][col]);
            }
        }

        add(this.gamePanel, BorderLayout.CENTER);
    }

    public void addGameListener(ActionListener buttonListener) {
    	for (int row = 0; row < this.numRow; row++) {
            for (int col = 0; col < this.numCol; col++) {
                field[row][col].addActionListener(buttonListener);
            }
        }
    }
    
    public void addSaveMenuItemListener(ActionListener saveMenuListener) {
    	this.saveMenuItem.addActionListener(saveMenuListener);
    }
    
    public JMenuItem getSaveMenuItem() {
    	return saveMenuItem;
    }
    
    public JButton getButtonAt(int x, int y) {
    	return field[x][y];
    }
    
	public int getDuration() {
		return duration;
	}

	public int getNumCol() {
		return numCol;
	}

	public int getNumRow() {
		return numRow;
	}

	public void setTimeInSeconds(int duration) {
		this.duration = duration;
	}

	public void setNumCol(int numCol) {
		this.numCol = numCol;
	}

	public void setNumRow(int numRow) {
		this.numRow = numRow;
	}
    
	public JLabel getTimerLabel() {
		return timerLabel;
	}

    
}
