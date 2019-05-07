package model;

import java.awt.Graphics;
import javax.swing.ImageIcon;

public class Boat {

	 private int xAxis;
	 private int yAxis;
	 private String ImagePath;
	 int position ;
	    private static Boat single_instance = null; 

	public int getPosition() {
			return position;
		}
		public void setPosition(int position) {
			this.position = position;
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
	private Boat(int xAxis, int yAxis, String imagePath, int position ) {
		super();
		this.xAxis = xAxis;
		this.yAxis = yAxis;
		ImagePath = imagePath;
		this.position=position;
		
	}
	
	  public static Boat getInstance(int xAxis , int yAxis , String imagePath, int position) 
	    { 
	        if (single_instance == null) 
	            single_instance = new Boat(xAxis, yAxis,imagePath,position); 
	  
	        return single_instance; 
	    } 
	
	
	public void drawBoat(Graphics g) {
		ImageIcon Boat =new ImageIcon(ImagePath);
		g.drawImage(Boat.getImage(), xAxis, yAxis,null);
	}
}
