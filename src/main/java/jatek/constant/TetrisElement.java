package jatek.constant;

public enum TetrisElement {

    SQUARE(2, 2, 2, 2) {
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
    RIGHT_L(3, 2, 1, 1) {
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
    RIGHT_L2(3, 2, 1, 1) {
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
    RIGHT_L3(3, 2, 1, 1) {
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
    RIGHT_L4(3, 2, 1, 1) {
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
    LEFT_L(3, 2, 1, 1) {
        @Override
        public TrackElement[][] spawnNew(TrackElement[][] track) {
            int startPoint = track[0].length / 2;
            track[0][startPoint - 1] = TrackElement.THREE_LONG_ELEMENT_UP_LEFT;
            track[0][startPoint] = TrackElement.THREE_LONG_ELEMENT_UP_MIDDLE;
            track[1][startPoint] = TrackElement.THREE_LONG_ELEMENT_MIDDLE_MIDDLE;
            track[2][startPoint] = TrackElement.THREE_LONG_ELEMENT_DOWN_MIDDLE;
            return track;
        }
    }, LEFT_L2(3, 2, 1, 1) {
        @Override
        public TrackElement[][] spawnNew(TrackElement[][] track) {
            int startPoint = track[0].length / 2;
            track[0][startPoint] = TrackElement.THREE_LONG_ELEMENT_UP_LEFT;
            track[0][startPoint + 1] = TrackElement.THREE_LONG_ELEMENT_UP_MIDDLE;
            track[0][startPoint + 2] = TrackElement.THREE_LONG_ELEMENT_MIDDLE_MIDDLE;
            track[1][startPoint] = TrackElement.THREE_LONG_ELEMENT_DOWN_MIDDLE;
            return track;
        }
    }, LEFT_L3(3, 2, 1, 1) {
        @Override
        public TrackElement[][] spawnNew(TrackElement[][] track) {
            int startPoint = track[0].length / 2;
            track[0][startPoint] = TrackElement.THREE_LONG_ELEMENT_UP_LEFT;
            track[1][startPoint] = TrackElement.THREE_LONG_ELEMENT_UP_MIDDLE;
            track[2][startPoint] = TrackElement.THREE_LONG_ELEMENT_MIDDLE_MIDDLE;
            track[2][startPoint + 1] = TrackElement.THREE_LONG_ELEMENT_DOWN_MIDDLE;
            return track;
        }
    }, LEFT_L4(3, 2, 1, 1) {
        @Override
        public TrackElement[][] spawnNew(TrackElement[][] track) {
            int startPoint = track[0].length / 2;
            track[0][startPoint] = TrackElement.THREE_LONG_ELEMENT_UP_LEFT;
            track[1][startPoint - 2] = TrackElement.THREE_LONG_ELEMENT_UP_MIDDLE;
            track[1][startPoint - 1] = TrackElement.THREE_LONG_ELEMENT_MIDDLE_MIDDLE;
            track[1][startPoint] = TrackElement.THREE_LONG_ELEMENT_DOWN_MIDDLE;
            return track;
        }
    }, RIGHT_PYRAMID(3, 1, 1, 1) {
        @Override
        public TrackElement[][] spawnNew(TrackElement[][] track) {
            int startPoint = track[0].length / 2 - 1;
            track[0][startPoint] = TrackElement.THREE_LONG_ELEMENT_UP_MIDDLE;
            track[1][startPoint] = TrackElement.THREE_LONG_ELEMENT_MIDDLE_MIDDLE;
            track[1][startPoint + 1] = TrackElement.THREE_LONG_ELEMENT_MIDDLE_RIGHT;
            track[2][startPoint] = TrackElement.THREE_LONG_ELEMENT_DOWN_MIDDLE;
            return track;
        }
    }, LEFT_PYRAMID(3, 1, 1, 1) {
        @Override
        public TrackElement[][] spawnNew(TrackElement[][] track) {
            int startPoint = track[0].length / 2;
            track[0][startPoint] = TrackElement.THREE_LONG_ELEMENT_UP_MIDDLE;
            track[1][startPoint] = TrackElement.THREE_LONG_ELEMENT_MIDDLE_MIDDLE;
            track[1][startPoint - 1] = TrackElement.THREE_LONG_ELEMENT_MIDDLE_LEFT;
            track[2][startPoint] = TrackElement.THREE_LONG_ELEMENT_DOWN_MIDDLE;
            return track;
        }
    }, PYRAMID(3, 1, 1, 1) {
        @Override
        public TrackElement[][] spawnNew(TrackElement[][] track) {
            int startPoint = track[0].length / 2;
            track[0][startPoint] = TrackElement.THREE_LONG_ELEMENT_UP_MIDDLE;
            track[1][startPoint - 1] = TrackElement.THREE_LONG_ELEMENT_MIDDLE_MIDDLE;
            track[1][startPoint] = TrackElement.THREE_LONG_ELEMENT_MIDDLE_LEFT;
            track[1][startPoint + 1] = TrackElement.THREE_LONG_ELEMENT_DOWN_MIDDLE;
            return track;
        }
    }, REV_PYRAMID(3, 1, 1, 1) {
        @Override
        public TrackElement[][] spawnNew(TrackElement[][] track) {
            int startPoint = track[0].length / 2;
            track[0][startPoint - 1] = TrackElement.THREE_LONG_ELEMENT_UP_MIDDLE;
            track[0][startPoint] = TrackElement.THREE_LONG_ELEMENT_MIDDLE_MIDDLE;
            track[0][startPoint + 1] = TrackElement.THREE_LONG_ELEMENT_MIDDLE_LEFT;
            track[1][startPoint] = TrackElement.THREE_LONG_ELEMENT_DOWN_MIDDLE;
            return track;
        }
    }, STRAIGHT(3, 3, 1, 1) {
        @Override
        public TrackElement[][] spawnNew(TrackElement[][] track) {
            int startPoint = track[0].length / 2 - 1;
            track[0][startPoint] = TrackElement.THREE_LONG_ELEMENT_UP_MIDDLE;
            track[1][startPoint] = TrackElement.THREE_LONG_ELEMENT_MIDDLE_MIDDLE;
            track[2][startPoint] = TrackElement.THREE_LONG_ELEMENT_DOWN_MIDDLE;
            return track;
        }

    }, STRAIGHT2(3, 3, 1, 1) {
        @Override
        public TrackElement[][] spawnNew(TrackElement[][] track) {
            int startPoint = track[0].length / 2 - 1;
            track[0][startPoint - 1] = TrackElement.THREE_LONG_ELEMENT_UP_MIDDLE;
            track[0][startPoint] = TrackElement.THREE_LONG_ELEMENT_MIDDLE_MIDDLE;
            track[0][startPoint + 1] = TrackElement.THREE_LONG_ELEMENT_DOWN_MIDDLE;
            return track;
        }

    };

    TetrisElement(int maxel1, int maxel2, int maxel3, int maxel4) {
        this.maxel1 = maxel1;
        this.maxel2 = maxel2;
        this.maxel3 = maxel3;
        this.maxel4 = maxel4;
    }

    public abstract TrackElement[][] spawnNew(TrackElement[][] track);
    public final int maxel1, maxel2, maxel3, maxel4;

}
