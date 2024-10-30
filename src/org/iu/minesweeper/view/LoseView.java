package org.iu.minesweeper.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class LoseView extends JPanel{
	private MinesweeperFrame frame;
	private JButton backFieldButton, backMenuButton;
	private JLabel label;
	private GridBagConstraints constraints = new GridBagConstraints();
	
	public LoseView(MinesweeperFrame frame) {
		this.frame = frame;
		this.label = new JLabel();
		
		this.label.setIcon(new ImageIcon(getClass().getClassLoader().getResource("crashed_xwing.png")));;
		//this.label.setText("You Lose");
		this.label.setFont(new Font("Arial", Font.BOLD, 42));
		this.label.setForeground(Color.black);
		
		this.label.setLayout(new GridBagLayout());
		
		this.backFieldButton = new JButton();
		this.backFieldButton.addActionListener(e -> this.frame.getCardLayout().show(this.frame.getMainPanel(), "Game"));
		this.backFieldButton.setText("View Field");
		this.backFieldButton.setFocusable(false);
		this.backFieldButton.setHorizontalTextPosition(JButton.CENTER);
		this.backFieldButton.setVerticalTextPosition(JButton.BOTTOM);
		this.backFieldButton.setBorder(BorderFactory.createEtchedBorder());
		
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.weightx = 0;
		constraints.weighty = 0;
		constraints.fill = GridBagConstraints.NONE;
		constraints.anchor = GridBagConstraints.SOUTHWEST;
		constraints.ipadx = 80;
		constraints.ipady = 50;
		constraints.insets = new Insets(300, 100, 100, 100);
		this.label.add(backFieldButton, constraints);

		
		this.backMenuButton = new JButton();
		this.backMenuButton.addActionListener(e -> this.frame.getCardLayout().show(this.frame.getMainPanel(), "Menu"));
		this.backMenuButton.setText("Back To Menu");
		this.backMenuButton.setFocusable(false);
		this.backMenuButton.setHorizontalTextPosition(JButton.CENTER);
		this.backMenuButton.setVerticalTextPosition(JButton.BOTTOM);
		this.backMenuButton.setBorder(BorderFactory.createEtchedBorder());
		
		constraints.gridx = 1;
		constraints.gridy = 0;
		constraints.weightx = 0;
		constraints.weighty = 0;
		constraints.fill = GridBagConstraints.NONE;
		constraints.anchor = GridBagConstraints.SOUTHWEST;
		constraints.ipadx = 80;
		constraints.ipady = 50;
		constraints.insets = new Insets(300, 100, 100, 100);
		
		this.label.add(backMenuButton, constraints);
		
		add(this.label);
		
	}
}
