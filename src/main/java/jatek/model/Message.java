package jatek.model;

import jatek.constant.TetrisElement;
import jatek.constant.TrackElement;

public class Message {
    public TrackElement[][] track;
    public TetrisElement current;
    public TetrisElement next;
    public String username;
    public int point;
}
