package river;

import java.awt.Graphics;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;

public class Farmer1 {
 private int xAxis;
 private int yAxis;
 private String ImagePath;
 ImageIcon farmerIcon ;
int position ;
	
 public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

public ImageIcon getFarmerIcon() {
	return farmerIcon;
	
}

public Farmer1(int xAxis, int yAxis, String imagePath, int position) {
	super();
	this.xAxis = xAxis;
	this.yAxis = yAxis;
	ImagePath = imagePath;
	this.position= position;
	

}

public int getxAxis() {
	return xAxis;
}

public void setxAxis(int xAxis) {
	this.xAxis = xAxis;
}

public int getyAxis() {
	return yAxis;
}

public void setyAxis(int yAxis) {
	this.yAxis = yAxis;
}

public String getImagePath() {
	return ImagePath;
}

public void setImagePath(String imagePath) {
	ImagePath = imagePath;
}
public void drawFarmer(Graphics g) {
	 farmerIcon =new ImageIcon(ImagePath);
	g.drawImage(farmerIcon.getImage(), xAxis, yAxis,null);
}

public void addMouseListener(MouseListener mouseListener) {
	
	
}

public void drawFarmer(String string) {
	// TODO Auto-generated method stub
	
}

}
