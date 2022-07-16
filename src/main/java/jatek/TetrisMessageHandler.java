package jatek;

import jatek.MessageHandler;
import jatek.model.Message;
import jatek.utl.JsonUtil;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TetrisMessageHandler implements MessageHandler {
    private Logger logger;

    public TetrisMessageHandler(Logger logger) {
        this.logger = logger;
    }

    @Override
    public void handleMessage(String message) {
        logger.log(Level.INFO, message);
        Message messageObject = JsonUtil.fromJson(message, Message.class);

    }
}
