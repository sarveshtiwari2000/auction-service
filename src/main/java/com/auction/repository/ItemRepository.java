package com.auction.repository;


import com.auction.model.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ItemRepository extends CrudRepository<Item, String> {

    public List<Item> findBySellerUsername (String username);
    public List<Item> findByBuyerUsername (String username);
    public List<Item> findByTopic (String topic);
    public List<Item> findByEndDate (String topic);
    public Item findById (Long Id);

    @Transactional
    Long deleteById(Long firstName);
}
