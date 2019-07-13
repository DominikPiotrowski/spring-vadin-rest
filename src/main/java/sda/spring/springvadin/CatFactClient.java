package sda.spring.springvadin;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import sda.spring.springvadin.models.CatFact;

@Service
public class CatFactClient {

    public CatFact getCatFactFromApi() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<CatFact> exchange =
                restTemplate.exchange("https://cat-fact.herokuapp.com/facts/random",
                        HttpMethod.GET,
                        HttpEntity.EMPTY,
                        CatFact.class);
        return exchange.getBody();
    }

}