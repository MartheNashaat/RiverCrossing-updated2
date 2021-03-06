package model;

import java.awt.Graphics;

import javax.swing.ImageIcon;

import river.GameCrossers;

public class Plant extends GameCrossers {
	 private int xAxis;
	 private int yAxis;
	 private String ImagePath;
	 int position ;
	 ImageIcon planticon;
	public Plant () {
		super();
		
	}
	public ImageIcon getPlanticon() {
		return planticon;
	}
//	public void setPlanticon(ImageIcon planticon) {
	//	this.planticon = planticon;
	//}
	public int getPosition() {
			return position;
		}
		public void setPosition(int position) {
			this.position = position;
		}
	public Plant(int xAxis, int yAxis, String imagePath, int position) {
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
	public void drawPlant(Graphics g) {
		planticon =new ImageIcon(ImagePath);
		g.drawImage(planticon.getImage(), xAxis, yAxis,null);
	}
}
