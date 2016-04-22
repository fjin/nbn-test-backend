package nbn.rover;

import nbn.rover.exception.OutOfPlateauException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static nbn.rover.Position.position;
import static nbn.rover.Rover.rover;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by jinf on 20/04/2016.
 */
public class RoverRunTest {

    @Rule
    public final ExpectedException expectedException = ExpectedException.none();
    private Plateau plateau;


    @Before
    public void setUp() throws Exception {
        plateau = Plateau.plateau("5 5");
    }

    @Test
    public void shouldGoLegally1() throws Exception {
        Rover rover = rover(Direction.NORTH, position(1, 2));
        rover.run("LMLMLMLMM", plateau);
        assertThat(rover.getPosition(), is(position(1, 3)));
        assertThat(rover.getDirection(), is(Direction.NORTH));
    }

    @Test
    public void shouldGoLegally2() throws Exception {
        Rover rover = rover(Direction.EAST, position(3, 3));
        rover.run("MMRMMRMRRM", plateau);
        assertThat(rover.getPosition(), is(position(5, 1)));
        assertThat(rover.getDirection(), is(Direction.EAST));
    }

    @Test
    public void shouldGoLegally3() throws Exception {
        Rover rover = rover(Direction.NORTH, position(0, 0));
        rover.run("MRMMLMRMRMMRMMML", plateau);
        assertThat(rover.getPosition(), is(position(0, 0)));
        assertThat(rover.getDirection(), is(Direction.SOUTH));
    }


    @Test
    public void shouldGoOutOfPlateau1() throws Exception {
        Plateau plateau = Plateau.plateau("3 3");
        Rover rover = rover(Direction.NORTH, position(0, 0));
        try {
            rover.run("MMMM", plateau);
        } catch (Exception e) {
            expectedException.expect(OutOfPlateauException.class);
            expectedException.expectMessage("You are out of the plateau! Current position: 0 4");
            throw new OutOfPlateauException("You are out of the plateau! Current position: 0 4");
        }
    }
}