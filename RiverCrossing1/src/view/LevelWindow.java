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
		backButton.addMouseListener(this);
		backButton.addActionListener(this);
		levels.getContentPane().add(backButton);
		
		enterButton.setBounds(0, 0, 732, 382);
		enterButton.setIcon(new ImageIcon("ImportedImages\\Images\\Background.jpg"));
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
	
	}
	
	public void paint (Graphics g) {
		background = new ImageIcon("ImportedImages\\Images\\Background.jpg");
		g.drawImage(background.getImage(),0,0,null);
		
	}
	
	
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
		
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		
	}
	
	public static void main (String args []) {
		LevelWindow le = new LevelWindow();
	}
}
