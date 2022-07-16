package jatek.rotate;

import jatek.constant.TrackElement;

import static jatek.constant.TrackElement.POINT;

public class LeftRotator extends BaseRotator {

    @Override
    protected boolean isRotateColliedWithPoint(TrackElement[][] track, int i, int j) {
        return track
                [i + track[i][j].rotateLeftRowIndex]
                [j + track[i][j].rotateLeftColumnIndex] == POINT;
    }

    @Override
    protected TrackElement[][] replaceElement(TrackElement[][] rotatedTrack, TrackElement[][] track, int i, int j) {
        final int newRowPosition = i + track[i][j].rotateLeftRowIndex;
        final int newColumnPosition = j + track[i][j].rotateLeftColumnIndex;
        rotatedTrack[newRowPosition][newColumnPosition] = track[i][j].getLeftNewType();
        return rotatedTrack;
    }

}
