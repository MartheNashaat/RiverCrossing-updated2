package view;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.IOException;

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
import model.Plant;
import river.Factory;
import river.GameEngine;
import river.Moveleft;
import river.Moveright;
import river.GameEngine.Item;
import river.GameEngine.Location;

public class FirstLevel extends JPanel implements ActionListener, MouseListener, MouseMotionListener {

	GameEngine engine;

	public static void main(String args[]) throws IOException {
		FirstLevel kk = new FirstLevel();

		window.addMouseListener(kk);

	}

	boolean moveleft = false;
	boolean moveright = false;
	boolean onleft = false;
	static JFrame window = new JFrame("First Story");
	int xfarmer = 717;
	int yfarmer = 190;
	int xboat = 700;
	int yboat = 420;
	int xgoat = 780;
	int ygoat = 270;
	int xwolf =840;
	int ywolf =270;
	int xplant = 980;
	int yplant = 390;
	int moves=0;
	
	

	Timer t = new Timer(100, this);
	Farmer1 farmer = new Farmer1(xfarmer, yfarmer, "F:\\Images\\farm2.png", 0);
	Factory f = new Factory();
	
	Animal wolf = new Animal(xwolf, ywolf, "F:\\Images\\wolfff.png", 0);
	Animal goat = new Animal(xgoat, ygoat, "F:\\Images\\gggg.png", 0);
	Boat boat =  Boat.getInstance(xboat, yboat, "F:\\Images\\boat2.png", 0); //
	
	Plant plant = (Plant)f.getShape("Plant");
	
	Moveleft m = new Moveleft(boat);
	Moveright r= new Moveright(boat);
	JLabel numberofmoves = new JLabel();
	
	
	

	JButton instructionsButton = new JButton();
	JButton solutionButton = new JButton();
	JLabel fa = new JLabel();
	JButton move = new JButton();
	JButton moveback = new JButton();

	FirstLevel() throws IOException {
		plant.setxAxis(xplant);
		plant.setyAxis(yplant);
		plant.setImagePath("F:\\Images\\plantt.png");
		plant.setPosition(0);
		t.start();
		window.add(this);
		window.setSize(1500, 620);
		window.setLocation(40, 20);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		
//instructions button		
		instructionsButton.setText("Instructions ");
		instructionsButton.setBackground(Color.WHITE);
		
		instructionsButton.addActionListener(this);
		instructionsButton.addMouseListener(this);
		instructionsButton.setSize(0, 0);
		window.add(instructionsButton, BorderLayout.WEST);
		window.setLayout(null);
		instructionsButton.setBounds(1350, 130, 100, 30);
		
//solutions button
		solutionButton.setText("Solution ");
		solutionButton.setBackground(Color.WHITE);
		solutionButton.addActionListener(this);
		solutionButton.addMouseListener(this);
		solutionButton.setSize(0, 0);
		window.add(solutionButton, BorderLayout.WEST);
		solutionButton.setBounds(1350, 80, 100, 30);

	//move boat to the left bank	
		move.setText("Move");
		move.setBackground(Color.WHITE);
		move.addActionListener(this);
		move.addMouseListener(this);
		move.setSize(0, 0);
		window.add(move);
		move.setBounds(1350, 180, 100, 30);
		
	//move boat back to the right bank	
		moveback.setText("Moveback");
		moveback.setBackground(Color.WHITE);
		moveback.addActionListener(this);
		moveback.addMouseListener(this);
		moveback.setSize(0, 0);
		window.add(moveback);
		moveback.setBounds(1350, 230, 100, 30);
		moveback.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				moveright = true;
				moves++;
				numberofmoves.setText("Moves : " + moves);
			
			}
		});

		move.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				moveleft = true;
				moves++;
				numberofmoves.setText("Moves : " + moves);
			
			}
		});

		numberofmoves.setBounds(1350, 400, 100,30);
		//this.add(numberofmoves);
		window.add(numberofmoves);
		
		
		
	}

	public void paint(Graphics g) {
		ImageIcon background = new ImageIcon("F:\\Images\\story1.jpeg");
		g.drawImage(background.getImage(), 0, 0, null);
		
		
		boat.drawBoat(g);
		goat.drawAnimal(g);
		wolf.drawAnimal(g);
		plant.drawPlant(g);
		farmer.drawFarmer(g);

	}

	@Override
	public void actionPerformed(ActionEvent ib) {
		if (ib.getSource() == instructionsButton) {

			JOptionPane.showMessageDialog(null,
					" A farmer wants to cross a river and take with him a wolf,a goat, and a cabbage :" + "\n"
							+ "Rules :" + "\n"
							+ "1)- the farmer is the only one who can take one passenger either the wolf,the goat,or the cabbage  "
							+ "\n"
							+ "2)- if the wolf and the goat are alone on the same riverbank , the wolf will eat the goat."
							+ "\n"
							+ "3)- if the goat and the cabbage are alone on the same bank,the goat will eat the cabbage."
							+ "\n"
							+ "How can the farmer get the wolf, the goat ,and the cabbage across the river without any of them being eaten ?");

		} else if (ib.getSource() == solutionButton) {
			JOptionPane.showMessageDialog(null,
					"1- Farmer with the goat (cross)." + "\n" + "2-Faremer (return)." + "\n"
							+ "3- Farmer with the wolf (cross)" + "\n" + "4-Farmer with the goat(return)." + "\n"
							+ "5-Farmer with cabbage(cross)." + "\n" + "6-Farmer (return)" + "\n"
							+ "7-Farmer with the goat(cross)" + "\n\n" + "Done.");
		} else if (ib.getSource() == t) {
			if (moveleft == true) {
				if (!isvalid())
				{
					moveleft=false;
					return;
					
				}
				
				
				if (xboat > 500) {

					if (farmer.getPosition() == 1) {

						xfarmer -= 60;
						farmer.setxAxis(xfarmer);

					}
					if (goat.getPosition() == 1) {

						xgoat -= 60;
						goat.setxAxis(xgoat);

					}
					
					if (wolf.getPosition() == 1) {

						xwolf -= 60;  
						wolf.setxAxis(xwolf);

					}
					if (plant.getPosition() == 1) {

						xplant  -= 60;  
						plant.setxAxis(xplant);

					}
					
					xboat -= 60;
			        r.execute();
					repaint();
				} else {// boat is on the left bank
					
					moveleft = false;
					onleft = true;
					if (farmer.getPosition() == 1) {
						farmer.setPosition(2);
						xfarmer -= 150;
						yfarmer -= 90;
						farmer.setyAxis(yfarmer);
						farmer.setxAxis(xfarmer);
						repaint();
					}

					if (goat.getPosition() == 1) {
						goat.setPosition(2);
						xgoat -= 300;
						ygoat -=80;
						goat.setyAxis(ygoat);
						goat.setxAxis(xgoat);
						repaint();
					}
					
					if (wolf.getPosition() == 1) {
						wolf.setPosition(2);
						xwolf -= 370;
						ywolf -= 50;
						wolf.setyAxis(ywolf);
						wolf.setxAxis(xwolf);
						repaint();
					}
					if (plant.getPosition() == 1) {
						plant.setPosition(2);
						xplant -= 200;
						yplant -= 80;
						plant.setyAxis(yplant);
						plant.setxAxis(xplant);
						repaint();
					}
					

					
				}
			}
			if (moveright == true) {
				if (!isvalid())
				{moveright=false;
					return;
					
				}
				
				if (xboat < 720) {

					if (farmer.getPosition() == 1) {

						xfarmer += 60;
						farmer.setxAxis(xfarmer);

					}
					if (goat.getPosition() == 1) {

						xgoat += 60;
						goat.setxAxis(xgoat);

					}
					
					if (wolf.getPosition() == 1) {

						xwolf += 60;
						wolf.setxAxis(xwolf);

					}
					

					if (plant.getPosition() == 1) {

						xplant += 60;
						plant.setxAxis(xplant);

					}
					


					xboat += 60;
					m.execute();
					repaint();
				} else {
					
					moveright = false;
					onleft = false;
					
					if (farmer.getPosition() == 1) {
						
						farmer.setPosition(0);
						xfarmer -= 45;
						yfarmer-=120;
						farmer.setyAxis(yfarmer);
						farmer.setxAxis(xfarmer);
						repaint();
						
					}

					if (goat.getPosition() == 1) {
						
						goat.setPosition(0);
						xgoat -= 10;
						ygoat-=110;
						goat.setyAxis(ygoat);
						goat.setxAxis(xgoat);
						repaint();
					}
					
					if (wolf.getPosition() == 1) {
						
						wolf.setPosition(0);
						xwolf += 90;
						ywolf-=45;
						wolf.setyAxis(ywolf);
						wolf.setxAxis(xwolf);
						repaint();
						
					}
				
					
					if (plant.getPosition() == 1) {
						
						plant.setPosition(0);
						xplant += 190;
						yplant-=30;
						plant.setyAxis(yplant);
						plant.setxAxis(xplant);
						repaint();
					}

			}

		}
	  }
	}

	public boolean isvalid() {
		
		if (farmer.getPosition() != 1)
			return false;
		if (goat.getPosition() == wolf.getPosition())
			return false;
		if (goat.getPosition() == plant.getPosition())
			return false;
		if (farmer.getPosition()==2 && goat.getPosition()==2 && wolf.getPosition()==2 && plant.getPosition()==2)
			JOptionPane.showMessageDialog(window, "You Won");
	
		return true;

	}

	
	public void handlepressonright(int x, int y) {

		if (x >= xfarmer && x <= xfarmer + farmer.getFarmerIcon().getIconWidth()) {
			if (y >= yfarmer && y <= yfarmer + farmer.getFarmerIcon().getIconHeight())
		{
				
				
				if (farmer.getPosition()!=1) {
				xfarmer += 40;
				yfarmer += 118;
				farmer.setPosition(1);
				farmer.setyAxis(yfarmer);
				farmer.setxAxis(xfarmer);
				repaint();
			}
			
		}
		}

		else if (x >= goat.getxAxis() && x <= goat.getxAxis() + goat.getAnimalIcon().getIconWidth()) {
			
			if (y >= goat.getyAxis() && y <= goat.getyAxis() + goat.getAnimalIcon().getIconHeight()) {
				
				if (goat.getPosition()!=1) {
					
				xgoat += 40;
				ygoat += 100;
				goat.setPosition(1);
				goat.setyAxis(ygoat);
				goat.setxAxis(xgoat);
				repaint();
				
			  } 
			}		
		}
		
		else if (x >= wolf.getxAxis() && x <= wolf.getxAxis() + wolf.getAnimalIcon().getIconWidth()) {
			 
			if (y >= wolf.getyAxis() && y <= wolf.getyAxis() + wolf.getAnimalIcon().getIconHeight()) {
				
				if (wolf.getPosition()!=1) {
				xwolf -= 55;
				ywolf += 40;
				wolf.setPosition(1);
				wolf.setyAxis(ywolf);
				wolf.setxAxis(xwolf);
				wolf.setPosition(1);
				repaint();
				
				}

			}	
		}
		
		
		else if (x >= plant.getxAxis() && x <= plant.getxAxis() + plant.getPlanticon().getIconWidth()) {
			
			if (y >= plant.getyAxis() && y <= plant.getyAxis() + plant.getPlanticon().getIconHeight())	{
				
				if (plant.getPosition()!=1) {
				xplant -= 140;
				yplant +=40;
				plant.setPosition(1);
				plant.setyAxis(yplant);
				plant.setxAxis(xplant);
			
				repaint();
			}
			}
		}
	}
	
	
	public void handlepressonleft(int x, int y) {
	
		if (x >= xfarmer && x <= xfarmer + farmer.getFarmerIcon().getIconWidth()) {
			
			if (y >= yfarmer && y <= yfarmer + farmer.getFarmerIcon().getIconHeight()) {
				
				if (farmer.getPosition()!=1) {
				xfarmer += 110;
				 yfarmer += 100;
				farmer.setPosition(1);
				farmer.setyAxis(yfarmer);
				farmer.setxAxis(xfarmer);
				repaint();
				
			   }
			}
		}

		else if (x >= xgoat && x <= xgoat + goat.getAnimalIcon().getIconWidth()) {
			
			if (y >= ygoat && y <= ygoat + goat.getAnimalIcon().getIconHeight()) {
				

				if (goat.getPosition()!=1) {
				xgoat +=200;
				ygoat+=85;
				goat.setPosition(1);
				goat.setyAxis(ygoat);
				goat.setxAxis(xgoat);
				repaint();
				
				}
			}	
		}

		else if (x >= xwolf && x <= xwolf + wolf.getAnimalIcon().getIconWidth()) {
			
			if (y >= ywolf && y <= ywolf + wolf.getAnimalIcon().getIconHeight()) {
				

				if (wolf.getPosition()!=1) {
				xwolf += 300;
				ywolf +=50;
				wolf.setPosition(1);
				wolf.setyAxis(ywolf);
				wolf.setxAxis(xwolf);
				repaint();
			
				}
			}
		}
		else if (x >= xplant && x <= xplant + plant.getPlanticon().getIconWidth()) {
			
			if (y >= yplant && y <= yplant + plant.getPlanticon().getIconHeight()) {
				

				if (plant.getPosition()!=1) {
				xplant += 80;
				yplant+=80;
				plant.setPosition(1);
				plant.setyAxis(yplant);
				plant.setxAxis(xplant);
				repaint();
			
				}
			}
		}
		
	}
		

		
	
	

	@Override
	public void mouseClicked(MouseEvent e) {

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
	
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
	}

}
