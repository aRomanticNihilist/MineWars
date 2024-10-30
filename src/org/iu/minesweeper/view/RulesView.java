package org.iu.minesweeper.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import defaultpackage.Minesweeper;

@SuppressWarnings("serial")
public class RulesView extends JPanel{
	private MinesweeperFrame frame;
	private JLabel label;
	private ImageIcon image, icon;
	private Font font = new Font("Arial", Font.BOLD, 14);
	private Color orangeColor = Color.ORANGE;
	private JButton playButton;

	public RulesView(MinesweeperFrame frame) {
		this.frame = frame;
		this.label = new JLabel();
		this.image = new ImageIcon(getClass().getClassLoader().getResource("space.png"));
		this.icon = new ImageIcon(getClass().getClassLoader().getResource("falcon.png"));

		setLayout(new GridBagLayout());


		this.label.setIcon(image);
		this.label.setText("<html><body>1. Das Ziel von Minesweeper ist es, alle versteckten Minen auf einem Rasterfeld aufzudecken, ohne eine Mine zu detonieren. Du gewinnst das Spiel,<br><br> indem du alle Felder ohne Minen aufdeckst.<br><br><br>"
				+ "2. Das Spiel wird auf einem Rasterfeld gespielt, das aus Quadraten besteht. Die Größe des Rasters kann variieren, aber es besteht immer aus einer <br><br> bestimmten Anzahl von Reihen und Spalten. Jedes Quadrat im Raster kann entweder eine Mine oder einen Zahlenwert anzeigen.<br><br><br>"
				+ "3. Bevor das Spiel beginnt, werden auf dem Rasterfeld Minen platziert. Die Anzahl der Minen variiert je nach Schwierigkeitsgrad. Die Minen sind für den Spieler zu <br><br> Beginn des Spiels unsichtbar.<br><br><br>"
				+ "4. Der Spieler kann Felder aufdecken, indem er auf sie klickt. Wenn das Feld eine Mine enthält, verliert der Spieler das Spiel. Wenn das Feld keinen Zahlenwert hat,<br><br> werden automatisch alle benachbarten Felder aufgedeckt, die ebenfalls keinen Zahlenwert haben. Wenn das Feld eine Zahl anzeigt, gibt diese Zahl an, <br><br> wie viele Minen sich in den benachbarten Feldern befinden.<br><br><br>"
				+ "5. Um Minen zu markieren, kann der Spieler mit der rechten Maustaste auf ein Feld klicken. Dies setzt eine Flagge auf das Feld, um anzuzeigen, dass dort <br><br> eine Mine vermutet wird. Das Markieren der Minen hilft dabei, den Überblick über das Rasterfeld zu behalten und die verbleibenden Minen zu identifizieren.");

		this.label.setFont(this.font);
		this.label.setForeground(this.orangeColor);
		this.label.setHorizontalTextPosition(JLabel.CENTER);
		this.label.setVerticalTextPosition(JLabel.CENTER);
		this.label.setIcon(this.image);
		this.label.setLayout(new GridBagLayout());

		this.playButton = new JButton();
		this.playButton.addActionListener(e -> {
			this.frame.getCardLayout().show(this.frame.getMainPanel(), "Game");
		});
		this.playButton.setText("Play");
		this.playButton.setFocusable(false);
		this.playButton.setIcon(this.icon);
		this.playButton.setHorizontalTextPosition(JButton.CENTER);
		this.playButton.setVerticalTextPosition(JButton.BOTTOM);
		this.playButton.setBorder(BorderFactory.createEtchedBorder());

		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.weightx = 1;
		constraints.weighty = 1;
		constraints.fill = GridBagConstraints.BOTH;

		add(this.label, constraints);

		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.weightx = 1;
		constraints.weighty = 1;
		constraints.fill = GridBagConstraints.NONE;
		constraints.anchor = GridBagConstraints.SOUTHEAST;
		constraints.ipadx = 40;
		constraints.ipady = 50;

		this.label.add(this.playButton, constraints);
	}

}


