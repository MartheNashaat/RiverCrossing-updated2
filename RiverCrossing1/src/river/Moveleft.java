package river;

import model.Boat;

public class Moveleft implements Command {
 Boat boat;
	
	public Moveleft (Boat boat)
	{this.boat=boat;
	
	}
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		boat.setxAxis(boat.getxAxis()+ 60);
		
		
		
	}

}
