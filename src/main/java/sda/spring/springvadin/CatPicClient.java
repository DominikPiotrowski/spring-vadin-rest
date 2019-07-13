package sda.spring.springvadin;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import sda.spring.springvadin.models.CatPic;

@Service
public class CatPicClient {

    public String getCatPicFromApi() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<CatPic> exchangePic;

        while (true) {
            exchangePic =
                    restTemplate.exchange("https://aws.random.cat/meow",
                            HttpMethod.GET,
                            HttpEntity.EMPTY,
                            CatPic.class);
            if (exchangePic.getBody().getFile().endsWith("gif")) {
                return exchangePic.getBody().getFile();
            }
        }
    }
}