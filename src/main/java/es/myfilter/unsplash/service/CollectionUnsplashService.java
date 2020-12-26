package es.myfilter.unsplash.service;

import java.util.List;

import es.myfilter.domain.ItemDto;

public interface CollectionUnsplashService {
	List<ItemDto> getCollection(String filter);
}