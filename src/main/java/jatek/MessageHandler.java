package jatek;

import exception.GameOverException;

public interface MessageHandler {
    void handleMessage(String message) throws GameOverException;
}
