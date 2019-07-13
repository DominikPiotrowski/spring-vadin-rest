package sda.spring.springvadin;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class CatFactClientObjectImplementation {

    private RestTemplate restTemplate;

    public CatFactClientObjectImplementation() {
        this.restTemplate = new RestTemplate();
    }

    //TO ZADZIAŁA BEZ MODELU,
    // lepiej pisać model (chyba że to wyciągamy tylko jeden atrybut)

    public String getCatFactFromApi() {
        ResponseEntity<String> exchange =
                restTemplate.exchange("https://cat-fact.herokuapp.com/facts/random",
                        HttpMethod.GET,
                        HttpEntity.EMPTY,
                        String.class);
        String json = exchange.getBody();
        JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
        String url = jsonObject.get("text").getAsString();
        return url;
    }
}