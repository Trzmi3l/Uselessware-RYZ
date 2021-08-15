package main;

import java.awt.Frame;

import javax.swing.JFrame;

public class RisingAndLoweringWIndows implements Runnable {

	public RisingAndLoweringWIndows(JFrame frame) {
		this.frame = frame; 
	}
	
	JFrame frame;
	
	static int maxX[] = {100,500,200,700,300}, maxY[] = {300,700,200,500,100};
	static int joyCount = 0;
	public void sizeChange(JFrame frame) {
		for(;;) {
			if(joyCount >= 4) {
				joyCount--;
			} else {
				joyCount++;
			}
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			frame.setLocation(maxX[joyCount], maxY[joyCount]);
			
		}
		
	}
	@Override
	public void run() {
		sizeChange(frame);
	}
}
