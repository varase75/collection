package es.myfilter.unsplash.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import es.myfilter.unsplash.dto.ItemUnsplashDto;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CollectionUnsplashInvokerService {

    private RestTemplate unsplashRestTemplate;
    private final String endpoint;

    private static final String PAGE_SIZE = "30";

    public CollectionUnsplashInvokerService(@Value("${my-filter.unsplash.endpoint.collection}") String endpoint,
                                            @Qualifier("unsplashRestTemplate") RestTemplate unsplashRestTemplate) {
        this.endpoint = endpoint;
    	this.unsplashRestTemplate = unsplashRestTemplate;
    }

    public List<ItemUnsplashDto> invoke() {
        try {
            log.info("calling to Unsplash collection");
            ItemUnsplashDto[] items = unsplashRestTemplate.getForObject(endpoint, ItemUnsplashDto[].class, PAGE_SIZE);
            log.info("calling to Unsplash collection successful");
            return Arrays.asList(items);
        } catch (RestClientException e) {
            log.error("Error fetching collection", e);

            throw e;
        }
    }

}