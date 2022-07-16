package jatek;

import jatek.control.Control;
import jatek.control.Optimizer;
import jatek.model.Game;
import jatek.model.Message;
import jatek.utl.JsonUtil;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TetrisMessageHandler implements MessageHandler {
    private int i;
    private Game actGame;
    private Logger logger;
    private Control control;

    public TetrisMessageHandler(Logger logger, Control control) {
        this.logger = logger;
        this.control = control;
        this.i = 0;
    }

    @Override
    public void handleMessage(String messageTxt) {
        logger.log(Level.INFO, messageTxt);
        i++;
        Message[] mos = JsonUtil.fromJson(messageTxt,  Message[].class);
        Arrays.stream(mos).filter(o->o.username.equals(actGame.user.getUsername()))
                .allMatch(message -> actGame.messageQueue.add(message));

        actGame.updateGame();

        Optimizer optimizer = new Optimizer();
        if (actGame.tetrisElements != null){
            control.doMovmentList(optimizer.getBasicSolution(actGame.track, actGame.tetrisElements.getCurrent(),i));
        }
    }

    public void setActGame(Game actGame) {
        this.actGame = actGame;
    }
}
