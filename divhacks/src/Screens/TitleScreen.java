package Screens;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import GameManagement.*;
import Components.*;

import javax.swing.*;

public class TitleScreen extends Screen implements ActionListener, KeyListener {

	private AllScreen as;
	private Image runner1;
	private Image runner2;
	private Image runner3;
	private TimeTracker t;

	public TitleScreen(AllScreen as, TimeTracker t) {
		this.as = as;
		runner1 = (new ImageIcon("divhacks/assets/Runner1.png").getImage());
		runner2 = (new ImageIcon("divhacks/assets/Runner2.png").getImage());
		runner3 = (new ImageIcon("divhacks/assets/Runner3.png").getImage());

		this.t = t; 


	}

	public void paintComponent(Graphics g) {

		Graphics2D g2 = (Graphics2D) g;

		// background
		g.setColor(new Color(7, 1, 43));
		g2.fillRect(0,0,800,800);

		// among us characters
		g.drawImage(runner1, 530, 180, 289, 398, this);
		g.drawImage(runner2, 280, 245, 273, 380, this);
		g.drawImage(runner3, 20, 180, 285, 375, this);

		// title
		g.setColor(Color.WHITE);
		Font newFont = new Font("Arial", Font.BOLD, 45);
		g.setFont(newFont);
		g.drawString("Between Us", 275, 90);

		Font font2 = new Font("Arial", Font.ITALIC, 25);
		g.setFont(font2);
		g.setColor(Color.GRAY);
		g.drawString("a social distancing game", 265, 130);

		// button
		g.setColor(new Color(192,192,192));
		g2.fillRoundRect(350, 655, 100, 50, 30, 30);
		g.setColor(new Color(7, 1, 43));
		g.drawString("Start!", 370, 688);

	}

	@Override
	public void mousePressed(MouseEvent e) {
		int xClick = e.getX();
		int yClick = e.getY();

		if(xClick >= 350 && xClick <= 450 && yClick >= 655 && yClick <= 705) {
			as.changeScreen("Game"); // change later
			t.startTimeTracker();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}


}