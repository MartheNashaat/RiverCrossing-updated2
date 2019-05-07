package river;

import model.Plant;
import model.farmer;
import model.goat;
import model.wolf;

public class Factory {
	 //use getShape method to get object of type shape 
	   public GameCrossers getShape(String shapeType){
	      if(shapeType == null){
	         return null;
	      }		
	      if(shapeType.equalsIgnoreCase("Farmer")){
	         return new farmer();
	         
	      } else if(shapeType.equalsIgnoreCase("Wolf")){
	         return new wolf();
	         
	      } else if(shapeType.equalsIgnoreCase("goat")){
	         return new goat();
	      }
	      else if (shapeType.equalsIgnoreCase("Plant")) {
	    	  return new Plant();
	      }
	      
	      return null;
	   }
	



}
