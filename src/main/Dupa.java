package main;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Iterator;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;



public class Dupa extends JFrame implements Runnable {
	

	static int posX[] = {100,400,200,50,0}, posY[] = {0,50,200,400,100} , x[] = {600,800,300,500,400,700}, y[] = {600,800,300,500,400,700};
	
	static String[] RawRyzPath = {"/media/ryz.jpg", "/media/ryz2.jpg", "/media/ryz3.jpg", "/media/ryz4.jpg", "/media/ryz5.jpg", "/media/ryz6.jpg", "/media/ryz7.jpg"};
	
	;
	static String RyzUrl(int z) {
		URL fileUrl = Dupa.class.getResource(RawRyzPath[z]);
		return fileUrl.toString();
	}
	static int windowCount = 0;
	

	
	public static void main(String[] args) {
		
		System.out.println(Dupa.class.getResource("/media/rysz.wav"));
		
		Dupa dupa = new Dupa();
		dupa.playRYZ();
		for(int i = 0; i < 5; i++) {
			(new Thread(new Dupa())).start();
		}
		
		
		
	}
	
	
	private void dupsko(int x, int y, int posX, int posY) {
		int maxX[] = {100,500,200,700,300};
		int maxY[] = {300,700,200,500,100};
		int joyCount = 0;
		windowCount++;
		new JFrame();
		this.setBounds(posX,posY,x,y);
		this.setType(javax.swing.JFrame.Type.UTILITY);
		this.setDefaultCloseOperation(0);
		this.setUndecorated(true);
		this.setAlwaysOnTop(true);
		try {
			Dupa dupa = new Dupa();
			InputStream setRyz = getClass().getResourceAsStream(RawRyzPath[RandomRYZ()]);
			dupa.setContentPane(new JLabel(new ImageIcon(ImageIO.read(setRyz))));
		 } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		}
		
		this.setVisible(true);
		
		for(;;) {
			if(joyCount >= 4) {
				joyCount--;
			} else {
				joyCount++;
			}
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			try {
				InputStream changeRyz = getClass().getResourceAsStream(RawRyzPath[RandomRYZ()]);
				this.setContentPane(new JLabel(new ImageIcon(ImageIO.read(changeRyz))));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.setLocation(RandomPosX(), RandomPosY());
			this.setSize(RandomPosX(), RandomPosY());
			
		}

	}
	
	public static int RandomRYZ() {
		Random rand = new Random();
		int randomNum = rand.nextInt((6 - 0) + 1) + 0;
		return randomNum;
	}
	
	public static int RandomPosX() {
		Random rand = new Random();
		int randomNum = rand.nextInt((1200 - 0) + 1) + 0;
		return randomNum;
	}
	public static int RandomPosY() {
		Random rand = new Random();
		int randomNum = rand.nextInt((600 - 0) + 1) + 0;
		return randomNum;
	}
	
	@Override
	public void run() {
		Dupa dupa = new Dupa();
		dupa.dupsko(x[windowCount],y[windowCount],posX[windowCount],posY[windowCount]);	
	}
	
	private void playRYZ() {
		try {
		Clip clip = AudioSystem.getClip();
		URL audioBytes = Dupa.class.getResource("/media/rysz.wav");
		AudioInputStream inputStream = AudioSystem.getAudioInputStream(audioBytes);
		System.out.println(audioBytes + " is " + inputStream);
		clip.open(inputStream);
		clip.start();
		clip.loop(2137);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
