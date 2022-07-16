package jatek.model;

import jatek.constant.Movement;
import jatek.constant.TrackElement;
import java.util.concurrent.ConcurrentLinkedQueue;


public class Game {

    public User user;
    public TrackElement[][] track;
    public ConcurrentLinkedQueue<Message> messageQueue;
    public TetrisElements tetrisElements;
}
