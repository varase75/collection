package es.myfilter.unsplash.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import es.myfilter.domain.ItemDto;
import es.myfilter.unsplash.dto.ItemUnsplashDto;

@Mapper(componentModel = "spring")
public interface ItemUnsplashDtoMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "coverPhoto.id", target = "coverPhotoId")
    ItemDto toDomain(ItemUnsplashDto itemUnsplashDto);

}