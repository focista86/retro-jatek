package jatek;

import com.fasterxml.jackson.core.type.TypeReference;
import jatek.MessageHandler;
import jatek.model.Game;
import jatek.model.Message;
import jatek.model.Messages;
import jatek.utl.JsonUtil;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TetrisMessageHandler implements MessageHandler {
    private Game actGame;
    private Logger logger;

    public TetrisMessageHandler(Logger logger) {
        this.logger = logger;
    }

    @Override
    public void handleMessage(String messageTxt) {
        logger.log(Level.INFO, messageTxt);
        Message[] mos = JsonUtil.fromJson(messageTxt,  Message[].class);
        Arrays.stream(mos).filter(o->o.username.equals(actGame.user.getUsername()))
                .allMatch(message -> actGame.messageQueue.add(message));
    }

    public void setActGame(Game actGame) {
        this.actGame = actGame;
    }
}
