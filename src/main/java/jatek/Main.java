package jatek;


import jatek.contor.Control;
import jatek.model.TetrisMessageHandler;

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
    public static BufferedReader reader;
    public static void main(String[] args)  {
        System.out.println("Hajrá MacskaMarcik!");
        try{
            startLogger();
            messageHandler = new TetrisMessageHandler(logger);
            clientEndPoint = new WebsocketClientEndpoint(new URI("wss://tetris-backend-websocket.platform-dev.idomsoft.hu/tetris"), logger, messageHandler);
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(System.in));
            String command;
            // Reading data using readLine
             do {
                sleep(1000);
                command = reader.readLine();
                if (!command.equals("quit") && !command.isEmpty()) {
                    logger.log(Level.INFO, "Új játékot indítunk " + command + "néven");
                    Control.startGame(command);
                }
                System.out.println("ciklus belseje: " + clientEndPoint.session.getMessageHandlers().stream().count());
            } while (command != "quit");
        }catch(Exception e){System.out.println(e);}
    }

    private static void startLogger() throws IOException {
        SimpleDateFormat df = new SimpleDateFormat();
        String fname = "tetrisLog" + df.format(new Date()) + ".log";
        logger = Logger.getLogger(Main.class.getName());
        logger.addHandler(new ConsoleHandler());
        Handler fileHandler = new FileHandler(fname, 2000, 5);
        fileHandler.setFormatter(new SimpleFormatter());
        //setting custom filter for FileHandler
        logger.addHandler(fileHandler);
    }
}