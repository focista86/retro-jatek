package jatek;

import jatek.control.Control;
import jatek.control.Optimizer;
import jatek.model.Game;
import jatek.model.Message;
import jatek.utl.JsonUtil;

import java.util.Arrays;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TetrisMessageHandler implements MessageHandler {
    private int i;
    private Game actGame;
    private Logger logger;
    private Control control;

    public TetrisMessageHandler(Logger logger, Control control, Game actGame) {
        this.logger = logger;
        this.control = control;
        this.actGame = actGame;
        this.i = 1;
    }

    @Override
    public void handleMessage(String messageTxt) {
        logger.log(Level.INFO, messageTxt);
        Message[] mos = JsonUtil.fromJson(messageTxt, Message[].class);
        Optional<Message> message = Arrays.stream(mos).filter(o -> o.username.equals(actGame.user.getUsername())).findFirst();
        if (message.isPresent()) {
            actGame.updateGame(message.get());
            if (actGame.isNewElement) {
                i++;
                System.out.println("+++++++++++++++++++ " + i);
                Optimizer optimizer = new Optimizer();
                if (actGame.tetrisElements != null) {
                    control.doMovmentList(optimizer.getBasicSolution(actGame.track, actGame.tetrisElements.getCurrent(), i));
                }
            }
        } else {
            System.out.println("GAME OVER");
        }
    }
}
