package jatek;

import jatek.model.Game;

public interface MessageHandler {
    void handleMessage(String message);

    void setActGame(Game game);
}
