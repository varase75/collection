package es.myfilter.service;

import java.util.List;

import org.springframework.stereotype.Service;

import es.myfilter.domain.ItemDto;
import es.myfilter.unsplash.service.CollectionUnsplashService;

@Service
public class CollectionServiceImpl implements CollectionService {

    private CollectionUnsplashService collectionUnsplashPort;

    public CollectionServiceImpl(CollectionUnsplashService collectionUnsplashPort) {
        this.collectionUnsplashPort = collectionUnsplashPort;
    }

    @Override
	public List<ItemDto> getCollection(String filter) {
        return collectionUnsplashPort.getCollection(filter);
    }

}