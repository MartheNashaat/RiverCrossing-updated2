package view;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Graphics;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import model.Animal;
import model.Boat;
import model.Farmer1;

public class SecondLevel extends JPanel implements ActionListener, MouseListener {

	int xfarmer1 =600;
	int yfarmer1= 523;
	int xfarmer2= 690;
	int yfarmer2=538;
	int xfarmer3 =770;
	int yfarmer3=500;
	int xfarmer4=900;
	int yfarmer4=530;
	int xboat= 720;
	int yboat= 800;
	int xanimal= 850;
	int yanimal =700;
	int moves=0;
	int farmer1weight =60;
	int farmer2weight=40;
	int farmer3weight = 90;
	int farmer4weight= 80;
	int animalweight=20;
	
	
	
	
	static JFrame window = new JFrame("Second Story");
	Farmer1 farmer1= new Farmer1(xfarmer1,yfarmer1,"F:\\Images\\farmer44 trial.png",0);
	Farmer1 farmer2= new Farmer1(xfarmer2,yfarmer2,"F:\\Images\\farmm.png",0);
	Farmer1 farmer3= new Farmer1(xfarmer3,yfarmer3,"F:\\Images\\humanw.png",0);
	Farmer1 farmer4= new Farmer1(xfarmer4,yfarmer4,"F:\\Images\\farmer455.png",0);
	Boat boat = Boat.getInstance(xboat,yboat,"F:\\Images\\boatt.png",0);
	Animal animal=new Animal(xanimal,yanimal,"F:\\Images\\mikepp.png",0);
	JButton move = new JButton();
	JButton moveback = new JButton();
	boolean moveleft =false;
	boolean moveright = false;
	boolean onleft = false;
	Timer tt= new Timer(100,this);
	JLabel numberofmoves= new JLabel();
	
	
	JButton instructionsButton = new JButton();
	JButton solutionButton = new JButton();
	

	SecondLevel(){
		tt.start();
	//	tt.stop();
		this.setLayout(null);
		window.add(this);
		window.setSize(1320,950);
		window.setLocation(40,20);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		
		
		
//instructions button
		instructionsButton.setText("Instructions ");
		instructionsButton.setBackground(Color.WHITE);
		// instructionsButton.setIcon (new ImageIcon("images//instr..jpg"));
		instructionsButton.addActionListener(this);
		instructionsButton.addMouseListener(this);
		instructionsButton.setSize(0, 0);
		window.add(instructionsButton, BorderLayout.WEST);
		window.setLayout(null);
		instructionsButton.setBounds(1135, 144, 100, 30);
		
//solutions button
		solutionButton.setText("Solution ");
		solutionButton.setBackground(Color.WHITE);
		// instructionsButton.setIcon (new ImageIcon("images//instr..jpg"));
		solutionButton.addActionListener(this);
		solutionButton.addMouseListener(this);
		solutionButton.setSize(0, 0);
		window.add(solutionButton, BorderLayout.WEST);
		solutionButton.setBounds(1135, 200, 100, 30);

		
//move boat to the left bank	
		move.setText("Move");
		move.setBackground(Color.WHITE);
		move.addActionListener(this);
		move.addMouseListener(this);
		move.setSize(0, 0);
		window.add(move);
		move.setBounds(1135, 250, 100, 30);
		
		
//move boat back to the right bank	
		moveback.setText("Moveback");
		moveback.setBackground(Color.WHITE);
		moveback.addActionListener(this);
		moveback.addMouseListener(this);
		moveback.setSize(0, 0);
		window.add(moveback);
		moveback.setBounds(1135, 300, 100, 30);
		
		moveback.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				moveright = true;
				moves++;
				//repaint();
				numberofmoves.setText("Moves : " + moves);
				
				
				// TODO Auto-generated method stub

			}
		});

		move.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				moveleft = true;
				
				moves++;
				numberofmoves.setText("Moves : " + moves);
				
				//repaint();

				// TODO Auto-generated method stub

			}
		});

		
		//numberofmoves.setText("Moves : " + moves);
		
		
		numberofmoves.setBounds(1135, 400, 100,30);
		//this.add(numberofmoves);
		window.add(numberofmoves);
		
		
	}	
	public void paint (Graphics g) {
	//	super.paint(g);
		ImageIcon background = new ImageIcon("F:\\Images\\story2.jpg");
		g.drawImage(background.getImage(), 0, 0,null);
		boat.drawBoat(g);
		farmer1.drawFarmer(g);
		farmer2.drawFarmer(g);
		farmer3.drawFarmer(g);
		farmer4.drawFarmer(g);
		animal.drawAnimal(g);
	//	repaint();
//		
	}


	@Override
	public void actionPerformed(ActionEvent is) {
		 if(is.getSource()==instructionsButton) {
		JOptionPane.showMessageDialog(null,"Four Farmers need to cross a river in a small raft , Farmer1 weighs 90 kg , Farmer 2 weighs 80kg "+"\n"+" Farmer 3 weighs 60 kg"
				+ ", Farmer 4 weighs 40kg ,Animal weighs 40kg, and have a 20kg animal."+"\n"+"Rules:"+"\n"+"1)- The raft cannot bear a load heavier than 100 kg"+"\n"+"How can they all get to the other side with their animal ?");		
		 }
		
		 else if(is.getSource()==solutionButton) {
			 JOptionPane.showMessageDialog(null, "1-40 kg +60 kg (cross)."+"\n"+"2-40kg (return)."+"\n"+"3-90kg (cross)."+"\n"+"4-60kg(return)."+"\n"+"5-40kg+60kg(cross)."+"\n"+"6-40kg(return)."
		 +"\n"+"7-80kg+20kg(cross)."+"\n"+"60kg(return)."+"\n"+"9-40kg+60kg(cross)."+"\n\n"+"Done.");
		 }
		 
		 else if (is.getSource() == tt) {
				if (moveleft == true) {
					if (!isstoryvalid())
					{
						moveleft= false;
						return;
					}
					
					
					if (xboat > 130) {

						if (farmer1.getPosition() == 1) {

							xfarmer1 -= 60;
							farmer1.setxAxis(xfarmer1);
			
						}
						if (farmer2.getPosition() == 1) {

							xfarmer2-= 60;
							farmer2.setxAxis(xfarmer2);

						}
						
						if (farmer3.getPosition() == 1) {

							xfarmer3 -= 60;  
							farmer3.setxAxis(xfarmer3);

						}
						if (farmer4.getPosition() == 1) {

							xfarmer4  -= 60;  
							farmer4.setxAxis(xfarmer4);

						}
						if (animal.getPosition() == 1) {

							xanimal  -= 60;  
							animal.setxAxis(xanimal);

						}
						
						xboat -= 60;
						boat.setxAxis(xboat);

						repaint();
					} else {// boat is on the left bank
						moveleft = false;
						onleft = true;
						if (farmer1.getPosition() == 1) {
							farmer1.setPosition(2);
							xfarmer1 -= 20;
							yfarmer1-= 110;
							farmer1.setyAxis(yfarmer1);
							farmer1.setxAxis(xfarmer1);
							repaint();
						}

						if (farmer2.getPosition() == 1) {
							farmer2.setPosition(2);
							xfarmer2-= 30;
							yfarmer2-= 100;
							farmer2.setyAxis(yfarmer2);
							farmer2.setxAxis(xfarmer2);
							repaint();
						}
						
						if (farmer3.getPosition() == 1) {
							farmer3.setPosition(2);
							xfarmer3 -=175;
							yfarmer3 -=80;
							farmer3.setyAxis(yfarmer3);
							farmer3.setxAxis(xfarmer3);
							repaint();
						}
						if (farmer4.getPosition() == 1) {
							farmer4.setPosition(2);
							xfarmer4 -= 190;
							yfarmer4 -= 50;
							farmer4.setyAxis(yfarmer4);
							farmer4.setxAxis(xfarmer4);
							repaint();
						}
						if (animal.getPosition() == 1) {
							animal.setPosition(2);
							xanimal -= 200;
							yanimal -= 40;
							animal.setyAxis(yanimal);
							animal.setxAxis(xanimal);
							repaint();
						}
						
					 }
					
			   	}
				if (moveright == true) {
					if (!isstoryvalid())
					{
						moveright= false;
						return;
					}
					
					
					if (xboat < 710) {

						if (farmer1.getPosition() == 1) {

							xfarmer1 += 60;
							farmer1.setxAxis(xfarmer1);
							
							
						}
						if (farmer2.getPosition() == 1) {

							xfarmer2 += 60;
							farmer2.setxAxis(xfarmer2);

						}
						
						if (farmer3.getPosition() == 1) {

							xfarmer3 += 60;
							farmer3.setxAxis(xfarmer3);

						}
						

						if (farmer4.getPosition() == 1) {

							xfarmer4 += 60;
							farmer4.setxAxis(xfarmer4);

						}
						if (animal.getPosition() == 1) {

							xanimal += 60;
							animal.setxAxis(xanimal);

						}
						


						xboat += 60;
						boat.setxAxis(xboat);

						repaint();
					} else {
						moveright = false;
						onleft = false;
						if (farmer1.getPosition() == 1) {
							farmer1.setPosition(0);
							xfarmer1 -=200;
							yfarmer1-=130;
							farmer1.setyAxis(yfarmer1);
							farmer1.setxAxis(xfarmer1);
							repaint();
						}

						if (farmer2.getPosition() == 1) {
							farmer2.setPosition(0);
							xfarmer2 -= 160;
							yfarmer2-=120;
							farmer2.setyAxis(yfarmer2);
							farmer2.setxAxis(xfarmer2);
							repaint();
						}
						
						if (farmer3.getPosition() == 1) {
							farmer3.setPosition(0);
							xfarmer3 -=10;
							yfarmer3-=110;
							farmer3.setyAxis(yfarmer3);
							farmer3.setxAxis(xfarmer3);
							repaint();
						}
					
					
						if (farmer4.getPosition() == 1) {
							farmer4.setPosition(0);
							xfarmer4 += 170;
							yfarmer4-=130;
							farmer4.setyAxis(yfarmer4);
							farmer4.setxAxis(xfarmer4);
							repaint();
						}
					
						if (animal.getPosition() == 1) {
							animal.setPosition(0);
							xanimal += 150;
							yanimal-=70;
							animal.setyAxis(yanimal);
							animal.setxAxis(xanimal);
							repaint();
						}
						
				}

			}
		 }
		 
		 
	}
	
	
	public void handlepressonright(int x, int y) {

		if (x >= xfarmer1 && x <= xfarmer1 + farmer1.getFarmerIcon().getIconWidth()) {
			if (y >= yfarmer1 && y <= yfarmer1 + farmer1.getFarmerIcon().getIconHeight())
		{
				if (farmer1.getPosition()!=1) {
				xfarmer1 += 230;
				yfarmer1 += 140;
				farmer1.setPosition(1);
				farmer1.setyAxis(yfarmer1);
				farmer1.setxAxis(xfarmer1);
				repaint();
				
			}
		}

		}

		else if (x >= xfarmer2 && x <= xfarmer2 + farmer2.getFarmerIcon().getIconWidth()) {
				if (y >= yfarmer2 && y <= yfarmer2 + farmer2.getFarmerIcon().getIconHeight())
			{
					
					
					if (farmer2.getPosition()!=1) {
					xfarmer2 += 102;
					yfarmer2 += 150;
					farmer2.setPosition(1);
					farmer2.setyAxis(yfarmer2);
					farmer2.setxAxis(xfarmer2);
					repaint();
				}
			}
		}
		else if (x >= xfarmer3 && x <= xfarmer3 + farmer3.getFarmerIcon().getIconWidth()) {
				if (y >= yfarmer3 && y <= yfarmer3 + farmer3.getFarmerIcon().getIconHeight())
			{
					
					
					if (farmer3.getPosition()!=1) {
					xfarmer3 += 90;
					yfarmer3 += 110;
					farmer3.setPosition(1);
					farmer3.setyAxis(yfarmer3);
					farmer3.setxAxis(xfarmer3);
					repaint();
				}
			}	

			}
		
		else if (x >= xfarmer4 && x <= xfarmer4 + farmer4.getFarmerIcon().getIconWidth()) {
				if (y >= yfarmer4 && y <= yfarmer4 + farmer4.getFarmerIcon().getIconHeight())
			{
					
					
					if (farmer4.getPosition()!=1) {
					xfarmer4 -= 120;
					yfarmer4 += 140;
					farmer4.setPosition(1);
					farmer4.setyAxis(yfarmer4);
					farmer4.setxAxis(xfarmer4);
					repaint();
				}
			}

			}
		else if (x >= xanimal && x <= xanimal + animal.getAnimalIcon().getIconWidth()) {
			if (y >= yanimal && y <= yanimal + animal.getAnimalIcon().getIconHeight())
		{
				
				
				if (animal.getPosition()!=1) {
				xanimal -= 40;
				yanimal += 50;
				animal.setPosition(1);
				animal.setyAxis(yanimal);
				animal.setxAxis(xanimal);
				repaint();
			}
		}

		}
		//if (onleft==true )
	//if (onleft==false)
			//moves++;
	System.out.println(moves);	
	//	if (farmer1.getPosition()==1 || farmer2.getPosition()==1 || farmer3.getPosition()==1 || farmer4.getPosition()==1)
		//	tt.restart();
	//	else
		
		
	/*	
		if (animal.getPosition()==1 && farmer1.getPosition()==0 && farmer2.getPosition()==0 &&  farmer3.getPosition()==0 &&  farmer4.getPosition()==0)
		{
			tt.stop();
			
			
			
			//JOptionPane.showMessageDialog(window, "Only Farmers can row the boat");
		}
		else if (farmer1.getPosition() ==0&&  farmer2.getPosition()==0 && farmer3.getPosition()==0 && farmer4.getPosition()==0 &&animal.getPosition()==0)
			tt.stop();
		else if (farmer1.getPosition() ==2&&  farmer2.getPosition()==2 && farmer3.getPosition()==2 && farmer4.getPosition()==2 &&animal.getPosition()==2)
			tt.stop();
		else if (farmer1.getPosition()==1 && farmer2.getPosition()==1 && farmer3.getPosition()==0 && farmer4.getPosition()==0 && animal.getPosition()==0)//60+40
			tt.restart();
		else if (farmer4.getPosition()==1 && animal.getPosition()==1 && farmer1.getPosition()==0 && farmer2.getPosition()==0 && farmer3.getPosition()==0)//80+20
			tt.restart();
		else if (farmer1.getPosition()==1 && animal.getPosition()==1 && farmer2.getPosition()==0 && farmer3.getPosition()==0 && farmer4.getPosition()==0)//60+20
			tt.restart();
			
		else if (farmer1.getPosition()==1 && farmer3.getPosition()==1 )//60+90
		{
			tt.stop();
			JOptionPane.showMessageDialog(window, "Boat Cannot bear more than 100 kg!");
		}
		else if (farmer1.getPosition()==1 && farmer4.getPosition()==1)//60+80
		{
			tt.stop();
			JOptionPane.showMessageDialog(window, "Boat Cannot bear more than 100 kg!");
		}
		else if (farmer2.getPosition()==1 && farmer3.getPosition()==1)//40+90
		{
			tt.stop();
			JOptionPane.showMessageDialog(window, "Boat Cannot bear more than 100 kg!");
		}
		else if (farmer2.getPosition()==1 && farmer4.getPosition()==1)//40+80
		{
			tt.stop();
			JOptionPane.showMessageDialog(window, "Boat Cannot bear more than 100 kg!");
		}
		else if (farmer2.getPosition()==1 && animal.getPosition()==1 && farmer1.getPosition()==0 && farmer3.getPosition()==0 && farmer4.getPosition()==0)//40+20
		{
			tt.start();
		}
		else if (farmer3.getPosition()==1 && farmer4.getPosition()==1)//90+80
		{
			tt.stop();
			JOptionPane.showMessageDialog(window, "Boat Cannot bear more than 100 kg!");
		}
		else if (farmer3.getPosition()==1 && animal.getPosition()==1)//90+20
		{
			tt.stop();
			JOptionPane.showMessageDialog(window, "Boat Cannot bear more than 100 kg!");
		}
		
		else if (farmer3.getPosition()==1)
			tt.restart();
		
		
		if (farmer1.getPosition()==2 && farmer2.getPosition()==2 && farmer3.getPosition()==2 && farmer4.getPosition() ==2 && animal.getPosition() ==2)
		{
		tt.stop();
		moveright=false;
		onleft=true;
		
		JOptionPane.showMessageDialog(window, "You Won !!!");
	
		
		}
		*/
		
		}
	
	public boolean isstoryvalid() {
		
		int sum=0;
	
		if (farmer1.getPosition()==1)
			sum+= farmer1weight;
		 if (farmer2.getPosition()==1)
			sum+= farmer2weight;
		 if (farmer3.getPosition()==1)
			sum+= farmer3weight;
		 if (farmer4.getPosition()==1)
			 sum+= farmer4weight;
		 if (animal.getPosition()==1)
			 sum+= animalweight;
		 if(sum>100)
		 { JOptionPane.showMessageDialog(window, "Boat weight cannot exceed 100 kg");
			
			 return false;
		}
		 
				return true;
		
	}
	
	
	public void handlepressonleft(int x, int y) {
	
		if (x >= xfarmer1 && x <= xfarmer1 + farmer1.getFarmerIcon().getIconWidth()) {
			if (y >= yfarmer1 && y <= yfarmer1 + farmer1.getFarmerIcon().getIconHeight()) {

				if (farmer1.getPosition()!=1) {
			//	xfarmer1 += 100;
				yfarmer1 += 120;
				farmer1.setPosition(1);
				farmer1.setyAxis(yfarmer1);
				farmer1.setxAxis(xfarmer1);
				repaint();
			}
			}
		}

		else if (x >= xfarmer2 && x <= xfarmer2 + farmer2.getFarmerIcon().getIconWidth()) {
			if (y >= yfarmer2 && y <= yfarmer2 + farmer2.getFarmerIcon().getIconHeight()) {

				if (farmer2.getPosition()!=1) {
				xfarmer2 += 100;
				 yfarmer2 += 90;
				farmer2.setPosition(1);
				farmer2.setyAxis(yfarmer2);
				farmer2.setxAxis(xfarmer2);
				repaint();
			}

		  }
		}
		else if (x >= xfarmer3 && x <= xfarmer3 + farmer3.getFarmerIcon().getIconWidth()) {
			if (y >= yfarmer3 && y <= yfarmer3 + farmer3.getFarmerIcon().getIconHeight()) {
			
				if (farmer3.getPosition()!=1) {
				xfarmer3 += 100;
				 yfarmer3 += 85;
				farmer3.setPosition(1);
				farmer3.setyAxis(yfarmer3);
				farmer3.setxAxis(xfarmer3);
				repaint();
			 }
			}
		}
		else if (x >= xfarmer4 && x <= xfarmer4 + farmer4.getFarmerIcon().getIconWidth()) {
			if (y >= yfarmer4 && y <= yfarmer4 + farmer4.getFarmerIcon().getIconHeight()) {

				if (farmer4.getPosition()!=1) {
				xfarmer4 += 150;
				yfarmer4 += 50;
				farmer4.setPosition(1);
				farmer4.setyAxis(yfarmer4);
				farmer4.setxAxis(xfarmer4);
				repaint();
			}
			}		
		}
		else if (x >= xanimal && x <= xanimal + animal.getAnimalIcon().getIconWidth()) {
			if (y >= yanimal && y <= yanimal + animal.getAnimalIcon().getIconHeight()) {

				if (animal.getPosition()!=1) {
				xanimal += 100;
				yanimal += 50;
				animal.setPosition(1);
				animal.setyAxis(yanimal);
				animal.setxAxis(xanimal);
				repaint();
			}

		 }
		}

		
		
	}

		
	
	
	
	
	
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println(e.getX());
		System.out.println(e.getY());

		if (onleft == false) {
			handlepressonright(e.getX(), e.getY());

		}

		else {
			handlepressonleft(e.getX(), e.getY());

		}
		

	
		
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
	public static void main (String[] args) {
		SecondLevel se= new SecondLevel();
		 window.addMouseListener(se); 

	}

}
