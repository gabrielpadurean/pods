package org.pods.domain;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Astronomy picture of the day.
 * 
 * @author gabrielpadurean
 */
public class APOD {
	public static final String IMAGE_MEDIA_TYPE = "image";
	public static final String VIDEO_MEDIA_TYPE = "video";
	
    private String title;
    private String explanation;
    private LocalDate date;
    private String url;
    private String hdurl;

    @JsonProperty("media_type")
    private String mediaType;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public String getHdurl() {
        return hdurl;
    }

    public void setHdurl(String hdurl) {
        this.hdurl = hdurl;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

	public String getMediaType() {
		return mediaType;
	}

	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}