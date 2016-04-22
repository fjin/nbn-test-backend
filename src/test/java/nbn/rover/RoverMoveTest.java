package nbn.rover;

import org.junit.Test;

import static nbn.rover.Position.position;
import static nbn.rover.Rover.rover;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by jinf on 20/04/2016.
 */
public class RoverMoveTest {
    @Test
    public void shouldAddYFacingNorth() throws Exception {
        Rover rover = rover(Direction.NORTH, position(0, 0));
        rover.move();
        assertThat(rover.getPosition(), is(position(0, 1)));
    }

    @Test
    public void shouldAddXFacingEast() throws Exception {
        Rover rover = rover(Direction.EAST, position(0, 0));
        rover.move();
        assertThat(rover.getPosition(), is(position(1, 0)));
    }

    @Test
    public void shouldSubYFacingNorth() throws Exception {
        Rover rover = rover(Direction.SOUTH, position(0, 0));
        rover.move();
        assertThat(rover.getPosition(), is(position(0, -1)));
    }

    @Test
    public void shouldSubXFacingWest() throws Exception {
        Rover rover = rover(Direction.WEST, position(0, 0));
        rover.move();
        assertThat(rover.getPosition(), is(position(-1, 0)));
    }

    @Test
    public void shouldKeepOriginDirectionFacingNorth() throws Exception {
        Rover rover = rover(Direction.NORTH, position(0, 0));
        rover.move();
        assertThat(rover.getDirection(), is(Direction.NORTH));
    }

    @Test
    public void shouldKeepOriginDirectionFacingWest() throws Exception {
        Rover rover = rover(Direction.WEST, position(0, 0));
        rover.move();
        assertThat(rover.getDirection(), is(Direction.WEST));
    }

    @Test
    public void shouldKeepOriginDirectionFacingSouth() throws Exception {
        Rover rover = rover(Direction.SOUTH, position(0, 0));
        rover.move();
        assertThat(rover.getDirection(), is(Direction.SOUTH));
    }

    @Test
    public void shouldKeepOriginDirectionFacingEast() throws Exception {
        Rover rover = rover(Direction.EAST, position(0, 0));
        rover.move();
        assertThat(rover.getDirection(), is(Direction.EAST));
    }
}
