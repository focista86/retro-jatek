package jatek;

import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.tomcat.websocket.Constants;
import org.apache.tomcat.websocket.pojo.PojoEndpointClient;

import javax.net.ssl.SSLContext;
import javax.websocket.*;
import java.io.IOException;
import java.net.URI;
import java.nio.ByteBuffer;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;


@ClientEndpoint
public class WebsocketClientEndpoint {
    public Session session;
    public WebsocketClientEndpoint(URI endpointURI) {
        connectToServer(endpointURI);
    }

    private void connectToServer(URI endpointURI) {
        try {
            WebSocketContainer container = ContainerProvider.getWebSocketContainer();


            session = container.connectToServer(new PojoEndpointClient(this, new ArrayList<>()), createClientConfig(), endpointURI);
        } catch (IOException | DeploymentException | NoSuchAlgorithmException | KeyStoreException |
                 KeyManagementException | UnrecoverableKeyException | CertificateException e) {
            throw new AssertionError(e);
        }
    }

    private ClientEndpointConfig createClientConfig() throws KeyManagementException, UnrecoverableKeyException,
            NoSuchAlgorithmException, KeyStoreException, CertificateException, IOException {
        ClientEndpointConfig.Builder builder = ClientEndpointConfig.Builder.create();
        ClientEndpointConfig config = builder.decoders(new ArrayList<>()).encoders(new ArrayList<>())
                .preferredSubprotocols(new ArrayList<>()).build();
        SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null,  new TrustStrategy() {
            public boolean isTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
                return true;
            }
        }).build();
        config.getUserProperties().put(Constants.SSL_CONTEXT_PROPERTY, sslContext);
        return config;
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
    public void processMessage(String message) {
        System.out.println("Received message in client: " + message);
    }

    @OnMessage
    public void onMessage(ByteBuffer bytes) {
        System.out.println("Handle byte buffer" + bytes.toString());
    }

//    public void handleMessage(String message) {
//        try {
//            List<GameToSocketTextMapper.TrackDto> trackDtoList =
//                    objectMapper.readValue(message, new TypeReference<>() {
//                    });
//            trackDtoList.forEach(x -> logTrackForDebug(x.getTrack()));
//        } catch (Exception e) {
//            logger.error("handleFrame", e);
//        }
//    }
//
//    private void logTrackForDebug(GameToSocketTextMapper.TrackElementDto[][] track) {
//        StringBuilder finalText = new StringBuilder();
//        for (GameToSocketTextMapper.TrackElementDto[] row : track) {
//            finalText.append("|\n");
//            for (GameToSocketTextMapper.TrackElementDto column : row) {
//                switch (column) {
//                    case EMPTY:
//                        finalText.append(" ");
//                        break;
//                    case POINT:
//                        finalText.append("P");
//                        break;
//                    case ELEMENT:
//                        finalText.append("E");
//                        break;
//                }
//            }
//        }
//        logger.info(finalText.toString());
//    }
}