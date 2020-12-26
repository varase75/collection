package es.myfilter.service;

import java.util.List;

import es.myfilter.domain.ItemDto;

public interface CollectionService {
	List<ItemDto> getCollection(String filter);
}