package es.myfilter.unsplash.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import es.myfilter.domain.ItemDto;
import es.myfilter.unsplash.dto.ItemUnsplashDto;
import es.myfilter.unsplash.dto.mapper.ItemUnsplashDtoMapper;

@Service
public class CollectionUnsplashServiceImpl implements CollectionUnsplashService {

    private CollectionUnsplashInvokerService collectionUnsplashInvokerService;
    private ItemUnsplashDtoMapper itemUnsplashDtoMapper;

    public CollectionUnsplashServiceImpl(CollectionUnsplashInvokerService collectionUnsplashInvokerService, ItemUnsplashDtoMapper itemUnsplashDtoMapper) {
        this.collectionUnsplashInvokerService = collectionUnsplashInvokerService;
        this.itemUnsplashDtoMapper = itemUnsplashDtoMapper;
    }

    @Override
	public List<ItemDto> getCollection(final String filter) {
    	final List<ItemDto> list = new ArrayList<>();

    	List<ItemUnsplashDto> items = collectionUnsplashInvokerService.invoke();
    	items = items.parallelStream()
    		.filter(item -> isContainsFiter(item, filter))
    		.collect(Collectors.toList());

    	items.forEach(item -> {
    		list.add(itemUnsplashDtoMapper.toDomain(item));
    	});

    	return list;
    }

    private boolean isContainsFiter(ItemUnsplashDto item, String filter) {
    	return (item.getId() != null && item.getId().contains(filter))
    		|| (item.getTitle() != null && item.getTitle().contains(filter))
    		|| (item.getDescription() != null && item.getDescription().contains(filter))
    		|| (item.getCoverPhoto() != null && item.getCoverPhoto().getId() != null && item.getCoverPhoto().getId().contains(filter));
    }

}