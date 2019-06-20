package com.auction.service;

import com.auction.model.Item;
import com.auction.repository.ItemRepository;
import com.auction.model.User;
import com.auction.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuctionService {
    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private UserRepository userRepository;


    public List<Item> getAllBids(String username){
        List<Item> items = new ArrayList<>();
        itemRepository.findByBuyerUsername(username)
                .forEach(items::add);
        return items;
    }

    public void addBid(Item item, String username, double amount) {

        Item tempItem = itemRepository.findById(item.getId());
        User user = userRepository.findOne(username);
        if(user.getPenalty()==0 && tempItem.getPrice()< amount ) {
            tempItem.setPrice(amount);
            item.setSeller(itemRepository.findById(item.getId()).getSeller());
            item.setBuyer(new User(username,"", "", "", "", 0));
            itemRepository.save(item);
        }

    }

    public Item  getBid(String id){

        return itemRepository.findOne(id);
    }

    public void updateBid(Item item,  double amount) {

        Item tempItem = itemRepository.findById(item.getId());
        if(tempItem.getPrice()< amount ) {
            tempItem.setPrice(amount);
            item.setSeller(tempItem.getSeller());
            item.setBuyer(tempItem.getBuyer());
            itemRepository.save(item);
        }
    }



}
