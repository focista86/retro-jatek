package jatek.constant;

import java.util.Arrays;
import java.util.List;

public enum TetrisElement {

    SQUARE(Arrays.asList(2, 2, 2, 2), Arrays.asList(2,2,2,2)) {
        @Override
        public TrackElement[][] spawnNew(TrackElement[][] track) {
            int startPoint = track[0].length / 2;
            track[0][startPoint - 1] = TrackElement.SQUARE_POINT;
            track[0][startPoint] = TrackElement.SQUARE_POINT;
            track[1][startPoint - 1] = TrackElement.SQUARE_POINT;
            track[1][startPoint] = TrackElement.SQUARE_POINT;
            return track;
        }
    },
    RIGHT_L(Arrays.asList(3, 2, 1, 1), Arrays.asList(3,2,1,1)) {
        @Override
        public TrackElement[][] spawnNew(TrackElement[][] track) {
            int startPoint = track[0].length / 2 - 1;
            track[0][startPoint + 1] = TrackElement.THREE_LONG_ELEMENT_UP_RIGHT;
            track[0][startPoint] = TrackElement.THREE_LONG_ELEMENT_UP_MIDDLE;
            track[1][startPoint] = TrackElement.THREE_LONG_ELEMENT_MIDDLE_MIDDLE;
            track[2][startPoint] = TrackElement.THREE_LONG_ELEMENT_DOWN_MIDDLE;
            return track;
        }
    },
    RIGHT_L2(Arrays.asList(3, 2, 1, 1), Arrays.asList(2,1,1,3)) {
        @Override
        public TrackElement[][] spawnNew(TrackElement[][] track) {
            int startPoint = track[0].length / 2 - 1;
            track[0][startPoint] = TrackElement.THREE_LONG_ELEMENT_UP_RIGHT;
            track[1][startPoint] = TrackElement.THREE_LONG_ELEMENT_UP_MIDDLE;
            track[1][startPoint + 1] = TrackElement.THREE_LONG_ELEMENT_MIDDLE_MIDDLE;
            track[1][startPoint + 2] = TrackElement.THREE_LONG_ELEMENT_DOWN_MIDDLE;
            return track;
        }
    },
    RIGHT_L3(Arrays.asList(3, 2, 1, 1), Arrays.asList(1,1,3,2)) {
        @Override
        public TrackElement[][] spawnNew(TrackElement[][] track) {
            int startPoint = track[0].length / 2 - 1;
            track[0][startPoint] = TrackElement.THREE_LONG_ELEMENT_UP_RIGHT;
            track[1][startPoint] = TrackElement.THREE_LONG_ELEMENT_UP_MIDDLE;
            track[2][startPoint] = TrackElement.THREE_LONG_ELEMENT_MIDDLE_MIDDLE;
            track[2][startPoint - 1] = TrackElement.THREE_LONG_ELEMENT_DOWN_MIDDLE;
            return track;
        }
    },
    RIGHT_L4(Arrays.asList(3, 2, 1, 1), Arrays.asList(1,3,2,1)) {
        @Override
        public TrackElement[][] spawnNew(TrackElement[][] track) {
            int startPoint = track[0].length / 2 - 1;
            track[0][startPoint] = TrackElement.THREE_LONG_ELEMENT_UP_RIGHT;
            track[0][startPoint + 1] = TrackElement.THREE_LONG_ELEMENT_UP_MIDDLE;
            track[0][startPoint + 2] = TrackElement.THREE_LONG_ELEMENT_MIDDLE_MIDDLE;
            track[1][startPoint + 2] = TrackElement.THREE_LONG_ELEMENT_DOWN_MIDDLE;
            return track;
        }
    },
    LEFT_L(Arrays.asList(3, 2, 1, 1), Arrays.asList(1,2,3,1)) {
        @Override
        public TrackElement[][] spawnNew(TrackElement[][] track) {
            int startPoint = track[0].length / 2;
            track[0][startPoint - 1] = TrackElement.THREE_LONG_ELEMENT_UP_LEFT;
            track[0][startPoint] = TrackElement.THREE_LONG_ELEMENT_UP_MIDDLE;
            track[1][startPoint] = TrackElement.THREE_LONG_ELEMENT_MIDDLE_MIDDLE;
            track[2][startPoint] = TrackElement.THREE_LONG_ELEMENT_DOWN_MIDDLE;
            return track;
        }
    }, LEFT_L2(Arrays.asList(3, 2, 1, 1), Arrays.asList(2,3,1,1)) {
        @Override
        public TrackElement[][] spawnNew(TrackElement[][] track) {
            int startPoint = track[0].length / 2;
            track[0][startPoint] = TrackElement.THREE_LONG_ELEMENT_UP_LEFT;
            track[0][startPoint + 1] = TrackElement.THREE_LONG_ELEMENT_UP_MIDDLE;
            track[0][startPoint + 2] = TrackElement.THREE_LONG_ELEMENT_MIDDLE_MIDDLE;
            track[1][startPoint] = TrackElement.THREE_LONG_ELEMENT_DOWN_MIDDLE;
            return track;
        }
    }, LEFT_L3(Arrays.asList(3, 2, 1, 1), Arrays.asList(3,1,1,2)) {
        @Override
        public TrackElement[][] spawnNew(TrackElement[][] track) {
            int startPoint = track[0].length / 2;
            track[0][startPoint] = TrackElement.THREE_LONG_ELEMENT_UP_LEFT;
            track[1][startPoint] = TrackElement.THREE_LONG_ELEMENT_UP_MIDDLE;
            track[2][startPoint] = TrackElement.THREE_LONG_ELEMENT_MIDDLE_MIDDLE;
            track[2][startPoint + 1] = TrackElement.THREE_LONG_ELEMENT_DOWN_MIDDLE;
            return track;
        }
    }, LEFT_L4(Arrays.asList(3, 2, 1, 1), Arrays.asList(1,1,2,3)) {
        @Override
        public TrackElement[][] spawnNew(TrackElement[][] track) {
            int startPoint = track[0].length / 2;
            track[0][startPoint] = TrackElement.THREE_LONG_ELEMENT_UP_LEFT;
            track[1][startPoint - 2] = TrackElement.THREE_LONG_ELEMENT_UP_MIDDLE;
            track[1][startPoint - 1] = TrackElement.THREE_LONG_ELEMENT_MIDDLE_MIDDLE;
            track[1][startPoint] = TrackElement.THREE_LONG_ELEMENT_DOWN_MIDDLE;
            return track;
        }
    }, RIGHT_PYRAMID(Arrays.asList(3, 1, 1, 1), Arrays.asList(3,1,1,1)) {
        @Override
        public TrackElement[][] spawnNew(TrackElement[][] track) {
            int startPoint = track[0].length / 2 - 1;
            track[0][startPoint] = TrackElement.THREE_LONG_ELEMENT_UP_MIDDLE;
            track[1][startPoint] = TrackElement.THREE_LONG_ELEMENT_MIDDLE_MIDDLE;
            track[1][startPoint + 1] = TrackElement.THREE_LONG_ELEMENT_MIDDLE_RIGHT;
            track[2][startPoint] = TrackElement.THREE_LONG_ELEMENT_DOWN_MIDDLE;
            return track;
        }
    }, LEFT_PYRAMID(Arrays.asList(3, 1, 1, 1), Arrays.asList(1,1,3,1)) {
        @Override
        public TrackElement[][] spawnNew(TrackElement[][] track) {
            int startPoint = track[0].length / 2;
            track[0][startPoint] = TrackElement.THREE_LONG_ELEMENT_UP_MIDDLE;
            track[1][startPoint] = TrackElement.THREE_LONG_ELEMENT_MIDDLE_MIDDLE;
            track[1][startPoint - 1] = TrackElement.THREE_LONG_ELEMENT_MIDDLE_LEFT;
            track[2][startPoint] = TrackElement.THREE_LONG_ELEMENT_DOWN_MIDDLE;
            return track;
        }
    }, PYRAMID(Arrays.asList(3, 1, 1, 1), Arrays.asList(1,1,1,3)) {
        @Override
        public TrackElement[][] spawnNew(TrackElement[][] track) {
            int startPoint = track[0].length / 2;
            track[0][startPoint] = TrackElement.THREE_LONG_ELEMENT_UP_MIDDLE;
            track[1][startPoint - 1] = TrackElement.THREE_LONG_ELEMENT_MIDDLE_MIDDLE;
            track[1][startPoint] = TrackElement.THREE_LONG_ELEMENT_MIDDLE_LEFT;
            track[1][startPoint + 1] = TrackElement.THREE_LONG_ELEMENT_DOWN_MIDDLE;
            return track;
        }
    }, REV_PYRAMID(Arrays.asList(3, 1, 1, 1), Arrays.asList(1,3,1,1)) {
        @Override
        public TrackElement[][] spawnNew(TrackElement[][] track) {
            int startPoint = track[0].length / 2;
            track[0][startPoint - 1] = TrackElement.THREE_LONG_ELEMENT_UP_MIDDLE;
            track[0][startPoint] = TrackElement.THREE_LONG_ELEMENT_MIDDLE_MIDDLE;
            track[0][startPoint + 1] = TrackElement.THREE_LONG_ELEMENT_MIDDLE_LEFT;
            track[1][startPoint] = TrackElement.THREE_LONG_ELEMENT_DOWN_MIDDLE;
            return track;
        }
    }, STRAIGHT(Arrays.asList(3, 3, 1, 1), Arrays.asList(3,1,3,1)) {
        @Override
        public TrackElement[][] spawnNew(TrackElement[][] track) {
            int startPoint = track[0].length / 2 - 1;
            track[0][startPoint] = TrackElement.THREE_LONG_ELEMENT_UP_MIDDLE;
            track[1][startPoint] = TrackElement.THREE_LONG_ELEMENT_MIDDLE_MIDDLE;
            track[2][startPoint] = TrackElement.THREE_LONG_ELEMENT_DOWN_MIDDLE;
            return track;
        }

    }, STRAIGHT2(Arrays.asList(3, 3, 1, 1), Arrays.asList(1,3,1,3)) {
        @Override
        public TrackElement[][] spawnNew(TrackElement[][] track) {
            int startPoint = track[0].length / 2 - 1;
            track[0][startPoint - 1] = TrackElement.THREE_LONG_ELEMENT_UP_MIDDLE;
            track[0][startPoint] = TrackElement.THREE_LONG_ELEMENT_MIDDLE_MIDDLE;
            track[0][startPoint + 1] = TrackElement.THREE_LONG_ELEMENT_DOWN_MIDDLE;
            return track;
        }

    };

    TetrisElement(List elHosszList, List<Integer> forgatasiLista) {
        this.elHosszList = elHosszList;
        this.forgatasiLista = forgatasiLista;
    }

    public abstract TrackElement[][] spawnNew(TrackElement[][] track);
    public final List<Integer> elHosszList;
    public final List<Integer> forgatasiLista; // az első az alap helyzetet jelenti

}
