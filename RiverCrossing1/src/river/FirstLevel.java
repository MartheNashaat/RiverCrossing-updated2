package river;

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
	int xfarmer = 460;
	int yfarmer = 260;
	int xboat = 400;
	int yboat = 350;
	int xgoat = 480;
	int ygoat = 299;
	int xwolf =510;
	int ywolf =300;
	int xplant = 570;
	int yplant = 320;
	
	

	Timer t = new Timer(170, this);
	Farmer1 farmer = new Farmer1(xfarmer, yfarmer, "F:\\Images\\farmerr.png", 0);

//	Farmer1 farmer= new Farmer1(380,220,"F:\\codeblocks trials\\zarafa.png");

	Animal wolf = new Animal(xwolf, ywolf, "F:\\Images\\wol.png", 0);
	Animal goat = new Animal(xgoat, ygoat, "F:\\Images\\gg.png", 0);
	Boat boat = new Boat(xboat, yboat, "F:\\Images\\bb.png", 0); //
	Plant plant = new Plant(xplant, yplant, "F:\\Images\\plantt.png", 0);
//	Plant plant=new Plant(230,350,"images//grass.png");
	JButton instructionsButton = new JButton();
	JButton solutionButton = new JButton();
	JLabel fa = new JLabel();
	JButton move = new JButton();
	JButton moveback = new JButton();

	FirstLevel() throws IOException {
		t.start();
		window.add(this);
		window.setSize(1300, 620);
		window.setLocation(40, 20);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		
//instructions button		
		instructionsButton.setText("Instructions ");
		instructionsButton.setBackground(Color.WHITE);
		// instructionsButton.setIcon (new ImageIcon("images//instr..jpg"));
		instructionsButton.addActionListener(this);
		// instructionsButton.addKeyListener(this);
		instructionsButton.addMouseListener(this);
		instructionsButton.setSize(0, 0);
		window.add(instructionsButton, BorderLayout.WEST);
		window.setLayout(null);
		instructionsButton.setBounds(700, 130, 100, 30);
		
//solutions button
		solutionButton.setText("Solution ");
		solutionButton.setBackground(Color.WHITE);
		// instructionsButton.setIcon (new ImageIcon("images//instr..jpg"));
		solutionButton.addActionListener(this);
		solutionButton.addMouseListener(this);
		solutionButton.setSize(0, 0);
		window.add(solutionButton, BorderLayout.WEST);
		solutionButton.setBounds(700, 80, 100, 30);

	//move boat to the left bank	
		move.setText("Move");
		move.setBackground(Color.WHITE);
		move.addActionListener(this);
		move.addMouseListener(this);
		move.setSize(0, 0);
		window.add(move);
		move.setBounds(700, 180, 100, 30);
		
	//move boat back to the right bank	
		moveback.setText("Moveback");
		moveback.setBackground(Color.WHITE);
		moveback.addActionListener(this);
		moveback.addMouseListener(this);
		moveback.setSize(0, 0);
		window.add(moveback);
		moveback.setBounds(700, 230, 100, 30);
		moveback.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				moveright = true;
				// TODO Auto-generated method stub

			}
		});

		move.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				moveleft = true;

				
			}
		});

	}

	public void paint(Graphics g) {
		ImageIcon background = new ImageIcon("F:\\Images\\Background.jpg");
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
				
				
				if (xboat > 200) {

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
						//ywolf = +30;
					//	wolf.setyAxis(ywolf);
						wolf.setxAxis(xwolf);

					}
					if (plant.getPosition() == 1) {

						xplant  -= 60;  
						//ywolf = +30;
					//	wolf.setyAxis(ywolf);
						plant.setxAxis(xplant);

					}
					
					xboat -= 60;
					boat.setxAxis(xboat);

					repaint();
				} else {// boat is on the left bank
					moveleft = false;
					onleft = true;
					if (farmer.getPosition() == 1) {
						farmer.setPosition(2);
						xfarmer -= 90;
						farmer.setxAxis(xfarmer);
						repaint();
					}

					if (goat.getPosition() == 1) {
						goat.setPosition(2);
						xgoat -= 30;
						goat.setxAxis(xgoat);
						repaint();
					}
					
					if (wolf.getPosition() == 1) {
						wolf.setPosition(2);
						xwolf -= 100;
					//	ywolf += 150;
						wolf.setyAxis(ywolf);
						wolf.setxAxis(xwolf);
						repaint();
					}
					if (plant.getPosition() == 1) {
						plant.setPosition(2);
						xplant -= 200;
						yplant += 30;
						plant.setyAxis(yplant);
						plant.setxAxis(xplant);
						repaint();
					}
					

					
				}
			}
			if (moveright == true) {
				if (xboat < 400) {

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
						//ywolf = +30;
						//wolf.setyAxis(ywolf);
						wolf.setxAxis(xwolf);

					}
					

					if (plant.getPosition() == 1) {

						xplant += 60;
						//ywolf = +30;
						//wolf.setyAxis(ywolf);
						plant.setxAxis(xplant);

					}
					


					xboat += 60;
					boat.setxAxis(xboat);

					repaint();
				} else {
					moveright = false;
					onleft = false;
					if (farmer.getPosition() == 1) {
						farmer.setPosition(0);
						xfarmer += 60;
						yfarmer-=30;
						farmer.setyAxis(yfarmer);
						farmer.setxAxis(xfarmer);
						repaint();
					}

					if (goat.getPosition() == 1) {
						goat.setPosition(0);
						xgoat += 60;
						ygoat-=30;
						goat.setyAxis(ygoat);
						goat.setxAxis(xgoat);
						repaint();
					}
					
					if (wolf.getPosition() == 1) {
						wolf.setPosition(0);
						xwolf += 60;
						ywolf-=30;
						wolf.setyAxis(ywolf);
						wolf.setxAxis(xwolf);
						repaint();
					}
				
					
					if (plant.getPosition() == 1) {
						plant.setPosition(0);
						xplant += 60;
						yplant-=30;
						plant.setyAxis(yplant);
						plant.setxAxis(xplant);
						repaint();
					}
				

			}

		}
	  }
	}

/*	public boolean isvalid() {
		if (farmer.getPosition() != 1)
			return false;
		if (goat.getPosition() == wolf.getPosition())
			return false;
		if (goat.getPosition() == plant.getPosition())
			return false;

		return true;

	}
*/
	public void move(Item id) {
		switch (id) {
		case WOLF:
			if (wolf.getPosition() == 0 && goat.getPosition() != 1	&& plant.getPosition() != 1) {
				wolf.setPosition(1);
				farmer.setPosition(1);
				goat.setPosition(0);
			}
			break;
	/*	case CABBAGE:
			if (cabbage.getLocation() == CurrentLocation && wolf.getLocation() != Location.BOAT
					&& goat.getLocation() != Location.BOAT) {
				cabbage.setLocation(Location.BOAT);
			}
			break;*/
		default:
//add farmer
		}
	}
	
	
	
	
	public void handlepressonright(int x, int y) {

		if (x >= xfarmer && x <= xfarmer + farmer.getFarmerIcon().getIconWidth()) {
			if (y >= yfarmer && y <= yfarmer + farmer.getFarmerIcon().getIconHeight())
		{
				
				

				xfarmer -= 60;
				yfarmer += 30;
				farmer.setPosition(1);
				farmer.setyAxis(yfarmer);
				farmer.setxAxis(xfarmer);
				repaint();
			}
			

		}

		else if (x >= goat.getxAxis() && x <= goat.getxAxis() + goat.getAnimalIcon().getIconWidth()) {
			if (y >= goat.getyAxis() && y <= goat.getyAxis() + goat.getAnimalIcon().getIconHeight()) {
				xgoat -= 60;
				ygoat += 30;
				goat.setPosition(1);
				goat.setyAxis(ygoat);
				goat.setxAxis(xgoat);
			//	goat.setPosition(1);
				repaint();
			}

		}
		
		else if (x >= wolf.getxAxis() && x <= wolf.getxAxis() + wolf.getAnimalIcon().getIconWidth()) {
			if (y >= wolf.getyAxis() && y <= wolf.getyAxis() + wolf.getAnimalIcon().getIconHeight()) 
			{
				xwolf -= 60;
				//ywolf += 30;
				wolf.setPosition(1);
				//wolf.setyAxis(ywolf);
				wolf.setxAxis(xwolf);
				wolf.setPosition(1);
				repaint();
			}

		}
		
		
		else if (x >= plant.getxAxis() && x <= plant.getxAxis() + plant.getPlanticon().getIconWidth()) {
			if (y >= plant.getyAxis() && y <= plant.getyAxis() + plant.getPlanticon().getIconHeight())
				{
				xplant -= 120;
				yplant += 10;
				plant.setPosition(1);
				//wolf.setyAxis(ywolf);
				plant.setxAxis(xplant);
				plant.setPosition(1);
				repaint();
			}

		}
		}
	
	
	public void handlepressonleft(int x, int y) {
	
		if (x >= xfarmer && x <= xfarmer + farmer.getFarmerIcon().getIconWidth()) {
			if (y >= yfarmer && y <= yfarmer + farmer.getFarmerIcon().getIconHeight()) {

				xfarmer += 60;
				// yfarmer += 20;
				farmer.setPosition(1);
				farmer.setyAxis(yfarmer);
				farmer.setxAxis(xfarmer);
				repaint();
			}

		}

		else	if (x >= xgoat && x <= xgoat + goat.getAnimalIcon().getIconWidth()) {
			if (y >= ygoat && y <= ygoat + goat.getAnimalIcon().getIconHeight()) {

				xgoat += 60;
				// yfarmer += 20;
				goat.setPosition(1);
				goat.setyAxis(ygoat);
				goat.setxAxis(xgoat);
				repaint();
			}

		}

		else	if (x >= xwolf && x <= xwolf + wolf.getAnimalIcon().getIconWidth()) {
			if (y >= ywolf && y <= ywolf + wolf.getAnimalIcon().getIconHeight()) {

				xwolf += 50;
				//ywolf -=30;
				
				// yfarmer += 20;
				wolf.setPosition(1);
				wolf.setyAxis(ywolf);
				wolf.setxAxis(xwolf);
				repaint();
			}

		}
		else	if (x >= xplant && x <= xplant + plant.getPlanticon().getIconWidth()) {
			if (y >= yplant && y <= yplant + plant.getPlanticon().getIconHeight()) {

				xplant += 50;
				//ywolf -=30;
				
				// yfarmer += 20;
				plant.setPosition(1);
				plant.setyAxis(yplant);
				plant.setxAxis(xplant);
				repaint();
			}

		}
	}

		
	
	

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
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

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
