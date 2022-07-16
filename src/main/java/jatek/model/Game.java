package jatek.model;

import jatek.constant.Movement;
import jatek.constant.TetrisConstant;
import jatek.constant.TrackElement;
import java.util.concurrent.ConcurrentLinkedQueue;


public class Game {

    public User user= new User();
    public TrackElement[][] track = new TrackElement[TetrisConstant.ROW][TetrisConstant.COLUMN];
    public ConcurrentLinkedQueue<Message> messageQueue = new ConcurrentLinkedQueue<Message>();
    public TetrisElements tetrisElements = new TetrisElements();

    public void updateGame() {
        Message message = messageQueue.poll();
        this.track = message.track;
        this.user.setUsername(message.username);
        this.tetrisElements.setCurrent(message.current);
        this.tetrisElements.setNext(message.next);
    }
}
