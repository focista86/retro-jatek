package jatek.model;

import jatek.constant.Movement;
import jatek.constant.TrackElement;
import java.util.concurrent.ConcurrentLinkedQueue;


public class Game {

    private User user;
    private TrackElement[][] track;
    private ConcurrentLinkedQueue<Movement> movementQueue;
    private TetrisElements tetrisElements;

    public User getUser() {
        return user;
    }

    public Game setUser(User user) {
        this.user = user;
        return this;
    }

    public TrackElement[][] getTrack() {
        return track;
    }

    public Game setTrack(TrackElement[][] track) {
        this.track = track;
        return this;
    }

    public ConcurrentLinkedQueue<Movement> getMovementQueue() {
        return movementQueue;
    }

    public Game setMovementQueue(ConcurrentLinkedQueue<Movement> movementQueue) {
        this.movementQueue = movementQueue;
        return this;
    }

    public TetrisElements getTetrisElements() {
        return tetrisElements;
    }

    public Game setTetrisElements(TetrisElements tetrisElements) {
        this.tetrisElements = tetrisElements;
        return this;
    }
}
