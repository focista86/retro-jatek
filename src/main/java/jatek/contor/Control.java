package jatek.contor;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public class Control {

    public static void startGame(){
        System.out.println("startGame");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
//        JSONObject gamer = new JSONObject();
//        personJsonObject.put("id", 1);
//        personJsonObject.put("name", "John");

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> request =
                new HttpEntity<String>("{\"username\": \"macskaMarcik\"}", headers);
        String personResultAsJsonStr =
                restTemplate.postForObject("https://tetris-backend.platform-dev.idomsoft.hu/startGame", request, String.class);

//        HttpEntity<String> request = new HttpEntity<String>("{\"username\": \"macskaMarcik\"}", headers);
//        URI locationHeader = restTemplate.postForLocation("https://tetris-backend.platform-dev.idomsoft.hu/startGame", request);
    }
}
