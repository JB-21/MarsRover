import java.util.ArrayList;
import java.util.List;
/**
* This class defines the canvas on which MarsRover objects can be placed
* This was written using TDD.
* @author  Jack Burke (J.Burke1@newcastle.ac.uk/J.burke@JPMorgan.com)
* @since   12/08/2016
* @version 1.0
*/

public class Plateau {

	private final int x;
	private final int y;
	private MarsRover rover;
	private List<MarsRover> roverHolder = new ArrayList<MarsRover>();

	// input x and y defines upper-right limit coordinates
	public Plateau(int x, int y) {

		this.x = x;
		this.y = y;

	}

	public void setMarsRover(MarsRover rover) {

		if (rover.getX() > x || rover.getX() < 0) {

			throw new IllegalArgumentException(
					"You have placed the rover off the grid");
		}

		if (rover.getY() > x || rover.getY() < 0) {

			throw new IllegalArgumentException(
					"You have placed the rover off the grid");
		}

		this.rover = rover;

		roverHolder.add(rover);

	}

	public MarsRover getMarsRover() {

		return rover;
	}

	public int getX() {
		return x;
	}



	public int getY() {
		return y;
	}


	public List<MarsRover> getAllMarsRovers() {

		return roverHolder;

	}
	
	public String toString() {
		
		return String.format("Plateau Coordianates: X - "+getX()+" Y - "+ getY());
	}

}
