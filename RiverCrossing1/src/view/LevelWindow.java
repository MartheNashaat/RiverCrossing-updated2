package view;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class LevelWindow extends JPanel implements ActionListener,MouseListener {
	
	ImageIcon background;
	//JFrame login = new JFrame();
	
	
	JFrame levels=new JFrame();
	String[]s= {"First-Level","Second-Level"};
	JComboBox nameOfLevels = new JComboBox(s);
	JButton enterButton= new JButton();
	JButton backButton = new JButton();
	JButton level1button = new JButton();
	JButton level2button= new JButton();
	
	Font customFont= new Font("Italic",Font.ITALIC,30);
	Font comboFont = new Font("Italic",Font.ITALIC,25);


	LevelWindow(){
		
		levels.setVisible(true);
		levels.getContentPane().setLayout(null);
		
		levels.getContentPane().add(this);
		/*levels.getContentPane().add(level1button);
		level1button.setBounds(20,20,20,20);
		level1button.setVisible(true);
		*/
		nameOfLevels.setBounds(379, 382, 353, 73);
		nameOfLevels.setFont(comboFont);
		levels.getContentPane().add(nameOfLevels);
		backButton.setBounds(0, 456, 732, 47);
				
		
		backButton.setFont(customFont);
		backButton.setText("Back");
		backButton.setForeground(Color.BLACK);
		backButton.setBackground(Color.gray);
//		backButton.addKeyListener(this);
		backButton.addMouseListener(this);
		backButton.addActionListener(this);
		levels.getContentPane().add(backButton);
		
		enterButton.setBounds(0, 0, 732, 382);
		enterButton.setIcon(new ImageIcon("ImportedImages\\Images\\Background.jpg"));
	//	enterButton.addKeyListener(this);
		enterButton.addMouseListener(this);
		enterButton.addActionListener(this);
		levels.getContentPane().add(enterButton);
		levels.dispose();
		
		
		JLabel lblNewLabel = new JLabel("ClLICK TO SELECT LEVEL :");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(0, 380, 378, 75);
		levels.getContentPane().add(lblNewLabel);
		
		levels.setSize(750,550);
		levels.setLocation(50,50);
		levels.setVisible(true);
		
	/*	level1button = new JButton("Level 1");
		level1button.setFont(new Font("Segoe Print", Font.PLAIN, 15));
		level1button.setBounds(24, 181, 122, 35);
		levels.getContentPane().add(level1button);
		
		level2button = new JButton("Level 2");
		level2button.setFont(new Font("Segoe Print", Font.PLAIN, 15));
		level2button.setBounds(263, 181, 122, 35);
		levels.getContentPane().add(level2button);
		*/
	}
	
	public void paint (Graphics g) {
		background = new ImageIcon("ImportedImages\\Images\\Background.jpg");
		g.drawImage(background.getImage(),0,0,null);
		
	}
	
	
	/*@Override
	public void keyPressed(KeyEvent kp) {
		if(kp.getKeyCode()==KeyEvent.VK_ESCAPE)
		{
			window.dispose();
			MenuR m= new MenuR();
		}
	
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
*/
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()== backButton) {
			//levels.dispose();
			MenuR m=new MenuR();
		}
		else if(ae.getSource()==enterButton && nameOfLevels.getSelectedIndex()==0) {
			try {
				FirstLevel f1= new FirstLevel();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(ae.getSource()==enterButton && nameOfLevels.getSelectedIndex()==1) {
			SecondLevel sl=new SecondLevel();
		}
		
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main (String args []) {
		//LoginScreen ss = new LoginScreen();
		LevelWindow le = new LevelWindow();
	}
}
