package es.myfilter.unsplash.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ItemUnsplashDto {
	private String id;
	private String title;
	private String description;
//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
	@JsonProperty("published_at")
//	private LocalDateTime publishedAt;
	private String publishedAt;
	@JsonProperty("last_collected_at")
	private String lastCollectedAt;
	@JsonProperty("updated_at")
	private String updatedAt;
	private boolean curated;
	private boolean featured;
	@JsonProperty("total_photos")
	private Integer totalPhotos;
	@JsonProperty("private")
	private boolean pivate;
	@JsonProperty("share_key")
	private String shareKey;
	private List<Tag> tags;
	private Links links;
	private User user;
	@JsonProperty("cover_photo")
	private CoverPhoto coverPhoto;
	@JsonProperty("preview_photos")
	private List<PreviewPhoto> previewPhotos;

	@Data
	@JsonInclude(JsonInclude.Include.NON_NULL)
	public static class Tag {
	    public String type;
	    public String title;
	    public Source source;

	    @Data
		@JsonInclude(JsonInclude.Include.NON_NULL)
	    public static class Source {
	        public Ancestry ancestry;
	        public String title;
	        public String subtitle;
	        public String description;
	        @JsonProperty("meta_title")
	        public String metaTitle;
	        @JsonProperty("meta_description")
	        public String metaDescription;
	        @JsonProperty("cover_photo")
	        public CoverPhoto coverPhoto;
 
	        @Data
			@JsonInclude(JsonInclude.Include.NON_NULL)
	        public static class Ancestry {
	            public Type type;
	            public Category category;
	            public Subcategory subcategory;

	            @Data
				@JsonInclude(JsonInclude.Include.NON_NULL)
	            public static class Type {
	                public String slug;
	                @JsonProperty("pretty_slug")
	                public String prettySlug;
	            }

	            @Data
				@JsonInclude(JsonInclude.Include.NON_NULL)
	            public static class Subcategory {
	                public String slug;
	                @JsonProperty("pretty_slug")
	                public String prettySlug;
	            }
	        }
	    }
	}
	
    @Data
	@JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Category {
        public String slug;
        @JsonProperty("pretty_slug")
        public String prettySlug;
    }

	@Data
	@JsonInclude(JsonInclude.Include.NON_NULL)
	public static class Links {
		private String self;
		private String html;
		private String download;
		@JsonProperty("download_location")
		private String downloadLocation;
		private String photos;
		private String likes;
		private String portfolio;
		private String related;
	}

	@Data
	@JsonInclude(JsonInclude.Include.NON_NULL)
	public static class User {
		private String id;
		@JsonProperty("updated_at")
		private String updatedAt;
		private String username;
		private String name;
		@JsonProperty("first_name")
		private String firstName;
		@JsonProperty("last_name")
		private String lastName;
		@JsonProperty("twitter_username")
		private String twitterUsername;
		@JsonProperty("portfolio_url")
		private String portfolioUrl;
		private String bio;
		private String location;
		private Links links;
		@JsonProperty("profile_image")
		private ProfileImage profileImage;
		@JsonProperty("instagram_username")
		private String instagramUsername;
		@JsonProperty("total_collections")
		private Integer totalCollections;
		@JsonProperty("total_likes")
		private Integer totalLikes;
		@JsonProperty("total_photos")
		private Integer totalPhotos;
		@JsonProperty("accepted_tos")
		private boolean acceptedTos;

		@Data
		@JsonInclude(JsonInclude.Include.NON_NULL)
		public static class ProfileImage {
			private String small;
			private String medium;
			private String large;
		}
	}

	@Data
	@JsonInclude(JsonInclude.Include.NON_NULL)
	public static class CoverPhoto {
		private String id;
		@JsonProperty("created_at")
		private String createdAt;
		@JsonProperty("updated_at")
		private String updatedAt;
		@JsonProperty("promoted_at")
		private String promotedAt;
		private Integer width;
		private Integer height;
		private String color;
		@JsonProperty("blur_hash")
		private String blurHash;
		private String description;
		@JsonProperty("alt_description")
		private String altDescription;
		private Urls urls;
		private Links links;
		private List<Category> categories;
		private Integer likes;
		@JsonProperty("liked_by_user")
		private Boolean likedByUser;
		private User user;
	}

	@Data
	@JsonInclude(JsonInclude.Include.NON_NULL)
	public static class PreviewPhoto {
	    public String id;
		@JsonProperty("created_at")
	    public String createdAt;
		@JsonProperty("updated_at")
	    public String updatedAt;
		@JsonProperty("blur_hash")
	    public String blurHash;
	    public Urls urls;
	}

	@Data
	@JsonInclude(JsonInclude.Include.NON_NULL)
	public static class Urls {
		private String raw;
		private String full;
		private String regular;
		private String small;
		private String thumb;
	}

}