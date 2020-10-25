package Screens;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import GameManagement.*;

import javax.swing.*;

public class TitleScreen extends Screen implements ActionListener {

	private AllScreen as;
	private Image runner1;
	private Image runner2;
	private Image runner3;
	private TimeTracker t;

	public TitleScreen(AllScreen as, TimeTracker t) {
		this.as = as;
		runner1 = (new ImageIcon("divhacks/Runner1.png").getImage());
		runner2 = (new ImageIcon("divhacks/Runner2.png").getImage());
		runner3 = (new ImageIcon("divhacks/Runner3.png").getImage());

		this.t = t; 
	}

	public void paintComponent(Graphics g) {

		Graphics2D g2 = (Graphics2D) g;

		g.drawImage(runner1, 530, 100, 289, 398, this);
		g.drawImage(runner2, 290, 110, 273, 380, this);
		g.drawImage(runner3, 25, 110, 285, 375, this);
		
		g.setColor(new Color(255,255,255));
		Font newFont = new Font("Arial", Font.BOLD, 20);
		g.setFont(newFont);
		g.drawString("The Social Distancing Game", 250, 50);
		
		g.setColor(new Color(192,192,192));
		g2.fillRoundRect(350, 430, 100, 50, 30, 30);
		g.setColor(new Color(255,255,255));
		g.drawString("Start!", 370, 460);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		int xClick = e.getX();
		int yClick = e.getY();

		if(xClick >= 350 && xClick <= 450 && yClick >= 430 && yClick <= 480) {
			as.changeScreen("Results"); // change later
			t.startTimeTracker();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}


}