package jatek;

import jatek.constant.Movement;
import jatek.control.Control;
import jatek.control.Optimizer;
import jatek.control.Optimizer2;
import jatek.model.Game;
import jatek.model.Message;
import jatek.utl.JsonUtil;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TetrisMessageHandler implements MessageHandler {
    private int elemCounter;

    private Game actGame;
    private Logger logger;
    private Control control;

    public TetrisMessageHandler(Logger logger, Control control, Game actGame) {
        this.logger = logger;
        this.control = control;
        this.actGame = actGame;
        this.elemCounter = 1;
    }

    @Override
    public void handleMessage(String messageTxt) {
        //logger.log(Level.INFO, messageTxt);
        Message[] mos = JsonUtil.fromJson(messageTxt, Message[].class);
        Optional<Message> message = Arrays.stream(mos).filter(o -> o.username.equals(actGame.user.getUsername())).findFirst();
        if (message.isPresent()) {
            actGame.updateGame(message.get());
            if (actGame.isNewElement) {
                elemCounter++;

                Optimizer optimizer = new Optimizer();
                Optimizer2 optimizer2 = new Optimizer2();
                if (actGame.tetrisElements != null) {
                    //control.doMovmentList(optimizer.getBasicSolution(actGame.track, actGame.tetrisElements.getCurrent(), i));
                    System.out.println("+++++++++++++++++++ " + elemCounter);
                    List<Movement> movementList = optimizer2.elmebaj1(actGame.track, actGame.tetrisElements.getCurrent(), elemCounter);
                    System.out.println(movementList);
                    control.doMovmentList(movementList);
                }
            }
        } else {
            System.out.println("GAME OVER");
        }
    }
}
