package river;

public class GameEngine {

	public enum Item {
		WOLF, GOAT, CABBAGE, FARMER;
	}

	public enum Location {
		START, FINISH, BOAT;
	}

	private GameCrossers wolf;
	private GameCrossers goat;
	private GameCrossers cabbage;
	private GameCrossers farmer;
	private Location CurrentLocation;

	public GameEngine() {
		wolf = new wolf();
		goat = new goat();
		cabbage = new cabbage();
		farmer = new farmer();
		CurrentLocation = Location.START;
	}

	public String getName(Item id) {

		switch (id) {
		case WOLF:
			return wolf.getName();
		case GOAT:
			return goat.getName();
		case CABBAGE:
			return cabbage.getName();

		default:
			return farmer.getName();

		}
	}

	public Location getLocation(Item id) {
		switch (id) {
		case WOLF:
			return wolf.getLocation();
		case GOAT:
			return goat.getLocation();
		case CABBAGE:
			return cabbage.getLocation();
		default:
			return farmer.getLocation();
			
		}

	}

	public Location getCurrentLocation() {
		return CurrentLocation;
	}

//conditions for moving the boat
	public void move(Item id) {
		switch (id) {
		case WOLF:
			if (wolf.getLocation() == CurrentLocation && goat.getLocation() != Location.BOAT	&& cabbage.getLocation() != Location.BOAT) {
				wolf.setLocation(Location.BOAT);
			}
			break;
		case CABBAGE:
			if (cabbage.getLocation() == CurrentLocation && wolf.getLocation() != Location.BOAT
					&& goat.getLocation() != Location.BOAT) {
				cabbage.setLocation(Location.BOAT);
			}
			break;
		default:
//add farmer
		}
	}

//conditions for setting the current location
	public void unmove() {
		if (wolf.getLocation() == Location.BOAT) {
			wolf.setLocation(CurrentLocation);

		} else if (goat.getLocation() == Location.BOAT) {
			goat.setLocation(CurrentLocation);
		} else if (cabbage.getLocation() == Location.BOAT) {
			cabbage.equals(CurrentLocation);
		}
	
	}

	public void RowBoat() {
		assert (CurrentLocation != Location.BOAT);
		if (CurrentLocation == Location.START) {
			CurrentLocation = Location.FINISH;
			farmer.setLocation(Location.FINISH);

		} else {
			CurrentLocation = Location.START;
			farmer.setLocation(Location.START);
		}

	}

public boolean win() {
	 return wolf.getLocation()== Location.FINISH && goat.getLocation() == Location.FINISH && cabbage.getLocation()== Location.FINISH;
	
}

public boolean lost() {
	
	if (goat.getLocation()== Location.BOAT)
		return false;
	else if (goat.getLocation()!= farmer.getLocation() && goat.getLocation() == wolf.getLocation() )
		return true;
	else if (goat.getLocation() != farmer.getLocation() && goat.getLocation() == cabbage.getLocation())
		return true;

	return false; 
	
		
}
}
