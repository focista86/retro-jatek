package jatek.model;

import jatek.MessageHandler;

import java.util.logging.Logger;

public class TetrisMessageHandler implements MessageHandler {
    private Logger logger;

    public TetrisMessageHandler(Logger logger) {
        this.logger = logger;
    }

    @Override
    public void handleMessage(String message) {

    }
}
