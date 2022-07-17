package jatek.control;

import jatek.constant.TetrisElement;
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
        track = new TrackElement[12][4];
        // első sor
        track[0][0] = TrackElement.POINT;
        track[1][0] = TrackElement.POINT;
        track[2][0] = TrackElement.EMPTY;
        track[3][0] = TrackElement.POINT;
        track[4][0] = TrackElement.POINT;
        track[5][0] = TrackElement.EMPTY;
        track[6][0] = TrackElement.EMPTY;
        track[7][0] = TrackElement.POINT;
        track[8][0] = TrackElement.POINT;
        track[9][0] = TrackElement.EMPTY;
        track[10][0] = TrackElement.EMPTY;
        track[11][0] = TrackElement.POINT;

        // második sor
        track[0][1] = TrackElement.POINT;
        track[1][1] = TrackElement.POINT;
        track[2][1] = TrackElement.EMPTY;
        track[3][1] = TrackElement.EMPTY;
        track[4][1] = TrackElement.POINT;
        track[5][1] = TrackElement.EMPTY;
        track[6][1] = TrackElement.EMPTY;
        track[7][1] = TrackElement.POINT;
        track[8][1] = TrackElement.POINT;
        track[9][1] = TrackElement.EMPTY;
        track[10][1] = TrackElement.EMPTY;
        track[11][1] = TrackElement.POINT;

        // harmadik sor
        track[0][2] = TrackElement.EMPTY;
        track[1][2] = TrackElement.EMPTY;
        track[2][2] = TrackElement.EMPTY;
        track[3][2] = TrackElement.EMPTY;
        track[4][2] = TrackElement.EMPTY;
        track[5][2] = TrackElement.EMPTY;
        track[6][2] = TrackElement.EMPTY;
        track[7][2] = TrackElement.EMPTY;
        track[8][2] = TrackElement.EMPTY;
        track[9][2] = TrackElement.EMPTY;
        track[10][2] = TrackElement.EMPTY;
        track[11][2] = TrackElement.POINT;

        // negyedik sor
        track[0][3] = TrackElement.EMPTY;
        track[1][3] = TrackElement.EMPTY;
        track[2][3] = TrackElement.EMPTY;
        track[3][3] = TrackElement.EMPTY;
        track[4][3] = TrackElement.EMPTY;
        track[5][3] = TrackElement.EMPTY;
        track[6][3] = TrackElement.EMPTY;
        track[7][3] = TrackElement.EMPTY;
        track[8][3] = TrackElement.EMPTY;
        track[9][3] = TrackElement.EMPTY;
        track[10][3] = TrackElement.EMPTY;
        track[11][3] = TrackElement.EMPTY;


    }

    @Test
    public void calculateHoles() {
        List<EmptySpace> holeList = optimizer.calculateHoles(track);
        assertEquals(3, holeList.size());
    }
}