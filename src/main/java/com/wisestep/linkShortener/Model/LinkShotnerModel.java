package com.wisestep.linkShortener.Model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "linkshortner")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LinkShotnerModel {
	@Id
	private String id;
	private String shortLink;
	private String originalLink;
	private LocalDateTime dateTime;


}
