/**
 * The MarsRover class will create multiple instances of a MarsRover and define
 * data This was written using TDD.
 * 
 * @author Jack Burke (J.Burke1@newcastle.ac.uk/J.burke@JPMorgan.com)
 * @since 12/08/2016
 * @version 1.0
 */
public class MarsRover {

	private int x;
	private int y;
	private String direction;

	public MarsRover(int x, int y, String direction) {
		this.x = x;
		this.y = y;
		this.direction = direction;

	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {

		this.direction = direction;

	}

	// this is a private method, only to used transitively through moveRover
	// method
	// this method will increment the x or y coordinates of the mars rover
	// depending what position its pointing to.
	private void engine() {

		if (direction.equalsIgnoreCase("N")) {
			setY(getY() + 1);
		} else if (direction.equalsIgnoreCase("S")) {
			setY(getY() - 1);
		} else if (direction.equalsIgnoreCase("E")) {
			setX(getX() + 1);
		} else if (direction.equalsIgnoreCase("W")) {
			setX(getX() - 1);
		}

	}

	public String moveRover(String[] instructions) {

		for (int a = 0; a < instructions.length; a++) {

			// move left
			if (instructions[a].equalsIgnoreCase("L")) {
    
				if (getDirection().equalsIgnoreCase("N")) {
					setDirection("W");
				} else if (getDirection().equalsIgnoreCase("S")) {
					setDirection("E");
				} else if (getDirection().equalsIgnoreCase("E")) {
					setDirection("N");
				} else if (getDirection().equalsIgnoreCase("W")) {
					setDirection("S");
				}

			}

			//move right
			if (instructions[a].equalsIgnoreCase("R")) {

				if (getDirection().equalsIgnoreCase("N")) {
					setDirection("E");
				} else if (getDirection().equalsIgnoreCase("E")) {
					setDirection("S");
				} else if (getDirection().equalsIgnoreCase("S")) {
					setDirection("W");
				} else if (getDirection().equalsIgnoreCase("W")) {
					setDirection("N");
				}

			}
			//move forward
			if (instructions[a].equalsIgnoreCase("M")) {
				engine();
			}

		}
		return this.toString();
	}
	
	public String toString(){
		
		return String.format(getX() + " " + getY() + " " + getDirection());
		
	}
}
