package com.wisestep.linkShortener.common;
import java.nio.charset.Charset;

import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.hash.Hashing;
import com.wisestep.linkShortener.Repository.LinkShotnerRepository;

@Component
public class Common {
	@Autowired
	private LinkShotnerRepository linkShotnerRepository;
	
	  public String getShortLink(String shortLink) {
		  String shortUrl = Hashing.murmur3_32_fixed().hashString(shortLink, Charset.defaultCharset()).toString();
			  return shortUrl;
	    }
	  
	    public boolean isValidLink(String link) {
	        UrlValidator urlValidator = new UrlValidator(new String[]{"http","https"});
	        boolean result = urlValidator.isValid(link);
	        return result;
	    }
}
