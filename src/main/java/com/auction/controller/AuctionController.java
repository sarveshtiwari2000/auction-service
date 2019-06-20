package com.auction.controller;

import com.auction.service.AuctionService;
import com.auction.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class AuctionController {

    @Autowired
    private AuctionService auctionService;


    @RequestMapping("/users/{username}/bids")
    public List<Item> getAllBids(@PathVariable String username){
        return auctionService.getAllBids(username);
    }

    @RequestMapping("/users/{username}/bids/{id}")
    public Item getBid(@PathVariable String id){
        return auctionService.getBid(id);
    }

    @RequestMapping(method= RequestMethod.POST, value = "/users/{username}/bids/{amount}")
    public void addBids(@RequestBody Item item, @PathVariable String username, @PathVariable double amount){
        auctionService.addBid(item,username,amount);
    }

    @RequestMapping(method= RequestMethod.PUT, value = "/users/{username}/bids/{id}/{amount}")
    public void updateItem(@RequestBody Item item, @PathVariable String username,@PathVariable String id, @PathVariable double amount){
        auctionService.updateBid(item,amount);
    }

}
