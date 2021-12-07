package com.ynov.productapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ynov.productapi.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	public Iterable<User> findByName(String name);
}
