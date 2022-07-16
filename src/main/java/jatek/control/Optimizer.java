package jatek.control;

import jatek.constant.TetrisElement;
import jatek.constant.TrackElement;

import java.util.ArrayList;
import java.util.List;

/*
Ez az algoritmus, ami a megkapott pálya és követzkező alakzat alapján belövi, hogy mi lenne a jó lépés
Az egészet kb innen vettem: https://medium.com/python-pandemonium/building-a-tetris-bot-part-1-the-stupid-bot-2cbc38d6e32b
 */
public class Optimizer {


    TrackElement[][] track;
    TetrisElement current;
    static final String ROTATE_LEFT = "ROTATE_LEFT";
    static final String ROTATE_RIGHT = "ROTATE_RIGHT";
    static final String MOVE_LEFT = "MOVE_LEFT";
    static final String MOVE_RIGHT = "MOVE_RIGHT";


    /**
     * Az alapmegoldás
     *
     * @param track       A pálya
     * @param current     az elem amiről dönteni kell
     * @param itemCounter megmondja, hogy hányadik elemként jött a játék kezdete óta
     * @return A current helyezéséhez szükséges lépések listája
     * @return
     */
    public List<String> getBasicSolution(TrackElement[][] track, TetrisElement current, int itemCounter) {
        List<String> solution = new ArrayList<>();

        String rotate = rotateToBaseLine(current);
        solution.add(rotate != null ? rotate : null);
        List<String> moves = moveToSides(track, itemCounter);
        solution.addAll(moves);
        return solution;
    }


    /**
     * A legalapabb megoldás
     *
     * @param track   A pálya
     * @param current az elem amiről dönteni kell
     * @return A current helyezéséhet szükséges lépések listája
     */
    public List<String> getMostBasicSolution(TrackElement[][] track, TetrisElement current) {
        List<String> solution = new ArrayList<>();
        String rotate = rotateToBaseLine(current);
        solution.add(rotate != null ? rotate : null);
        return solution;
    }

    /**
     * faék megoldás: a hogy merre kell forgatni, hogy a megnagyobb egyenes oldala legyen lefelé
     *
     * @param current a szóbanforgó elem
     * @return a szükséges forgatás iránya
     */
    private String rotateToBaseLine(TetrisElement current) {
        if (current.equals(TetrisElement.SQUARE)) {
            //nincs itt semmi dolgunk, gyújts rá egy jó történetre!
            return null;
        } else if (current.equals(TetrisElement.RIGHT_L) || current.equals(TetrisElement.RIGHT_PYRAMID)) {
            return ROTATE_LEFT;
        } else { // az össze többi: LEFT_L, LEFT_PYRAMID, STRAIGHT
            return ROTATE_RIGHT;
        }
    }


    /**
     * faék megoldás: hármas iterációban balszélre mozgatja,
     * középen hagyja vagy jobbszélre mozgatja az elemet
     *
     * @param track       a pálya
     * @param itemCounter hányadik elem ez a játék folyamán
     * @return a lépések sorozata ahhoz, hogy jó helyre kerüljön az elem
     */
    private List<String> moveToSides(TrackElement[][] track, int itemCounter) {
        List<String> returnList = new ArrayList<>();
        int neededSteps = track[0].length / 2;
        if (itemCounter / 3 == 0) {
            for (int i = 0; i < neededSteps; i++) {
                returnList.add(MOVE_LEFT);
            }
        } else if (itemCounter / 3 == 1) {
            //középen marad, nem megy sehová, mindenki vidám
        } else if (itemCounter / 3 == 2) {
            for (int i = 0; i < neededSteps; i++) {
                returnList.add(MOVE_RIGHT);
            }
        }
        return returnList;
    }

//    public void getOptimalDrop(TrackElement[][] track, TetrisElement current) {
//        List<TetrisElement> possibleRotations = getAllRotationsForElement(current);
//
//        possibleRotations.forEach(rotation -> {
//            // végigiterálok az összes oszlopon, ezek számát a track[0].length-el tudtam begyűjteni
//            for (int i = 0; i < track[0].length; i++) {
//                TrackElement[][] t = track;
//                rotation.toString();
//                drop(t, current, i);
//
//                // ha jó a drop, akkor bekerül a jó válaszok közé
//
//            }
//        });
//
//
//    }
//
//    private List<TetrisElement> getAllRotationsForElement(TetrisElement current) {
//        List<TetrisElement> returnlist = new ArrayList<>();
//        if (current.equals(TetrisElement.SQUARE)) {
//            returnlist.add(TetrisElement.SQUARE);
//        } else if (current.equals(TetrisElement.STRAIGHT)) {
//            returnlist.add(TetrisElement.STRAIGHT);
//            returnlist.add(TetrisElement.STRAIGHT2);
//        } else if (current.equals(TetrisElement.LEFT_L)) {
//            returnlist.add(TetrisElement.LEFT_L);
//            returnlist.add(TetrisElement.LEFT_L2);
//            returnlist.add(TetrisElement.LEFT_L3);
//            returnlist.add(TetrisElement.LEFT_L4);
//        } else if(current.equals(TetrisElement.RIGHT_L)){
//            returnlist.add(TetrisElement.RIGHT_L);
//            returnlist.add(TetrisElement.RIGHT_L2);
//            returnlist.add(TetrisElement.RIGHT_L3);
//            returnlist.add(TetrisElement.RIGHT_L4);
//        } else if (current.equals(TetrisElement.LEFT_PYRAMID) || current.equals(TetrisElement.RIGHT_PYRAMID)) {
//            returnlist.add(TetrisElement.PYRAMID);
//            returnlist.add(TetrisElement.LEFT_PYRAMID);
//            returnlist.add(TetrisElement.RIGHT_PYRAMID);
//            returnlist.add(TetrisElement.REV_PYRAMID);
//        }
//        return returnlist;
//        //ésígytovább
//    }
//
//
//    /*
//
//            Drops a tetromino in the specified column.
//            The leftmost column of the tetromino will be aligned with the specified
//            column.
//            Returns the row it was dropped in for computations.
//
//     */
//    private int drop(TrackElement[][] t, TetrisElement current, int column) {
//
//        Assert.isTrue(column >= 0);
//        Assert.isTrue(column + current. () <= track[0].length);
//        row = self._get_tetromino_drop_row(tetromino, column);
//        Assert.isTrue(row != -1);
//        self._place_tetromino(tetromino, row, column)
//        self._line_clear()
//        return row
//    }
//
//    def count_gaps(self):
//            """
//        Check each column one by one to make sure there are no gaps in the
//        column.
//        """
//            return
//
//    sum(
//            ["".join([row[col]for row in self.state]).
//
//    lstrip().
//
//    count(' ')
//             for
//    col in
//
//    range(Field.WIDTH)])
//
//    def height(self):
//            """
//        Returns the height on the field of the highest placed tetromino on the
//        field.
//        """
//            for i,
//    row in
//
//    enumerate(self.state):
//            if''.
//
//    join(row).
//
//    strip():
//            return Field.HEIGHT -i

}



