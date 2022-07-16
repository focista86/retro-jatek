package jatek.rotate;

import jatek.constant.TrackElement;

import static jatek.constant.TrackElement.POINT;


public class RightRotator extends BaseRotator {

    @Override
    protected TrackElement[][] replaceElement(TrackElement[][] rotatedTrack, TrackElement[][] track, int i, int j) {
        final int newRowPosition = i + track[i][j].rotateRightRowIndex;
        final int newColumnPosition = j + track[i][j].rotateRightColumnIndex;
        rotatedTrack[newRowPosition][newColumnPosition] = track[i][j].getRightNewType();
        return rotatedTrack;
    }

    @Override
    protected boolean isRotateColliedWithPoint(TrackElement[][] track, int i, int j) {
        return track
                [i + track[i][j].rotateRightRowIndex]
                [j + track[i][j].rotateRightColumnIndex] == POINT;
    }

}
