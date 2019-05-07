package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuR extends JPanel implements ActionListener, MouseListener {
	JFrame menu =new JFrame();
	
	JButton playButton = new JButton();
	JButton exitButton = new JButton();
	JLabel centerImageLabel= new JLabel();
	
	MenuR(){
		this.setBackground(Color.lightGray);
		this.setForeground(Color.pink);
		
		menu.add(this);
		
		/*playButton.setBackground(Color.WHITE);
		playButton.setIcon (new ImageIcon("images//play.png"));
		playButton.addActionListener(this);
	//	playButton.addKeyListener(this);
		playButton.addMouseListener(this);
		playButton.setSize(5, 5);
		window.add(playButton,BorderLayout.EAST);
		
		exitButton.setBackground(Color.WHITE);
		exitButton.setIcon (new ImageIcon("images//exit3.png"));
		exitButton.addActionListener(this);
	//	exitButton.addKeyListener(this);
		exitButton.addMouseListener(this);
		window.add(exitButton,BorderLayout.PAGE_END);
		window.setUndecorated(true);
		
		//centerImageLabel.setBackground(Color.DARK_GRAY);
		centerImageLabel.setIcon(new ImageIcon("images//canyou.jpg"));
		window.add(centerImageLabel,BorderLayout.CENTER);
	*/	
		menu.setLocation(50, 50);
		menu.setSize(650,550);
		menu.setVisible(true);
	}

	/*@Override
	public void keyPressed(KeyEvent kp) {
		if(kp.getKeyCode()==KeyEvent.VK_ESCAPE) {
			window.dispose();
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
		if(ae.getSource()==exitButton) {
			menu.dispose();
		}
		else if(ae.getSource()==playButton) {
			menu.dispose();
			LevelWindow lw =new LevelWindow(); 
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

}
