import java.awt.CardLayout;

import javax.swing.JFrame;

public class Fling extends JFrame{

	private static AllScreen as;

	
	public Fling() {
		as = new AllScreen();
	}
	
	public static void main(String[] args)
	{
		Fling w = new Fling();
		
		w.setTitle("Fling");
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		w.setBounds(100, 100, 800, 600);
		w.add(as);
		w.getContentPane().repaint();
		
		w.setResizable(false);
		w.setVisible(true);
		
		// AllScreen.panel.run();
		
		// Fling w = new Fling();
		
		/*
		 * w.setBounds(100, 100, 800, 600);

		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			w.add(titlePanel);
			System.out.println(Screen + "");
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
			if(AllScreen.SCREEN == 6) {
				AllScreen.cards.show(this, "Title");
			}
			else if(AllScreen.SCREEN == 7)
				AllScreen.cards.show(this, "Level");
			else if(AllScreen.SCREEN == 8)
				AllScreen.cards.show(this, "Game");
			else if(AllScreen.SCREEN == 9)
				AllScreen.cards.show(this, "Results");
			
		}
		
	}
	*/
	
	
	
}
