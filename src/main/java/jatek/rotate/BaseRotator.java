package jatek.rotate;

import jatek.constant.TrackElement;

import static jatek.constant.TrackElement.EMPTY;

public abstract class BaseRotator {

    public TrackElement[][] rotate(TrackElement[][] track) {
        try {
            return rotateIterator(track);
        } catch (IndexOutOfBoundsException e) {
            throw e;
        }
    }

    private TrackElement[][] rotateIterator(TrackElement[][] track) {
        TrackElement[][] rotatedTrack = deepCopyPointInTheTrack(track);
        for (int i = 0; i < track.length; i++) {
            for (int j = 0; j < track[i].length; j++) {
                if (track[i][j].isNotFix) {
                    checkIsRotateColliedWithPoint(track, i, j);
                    rotatedTrack = replaceElement(rotatedTrack, track, i, j);
                }
            }
        }
        return rotatedTrack;
    }

    private void checkIsRotateColliedWithPoint(TrackElement[][] track, int i, int j) {
        if (isRotateColliedWithPoint(track, i, j)) {
            throw new IndexOutOfBoundsException();
        }
    }

    protected abstract boolean isRotateColliedWithPoint(TrackElement[][] rotatedTrack, int i, int j);

    protected abstract TrackElement[][] replaceElement(TrackElement[][] rotatedTrack, TrackElement[][] track, int i, int j);

    private TrackElement[][] deepCopyPointInTheTrack(TrackElement[][] track) {
        TrackElement[][] cloneTrack = new TrackElement[track.length][];
        for (int i = 0; i < track.length; i++) {
            cloneTrack[i] = new TrackElement[track[i].length];
            for (int j = 0; j < track[i].length; j++) {
                cloneTrack[i][j] = track[i][j].isNotFix ? EMPTY : track[i][j];
            }
        }
        return cloneTrack;
    }
}
