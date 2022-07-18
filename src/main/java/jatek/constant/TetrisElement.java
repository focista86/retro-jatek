package jatek.constant;

import java.util.Arrays;
import java.util.List;

public enum TetrisElement {

    SQUARE(Arrays.asList(2, 2, 2, 2), Arrays.asList(2,2,2,2), Arrays.asList(-1,-1,-1,-1), Arrays.asList(2,2,2,2), Arrays.asList(Arrays.asList(0,0),Arrays.asList(0,0),Arrays.asList(0,0),Arrays.asList(0,0)), Arrays.asList(Arrays.asList(0,0),Arrays.asList(0,0),Arrays.asList(0,0),Arrays.asList(0,0))) {
        @Override
        public TrackElement[][] spawnNew(TrackElement[][] track) {
            int startPoint = track[0].length / 2;
            track[0][startPoint - 1] = TrackElement.SQUARE_POINT;
            track[0][startPoint] = TrackElement.SQUARE_POINT;
            track[1][startPoint - 1] = TrackElement.SQUARE_POINT;
            track[1][startPoint] = TrackElement.SQUARE_POINT;
            return track;
        }
    }

    ,
    //**
    //*
    //*
    RIGHT_L(Arrays.asList(3, 2, 1, 1), Arrays.asList(1,3,2,1), Arrays.asList(-1,-2,-2,-2), Arrays.asList(2,3,2,3)
            , Arrays.asList(Arrays.asList(0,0),Arrays.asList(0,0),Arrays.asList(0,0),Arrays.asList(2,0))
            , Arrays.asList(Arrays.asList(0,1),Arrays.asList(0,0),Arrays.asList(0,0),Arrays.asList(0,0))) {
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
    //**
    // *
    // *
    LEFT_L(Arrays.asList(3, 2, 1, 1), Arrays.asList(1,1,2,3), Arrays.asList(0,-1,0,-1), Arrays.asList(2,3,2,3)
            , Arrays.asList(Arrays.asList(0,0),Arrays.asList(0,2),Arrays.asList(0,0),Arrays.asList(0,0))
            , Arrays.asList(Arrays.asList(1,0),Arrays.asList(0,0),Arrays.asList(0,0),Arrays.asList(0,0))) {
        @Override
        public TrackElement[][] spawnNew(TrackElement[][] track) {
            int startPoint = track[0].length / 2;
            track[0][startPoint - 1] = TrackElement.THREE_LONG_ELEMENT_UP_LEFT;
            track[0][startPoint] = TrackElement.THREE_LONG_ELEMENT_UP_MIDDLE;
            track[1][startPoint] = TrackElement.THREE_LONG_ELEMENT_MIDDLE_MIDDLE;
            track[2][startPoint] = TrackElement.THREE_LONG_ELEMENT_DOWN_MIDDLE;
            return track;
        }
    }
    //*
    //**
    //*
    , RIGHT_PYRAMID(Arrays.asList(3, 1, 1, 1), Arrays.asList(1,3,1,1), Arrays.asList(-1,-2,-2,-2), Arrays.asList(2,3,2,3)
            , Arrays.asList(Arrays.asList(0,1),Arrays.asList(0,0),Arrays.asList(1,0),Arrays.asList(1,1))
            , Arrays.asList(Arrays.asList(0,0),Arrays.asList(0,0),Arrays.asList(0,0),Arrays.asList(0,0))) {
        @Override
        public TrackElement[][] spawnNew(TrackElement[][] track) {
            int startPoint = track[0].length / 2 - 1;
            track[0][startPoint] = TrackElement.THREE_LONG_ELEMENT_UP_MIDDLE;
            track[1][startPoint] = TrackElement.THREE_LONG_ELEMENT_MIDDLE_MIDDLE;
            track[1][startPoint + 1] = TrackElement.THREE_LONG_ELEMENT_MIDDLE_RIGHT;
            track[2][startPoint] = TrackElement.THREE_LONG_ELEMENT_DOWN_MIDDLE;
            return track;
        }
    }
    // *
    //**
    // *
    , LEFT_PYRAMID(Arrays.asList(3, 1, 1, 1), Arrays.asList(1,1,1,3), Arrays.asList(0,-1,0,-1), Arrays.asList(2,3,2,3)
            , Arrays.asList(Arrays.asList(1,0),Arrays.asList(1,1),Arrays.asList(0,1),Arrays.asList(0,0))
            , Arrays.asList(Arrays.asList(0,0),Arrays.asList(0,0),Arrays.asList(0,0),Arrays.asList(0,0))) {
        @Override
        public TrackElement[][] spawnNew(TrackElement[][] track) {
            int startPoint = track[0].length / 2;
            track[0][startPoint] = TrackElement.THREE_LONG_ELEMENT_UP_MIDDLE;
            track[1][startPoint] = TrackElement.THREE_LONG_ELEMENT_MIDDLE_MIDDLE;
            track[1][startPoint - 1] = TrackElement.THREE_LONG_ELEMENT_MIDDLE_LEFT;
            track[2][startPoint] = TrackElement.THREE_LONG_ELEMENT_DOWN_MIDDLE;
            return track;
        }

    },
    //*
    //*
    //*
    STRAIGHT(Arrays.asList(3, 3, 1, 1), Arrays.asList(1,3,1,3), Arrays.asList(-1,-2,-1,-2), Arrays.asList(1,3,1,3)
            , Arrays.asList(Arrays.asList(0,0),Arrays.asList(0,0),Arrays.asList(0,0),Arrays.asList(0,0))
            , Arrays.asList(Arrays.asList(0,0),Arrays.asList(0,0),Arrays.asList(0,0),Arrays.asList(0,0))) {
        @Override
        public TrackElement[][] spawnNew(TrackElement[][] track) {
            int startPoint = track[0].length / 2 - 1;
            track[0][startPoint] = TrackElement.THREE_LONG_ELEMENT_UP_MIDDLE;
            track[1][startPoint] = TrackElement.THREE_LONG_ELEMENT_MIDDLE_MIDDLE;
            track[2][startPoint] = TrackElement.THREE_LONG_ELEMENT_DOWN_MIDDLE;
            return track;
        }
    };

    TetrisElement(List elHosszList, List<Integer> forgatasiLista, List<Integer> miny, List<Integer> shadow, List<List<Integer>> secondRow, List<List<Integer>> thirdRow) {
        this.elHosszList = elHosszList;
        this.forgatasiLista = forgatasiLista;
        this.miny = miny;
        this.shadow = shadow;
        this.secondRow = secondRow;
        this.thirdRow = thirdRow;
    }

    public abstract TrackElement[][] spawnNew(TrackElement[][] track);
    public final List<Integer> elHosszList;
    public final List<Integer> forgatasiLista; // az első az alap helyzetet jelenti
   public final List<Integer> miny; // az első az alap helyzetet jelenti
   public final List<Integer> shadow; // az első az alap helyzetet jelenti
   public final List<List<Integer>> secondRow; //balra, jobbra kinyúlás
   public final List<List<Integer>> thirdRow; //balra, jobbra kinyúlás

}
