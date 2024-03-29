package com.auction.repository;

import com.auction.model.Item;
import com.auction.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
    public User findByUsername(String username);
}
