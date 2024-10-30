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
public class MenuView extends JPanel{
	private MinesweeperFrame frame;
	private ImageIcon icon, iconDiff, iconClose, image;
	private JLabel label;
	private JButton playButton, diffButton, closeButton;


	public MenuView(MinesweeperFrame frame) {
		this.frame = frame;
		this.icon = new ImageIcon(getClass().getClassLoader().getResource("falcon.png"));
		this.iconDiff = new ImageIcon(getClass().getClassLoader().getResource("xwingicon.png"));
		this.iconClose = new ImageIcon (getClass().getClassLoader().getResource("deathsta.png"));

		this.label = new JLabel();
		this.image = new ImageIcon(getClass().getClassLoader().getResource("tatooine.JPG"));
		this.label.setIcon(this.image);

		this.label.setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();

		this.playButton = new JButton();
		this.playButton.setText("Play");
		this.playButton.setFocusable(false);
		this.playButton.setIcon(this.icon);
		this.playButton.setHorizontalTextPosition(JButton.CENTER);
		this.playButton.setVerticalTextPosition(JButton.BOTTOM);
		this.playButton.setBorder(BorderFactory.createEtchedBorder());
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.weightx = 0;
		constraints.weighty = 0;
		constraints.fill = GridBagConstraints.NONE;
		constraints.anchor = GridBagConstraints.SOUTHWEST;
		constraints.ipadx = 80;
		constraints.ipady = 50;
		constraints.insets = new Insets(300, 100, 100, 100);

		this.label.add(this.playButton, constraints);

		this.diffButton = new JButton();
		this.diffButton.addActionListener(e -> this.frame.getCardLayout().show(this.frame.getMainPanel(), "Difficulty"));
		this.diffButton.setText("Difficulty");
		this.diffButton.setFocusable(false);
		this.diffButton.setIcon(this.iconDiff);
		this.diffButton.setHorizontalTextPosition(JButton.CENTER);
		this.diffButton.setVerticalTextPosition(JButton.BOTTOM);
		this.diffButton.setBorder(BorderFactory.createEtchedBorder());
		constraints.gridx = 1;
		constraints.gridy = 0;
		constraints.weightx = 0;
		constraints.weighty = 0;
		constraints.fill = GridBagConstraints.NONE;
		constraints.anchor = GridBagConstraints.SOUTHWEST;
		constraints.ipadx = 100;
		constraints.ipady = 50;
		constraints.insets = new Insets(300, 100, 100, 100);

		this.label.add(this.diffButton, constraints);
		
		this.closeButton = new JButton();
		this.closeButton.addActionListener(e -> System.exit(0));
		this.closeButton.setText("Close");
		this.closeButton.setFocusable(false);
		this.closeButton.setIcon(this.iconClose);
		this.closeButton.setHorizontalTextPosition(JButton.CENTER);
		this.closeButton.setVerticalTextPosition(JButton.BOTTOM);
		this.closeButton.setBorder(BorderFactory.createEtchedBorder());
		constraints.gridx = 3;
		constraints.gridy = 0;
		constraints.weightx = 0;
		constraints.weighty = 0;
		constraints.fill = GridBagConstraints.NONE;
		constraints.anchor = GridBagConstraints.SOUTHWEST;
		constraints.ipadx = 80;
		constraints.ipady = 50;
		constraints.insets = new Insets(300, 100, 100, 100);

		this.label.add(this.closeButton, constraints);

		add(this.label);


	}
	
	public void addDefaultPlayBtnListener(ActionListener listener) {
		this.playButton.addActionListener(listener);
	}
}
