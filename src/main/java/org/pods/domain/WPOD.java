package org.pods.domain;

import java.time.LocalDate;

/**
 * @author gabrielpadurean
 */
public class WPOD {
	private String link;
	private String description;
    private LocalDate date;
    
    
	public String getLink() {
		return link;
	}
	
	public void setLink(String link) {
		this.link = link;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public LocalDate getDate() {
		return date;
	}
	
	public void setDate(LocalDate date) {
		this.date = date;
	}
}