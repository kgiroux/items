package com.giroux.kevin.dofustuff.object.network.clients;

import com.giroux.kevin.dofustuff.commons.media.Media;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ItemClient {

    private RestTemplate restTemplate = new RestTemplate();

    @Value("${network.services.media}")
    private String urlMediaService;


    public void saveImageMetadata(Media media){
        HttpEntity<Media> entity = new HttpEntity<>(media);
        restTemplate.put(urlMediaService, entity);
    }
}
