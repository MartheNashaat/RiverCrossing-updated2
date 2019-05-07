package view;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;




import river.GameEngine.Item;
import river.GameEngine.Location;


public class GUI extends JPanel implements MouseListener {

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
/*	private final Rectangle leftFarmerRect= new Rectangle (80,215,50,50);
	private final Rectangle leftWolfRect= new Rectangle (20,215,50,50);
	private final Rectangle leftgoatRect = new Rectangle(20, 275, 50, 50);
    private final Rectangle leftcabbageRect = new Rectangle(80, 275, 50, 50);
    private final Rectangle leftBoatRect = new Rectangle(140, 275, 110, 50);
    private final Rectangle leftBoatDriverRect = new Rectangle(140, 215, 50, 50);
    private final Rectangle leftBoatPassengerRect = new Rectangle(200, 215, 50, 50);

    private final Rectangle rightFarmerRect = new Rectangle(730, 215, 50, 50);
    private final Rectangle rightWolfRect = new Rectangle(670, 215, 50, 50);
    private final Rectangle rightgoatRect = new Rectangle(670, 275, 50, 50);
    private final Rectangle rightcabbageRect = new Rectangle(730, 275, 50, 50);
    private final Rectangle rightBoatRect = new Rectangle(550, 275, 110, 50);
    private final Rectangle rightBoatDriverRect = new Rectangle(550, 215, 50, 50);
    private final Rectangle rightBoatPassengerRect = new Rectangle(610, 215, 50, 50);
	
    
    private GameEngine engine;
    
    
    public GUI() {
        
        engine = new GameEngine();
        addMouseListener(this);
        
    }
    
    public void paint(Graphics g) {
                
        g.setColor(Color.CYAN);
        
        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        color1(g);
        color2(g);
        color3(g);
    }
    //left
    
    public void color1(Graphics g) {

        if (engine.getLocation(Item.FARMER) == Location.START) {
            g.setColor(Color.MAGENTA);
            g.fillRect(80, 215, 50, 50);
        }
        
        if (engine.getLocation(Item.WOLF) == Location.START) {
            g.setColor(Color.CYAN);
            g.fillRect(20, 215, 50, 50);
            paintStringInRectangle("W", 20, 215, 50, 50, g);
        }
        if (engine.getLocation(Item.GOAT) == Location.START) {
            g.setColor(Color.CYAN);
            g.fillRect(20, 275, 50, 50);
            paintStringInRectangle("G", 20, 275, 50, 50, g);
        }
        if (engine.getLocation(Item.CABBAGE) == Location.START) {
            g.setColor(Color.CYAN);
            g.fillRect(80, 275, 50, 50);
            paintStringInRectangle("C", 80, 275, 50, 50, g);
        }
    }
    //right
    
    public void color2(Graphics g) {

        if (engine.getLocation(Item.FARMER) == Location.FINISH) {
            g.setColor(Color.MAGENTA);
            g.fillRect(730, 215, 50, 50);
        }
        if (engine.getLocation(Item.WOLF) == Location.FINISH) {
            g.setColor(Color.CYAN);
            g.fillRect(670, 215, 50, 50);
            paintStringInRectangle("W", 670, 215, 50, 50, g);
        }
        if (engine.getLocation(Item.GOAT) == Location.FINISH) {
            g.setColor(Color.CYAN);
            g.fillRect(670, 275, 50, 50);
            paintStringInRectangle("G", 670, 275, 50, 50, g);
        }
        if (engine.getLocation(Item.CABBAGE) == Location.FINISH) {
            g.setColor(Color.CYAN);
            g.fillRect(730, 275, 50, 50);
            paintStringInRectangle("C", 730, 275, 50, 50, g);
        }
    }
    
   //boat
    public void color3(Graphics g) {
    	
        if (engine.getCurrentLocation() == Location.START) {
            g.setColor(Color.ORANGE);
            g.fillRect(140, 275, 110, 50);
            if (engine.getLocation(Item.FARMER) == Location.BOAT) {
                g.setColor(Color.MAGENTA);
                g.fillRect(140, 215, 50, 50);
            }
            if (engine.getLocation(Item.WOLF) == Location.BOAT) {
                g.setColor(Color.CYAN);
                g.fillRect(200, 215, 50, 50);
                paintStringInRectangle("W", 200, 215, 50, 50, g);
            } else if (engine.getLocation(Item.GOAT) == Location.BOAT) {
                g.setColor(Color.CYAN);
                g.fillRect(200, 215, 50, 50);
                paintStringInRectangle("G", 200, 215, 50, 50, g);               
            } else if (engine.getLocation(Item.CABBAGE) == Location.BOAT) {
                g.setColor(Color.CYAN);
                g.fillRect(200, 215, 50, 50);
                paintStringInRectangle("C", 200, 215, 50, 50, g);               
            }
        }
        if (engine.getCurrentLocation() == Location.FINISH) {
            g.setColor(Color.ORANGE);
            g.fillRect(550, 275, 110, 50);
            if (engine.getLocation(Item.FARMER) == Location.BOAT) {
                g.setColor(Color.MAGENTA);
                g.fillRect(550, 215, 50, 50);
            }
            if (engine.getLocation(Item.WOLF) == Location.BOAT) {
                g.setColor(Color.CYAN);
                g.fillRect(610, 215, 50, 50);
                paintStringInRectangle("W", 610, 215, 50, 50, g);
            } else if (engine.getLocation(Item.GOAT) == Location.BOAT) {
                g.setColor(Color.CYAN);
                g.fillRect(610, 215, 50, 50);
                paintStringInRectangle("G", 610, 215, 50, 50, g);               
            } else if (engine.getLocation(Item.CABBAGE) == Location.BOAT) {
                g.setColor(Color.CYAN);
                g.fillRect(610, 215, 50, 50);
                paintStringInRectangle("C", 610, 215, 50, 50, g);               
            }
        }
    }
    
    public void paintStringInRectangle(String str, int x, int y, int width, int height, Graphics g) {
        g.setColor(Color.BLACK);
        g.setFont(new Font("Verdana", Font.BOLD, 36));
        FontMetrics fm = g.getFontMetrics();
        int strXCoord = x + width/2 - fm.stringWidth(str)/2;
        int strYCoord = y + height/2 + 36/2 - 4;
        g.drawString(str, strXCoord, strYCoord);
    }
    
    
    /**
     * Create the GUI and show it.  For thread safety, 
     * this method should be invoked from the 
     * event-dispatching thread.
     */
 /*   private static void createAndShowGUI() {
        
        // Create and set up the window
        JFrame frame = new JFrame("RiverCrossing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create and set up the content pane
        GUI newContentPane = new GUI();
        newContentPane.setOpaque(true);        
        frame.setContentPane(newContentPane);
        
        // Display the window
        frame.setSize(800, 600);
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(GUI::createAndShowGUI);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        if (leftFarmerRect.contains(e.getPoint())) {
            if (engine.getLocation(Item.FARMER) == Location.START) {
                engine.move(Item.FARMER);
            }
        } else if (leftWolfRect.contains(e.getPoint())) {
            if (engine.getLocation(Item.WOLF) == Location.START) {
                engine.move(Item.WOLF);
            }
        } else if (leftgoatRect.contains(e.getPoint())) {
            if (engine.getLocation(Item.GOAT) == Location.START) {
                engine.move(Item.GOAT);
            }
        } else if (leftcabbageRect.contains(e.getPoint())) {
            if (engine.getLocation(Item.CABBAGE) == Location.START) {
                engine.move(Item.CABBAGE);
            }
        } else if (leftBoatDriverRect.contains(e.getPoint())) {
            if (engine.getCurrentLocation() == Location.START &&
                    engine.getLocation(Item.FARMER) == Location.BOAT) {
                engine.unmove();
            }
        } else if (leftBoatPassengerRect.contains(e.getPoint())) {
            if (engine.getCurrentLocation() == Location.START &&
                    (engine.getLocation(Item.WOLF) == Location.BOAT ||
                    engine.getLocation(Item.GOAT) == Location.BOAT ||
                    engine.getLocation(Item.CABBAGE) == Location.BOAT)) {
                engine.unmove();
            }
        } else if (leftBoatRect.contains(e.getPoint())) {
            if (engine.getCurrentLocation() == Location.START &&
                    engine.getLocation(Item.FARMER) == Location.BOAT) {
                engine.RowBoat();
            }
        } else if (rightFarmerRect.contains(e.getPoint())) {
            if (engine.getLocation(Item.FARMER) == Location.FINISH) {
                engine.move(Item.FARMER);
            }
        } else if (rightWolfRect.contains(e.getPoint())) {
            if (engine.getLocation(Item.WOLF) == Location.FINISH) {
                engine.move(Item.WOLF);
            }
        } else if (rightgoatRect.contains(e.getPoint())) {
            if (engine.getLocation(Item.GOAT) == Location.FINISH) {
                engine.move(Item.GOAT);
            }
        } else if (rightcabbageRect.contains(e.getPoint())) {
            if (engine.getLocation(Item.CABBAGE) == Location.FINISH) {
                engine.move(Item.CABBAGE);
            }
        } else if (rightBoatDriverRect.contains(e.getPoint())) {
            if (engine.getCurrentLocation() == Location.FINISH &&
                    engine.getLocation(Item.FARMER) == Location.BOAT) {
                engine.unmove();
            }
        } else if (rightBoatPassengerRect.contains(e.getPoint())) {
            if (engine.getCurrentLocation() == Location.FINISH &&
                    (engine.getLocation(Item.WOLF) == Location.BOAT ||
                    engine.getLocation(Item.GOAT) == Location.BOAT ||
                    engine.getLocation(Item.CABBAGE) == Location.BOAT)) {
                engine.unmove();
            }
        } else if (rightBoatRect.contains(e.getPoint())) {
            if (engine.getCurrentLocation() == Location.FINISH &&
                    engine.getLocation(Item.FARMER) == Location.BOAT) {
                engine.RowBoat();
            }
        } else {
            return;
        }
     
        repaint();
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

    
	
	
	//////////////////
	 * import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class MyMainClass {

    public static void main(String[] args) {
        new MyMainClass();
    }

    public MyMainClass() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JLayeredPane {

        public TestPane() {
            File[] images = new File("C:\\Users\\ASSEM\\Desktop\\New folder").listFiles(new FileFilter() {
                @Override
                public boolean accept(File pathname) {
                    String name = pathname.getName().toLowerCase();
                    return name.endsWith(".png") || 
                                    name.endsWith(".jpg") || 
                                    name.endsWith(".bmp") ||
                                    name.endsWith(".gif");
                }
            });

            int x = 0;
            int y = 0;
            for (File imgFile : images) {

                try {
                    BufferedImage img = ImageIO.read(imgFile);
                    JLabel label = new JLabel(new ImageIcon(img));
                    label.setSize(label.getPreferredSize());
                    label.setLocation(x, y);
                    MouseHandler mh  = new MouseHandler();
                    label.addMouseListener(mh);
                    label.addMouseMotionListener(mh);
                    add(label);
                    x += 20;
                    y += 20;
                } catch (IOException exp) {
                    exp.printStackTrace();
                }

            }

        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(800, 800);
        }

        public class MouseHandler extends MouseAdapter {

            private Point offset;

            @Override
            public void mousePressed(MouseEvent e) {
                JLabel label = (JLabel) e.getComponent();
                moveToFront(label);
                offset = e.getPoint();
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                int x = e.getPoint().x - offset.x;
                int y = e.getPoint().y - offset.y;
                Component component = e.getComponent();
                Point location = component.getLocation();
                location.x += x;
                location.y += y;
                component.setLocation(location);
            }

        }

    }

}
//////////////////////////////////////
	
	


	
	

}*/
