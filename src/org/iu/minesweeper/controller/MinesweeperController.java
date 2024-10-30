package org.iu.minesweeper.controller;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import org.iu.minesweeper.model.Board;
import org.iu.minesweeper.model.Cell;
import org.iu.minesweeper.model.EasyLevel;
import org.iu.minesweeper.model.MediumLevel;
import org.iu.minesweeper.model.HardLevel;
import org.iu.minesweeper.model.Level;
import org.iu.minesweeper.model.Location;
import org.iu.minesweeper.view.MenuView;
import org.iu.minesweeper.view.MinesweeperFrame;
import org.iu.minesweeper.view.SelectDifficultyView;

public class MinesweeperController {
	private Board board;
	private MinesweeperFrame view;

	public MinesweeperController(Board board, MinesweeperFrame view) {
		this.view = view;
		MenuView menuPanel = view.getMenuPanel();
		SelectDifficultyView diffPanel = view.getDifficultyPanel();


		menuPanel.addDefaultPlayBtnListener(new DefaultPlayListener());
		diffPanel.addDiffListener(new DifficultyListener());


	}

	private void generatePrevGameBoard(Board board) {
		view.getGamePanel().getSaveMenuItem().addActionListener(new SaveMenuItemListener());
		for (int i = 0; i < board.getLevel().getRows(); i++) {
			for (int j = 0; j < board.getLevel().getColumns(); j++) {
				if (board.getCellAt(new Location(i, j)).isHidden()) {
					addGameButtonListeners(i, j);
					if (board.getCellAt(new Location(i, j)).isFlagged()) 
						view.getGamePanel().getButtonAt(i, j).setBackground(Color.orange);
				} else 
				{
					setOpenedButton(i, j);
				}
			}
		}
	}
	private void generateNewGameBoard(Level level) {
		this.board = new Board(level);
		view.getGamePanel().getSaveMenuItem().addActionListener(new SaveMenuItemListener());
		for (int i = 0; i < this.board.getLevel().getRows(); i++) {
			for (int j = 0; j < this.board.getLevel().getColumns(); j++) {
				addGameButtonListeners(i, j);
			}
		}
		Timer countdown = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (board.getSecondsRemaining() > 0) {
					board.setSecondsRemaining(board.getSecondsRemaining() - 1);
					view.getGamePanel().getTimerLabel().setText("Time remaining: " + board.getSecondsRemaining());
				} else {
					board.setLost(true);
					for (Cell cell : board.getAllCells()) {
						cell.setHidden(false);
						setOpenedButton(cell.getLocation().getxCoor(), cell.getLocation().getyCoor());
					}
					view.getCardLayout().show(view.getMainPanel(), "Lost");
					deleteLastSave();
				}
				if (board.isLost() || board.isWon()) {
					((Timer) e.getSource()).stop();
				}
			}
		});
		countdown.start();

	}

	private void addGameButtonListeners(int i, int j) {
		view.getGamePanel().getButtonAt(i, j).addActionListener(new GameButtonListener(i, j));
		view.getGamePanel().getButtonAt(i, j).addMouseListener(new FlagListener(i, j));
	}

	class SaveMenuItemListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			board.save();
		}
	}
	class FlagListener implements MouseListener {
		int x, y;
		public FlagListener(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			if (SwingUtilities.isRightMouseButton(e) && view.getGamePanel().getButtonAt(x, y).isEnabled()) {
				Location cellLocation = new Location(x, y);
				board.getCellAt(cellLocation).toggleFlagged();
				if (board.getCellAt(cellLocation).isFlagged()) view.getGamePanel().getButtonAt(x, y).setBackground(Color.orange);
				else view.getGamePanel().getButtonAt(x, y).setBackground(null);
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}

		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {		
		}
	}

	class GameButtonListener implements ActionListener {
		int x, y;
		public GameButtonListener(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			Location cellLocation = new Location(x, y);
			board.updateGameField(cellLocation);

			for (int i = 0; i < board.getLevel().getRows(); i++) {
				for (int j = 0; j < board.getLevel().getColumns(); j++) {
					if (!board.getCellAt(new Location(i, j)).isHidden()) {
						setOpenedButton(i, j);
					}
				}
			}
			if (board.isLost()) {
				view.getCardLayout().show(view.getMainPanel(), "Lost");
				deleteLastSave();
			}
			if (board.isWon()) {
				view.getCardLayout().show(view.getMainPanel(), "Won");
				deleteLastSave();
			}
		}
	}	

	class DefaultPlayListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			view.getCardLayout().show(view.getMainPanel(), "Rules");
			File lastSave = new File("currentstate.millenial");
			if (lastSave.exists()) {
				try { // Loading the saved game
					board = new Board();
					board.load();
					view.setGamePanel(view, board.getLevel().getRows(), board.getLevel().getColumns(), board.getSecondsRemaining(), board.getLevel().getNumMine(), board.getLevel().getDensityFactor());
					generatePrevGameBoard(board);

				} catch (ClassNotFoundException | IOException ex) {
					ex.printStackTrace();
				}
			}
			else // Default to new Easy Level game
			{
				EasyLevel easy = new EasyLevel();
				view.setGamePanel(view, easy.getRows(), easy.getColumns(), easy.calculateDuration(), easy.getNumMine(), easy.getDensityFactor());

				generateNewGameBoard(easy);
				lastSave.delete();
			}
		}
	}

	class DifficultyListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			view.getCardLayout().show(view.getMainPanel(), "Rules");

			Level level = null;
			if (((JButton)e.getSource())
					.equals(view.getDifficultyPanel().getEasyButton())) {
				level = new EasyLevel();
				view.setGamePanel(view, level.getRows(), level.getColumns(), level.calculateDuration(), level.getNumMine(), level.getDensityFactor());
			} 
			else if (((JButton)e.getSource())
					.equals(view.getDifficultyPanel().getMedButton())) {
				level = new MediumLevel();
				view.setGamePanel(view, level.getRows(), level.getColumns(), level.calculateDuration(), level.getNumMine(), level.getDensityFactor());
			} 
			else if (((JButton)e.getSource())
					.equals(view.getDifficultyPanel().getHardButton())) {
				level = new HardLevel();
				view.setGamePanel(view, level.getRows(), level.getColumns(), level.calculateDuration(), level.getNumMine(), level.getDensityFactor());
			} //TODO: Implement custom level

			generateNewGameBoard(level);
			deleteLastSave();
		}
	}

	private void deleteLastSave() {
		File lastSave = new File("currentstate.millenial");
		lastSave.delete();
	}	

	private void setOpenedButton(int i, int j) {
		JButton button = view.getGamePanel().getButtonAt(i, j);
		button.setBackground(Color.LIGHT_GRAY);
		button.setEnabled(false);

		Location cellLocation = new Location(i, j);

		if (board.getCellAt(cellLocation).getValue() <= 8) {
			button.setText(board.getCellAt(new Location(i, j)).toString());
		} else {
			Image mineImage = new ImageIcon(getClass().getClassLoader().getResource(view.getMineIcon())).getImage();
			Image mineResizedImage = mineImage.getScaledInstance(button.getHeight(), button.getHeight(), Image.SCALE_SMOOTH);
			ImageIcon mineIcon = new ImageIcon(mineResizedImage);

			button.setBackground(Color.BLACK);
			button.setIcon(mineIcon);
			button.setDisabledIcon(mineIcon);
		}
	}
}
