package org.iu.minesweeper.view;

import java.awt.CardLayout;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import defaultpackage.Minesweeper;

@SuppressWarnings("serial")
public class MinesweeperFrame extends JFrame{
	private CardLayout cardLayout;
	private JPanel mainPanel;
	private OnboardingView onboardingPanel;
	private MenuView menuPanel;
	private SelectDifficultyView difficultyPanel;
	private RulesView rulesPanel;
	private MinesweeperGameView gamePanel;
	private LoseView loseView;
	private WinView winView;
	private ImageIcon cursorImage;
	private Cursor cursor;
	private String mineIcon = "mine.png";
	
	
	public MinesweeperFrame() {
		setTitle("MineWars");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setSize(1280, 720);
		
		this.cursorImage = new ImageIcon(getClass().getClassLoader().getResource("lightsaber.png"));
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		this.cursor = toolkit.createCustomCursor(this.cursorImage.getImage(), new Point(this.getX(), this.getY()), "customCursor");
		setCursor(this.cursor);
		
		this.cardLayout = new CardLayout();
		this.mainPanel = new JPanel(cardLayout);
		
		this.menuPanel = new MenuView(this);
		this.onboardingPanel = new OnboardingView(this);
		this.difficultyPanel = new SelectDifficultyView(this);
		this.rulesPanel = new RulesView(this);
		this.loseView = new LoseView(this);
		this.winView = new WinView(this);

		this.mainPanel.add(onboardingPanel, "Onboarding");
		this.mainPanel.add(menuPanel, "Menu");
		this.mainPanel.add(difficultyPanel, "Difficulty");
		this.mainPanel.add(rulesPanel, "Rules");
		this.mainPanel.add(loseView, "Lost");
		this.mainPanel.add(winView, "Won");
		
		add(this.mainPanel);

		this.cardLayout.show(this.mainPanel, "Onboarding");
		
		setVisible(true);
	}

	public JPanel getMainPanel() {
		return mainPanel;
	}

	public CardLayout getCardLayout() {
		return cardLayout;
	}

	public OnboardingView getOnboardingPanel() {
		return onboardingPanel;
	}

	public MenuView getMenuPanel() {
		return menuPanel;
	}

	public SelectDifficultyView getDifficultyPanel() {
		return difficultyPanel;
	}

	public RulesView getRulesPanel() {
		return rulesPanel;
	}

	public MinesweeperGameView getGamePanel() {
		return gamePanel;
	}

	public void setGamePanel(MinesweeperFrame frame, int numRow, int numCol, int duration, int numMine, double densityFactor) {
		this.gamePanel = new MinesweeperGameView(this, numRow, numCol, duration, numMine, densityFactor);
		this.mainPanel.add(gamePanel, "Game");
	}

	public ImageIcon getCursorImage() {
		return cursorImage;
	}

	public Cursor getCursor() {
		return cursor;
	}
	
	public String getMineIcon() {
		return mineIcon ;
	}

}
