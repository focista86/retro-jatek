package jatek.control;

import jatek.constant.Movement;
import jatek.constant.TetrisElement;
import jatek.model.EmptySpace;

import java.util.ArrayList;
import java.util.List;

public class Optimizer2 {

    //ha null akkor az getBasicSolution-t kell hívni !!!!!!
    public List<Movement> emptySpaceFill(List<EmptySpace> emptySpaceList, TetrisElement current){
        List<Movement> solution = null;

        for (Integer elHossza : current.elHosszList) {
            for (EmptySpace emptySpace : emptySpaceList) {
                if (elHossza == emptySpace.length){
                    solution = new ArrayList<>();
//                    megfelelő él hosszra forgat
//                    a baloldalát a emptySpace.startPositionra mozgatni
                }
            }
            for (EmptySpace emptySpace : emptySpaceList) {
                if (elHossza < emptySpace.length){
//                    megfelelő él hosszra forgat
//                    a baloldalát a emptySpace.startPositionra mozgatni
                }
            }
        }
        return solution;
    }




}
