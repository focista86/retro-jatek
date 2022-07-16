package jatek;


import jatek.control.Control;
import jatek.control.Optimizer;
import jatek.model.Game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.*;

import static java.lang.Thread.sleep;

public class Main {

    public static Logger logger;
    public static WebsocketClientEndpoint clientEndPoint;
    public static MessageHandler messageHandler ;
    private static Control control;
    private static Game game;

    public static void main(String[] args)  {
        System.out.println("Hajrá MacskaMarcik!");
        try{
            startLogger();
            control = new Control(logger);
            game = control.startGame("macskaMarcik");
            messageHandler = new TetrisMessageHandler(logger, control);
            messageHandler.setActGame(game);
            clientEndPoint = new WebsocketClientEndpoint(new URI("wss://tetris-backend-websocket.platform-dev.idomsoft.hu/api/tetris"), logger, messageHandler);
            for (;;){}
//            BufferedReader reader = new BufferedReader(
//                    new InputStreamReader(System.in));
//            String command;
            // Reading data using readLine
//             do {
//                sleep(1000);
//                 System.out.println("Indítsak?");
//                command = reader.readLine();
//                if (!command.equals("quit") && !command.isEmpty()) {
//                    logger.log(Level.INFO, "Új játékot indítunk " + command + "néven");
//                }
//                System.out.println("ciklus belseje: " + clientEndPoint.session.getMessageHandlers().stream().count());
//            } while (command != "quit");
        } catch(Exception e){System.out.println(e);}
    }

    private static void startLogger() throws IOException {
        SimpleDateFormat df = new SimpleDateFormat();
        df.applyPattern("yyyyMMddHHmmSS");
        String fname = "tetrisLog" + df.format(new Date()) + ".log";
        logger = Logger.getLogger(Main.class.getName());
        logger.addHandler(new ConsoleHandler());
        Handler fileHandler = new FileHandler(fname, 2000, 5);
        fileHandler.setFormatter(new SimpleFormatter());
        //setting custom filter for FileHandler
        logger.addHandler(fileHandler);
    }
}