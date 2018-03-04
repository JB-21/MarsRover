import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
/**
* Test class for MarsRover Functionality.
* This was written using TDD.
* @author  Jack Burke (J.Burke1@newcastle.ac.uk/Jack.Burke@JPMorgan.com)
* @since   12/08/2016
* @version 1.0
*/

public class AMarsRoverShould {
	MarsRover roverTest;
	Plateau testGrid;
	MarsRover roverTestV2;
	List<MarsRover> roverHolder;
	MarsRover outOfGridRover;
	MarsRover roverTestV3;
	MarsRover directionTest;
	
	@Before
	public void initialise() {
		testGrid = new Plateau(5,5);
		roverTest = new MarsRover(1, 2, "N");
		roverTestV2 = new MarsRover(3,3,"E");
		testGrid.setMarsRover(roverTest);
		outOfGridRover = new MarsRover(2,8,"E");
		roverTestV3 = new MarsRover(1,1,"N");
		directionTest = new MarsRover(2,2,"N");
		
	}

	@Test
	public void createMultipleInstances() {
		MarsRover dummy = new MarsRover(4, 2, "W");
		
		assertNotEquals(roverTest, dummy);
	}
	
	@Test
	public void storeXAndY() {
		
		assertEquals(roverTest.getX(), 1);
		assertEquals(roverTest.getY(), 2);
	}
	
	@Test
	public void beAbleToPerformInstructions() {
		//supplied test data 1
		String[] holder = {"L","M","L","M","L","M","L","M","M"};
		roverTest.moveRover(holder);
		
		assertEquals(roverTest.getX(), 1);
		assertEquals(roverTest.getY(), 3);
		assertEquals(roverTest.getDirection(), "N");
	}
	
	@Test
	public void beAbleToPerformInstructionsOnV2() {
		// supplied test data 2
		String[] holder2 = {"M","M","R","M","M","R","M","R","R","M"};
		roverTestV2.moveRover(holder2);
		
	
		assertEquals(roverTestV2.getX(), 5);
		assertEquals(roverTestV2.getY(), 1);
		assertEquals(roverTestV2.getDirection(), "E");
	}
	
	@Test
	public void beAbleToPerformInstructionsWithOwnTestData() {
		// supplied test data 2
		String[] holder3 = {"M","M","R","M","R","M"};
		roverTestV3.moveRover(holder3);
		//4 2
		assertEquals(roverTestV3.getX(), 2);
		assertEquals(roverTestV3.getY(), 2);
		assertEquals(roverTestV3.getDirection(), "S");
	}
	@Test
	public void beAbleToMoveLeft() {
	
		String[] leftContainer = {"L"};
		directionTest.moveRover(leftContainer);
		
		assertEquals(directionTest.getDirection(), "W");
		
	}
	@Test
	public void beAbleToMoveRight() {
	
		String[] rightContainer = {"R"};
		directionTest.moveRover(rightContainer);
		
		assertEquals(directionTest.getDirection(), "E");
		
	}
	@Test
	public void beAbleToMoveup() {
		
		String[] upContainer = {"M"};
		directionTest.moveRover(upContainer);
		
		assertEquals(directionTest.getY(), 3);
	
	}
	@Test
	public void beAbleToMoveDown() {
		
		String[] downContainer = {"R","R","M"};
		directionTest.moveRover(downContainer);
		
		assertEquals(directionTest.getY(), 1);
	
	}

}
