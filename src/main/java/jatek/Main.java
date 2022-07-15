package jatek;



import ch.qos.logback.core.net.server.Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.URI;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.websocket.*;

public class Main {


    public static void main(String[] args)  {
        System.out.println("Hajrá MacskaMarcik!");

//        try{
//            final WebsocketClientEndpoint clientEndPoint = new WebsocketClientEndpoint(new URI("ws://tetris-backend-websocket.platform-dev.idomsoft.hu/tetris"));
//
////            Socket s=new Socket("tetris-backend-websocket.platform-dev.idomsoft.hu",9080);
//            for (;;) {
//                DataInputStream din = new DataInputStream(s.getInputStream());
//                System.out.println(din.readUTF());
//                din.close();
//                s.close();
//            }
//        }catch(Exception e){System.out.println(e);}

        try {
            WebSocketContainer container = ContainerProvider.getWebSocketContainer();
            String uri = "ws://tetris-backend-websocket.platform-dev.idomsoft.hu/tetris:9080/";
            System.out.println("Connecting to " + uri);
            container.connectToServer(MyClientEndpoint.class, URI.create(uri));
        } catch (DeploymentException | IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}