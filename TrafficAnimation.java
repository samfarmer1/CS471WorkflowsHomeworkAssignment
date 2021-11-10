import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * CS 121 Project 1: Traffic Animation
 *
 * Animates a Submarine and a worm on shore
 *
 * @author BSU CS 121 Instructors
 * @author Samantha Farmer
 */
@SuppressWarnings("serial")
public class TrafficAnimation extends JPanel
{
	// This is where you declare constants and variables that need to keep their
	// values between calls	to paintComponent(). Any other variables should be
	// declared locally, in the method where they are used.

	/**
	 * A constant to regulate the frequency of Timer events.
	 * Note: 100ms is 10 frames per second - you should not need
	 * a faster refresh rate than this
	 */
	private final int DELAY = 100; //milliseconds

	/**
	 * The anchor coordinate for drawing / animating. All of your vehicle's
	 * coordinates should be relative to this offset value.
	 */
	private int xOffset = 0;

	/**
	 * The number of pixels added to xOffset each time paintComponent() is called.
	 */
	private int stepSize = 10;

	private final Color BACKGROUND_COLOR = Color.black;

	/* This method draws on the panel's Graphics context.
	 * This is where the majority of your work will be.
	 *
	 * (non-Javadoc)
	 * @see java.awt.Container#paint(java.awt.Graphics)
	 */
	public void paintComponent(Graphics g)
	{
		// Get the current width and height of the window.
		int width = getWidth(); // panel width
		int height = getHeight(); // panel height

		// Fill the graphics page with the background color.
		Color Sky = new Color (153, 225, 247);
		g.setColor(Sky);
		g.fillRect(0, 0, width, height);

		// Calculate the new xOffset position of the moving object.
		xOffset  = (xOffset + stepSize) % width;

		// TODO: Use width, height, and xOffset to draw your scalable objects
		// at their new positions on the screen
		int riverWidth = width;
		int riverHeight = height / 3;
		int riverX = 0;
		int riverY = height / 3;
		
		Color river = new Color(12, 103, 240);
		g.setColor(river);
		g.fillRect(riverX, riverY, riverWidth, riverHeight);
		
		//Grass.
		int btmgrassWidth = width;
		int btmgrassHeight = height / 3;
		int btmgrassX = 0;
		int btmgrassY = riverY + height / 3;
		
		Color btmgrass = new Color(49, 176, 7);
		g.setColor(btmgrass);
		g.fillRect(btmgrassX, btmgrassY, btmgrassWidth, btmgrassHeight);
		

		// This draws a red circle: the back of my submarine.
		int squareSide = height / 5;
		int squareY = height / 2 - squareSide / 2;
		
		
		g.setColor(Color.RED);
		g.fillOval(xOffset, squareY, squareSide, squareSide);
		
		//A yellow circle in the top left-hand corner.
		int sunWidth = squareSide;
		int sunHeight = squareSide;
		int sunX = 0 + squareSide / 2;
		int sunY = height / 12;
		
		Color sun = new Color(235, 223, 66);
		g.setColor(sun);
		g.fillOval(sunX, sunY, sunWidth, sunHeight);
		
		//Draws the circle to the right of the square.
		int circleWidth = squareSide * 2;
		int circleHeight = squareSide;		
		int circleX = xOffset + squareSide;
		int circleY = squareY;
		
		g.setColor(Color.RED);
		g.fillOval(circleX, circleY, circleWidth, circleHeight);
		
		//Draws a thin rectangle on the top of the oval.
		int cabinWidth = circleWidth / 4;
		int cabinHeight = circleHeight / 2;
		int cabinX = circleX + squareSide;
		int cabinY = squareY - circleHeight / 8;
		
		g.setColor(Color.RED);
		g.fillRect(cabinX, cabinY, cabinWidth, cabinHeight);
		
		//Circles on the body of my submarine made to be windows.
		int windowWidth = cabinWidth / 2;
		int windowHeight = cabinHeight / 2;
		int windowX = circleX + circleWidth / 6;
		int windowY = circleY + circleHeight / 4;
		
		g.setColor(Color.WHITE);
		g.fillOval(windowX, windowY, windowWidth, windowHeight);
		
		int windtwoWidth = cabinWidth /2;
		int windtwoHeight = cabinHeight / 2;
		int windtwoX = windowX + circleWidth / 6;
		int windtwoY = windowY;
		
		g.setColor(Color.WHITE);
		g.fillOval(windtwoX, windtwoY, windtwoWidth, windtwoHeight);
		
		int windthreeWidth = cabinWidth / 2;
		int windthreeHeight = cabinHeight / 2;
		int windthreeX = windtwoX + circleWidth / 6;
		int windthreeY = windowY;
		
		g.setColor(Color.WHITE);
		g.fillOval(windthreeX, windthreeY, windthreeWidth, windthreeHeight);
		
		int WindfourWidth = cabinWidth / 2;
		int windfourHeight = cabinHeight / 2;
		int windfourX = windthreeX + circleWidth / 6;
		int windfourY = windowY;
		
		g.setColor(Color.WHITE);
		g.fillOval(windfourX, windfourY, WindfourWidth, windfourHeight);
		
		//Scope made from two rectangles: one vertical and one horizontal.
		int vertWidth = cabinWidth / 2;
		int vertHeight = cabinHeight;
		int vertX = cabinX + cabinWidth / 3;
		int vertY = cabinY - cabinHeight;
		
		g.setColor(Color.RED);
		g.fillRect(vertX, vertY, vertWidth, vertHeight);
		
		int scopeWidth = circleWidth / 3;
		int scopeHeight = cabinWidth / 2;
		int scopeX = cabinX + cabinWidth / 3;
		int scopeY = cabinY - cabinHeight;
		
		g.setColor(Color.RED);
		g.fillRect(scopeX, scopeY, scopeWidth, scopeHeight);

		// A caterpillar on the grass.
		int cataWidth = windowWidth * 2;
		int cataHeight = windowHeight * 2;
		int cataX = btmgrassWidth /4;
		int cataY = btmgrassHeight *2 + windowHeight;
		
		Color caterpillar = new Color(66, 245, 182);
		g.setColor(caterpillar);
		g.fillOval(cataX, cataY, cataWidth, cataHeight);
		
		int bugWidth = cataWidth;
		int bugHeight = cataHeight;
		int bugX = cataX + cataWidth / 2;
		int bugY = cataY;
		
		g.setColor(caterpillar);
		g.fillOval(bugX, bugY, bugWidth, bugHeight);
		
		int secBugWidth = cataWidth;
		int secBugHeight = cataHeight;
		int secBugX = bugX + cataWidth / 2;
		int secBugY = bugY;
		
		g.setColor(caterpillar);
		g.fillOval(secBugX, secBugY, secBugWidth, secBugHeight);
		
		int thirdBugWidth = cataWidth;
		int thirdBugHeight = cataHeight;
		int thirdBugX = secBugX + cataWidth / 2;
		int thirdBugY = secBugY;
		
		g.setColor(caterpillar);
		g.fillOval(thirdBugX, thirdBugY, thirdBugWidth, thirdBugHeight);
		
		int fourBugWidth = cataWidth;
		int fourBugHeight = cataHeight;
		int fourBugX = thirdBugX + cataWidth / 2;
		int fourBugY = thirdBugY;
		
		g.setColor(caterpillar);
		g.fillOval(fourBugX, fourBugY, fourBugWidth, fourBugHeight);
		
		//Legs of the caterpillar.
		int legWidth = fourBugWidth / 16;
		int legHeight = fourBugHeight /3;
		int legX = bugX + cataWidth / 4;
		int legY = bugY + bugHeight;
		
		g.setColor(Color.BLACK);
		g.fillRect(legX, legY, legWidth, legHeight);
		
		int secLegWidth = legWidth;
		int secLegHeight = legHeight;
		int secLegX = legX + cataWidth /4 ;
		int secLegY = legY;
		
		g.setColor(Color.BLACK);
		g.fillRect(secLegX, secLegY, secLegWidth, secLegHeight);
		
		int thirdLegWidth = secLegWidth;
		int thirdLegHeight = secLegHeight;
		int thirdLegX = secLegX + cataWidth / 4;
		int thirdLegY = legY;
		
		g.setColor(Color.BLACK);
		g.fillRect(thirdLegX, thirdLegY, thirdLegWidth, thirdLegHeight);
		
		int fourLegWidth = thirdLegWidth;
		int fourLegHeight = thirdLegHeight;
		int fourLegX = thirdLegX + cataWidth / 4;
		int fourLegY = legY;
		
		g.setColor(Color.BLACK);
		g.fillRect(fourLegX, fourLegY, fourLegWidth, fourLegHeight);
		
		int fifthLegWidth = fourLegWidth;
		int fifthLegHeight = fourLegHeight;
		int fifthLegX = fourLegX + cataWidth / 4;
		int fifthLegY = legY;
		 
		g.setColor(Color.BLACK);
		g.fillRect(fifthLegX, fifthLegY, fifthLegWidth, fifthLegHeight);
		
		int sixthLegWidth = fifthLegWidth;
		int sixthLegHeight = fifthLegHeight;
		int sixthLegX = fifthLegX + cataWidth / 4;
		int sixthLegY = legY;
		
		g.setColor(Color.BLACK);
		g.fillRect(sixthLegX, sixthLegY, sixthLegWidth, sixthLegHeight);
		 
		int lastLegWidth = sixthLegWidth;
		int lastLegHeight = sixthLegHeight;
		int lastLegX = sixthLegX + cataWidth / 4;
		int lastLegY = legY;
		
		g.setColor(Color.BLACK);
		g.fillRect(lastLegX, lastLegY, lastLegWidth, lastLegHeight);
		
		//Face of the caterpillar.
		int eyeWidth = cataWidth / 6;
		int eyeHeight = cataHeight / 6;
		int eyeX = fourBugX + fourBugWidth / 3;
		int eyeY = fourBugY + fourBugHeight / 4;
		
		g.setColor(Color.BLACK);
		g.fillOval(eyeX, eyeY, eyeWidth, eyeHeight);
		
		int secEyeWidth = eyeWidth;
		int secEyeHeight = eyeHeight;
		int secEyeX = eyeX + fourBugWidth / 3;
		int secEyeY = eyeY;
		
		g.setColor(Color.BLACK);
		g.fillOval(secEyeX, secEyeY, secEyeWidth, secEyeHeight); 
		
		int smileWidth = eyeWidth * 4;
		int smileHeight = secEyeHeight;
		int smileX = eyeX;
		int smileY = eyeY + fourBugHeight / 2;
		
		g.setColor(Color.BLACK);
		g.fillOval(smileX, smileY, smileWidth, smileHeight);
		
		int cornerWidth = eyeWidth;
		int cornerHeight = eyeHeight;
		int cornerX = smileX;
		int cornerY = smileY - eyeHeight / 2;
		
		g.setColor(Color.BLACK);
		g.fillOval(cornerX, cornerY, cornerWidth, cornerHeight);
		
		int leftWidth = cornerWidth;
		int leftHeight = cornerHeight;
		int leftX = cornerX + eyeWidth * 3;
		int leftY = cornerY;
		
		g.setColor(Color.BLACK);
		g.fillOval(leftX, leftY, leftWidth, leftHeight);
		
		//Thought bubble.
		int oneWidth = windowWidth;
		int oneHeight = windowHeight;
		int oneX = fourBugX + bugWidth * 2;
		int oneY = fourBugY;
		
		g.setColor(Color.WHITE);
		g.fillOval(oneX, oneY, oneWidth, oneHeight);
		
		int twoWidth = windowWidth * 2;
		int twoHeight = windowHeight * 2;
		int twoX = oneX + bugWidth;
		int twoY = oneY + windowHeight;
		
		g.setColor(Color.WHITE);
		g.fillOval(twoX, twoY, twoWidth, twoHeight);
		
		int commentWidth = twoWidth * 4;
		int commentHeight = twoHeight * 3;
		int commentX = twoX + bugWidth * 2;
		int commentY = twoY - twoHeight;
		
		g.setColor(Color.WHITE);
		g.fillOval(commentX, commentY, commentWidth, commentHeight);
		
		//Text "Ahoy!" in my third comment bubble.
		int x = commentX;
		int y = commentY + commentHeight / 2 + twoHeight  / 2;
		String text = "Ahoy!";
		
		g.setColor(Color.BLACK);
		g.setFont(new Font ("Arial", Font.BOLD, 50));
		g.drawString(text, x, y);
		
		// Put your code above this line. This makes the drawing smoother.
		Toolkit.getDefaultToolkit().sync();
	}


	//==============================================================
	// You don't need to modify anything beyond this point.
	//==============================================================


	/**
	 * Starting point for this program. Your code will not go in the
	 * main method for this program. It will go in the paintComponent
	 * method above.
	 *
	 * DO NOT MODIFY this method!
	 *
	 * @param args unused
	 */
	public static void main (String[] args)
	{
		// DO NOT MODIFY THIS CODE.
		JFrame frame = new JFrame ("Traffic Animation");
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new TrafficAnimation());
		frame.pack();
		frame.setVisible(true);
	}

	/**
	 * Constructor for the display panel initializes necessary variables.
	 * Only called once, when the program first begins. This method also
	 * sets up a Timer that will call paint() with frequency specified by
	 * the DELAY constant.
	 */
	public TrafficAnimation()
	{
		// Do not initialize larger than 800x600. I won't be able to
		// grade your project if you do.
		int initWidth = 600;
		int initHeight = 400;
		setPreferredSize(new Dimension(initWidth, initHeight));
		this.setDoubleBuffered(true);

		//Start the animation - DO NOT REMOVE
		startAnimation();
	}

	/**
	 * Create an animation thread that runs periodically.
	 * DO NOT MODIFY this method!
	 */
	private void startAnimation()
	{
		ActionListener timerListener = new TimerListener();
		Timer timer = new Timer(DELAY, timerListener);
		timer.start();
	}

	/**
	 * Repaints the graphics panel every time the timer fires.
	 * DO NOT MODIFY this class!
	 */
	private class TimerListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			repaint();
		}
	}
}
