import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
/**
* Test class for Plateau Functionality.
* This was written using TDD.
* @author  Jack Burke (J.Burke1@newcastle.ac.uk/Jack.Burke@JPMorgan.com)
* @since   12/08/2016
* @version 1.0
*/

public class APlateauShould {
	MarsRover roverTest;
	Plateau testGrid;
	MarsRover roverTestV2;
	MarsRover outOfGridRover;
	List<MarsRover> roverHolder;

	
	@Before
	public void initialise() {
		testGrid = new Plateau(5,5);
		roverTest = new MarsRover(1, 2, "N");
		roverTestV2 = new MarsRover(3,3,"E");
		testGrid.setMarsRover(roverTest);
		outOfGridRover = new MarsRover(2,8,"E");
		
	}
	
	@Test
	public void storeXandYCoordinates() {
		
		assertEquals(roverTest.getX(), 1);
		assertEquals(roverTest.getY(), 2);
		
	}
	
	@Test
	public void beAbleToAddARover() {
		
		assertEquals(testGrid.getMarsRover(), roverTest);
		
	}
	
	@Test
	public void beAbleToAddMultipleRovers() {
		testGrid.setMarsRover(roverTestV2);
		roverHolder = new ArrayList<MarsRover>();
		roverHolder.add(roverTest);
		roverHolder.add(roverTestV2);
		
		assertEquals(testGrid.getAllMarsRovers(), roverHolder);
		
		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void notAddRoverIfOverBoundies() {
		
		testGrid.setMarsRover(outOfGridRover);
		
	}
	
	}
