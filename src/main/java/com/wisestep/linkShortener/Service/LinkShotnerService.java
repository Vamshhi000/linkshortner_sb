package com.wisestep.linkShortener.Service;

import com.wisestep.linkShortener.Dto.Dto;
import com.wisestep.linkShortener.Model.LinkShotnerModel;

public interface LinkShotnerService {
	public Dto getShortLink(String url);
	public Dto createShortLink(LinkShotnerModel linkShotnerModel);
	public Dto deleteShortUrl(String shortLink);
	
}
