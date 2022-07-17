package jatek.control;

import jatek.constant.Movement;
import jatek.constant.TetrisElement;
import jatek.constant.TrackElement;
import jatek.model.EmptySpace;

import java.util.ArrayList;
import java.util.List;

public class EmptySpaceCalculator {
    public List<EmptySpace> calculate(TrackElement[][] track) {
        List<EmptySpace> list = new ArrayList<>();
        int[] heights = new int[track[0].length];
        int maxHeight;
        // maxheights
        for (int j = 0; j < track.length; j++) {
            maxHeight = 0;
            for (int i = 0; i < track[0].length; i++) {
                if (track[i][j].equals(TrackElement.POINT)) {
                    maxHeight = i;
                }
            }
            heights[j] = maxHeight;

        }
        int i = 0;
        while (i < heights.length) {
            if (heights[i] == 0) {
                EmptySpace eS = new EmptySpace();
                eS.startPosition = i;
                int j = i + 1;
                while (j < heights.length && heights[j] == 0) {
                    j++;
                }
                eS.length = j - i + 1;
                list.add(eS);
            }
        }
        return list;
    }
}
