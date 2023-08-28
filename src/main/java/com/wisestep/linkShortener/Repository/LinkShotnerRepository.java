package com.wisestep.linkShortener.Repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.wisestep.linkShortener.Model.LinkShotnerModel;
@Repository
public interface LinkShotnerRepository extends MongoRepository<LinkShotnerModel, String>{

	public Optional<LinkShotnerModel> findByShortLink(String shortLink);

}
