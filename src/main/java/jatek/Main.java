package jatek;


import java.net.URI;

import static java.lang.Thread.sleep;

public class Main {


    public static void main(String[] args)  {
        System.out.println("Hajrá MacskaMarcik!");

        try{
            final WebsocketClientEndpoint clientEndPoint = new WebsocketClientEndpoint(new URI("wss://tetris-backend-websocket.platform-dev.idomsoft.hu/tetris"));
//            clientEndPoint.add(new WebsocketClientEndpoint.MessageHandler() {
//                public void handleMessage(String message) {
//                    System.out.println(message);
//                }
//            });
            for (;;) {
                sleep(1000);
                System.out.println("ciklus belseje: " + clientEndPoint.session.getMessageHandlers().stream().count());
            }
        }catch(Exception e){System.out.println(e);}
    }
}