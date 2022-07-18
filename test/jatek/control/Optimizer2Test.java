package jatek.control;

import jatek.constant.TrackElement;
import jatek.model.EmptySpace;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class Optimizer2Test {

    private TrackElement[][] track;
    private Optimizer2 optimizer = new Optimizer2();

    @Before
    public void setUp() throws Exception {
        track = new TrackElement[4][12];
        // első sor
        track[3][0 ] = TrackElement.POINT;
        track[3][1 ] = TrackElement.POINT;
        track[3][2 ] = TrackElement.EMPTY;
        track[3][3 ] = TrackElement.POINT;
        track[3][4 ] = TrackElement.POINT;
        track[3][5 ] = TrackElement.EMPTY;
        track[3][6 ] = TrackElement.EMPTY;
        track[3][7 ] = TrackElement.POINT;
        track[3][8 ] = TrackElement.POINT;
        track[3][9 ] = TrackElement.EMPTY;
        track[3][10] = TrackElement.EMPTY;
        track[3][11] = TrackElement.POINT;

        // második sor
        track[2][0 ]= TrackElement.POINT;
        track[2][1 ]= TrackElement.POINT;
        track[2][2 ]= TrackElement.EMPTY;
        track[2][3 ]= TrackElement.EMPTY;
        track[2][4 ]= TrackElement.POINT;
        track[2][5 ]= TrackElement.EMPTY;
        track[2][6 ]= TrackElement.EMPTY;
        track[2][7 ]= TrackElement.POINT;
        track[2][8 ]= TrackElement.POINT;
        track[2][9 ]= TrackElement.EMPTY;
        track[2][10] = TrackElement.EMPTY;
        track[2][11] = TrackElement.POINT;

        // harmadik sor
        track[1][0 ]= TrackElement.EMPTY;
        track[1][1 ]= TrackElement.EMPTY;
        track[1][2 ]= TrackElement.EMPTY;
        track[1][3 ]= TrackElement.EMPTY;
        track[1][4 ]= TrackElement.EMPTY;
        track[1][5 ]= TrackElement.EMPTY;
        track[1][6 ]= TrackElement.EMPTY;
        track[1][7 ]= TrackElement.EMPTY;
        track[1][8 ]= TrackElement.EMPTY;
        track[1][9 ]= TrackElement.EMPTY;
        track[1][10] = TrackElement.EMPTY;
        track[1][11] = TrackElement.POINT;

        // negyedik sor
        track[0][0 ]= TrackElement.EMPTY;
        track[0][1 ]= TrackElement.EMPTY;
        track[0][2 ]= TrackElement.EMPTY;
        track[0][3 ]= TrackElement.EMPTY;
        track[0][4 ]= TrackElement.EMPTY;
        track[0][5 ]= TrackElement.EMPTY;
        track[0][6 ]= TrackElement.EMPTY;
        track[0][7 ]= TrackElement.EMPTY;
        track[0][8 ]= TrackElement.EMPTY;
        track[0][9 ]= TrackElement.EMPTY;
        track[0][10] = TrackElement.EMPTY;
        track[0][11] = TrackElement.EMPTY;


    }

    @Test
    public void calculateHoles() {
        List<EmptySpace> holeList = optimizer.calculateHoles(track, 3, 0);
        assertEquals(7, holeList.size());
    }
    @Test
    public void calculateOneThird() {
        boolean result = optimizer.calculateOneThird(track);
        assertTrue(result);
    }
}