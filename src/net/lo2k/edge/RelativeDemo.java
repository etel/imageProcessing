package net.lo2k.edge;


import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class RelativeDemo extends JPanel {

	
	private static final String IMG_URL = "seek.jpg";
	//private static final String FIND_IMG_URL = "pattern.jpg";
	//ball
	//private static final String IMG_URL = "http://www.insolite.ca/wp-content/uploads/2009/10/soccer-ball.jpg";
	
	//ball2
	private static final String FIND_IMG_URL = "http://www.footballpictures.net/data/media/144/Euro-2008-official-ball.jpg";
	
	//trian
	//private static final String FIND_IMG_URL = "http://www.montigny78.fr/montigny/2101/TRIANGLE3.JPG";
		
	//plage
	//private static final String FIND_IMG_URL = "http://www.photoway.com/images/martinique/plus-belle-plage.jpg";
	
	//inca ball
	//private static final String FIND_IMG_URL = "http://www.incaballonlinegame.com/images/screenshots/inca-ball_1.jpg";
	//private static final String FIND_IMG_URL = "http://ca.7digital.com/cms/USEvents/Img/Stock-Soccer-Ball.jpg";
	//private static final String IMG_URL = "http://ca.7digital.com/cms/USEvents/Img/Stock-Soccer-Ball.jpg";
	
	
	public static void main(String args[]) throws MalformedURLException,
			IOException {

		final BufferedImage imageOne = ImageIO.read(new File(IMG_URL));
		BufferedImage imagePattern = ImageIO.read(new URL(FIND_IMG_URL));
		

		
		final JFrame frame = new JFrame();

		frame.setLayout(new GridLayout(2, 2));
		//frame.add(new DisplayPanel(imageTwo));

		Detector detector = new Detector();
		
		RelativeHausdorffDistance dist = new RelativeHausdorffDistance(true);
		dist.iterate(new NearestPointImg(detector.getEdgesFor(imageOne)), new NearestPointImg(detector.getEdgesFor(imagePattern)));
		frame.add(new DisplayPanel(dist.getDebugImg()));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.pack();
		
		frame.repaint();
	}

}

