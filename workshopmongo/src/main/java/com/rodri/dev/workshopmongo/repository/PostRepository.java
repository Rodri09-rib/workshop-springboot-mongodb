package com.rodri.dev.workshopmongo.repository;

import com.rodri.dev.workshopmongo.domain.Post;
import com.rodri.dev.workshopmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
}
