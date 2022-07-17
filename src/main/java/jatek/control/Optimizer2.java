package jatek.control;

import jatek.constant.Movement;
import jatek.constant.TetrisElement;
import jatek.constant.TrackElement;
import jatek.model.EmptySpace;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static jatek.constant.Movement.*;
import static java.lang.Math.abs;

public class Optimizer2 {

    public List<Movement> elmebaj1(TrackElement[][] track, TetrisElement current, int itemCounter) {
        return emptySpaceFill(calculateHoles(track), current, track[0].length);
    }
    //ha null akkor az getBasicSolution-t kell hívni !!!!!!
    public List<Movement> emptySpaceFill(List<EmptySpace> emptySpaceList, TetrisElement current, int tableLength){
        List<Movement> solution = null;

        for (Integer elHossza : current.elHosszList) {
            for (EmptySpace emptySpace : emptySpaceList) {
                if (elHossza == emptySpace.length){
                    solution = calculateMovements(current, elHossza, emptySpace.startPosition, tableLength);
//                    megfelelő él hosszra forgat
//                    a baloldalát a emptySpace.startPositionra mozgatni
                }
            }
            for (EmptySpace emptySpace : emptySpaceList) {
                if (elHossza < emptySpace.length){
                    solution = calculateMovements(current, elHossza, emptySpace.startPosition, tableLength);
//                    megfelelő él hosszra forgat
//                    a baloldalát a emptySpace.startPositionra mozgatni
                }
            }
        }
        return solution;
    }

    private  List<Movement> calculateMovements(TetrisElement current, Integer elHossza, int startPosition, int tableLength) {
        ArrayList<Movement> movementList = new ArrayList<Movement>();
        List<Integer> l = current.forgatasiLista;
        for (int i = 0; i < l.size(); i++) {
            if (l.get(i) == elHossza) {
                push(movementList, i, ROTATE_LEFT);
                int minor_offset = current.miny.get(i);
                int offset = tableLength/2 + minor_offset - startPosition;
                push(movementList, abs(offset), (offset > 0) ? MOVE_LEFT : MOVE_RIGHT );
                break;
            }
        }
        return movementList;
    }

    private void push(ArrayList<Movement> movementList, int i, Movement movement) {
        if (i <= 0) {
            return;
        }
        for (int j = 0; j < i; j++) {
            movementList.add(movement);
        }
    }

    public List<EmptySpace> calculateHoles(TrackElement[][] track) {
        List<EmptySpace> list = new ArrayList<>();
        List<Integer> heights = new ArrayList<>();
        int maxHeight;
        // maxheights
        for (int i = 0; i < track[0].length; i++) {
            maxHeight = 0;
            for (int j = track.length - 1 ; j > 0; j--) {
                if (track[j][i].equals(TrackElement.POINT)) {
                    maxHeight = track.length - j;
                }
            }
            heights.add( maxHeight);
        }
        int minHeight = calculateMinimumHeight(heights);
        int i = 0;
        while (i < heights.size()) {
            if (heights.get(i) == minHeight) {
                EmptySpace eS = new EmptySpace();
                eS.startPosition = i;
                int j = i + 1;
                while (j < heights.size() && heights.get(j) == minHeight) {
                    j++;
                }
                eS.length = j - i ;
                list.add(eS);
                i = j-1;
            }
            i++;
        }
        return list;
    }

    private int calculateMinimumHeight(List<Integer> heights) {
        return heights.stream().min(Integer::compare).get();
    }
}
