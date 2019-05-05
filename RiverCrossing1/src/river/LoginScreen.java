package river;

import java.awt.Graphics;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LoginScreen extends JPanel {
	ImageIcon background;
	JFrame login = new JFrame();
	LoginScreen(){
		login.add(this);
		
		/*try {
			File sound = new File("sounds//sound.wav");
		AudioInputStream ais = AudioSystem.getAudioInputStream(sound);
		Clip clip = AudioSystem.getClip();
		clip.open(ais);
		clip.start();
		}catch (Exception e) {System.out.println(e);}
		
		*/
		
		login.setLocation(200,100);
		
		//login.setUndecorated(true);
		login.setSize(650,460);
		login.setVisible(true);
		
		try {
		//	Thread.sleep(5000);
		//	login.dispose();
		//	MenuR m=new MenuR();
		}catch(Exception e) {System.out.println(e);}
		
	}
/*	
	public void paint(Graphics g) {
		 ImageIcon background=new ImageIcon("F:\\Images\\Menu.jpg");
		 g.drawImage(background.getImage(),20,20,null);
		 
	}*/
	
	public void paint (Graphics g) {
		background = new ImageIcon("F:\\Images\\Background.jpg");
		g.drawImage(background.getImage(),0,0,null);
	
	}
	
	public static void main (String args [])
	{
		LoginScreen gg= new LoginScreen();
		
	}

}
