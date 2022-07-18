package jatek;

import jatek.control.Control;
import jatek.model.Game;

import java.io.IOException;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.*;

public class Main {

    public static Logger logger;
    public static WebsocketClientEndpoint clientEndPoint;
    private static Control control;

    public static void main(String[] args)  {
        System.out.println("Hajrá MacskaMarcik!");
        try{
            startLogger();
            Game game = new Game("macskaMarcik");

            control = new Control(logger, game);

            clientEndPoint = new WebsocketClientEndpoint(new URI("wss://tetris-backend-websocket.platform-dev.idomsoft.hu/api/tetris"),
                    logger, new TetrisMessageHandler(logger, control, game));
//            for (;;){}
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
//        fileHandler.setFormatter(new SimpleFormatter());
        //setting custom filter for FileHandler
        //logger.addHandler(fileHandler);
    }
}