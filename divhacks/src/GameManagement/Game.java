package GameManagement;

import javax.swing.JFrame;

public class Game extends JFrame{

	private static AllScreen as;

	
	public Game() {
		as = new AllScreen();
	}
	
	public static void main(String[] args)
	{
		Game w = new Game();
		
		w.setTitle("Social Distancing - The GameManagement.Game");
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		w.setBounds(100, 100, 800, 800);
		w.add(as);
		w.getContentPane().repaint();
		
		w.setResizable(false);
		w.setVisible(true);
		
		// GameManagement.AllScreen.panel.run();
		
		// Fling w = new Fling();
		
		/*
		 * w.setBounds(100, 100, 800, 600);

		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			w.add(titlePanel);
			System.out.println(Screens.Screen + "");
			System.out.println(level + "");

		w.setResizable(false);
		w.setVisible(true);


		panel.addMouseListener(panel);
		panel.addMouseMotionListener(panel);
		titlePanel.addMouseListener(titlePanel);
		resultPanel.addMouseListener(resultPanel);
		levelPanel.addMouseListener(levelPanel);
	
		*/
	}
	
/*public void run(){
		
		while (true){
			if(GameManagement.AllScreen.SCREEN == 6) {
				GameManagement.AllScreen.cards.show(this, "Title");
			}
			else if(GameManagement.AllScreen.SCREEN == 7)
				GameManagement.AllScreen.cards.show(this, "Level");
			else if(GameManagement.AllScreen.SCREEN == 8)
				GameManagement.AllScreen.cards.show(this, "GameManagement.Game");
			else if(GameManagement.AllScreen.SCREEN == 9)
				GameManagement.AllScreen.cards.show(this, "Results");
			
		}
		
	}
	*/
	
	
	
}
