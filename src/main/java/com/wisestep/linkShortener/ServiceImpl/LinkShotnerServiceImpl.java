package com.wisestep.linkShortener.ServiceImpl;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wisestep.linkShortener.Dto.Dto;
import com.wisestep.linkShortener.Model.LinkShotnerModel;
import com.wisestep.linkShortener.Repository.LinkShotnerRepository;
import com.wisestep.linkShortener.Service.LinkShotnerService;
import com.wisestep.linkShortener.common.Common;


import lombok.extern.log4j.Log4j2;
@Log4j2
@Service
public class LinkShotnerServiceImpl implements LinkShotnerService{

	@Autowired
	private LinkShotnerRepository linkShotnerRepository;
	@Autowired
	private Common common;
	LocalDateTime dateTime;
	@Override
	public Dto getShortLink(String url) {
		Dto dto=null;
		Optional<LinkShotnerModel> urlObj=linkShotnerRepository.findByShortLink(url);
		if(urlObj.isPresent()) {
			log.info("Url detected");
			dto=Dto.builder()
					.flag(true)
					.originalLink(urlObj.get().getOriginalLink())
					.dateTime(urlObj.get().getDateTime())
					.build();
		}else {
			log.info("Url not found");
			dto=Dto.builder()
					.flag(false)
					.msg("Url not found")
					.build();
		}
		return dto;
	}

	@Override
	public Dto createShortLink(LinkShotnerModel linkShotnerModel) {
		LinkShotnerModel linkModel=null;
		Dto dto=null;
		if(common.isValidLink(linkShotnerModel.getOriginalLink())) {
			if(linkShotnerRepository.findByShortLink(common.getShortLink(linkShotnerModel.getOriginalLink())).isEmpty()) {
				linkModel = LinkShotnerModel.builder()
				.shortLink(common.getShortLink(linkShotnerModel.getOriginalLink()))
				.originalLink(linkShotnerModel.getOriginalLink())
				.dateTime(dateTime.now())
				.build();
			linkShotnerRepository.save(linkModel);
			dto=Dto.builder()
			.shortLink(linkModel.getShortLink())
			.originalLink(linkModel.getOriginalLink())
			.dateTime(linkModel.getDateTime())
			.flag(true)
			.msg("Generated")
			.build();
			log.info("Valied link");
			}else {
				log.error("Duplicate link");
				dto=Dto.builder()
						.flag(false)
						.msg("Duplicate Link")
						.build();
			}
		}else {
			log.error("Invalied link");
			dto=Dto.builder()
			.flag(false)
			.msg("Invalied Link")
			.build();
			
		}

		return dto;
	}

	@Override
	public Dto deleteShortUrl(String shortLink) {
		Dto dto=null;
		Optional<LinkShotnerModel> urlObj=linkShotnerRepository.findByShortLink(shortLink);
		if(urlObj.isPresent()) {
		linkShotnerRepository.deleteById(urlObj.get().getId());
		log.info("short link deleted");
		dto=Dto.builder()
				.flag(false)
				.msg("Url Expired")
				.build();
		}else {
			dto=Dto.builder()
					.flag(false)
					.msg("Short link not found")
					.build();
		}
		return dto;
	}
	
	
	

}
