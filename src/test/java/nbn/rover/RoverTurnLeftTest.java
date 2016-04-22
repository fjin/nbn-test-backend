package nbn.rover;

import org.junit.Test;

import static nbn.rover.Position.position;
import static nbn.rover.Rover.rover;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class RoverTurnLeftTest {

    @Test
    public void shouldFaceNorthGivenEast() throws Exception {
        Rover rover = rover(Direction.EAST, position(0, 0));
        rover.turnLeft();
        assertThat(rover.getDirection(), is(Direction.NORTH));
    }

    @Test
    public void shouldFaceWestGivenNorth() throws Exception {
        Rover rover = rover(Direction.NORTH, position(0, 0));
        rover.turnLeft();
        assertThat(rover.getDirection(), is(Direction.WEST));
    }

    @Test
    public void shouldFaceSouthGivenWest() throws Exception {
        Rover rover = rover(Direction.WEST, position(0, 0));
        rover.turnLeft();
        assertThat(rover.getDirection(), is(Direction.SOUTH));
    }

    @Test
    public void shouldFaceEastGivenSouth() throws Exception {
        Rover rover = rover(Direction.SOUTH, position(0, 0));
        rover.turnLeft();
        assertThat(rover.getDirection(), is(Direction.EAST));
    }

    @Test
    public void shouldStayOriginPositionGivenEast() throws Exception {
        Rover rover = rover(Direction.EAST, position(0, 0));
        rover.turnLeft();
        assertThat(rover.getPosition(), is(position(0, 0)));
    }

    @Test
    public void shouldStayOriginPositionGivenWest() throws Exception {
        Rover rover = rover(Direction.WEST, position(0, 0));
        rover.turnLeft();
        assertThat(rover.getPosition(), is(position(0, 0)));
    }

    @Test
    public void shouldStayOriginPositionGivenNorth() throws Exception {
        Rover rover = rover(Direction.NORTH, position(0, 0));
        rover.turnLeft();
        assertThat(rover.getPosition(), is(position(0, 0)));
    }

    @Test
    public void shouldStayOriginPositionGivenSouth() throws Exception {
        Rover rover = rover(Direction.SOUTH, position(0, 0));
        rover.turnLeft();
        assertThat(rover.getPosition(), is(position(0, 0)));
    }
}