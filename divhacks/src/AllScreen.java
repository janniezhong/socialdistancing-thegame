import java.awt.CardLayout;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.JPanel;

public class AllScreen extends JPanel{
	
	public static CardLayout cards;
	private TitleScreen titlePanel;
	private ResultScreen resultPanel;
	private LevelScreen levelPanel;
	public GameScreen panel;
	public static int SCREEN;
	public static int LEVEL;

	public AllScreen(){
		LEVEL = 1;
		
		cards = new CardLayout();
		
		panel = new GameScreen(this);
		titlePanel = new TitleScreen(this);
		resultPanel = new ResultScreen(this);
		levelPanel = new LevelScreen(this);
		

		
		this.setLayout(cards);
//	    this.add(titlePanel, "Title");
//	    this.add(levelPanel, "Level");
//	    this.add(panel, "Game");
//	    this.add(resultPanel, "Results");
	    
//	     cards.show(this, "Title");

//		panel.addMouseListener(panel);
//		panel.addMouseMotionListener(panel);
//		titlePanel.addMouseListener(titlePanel);
//		resultPanel.addMouseListener(resultPanel);
//		levelPanel.addMouseListener(levelPanel);
	
		
	}
	
	public void changeScreen(String name) {
		// if we restart a game, make sure start from clean slate, so that we do not have leftovers from last game
		
		if (name.equals("Results")) {
			
			/*
			this.remove(panel);
			panel = new GameScreen(this);
			panel.setLevel(LEVEL);
			panel.addMouseListener(panel);
			panel.addMouseMotionListener(panel);
			this.add(panel, "Game");
			*/
			panel.reset();
		}
		
		if (name.equals("Level")) {
			resultPanel.reset();
		}
		
		
		cards.show(this, name);
		
	}

	
}
