package com.wisestep.linkShortener.Dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Dto {
	private String shortLink;
	private String originalLink;
	private LocalDateTime dateTime;
	private boolean flag;
	private String msg;
}
