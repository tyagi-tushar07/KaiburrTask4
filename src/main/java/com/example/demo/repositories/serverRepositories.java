package com.example.demo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.demo.model.Servers;

public interface serverRepositories extends MongoRepository<Servers,Integer>{
	
	@Override
    public void delete(Servers server);
	
}
