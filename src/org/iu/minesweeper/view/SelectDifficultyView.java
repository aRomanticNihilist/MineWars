package org.iu.minesweeper.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import defaultpackage.Minesweeper;

@SuppressWarnings("serial")
public class SelectDifficultyView extends JPanel{
	private MinesweeperFrame frame;
	private ImageIcon iconEasy, iconMedium, iconHard, image;
	private JButton easyButton, medButton, hardButton, backButton;
	private JLabel label;
	
	public SelectDifficultyView(MinesweeperFrame frame) {
		this.frame = frame;
		this.iconEasy = new ImageIcon(getClass().getClassLoader().getResource("Easy.png"));
		this.iconMedium = new ImageIcon(getClass().getClassLoader().getResource("Medium.png"));
		this.iconHard = new ImageIcon(getClass().getClassLoader().getResource("Hard.png"));
		this.image = new ImageIcon(getClass().getClassLoader().getResource("difficulty.jpg"));
		
		this.label = new JLabel();
		this.label.setIcon(this.image);
		
		this.label.setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		
		this.easyButton = new JButton();
		this.easyButton.setText("Easy");
		this.easyButton.setFocusable(false);
		this.easyButton.setIcon(this.iconEasy);
		this.easyButton.setHorizontalTextPosition(JButton.CENTER);
		this.easyButton.setVerticalTextPosition(JButton.BOTTOM);
		this.easyButton.setBorder(BorderFactory.createEtchedBorder());
		constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.SOUTHWEST;
        constraints.ipadx = 100;
        constraints.ipady = 50;
        constraints.insets = new Insets(300, 100, 100, 100);
        
        this.label.add(this.easyButton, constraints);
		
        this.medButton = new JButton();
		this.medButton.setText("Medium");
		this.medButton.setFocusable(false);
		this.medButton.setIcon(this.iconMedium);
		this.medButton.setHorizontalTextPosition(JButton.CENTER);
		this.medButton.setVerticalTextPosition(JButton.BOTTOM);
		this.medButton.setBorder(BorderFactory.createEtchedBorder());
		constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.SOUTHWEST;
        constraints.ipadx = 100;
        constraints.ipady = 50;
        constraints.insets = new Insets(300, 100, 100, 100);
        
        this.label.add(this.medButton, constraints);

		this.hardButton = new JButton();
		this.hardButton.setText("Hard");
		this.hardButton.setFocusable(false);
		this.hardButton.setIcon(this.iconHard);
		this.hardButton.setHorizontalTextPosition(JButton.CENTER);
		this.hardButton.setVerticalTextPosition(JButton.BOTTOM);
		this.hardButton.setBorder(BorderFactory.createEtchedBorder());
		constraints.gridx = 2;
        constraints.gridy = 0;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.SOUTHWEST;
        constraints.ipadx = 100;
        constraints.ipady = 50;
        constraints.insets = new Insets(300, 100, 100, 100);
        
        this.label.add(this.hardButton, constraints);

		this.backButton = new JButton();
		this.backButton.addActionListener(e -> this.frame.getCardLayout().show(this.frame.getMainPanel(), "Menu"));
		this.backButton.setText("Back");
		this.backButton.setFocusable(false);
		this.backButton.setHorizontalTextPosition(JButton.CENTER);
		this.backButton.setVerticalTextPosition(JButton.BOTTOM);
		this.backButton.setBorder(BorderFactory.createEtchedBorder());
		constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.ipadx = 20;
        constraints.ipady = 20;
        constraints.insets = new Insets(0, 0, 0, 0);
        
        this.label.add(this.backButton, constraints);
        
        add(this.label);
	}
	
	public void addDiffListener(ActionListener diffBtnListener) {
		this.easyButton.addActionListener(diffBtnListener);
		this.medButton.addActionListener(diffBtnListener);
		this.hardButton.addActionListener(diffBtnListener);
	}

	public MinesweeperFrame getFrame() {
		return frame;
	}

	public ImageIcon getIconEasy() {
		return iconEasy;
	}

	public ImageIcon getIconMedium() {
		return iconMedium;
	}

	public ImageIcon getIconHard() {
		return iconHard;
	}

	public ImageIcon getImage() {
		return image;
	}

	public JButton getEasyButton() {
		return easyButton;
	}

	public JButton getMedButton() {
		return medButton;
	}

	public JButton getHardButton() {
		return hardButton;
	}

	public JButton getBackButton() {
		return backButton;
	}

	public JLabel getLabel() {
		return label;
	}
	
	
	
}
