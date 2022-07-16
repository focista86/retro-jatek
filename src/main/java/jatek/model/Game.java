package jatek.model;

import jatek.constant.Movement;
import jatek.constant.TetrisConstant;
import jatek.constant.TrackElement;
import java.util.concurrent.ConcurrentLinkedQueue;


public class Game {

    public User user= new User();
    public TrackElement[][] track = new TrackElement[TetrisConstant.ROW][TetrisConstant.COLUMN];
    public ConcurrentLinkedQueue<Message> messageQueue = new ConcurrentLinkedQueue<Message>();
    public TetrisElements tetrisElements;
}
