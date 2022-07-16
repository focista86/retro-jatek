package jatek.control;

import jatek.model.Game;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.client.HttpClient;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.protocol.HttpContext;
import org.apache.http.ssl.SSLContextBuilder;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.ws.transport.http.HttpComponentsMessageSender;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Control {

    private static RestTemplate restTemplate;
    private final int TIMEOUT = 20000;

    public Control(Logger logger) {
        this.logger = logger;
    }

    private String token;
    private Logger logger;
    private Game game;

    public Game startGame(String username) {
        System.out.println("startGame");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        restTemplate = new RestTemplate(getClientHttpRequestFactory());
        try {
            HttpEntity<String> request =
                    new HttpEntity<String>("{\"username\": \"" + username + "\"}", headers);
            game = new Game();
            game.user.setUsername(username);
            token = restTemplate.postForObject("https://tetris-backend.platform-dev.idomsoft.hu/startGame", request, String.class);

            game.user.setToken(token);
        } catch (Exception e) {
            logger.log(Level.WARNING,
                    "nem sikerült elindítani az új játékot " + username + "néven",
                    e);
        }
        return game;
    }

    public void moveLeft() {
        System.out.println("moveLeft");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("x-username", game.user.getUsername());
        headers.set("x-token", game.user.getToken());

        HttpEntity<String> request =
                new HttpEntity<String>("{\"username\": \"macskaMarcik\"}", headers);
        System.out.println("MOVE LEFT: " +
                restTemplate.postForObject("https://tetris-backend.platform-dev.idomsoft.hu/control?movement=MOVE_LEFT", request, String.class));
    }

    public void moveRight() {
        System.out.println("moveRight");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("x-username", game.user.getUsername());
        headers.set("x-token", game.user.getToken());

        HttpEntity<String> request =
                new HttpEntity<String>("{\"username\": \"macskaMarcik\"}", headers);
        System.out.println("MOVE RIGHT: " +
                restTemplate.postForObject("https://tetris-backend.platform-dev.idomsoft.hu/control?movement=MOVE_RIGHT", request, String.class));
    }

    public void rotateLeft() {
        System.out.println("rotateLeft");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("x-username", game.user.getUsername());
        headers.set("x-token", game.user.getToken());

        HttpEntity<String> request =
                new HttpEntity<String>("{\"username\": \"macskaMarcik\"}", headers);
        System.out.println("ROTATE LEFT: " +
                restTemplate.postForObject("https://tetris-backend.platform-dev.idomsoft.hu/control?movement=ROTATE_LEFT", request, String.class));
    }

    public  void rotateRight() {
        System.out.println("rotateRight");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("x-username", game.user.getUsername());
        headers.set("x-token", game.user.getToken());

        HttpEntity<String> request =
                new HttpEntity<String>("{\"username\": \"macskaMarcik\"}", headers);
        System.out.println("ROTATE RIGHT: " +
                restTemplate.postForObject("https://tetris-backend.platform-dev.idomsoft.hu/control?movement=ROTATE_RIGHT", request, String.class));
    }

    private ClientHttpRequestFactory getClientHttpRequestFactory() {
        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        clientHttpRequestFactory.setConnectTimeout(20000);
        try {
            clientHttpRequestFactory.setHttpClient(createHttpClient_AcceptsUntrustedCerts());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return clientHttpRequestFactory;
    }

    private HttpClient createHttpClient_AcceptsUntrustedCerts() throws Exception {
        HttpClientBuilder b = HttpClientBuilder.create();

// SM, ezt nem tudom micsoda és ezért nem tudom feloldani
//        b.addInterceptorFirst(new HttpComponentsMessageSender.RemoveSoapHeadersInterceptor());

        b.addInterceptorLast(new HttpRequestInterceptor() {
            @Override
            public void process(HttpRequest request, HttpContext context) {
                request.removeHeaders("accept-charset");
            }
        });

        // setup a Trust Strategy that allows all certificates.
        //
        SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
            public boolean isTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
                return true;
            }
        }).build();
        b.setSSLContext(sslContext);

        // don't check Hostnames, either.
        //      -- use SSLConnectionSocketFactory.getDefaultHostnameVerifier(), if you don't want to weaken
        HostnameVerifier hostnameVerifier = SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER;

        // here's the special part:
        //      -- need to create an SSL Socket Factory, to use our weakened "trust strategy";
        //      -- and create a Registry, to register it.
        //
        SSLConnectionSocketFactory sslSocketFactory = new SSLConnectionSocketFactory(sslContext, hostnameVerifier);
        Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
                .register("http", PlainConnectionSocketFactory.getSocketFactory())
                .register("https", sslSocketFactory)
                .build();

        // now, we create connection-manager using our Registry.
        //      -- allows multi-threaded use
        PoolingHttpClientConnectionManager connMgr = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
        b.setConnectionManager(connMgr);

        // finally, build the HttpClient;
        //      -- done!
        HttpClient client = b.build();
        return client;
    }


    public void setLogger(Logger logger) {
        this.logger = logger;
    }
}