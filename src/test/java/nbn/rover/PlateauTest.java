package nbn.rover;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by jinf on 20/04/2016.
 */
public class PlateauTest {
    @Test
    public void plateau() throws Exception {
        Plateau plateau = Plateau.plateau(5,5);
        assertThat(plateau.getWidth(), is(5));
        assertThat(plateau.getHeight(), is(5));
    }

    @Test
    public void plateau1() throws Exception {
        Plateau plateau = Plateau.plateau("5 5");
        assertThat(plateau.getWidth(), is(5));
        assertThat(plateau.getHeight(), is(5));
    }

    @Test
    public void shouldSetWidth() throws Exception {
        Plateau plateau = Plateau.plateau("5 5");
        plateau.setWidth(9);
        assertThat(plateau.getWidth(), is(9));

    }

    @Test
    public void shouldSetHeight() throws Exception {
        Plateau plateau = Plateau.plateau("5 5");
        plateau.setHeight(10);
        assertThat(plateau.getHeight(), is(10));
    }

    @Test
    public void shouldBeOutTrue() throws Exception {
        Plateau plateau = Plateau.plateau("5 5");
        Position position = Position.position(6,4);
        assertThat(plateau.isOut(position), is(true));
    }

    @Test
    public void shouldBeOutNegativeTrue() throws Exception {
        Plateau plateau = Plateau.plateau("5 5");
        Position position = Position.position(-1,4);
        assertThat(plateau.isOut(position), is(true));
    }

    @Test
    public void shouldBeOutFalse() throws Exception {
        Plateau plateau = Plateau.plateau("5 5");
        Position position = Position.position(4,4);
        assertThat(plateau.isOut(position), is(false));
    }

}