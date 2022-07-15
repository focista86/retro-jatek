package jatek.tetrisbackend.gamer;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;

import javax.websocket.*;
import java.io.IOException;
import java.net.URI;
import java.nio.ByteBuffer;
import java.util.List;

@ClientEndpoint
public class WebsocketClientEndpoint {


    public WebsocketClientEndpoint(URI endpointURI) {
        connectToServer(endpointURI);
    }

    private void connectToServer(URI endpointURI) {
        try {
            WebSocketContainer container = ContainerProvider.getWebSocketContainer();
            container.connectToServer(this, endpointURI);
        } catch (IOException | DeploymentException e) {
            throw new AssertionError(e);
        }
    }

    @OnOpen
    public void onOpen(Session userSession) {
        System.out.println("opening websocket" + userSession);
    }

    @OnClose
    public void onClose(Session userSession, CloseReason reason) {
        System.out.println("closing websocket" + userSession.toString() + reason.toString());
    }

    @OnMessage
    public void onMessage(String message) {
        handleMessage(message);
    }

    @OnMessage
    public void onMessage(ByteBuffer bytes) {
        System.out.println("Handle byte buffer" + bytes.toString());
    }

    public void handleMessage(String message) {
        System.out.println(message);
        //        try {
//            List<GameToSocketTextMapper.TrackDto> trackDtoList =
//                    objectMapper.readValue(message, new TypeReference<>() {
//                    });
//            trackDtoList.forEach(x -> logTrackForDebug(x.getTrack()));
//        } catch (Exception e) {
//            logger.error("handleFrame", e);
//        }
    }

    private void logTrackForDebug(GameToSocketTextMapper.TrackElementDto[][] track) {
        StringBuilder finalText = new StringBuilder();
        for (GameToSocketTextMapper.TrackElementDto[] row : track) {
            finalText.append("|\n");
            for (GameToSocketTextMapper.TrackElementDto column : row) {
                switch (column) {
                    case EMPTY:
                        finalText.append(" ");
                        break;
                    case POINT:
                        finalText.append("P");
                        break;
                    case ELEMENT:
                        finalText.append("E");
                        break;
                }
            }
        }
        System.out.println(finalText.toString());
    }
}