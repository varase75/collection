package es.myfilter.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.ALWAYS)
public class ItemDto {
	private String id;
	private String title;
	private String description;
	@JsonProperty("cover_photo_id")
	private String coverPhotoId;
}