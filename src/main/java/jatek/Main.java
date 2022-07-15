package jatek;


import jatek.tetrisbackend.gamer.WebsocketClientEndpoint;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.URI;
import javax.websocket.*;

public class Main {


    public static void main(String[] args)  {
        System.out.println("Hajrá MacskaMarcik!");

        try{
            final WebsocketClientEndpoint clientEndPoint = new WebsocketClientEndpoint(new URI("ws://tetris-backend-websocket.platform-dev.idomsoft.hu/tetris"));

//            Socket s=new Socket("tetris-backend-websocket.platform-dev.idomsoft.hu",9080);
            for (;;) {
                DataInputStream din = new DataInputStream(s.getInputStream());
                System.out.println(din.readUTF());
                din.close();
                s.close();
            }
        }catch(Exception e){System.out.println(e);}
    }
}