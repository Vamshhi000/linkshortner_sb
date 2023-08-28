package com.wisestep.linkShortener.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wisestep.linkShortener.Dto.Dto;
import com.wisestep.linkShortener.Model.LinkShotnerModel;
import com.wisestep.linkShortener.ServiceImpl.LinkShotnerServiceImpl;

@RestController
@RequestMapping("/linkshotner")
@CrossOrigin(origins = "*")
public class LinkShotnerController {
	
	@Autowired
	private LinkShotnerServiceImpl linkShotnerServiceImpl;
	
	@GetMapping
	public ResponseEntity<Dto> getShortLink(@RequestParam(name = "url") String url){
		return new ResponseEntity<Dto>(linkShotnerServiceImpl.getShortLink(url),HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{shortLink}")
	public ResponseEntity<Dto> deleteLink(@PathVariable String shortLink) {
		return new ResponseEntity<Dto>( linkShotnerServiceImpl.deleteShortUrl(shortLink),HttpStatus.OK);
	}
	
	@PostMapping()
	public ResponseEntity<Dto> createShortLink(@RequestBody LinkShotnerModel linkShotnerModel) {
	
		return new ResponseEntity<Dto>(linkShotnerServiceImpl.createShortLink(linkShotnerModel),HttpStatus.OK);
		
	
	}

}
