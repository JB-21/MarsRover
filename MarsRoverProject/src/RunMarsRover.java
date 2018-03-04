import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class will in take user input from the console for data to be passed
 * through both the MarsRover and Grid classes this class will also act as a
 * string parser after it takes an input This was written using TDD.
 * 
 * @author Jack Burke (J.Burke1@newcastle.ac.uk/J.burke@JPMorgan.com)
 * @since 12/08/2016
 * @version 1.0
 */

public class RunMarsRover {

	public static void main(String[] args) {

		// Create variables
		MarsRover rover;
		Pattern defineGrid = Pattern.compile("\\d\\s\\d+");
		Pattern placeRover = Pattern.compile("\\d\\s\\d\\s[neswNESW]+");
		Pattern instructions = Pattern.compile("[mlrMLR]+");
		boolean exCheckPlaceRover = false;
		boolean exCheckRoverPos = false;
		boolean exCheckInstructions = false;
		boolean checker = false;
		Matcher match;

		System.out.print("Define Grid coordinates:");
		// create new scanner to intake input from console
		Scanner scanLine = new Scanner(System.in);
		// take input from first line and save as a string
		String gridInput = scanLine.nextLine();

		// match input with defineInput Regex
		match = defineGrid.matcher(gridInput);
		exCheckRoverPos = match.matches();

		// if input does not satisfy defineGrid regex, exit application.
		// as the code is ina while loop, give the user the option to kill the
		// application with "exit" key word
		if (gridInput.equalsIgnoreCase("exit")) {
			System.exit(0);
		} else if (exCheckRoverPos != true) {
			System.out.println("Please enter your input in the correct format");
			System.exit(0);
		}

		// if the input string passes checks, split at every white space and
		// save in a array
		String[] splited = gridInput.split("\\s+");

		// parse first and second element in the array as a integer and save
		// them as x and y
		int x = Integer.parseInt(splited[0]);
		int y = Integer.parseInt(splited[1]);

		// create a new grid object and pass in the x and y parameters
		Plateau grid = new Plateau(x, y);

		// repeat process multiple times until user want to quit by using the
		// "exit" key word
		while (checker != true) {

			// take in next string to place mars rover
			System.out.print("Define Mars Rover coordinates and position:");
			String RoverInput = scanLine.nextLine();

			// match input with placeRover Regex
			match = placeRover.matcher(RoverInput);
			exCheckPlaceRover = match.matches();

			// if input does not satisfy defineGrid regex, exit application.
			// as the code is in while loop, give the user the option to kill
			// the application with "exit" key word
			if (RoverInput.equalsIgnoreCase("exit")) {
				System.exit(0);
			} else if (exCheckPlaceRover != true) {
				System.out
						.println("Please enter your input in the correct format eg. 1 2 N LMLMRMM");
				// rerun while loop
				continue;
			}

			// if the input string passes checks, split at every white space and
			// save in a array
			String[] splitedPosition = RoverInput.split("\\s+");

			// parse strings to integer
			int xRover = Integer.parseInt(splitedPosition[0]);
			int yRover = Integer.parseInt(splitedPosition[1]);
			String position = splitedPosition[2];

			// create new mars rover with the variables passed in through the
			// command line
			rover = new MarsRover(xRover, yRover, position);

			// try to add the mars rover to the grid, if it catches an
			// IllegalArgumentException
			// alert the user and ask them to input the details again
			try {
				grid.setMarsRover(rover);
			} catch (IllegalArgumentException e) {
				System.out
						.println("You have not placed the Mars Rover on the grid defined, please try again");
				// rerun while loop
				continue;
			}

			System.out.print("Define Mars Rover instructions:");
			// take next line for instructions on how to move the rover
			String instructionInput = scanLine.nextLine();

			// check regex pattern of input against predefined value
			match = instructions.matcher(instructionInput);
			exCheckInstructions = match.matches();

			// if input does not satisfy the regex, exit application.
			// as the code is in while loop, give the user the option to kill
			// the application with "exit" key word
			if (instructionInput.equalsIgnoreCase("exit")) {
				checker = false;
			} else if (exCheckInstructions != true) {
				System.out
						.println("Please enter your input in the correct format g. 1 2 N LMLMRMM");
				// rerun while loop
				continue;

			}
			// if the input string passes all regex checks, split after every
			// character and save it into an array
			String[] splitedInstructions = instructionInput.split("");

			// call the moveRover function to perform the instructions, this
			// will return its x, y coordinates as well as direction
			// split the string to get the rovers x and y coordinates
			String result = rover.moveRover(splitedInstructions);
			String[] splitResult = result.split(" ");
			int resultX = Integer.parseInt(splitResult[0]);
			int resultY = Integer.parseInt(splitResult[1]);

			// check to see if the x and y coordinates of the mars rover is
			// still placed on the grid
			if ((resultX > grid.getX() || resultX < 0)
					|| (resultY > grid.getY() || resultY < 0)) {
				System.out
						.println("You Have Navigated you're rover off the grid, please try again");
				continue;
			} else {
				System.out.println("your rover has moved to: " + result);
			}
		}

	}
}
