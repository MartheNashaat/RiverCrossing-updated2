package river;

import model.Boat;

public class Moveright implements Command {
Boat boat;

public Moveright(Boat boat)
{
	this.boat= boat;
}
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		boat.setxAxis(boat.getxAxis()- 60);	
	}

}
