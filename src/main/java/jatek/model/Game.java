package jatek.model;

import jatek.constant.TetrisConstant;
import jatek.constant.TrackElement;

import java.util.concurrent.ConcurrentLinkedQueue;

public class Game {

    public User user = new User();
    public TrackElement[][] track = new TrackElement[TetrisConstant.ROW][TetrisConstant.COLUMN];
    public ConcurrentLinkedQueue<Message> messageQueue = new ConcurrentLinkedQueue<Message>();
    public TetrisElements tetrisElements = new TetrisElements();
    private int point = 0;
    public boolean isNewElement = false;

    public Game(String macskaMarcik) {
        this.user.setUsername(macskaMarcik);
    }

    public void updateGame(Message message) {
        this.track = message.track;
        this.user.setUsername(message.username);
        this.tetrisElements.setCurrent(message.current);
        this.tetrisElements.setNext(message.next);
        if (this.point != message.point) {
            this.isNewElement = true;
        }else {
            this.isNewElement = false;
        }
        this.point = message.point;
    }
}
