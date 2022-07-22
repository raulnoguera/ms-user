package com.medicalfollow.microservicios.app.users;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "user_1", collectionResourceRel =  "user_1")

public interface ContactoRepository extends CrudRepository<user_1, Integer>{

}
