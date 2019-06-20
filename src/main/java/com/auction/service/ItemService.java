package com.auction.service;

import com.auction.repository.ItemRepository;
import com.auction.model.Item;
import com.auction.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Item> getAllUserItems(String username){

        List<Item> items = new ArrayList<>();
        itemRepository.findBySellerUsername(username)
                .forEach(items::add);
        return items;

    }


    public List<Item> getAllItems(){

        List<Item> items = new ArrayList<>();
        itemRepository.findAll()
                .forEach(items::add);
        return items;

    }


    public List<Item> getAllSortedItems(){

        List<Item> items = new ArrayList<>();
        itemRepository.findAll()
                .forEach(items::add);
        items.sort((Item l1, Item l2)
                ->
                Double.compare(l1.getPrice(),l2.getPrice())
        );
        return items;

    }

    public List<Item> getAllItemsByTopic(String topicName){
        List<Item> items = new ArrayList<>();
        itemRepository.findByTopic(topicName)
                .forEach(items::add);
        return items;
    }





    public Item getItem(String id){

        return itemRepository.findOne(id);
    }

    public void addItem(Item item, String username) {

        item.setSeller(userRepository.findByUsername(username));
        itemRepository.save(item);
    }

    public void updateItem(Item item) {

        item.setBuyer(itemRepository.findById(item.getId()).getBuyer());
        itemRepository.save(item);
    }


    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }




}
