package jatek.control;

import jatek.constant.Movement;
import jatek.constant.TetrisElement;
import jatek.constant.TrackElement;
import jatek.model.EmptySpace;

import java.util.ArrayList;
import java.util.List;

import static jatek.constant.Movement.*;
import static java.lang.Math.abs;

public class Optimizer2 {

    public List<Movement> elmebaj1(TrackElement[][] track, TetrisElement current, int itemCounter) {

        return emptySpaceFill(calculateHoles(track, track.length-1), current, track[0].length);
    }
    //ha null akkor az getBasicSolution-t kell hívni !!!!!!
    public List<Movement> emptySpaceFill(List<EmptySpace> emptySpaceList, TetrisElement current, int tableLength){
        List<Movement> solution = null;

        for (Integer elHossza : current.elHosszList) {
            for (EmptySpace emptySpace : emptySpaceList) {
                if (elHossza == emptySpace.length){
                    solution = calculateMovements(current, elHossza, emptySpace.startPosition, tableLength, emptySpace);
                    if (solution != null) {
                        System.out.println("Optimizer szerint");
                        System.out.println(solution);
                        return solution;
                    }
//                    megfelelő él hosszra forgat
//                    a baloldalát a emptySpace.startPositionra mozgatni
                }
            }
            for (EmptySpace emptySpace : emptySpaceList) {
                if (elHossza < emptySpace.length){
                    solution = calculateMovements(current, elHossza, emptySpace.startPosition, tableLength, emptySpace);
                    if (solution != null) {
                        System.out.println("Optimizer szerint");
                        System.out.println(solution);
                        return solution;
                    }
//                    megfelelő él hosszra forgat
//                    a baloldalát a emptySpace.startPositionra mozgatni
                }
            }
        }
        return solution;
    }

    private  List<Movement> calculateMovements(TetrisElement current, Integer elHossza, int startPosition, int tableLength, EmptySpace emptySpace) {
        ArrayList<Movement> movementList = new ArrayList<Movement>();
        boolean isFound = false;
        List<Integer> l = current.forgatasiLista;
        List<Integer> s = current.shadow;
        for (int i = 0; i < l.size(); i++) {
            if (l.get(i) == elHossza && goodSolution(i, current, emptySpace) ) {
                push(movementList, i, ROTATE_LEFT);
                int minor_offset = current.miny.get(i);
                int offset = tableLength/2 + minor_offset - startPosition;
                push(movementList, abs(offset), (offset > 0) ? MOVE_LEFT : MOVE_RIGHT );
                isFound = true;
                break;
            }
        }
        System.out.println("Calculator szerint");
        System.out.println(movementList);

        return isFound ? movementList : null;
    }

    private boolean goodSolution(int i, TetrisElement current, EmptySpace emptySpace) {
        if (emptySpace.length > 1) return true;
        boolean isGood = true;
        //balra fölötte jók vagyunk?
        if (current.secondRow.get(i).get(0) > emptySpace.noses.get(0)) isGood = false;
        //jobbra fölötte jók vagyunk?
        if (current.secondRow.get(i).get(1) > emptySpace.noses.get(1)) isGood = false;
        //2-vel balra fölötte jók vagyunk?
        if (current.thirdRow.get(i).get(0) > emptySpace.noses.get(2)) isGood = false;
        //2-vel jobbra fölötte jók vagyunk?
        if (current.thirdRow.get(i).get(1) > emptySpace.noses.get(3)) isGood = false;
        return isGood;
    }

    private boolean isSide(int startPosition, int tableLength) {
        return (startPosition == 0 || startPosition == tableLength - 1);
    }

    private void push(ArrayList<Movement> movementList, int i, Movement movement) {
        if (i <= 0) {
            return;
        }
        if (movement == ROTATE_LEFT && i == 3) {
            movementList.add(ROTATE_RIGHT);
        } else {
            for (int j = 0; j < i; j++) {
                movementList.add(movement);
            }
        }
    }

    public List<EmptySpace> calculateHoles(TrackElement[][] track, int lineCount) {
        List<EmptySpace> list = new ArrayList<>();
        List<Integer> heights = new ArrayList<>();
        int maxHeight;
        // oszlopokon végigmegyünk
        for (int i = 0; i < track[0].length; i++) {
            maxHeight = 0;
            // oszlopon belül a sorokon, alulról fölfele
            for (int j = track.length - 1 ; j > 0; j--) {
                if (track[j][i].equals(TrackElement.POINT)) {
                    maxHeight = track.length - j;
                }
            }
            heights.add( maxHeight);
        }
        int minHeight = calculateMinimumHeight(heights);
        for (int k = 0; k < lineCount; k++) {
            int i = 0;
            while (i < heights.size()) {
                if (heights.get(i) == minHeight + k) {
                    EmptySpace eS = new EmptySpace();
                    eS.startPosition = i;
                    int j = i + 1;
                    while (j < heights.size() && heights.get(j) == minHeight + k) {
                        j++;
                    }
                    eS.length = j - i;
                    eS.row = minHeight + k;
                    list.add(eS);
                    i = j - 1;
                }
                i++;
            }
        }
        // az 1 hosszú lukak kiegészítő infók
        for (int i = 0; i <list.size(); i++) {
            if (list.get(i).length == 1) {
                EmptySpace hole = list.get(i);
                // balra, fölötte
                int n = 0;
                if (track.length > hole.row+1 && hole.startPosition > 0 && !track[track.length - hole.row -2][hole.startPosition -1].equals(TrackElement.POINT)) {
                    n++;
                    if (hole.startPosition > 1 && !track[track.length - hole.row -2][hole.startPosition -2].equals(TrackElement.POINT)) n++;
                }
                hole.noses.add(n);
                // jobbra, fölötte
                n = 0;
                if (track.length > hole.row +1 && hole.startPosition < track[0].length -2 && !track[track.length - hole.row -2][hole.startPosition +1].equals(TrackElement.POINT)) {
                    n++;
                    if (hole.startPosition < track[0].length -2 && !track[track.length - hole.row -2][hole.startPosition +2].equals(TrackElement.POINT)) n++;
                }
                hole.noses.add(n);
                // 2-vel balra, fölötte
                n = 0;
                if (track.length > hole.row + 2 && hole.startPosition > 0 && !track[track.length - hole.row -3][hole.startPosition -1].equals(TrackElement.POINT)) {
                    n++;
                    if (hole.startPosition > 1 && !track[track.length - hole.row -2][hole.startPosition -2].equals(TrackElement.POINT)) n++;
                }
                hole.noses.add(n);
                // 2-vel jobbra, fölötte
                n = 0;
                if (track.length > hole.row +2 && hole.startPosition < track[0].length -1 && !track[track.length - hole.row -3][hole.startPosition +1].equals(TrackElement.POINT)) {
                    n++;
                    if (hole.startPosition < track[0].length -2 && !track[track.length - hole.row -3][hole.startPosition +2].equals(TrackElement.POINT)) n++;
                }
                hole.noses.add(n);
            }
        }
        return list;
    }

    private int calculateMinimumHeight(List<Integer> heights) {
        return heights.stream().min(Integer::compare).get();
    }
}
