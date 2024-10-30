package org.iu.minesweeper.view;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import defaultpackage.Minesweeper;

@SuppressWarnings("serial")
public class OnboardingView extends JPanel{
	private MinesweeperFrame frame;
	private ImageIcon image, icon;
	private JLabel label;
	private Font font;
	private Color color;
	private JButton button;
	
	public OnboardingView(MinesweeperFrame frame) {
		this.frame = frame;
		this.image = new ImageIcon(getClass().getClassLoader().getResource("space.png"));
		this.icon = new ImageIcon(getClass().getClassLoader().getResource("falcon.png"));
		this.font = new Font("Arial", Font.BOLD, 16);
		this.color = Color.ORANGE;
		
		setLayout(new GridBagLayout());
		
		this.label = new JLabel();
		this.label.setText("<html><body>Es war einmal vor langer Zeit in einer weit, weit entfernten Galaxie, in der sich ein finsterer Schatten über die gesamte Galaxis legte.<br><br>"
				+ "Das Galaktische Imperium unter der tyrannischen Führung des gefürchteten Imperators und seines mächtigen Todessterns beherrschte mit eiserner Faust <br><br> die bekannten Welten.<br><br>"
				+ "Doch inmitten dieser Dunkelheit erhoben sich mutige Rebellen, die den Funken der Hoffnung am Leben hielten. Angeführt von ihrem tapferen Captain und <br> <br> seinem legendären Schiff, dem rasenden Falken, stellten sie sich der Übermacht entgegen.<br><br>"
				+ "Als Spieler wirst du nun zu einem entscheidenden Teil dieser epischen Schlacht. Du übernimmst die Kontrolle über den rasenden Falken und bist mit einer <br><br> gefährlichen Mission betraut:"
				+ "Die Zerstörung des Todessterns.<br><br> Doch Vorsicht ist geboten, denn jeder falsche Schritt kann zur Niederlage führen."
				+ "Nur mit geschicktem Taktieren und strategischem Vorgehen kannst du <br> <br> die Fallen des Imperiums aufdecken, ohne den rasenden Falken in die Luft zu jagen.<br><br><br>"
				+ "Helfe den Rebellen die Galaxie von der Unterdrückung des Imperiums zu befreien.<br><br>"
				+ "Die Galaxie wartet auf einen wahren Helden – wirst du derjenige sein, der den rasenden Falken sicher durch den Kampf führt und den Todesstern zerstört?<br><br><br>"
				+ "Möge die Macht mit dir sein, Pilot! Dein Abenteuer beginnt jetzt.\"</body></html>");
		
		this.label.setFont(font);
		this.label.setForeground(this.color);
		this.label.setHorizontalTextPosition(JLabel.CENTER);
		this.label.setVerticalTextPosition(JLabel.CENTER);
		this.label.setIcon(this.image);
		this.label.setLayout(new GridBagLayout());
		
		this.button = new JButton();
		this.button.addActionListener(e -> {
			this.frame.getCardLayout().show(this.frame.getMainPanel(), "Menu");
		});
		this.button.setText("Play");
		this.button.setFocusable(false);
		this.button.setIcon(this.icon);
		this.button.setHorizontalTextPosition(JButton.CENTER);
		this.button.setVerticalTextPosition(JButton.BOTTOM);
		this.button.setBorder(BorderFactory.createEtchedBorder());
		
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
        
        this.label.add(this.button, constraints);
	}
}