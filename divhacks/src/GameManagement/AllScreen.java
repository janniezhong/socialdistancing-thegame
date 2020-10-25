package GameManagement;

import Screens.GameScreen;
import Screens.ResultScreen;
import Screens.TitleScreen;


import java.awt.CardLayout;

import javax.swing.JPanel;

public class AllScreen extends JPanel{
	
	public static CardLayout cards;
	private TitleScreen titlePanel;
	private ResultScreen resultPanel;
	//private LevelScreen levelPanel;
	public GameScreen panel;
	public TimeTracker t;
	public static int SCREEN;
	public static int LEVEL;

	public AllScreen(){
		LEVEL = 1;
		
		cards = new CardLayout();
		
		t = new TimeTracker();
		panel = new GameScreen(this);
		titlePanel = new TitleScreen(this, t);
		resultPanel = new ResultScreen(this);
		
		this.setLayout(cards);
	    this.add(titlePanel, "Title");
	    this.add(panel, "Game");
	    this.add(resultPanel, "Results");
	    
	     cards.show(this, "Title");



		//panel.addMouseListener(panel);
		panel.addKeyListener(panel);
		//panel.addMouseMotionListener(panel);
		titlePanel.addMouseListener(titlePanel);
		resultPanel.addMouseListener(resultPanel);

		
	}
	
	public void changeScreen(String name) {
		// if we restart a game, make sure we start from clean slate, so that we do not have leftovers from last game
		
		if (name.equals("Results")) {
			
			/*
			this.remove(panel);
			panel = new Screens.GameScreen(this);
			panel.setLevel(LEVEL);
			panel.addMouseListener(panel);
			panel.addMouseMotionListener(panel);
			this.add(panel, "GameManagement.Game");
			*/
			panel.reset();
		}
		
		if (name.equals("Game")) {
			resultPanel.reset();
		}

		if (name.equals("Title")) {
			cards.show(this, "Title");
		}
		
		
		cards.show(this, name);
		
	}

	
}
